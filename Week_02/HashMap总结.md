# HashMap总结

HashMap是一种数组+链表/红黑树（JDK8）这样一种结构，其查询的时间复杂度在最优的情况下是O(1)，我们知道数组的查询的时间复杂度是O(1)，其实HashMap内部也是有一个数组，只不过里面的元素是以一种特定的方式（通过hash函数进行一系列操作得到数组下标）去存储的。大致如下图：

![hashmap1](http://39.97.125.68:88/download/M00/00/00/rBBX2V8wGj2AT73VAADs_JSxqpo468.png)

#### 初始化

HashMap有四个重载构造函数，分别是：HashMap(), HashMap(int initialCapacity, float loadFactor), HashMap(int initialCapacity), HashMap(Map<? extends K, ? extends V> m)

假设使用Map map=new HashMap() 进行初始化，此时采用默认容量大小是16，但HashMap采用懒加载模式，因此只有在真正put一个元素的时候才会初始化数组。

如果初始化指定一个容量，则会使用指定的容量（前提得是2的倍数），如果不是2的倍数，会将输入的值调整为大于等于这个数的2的倍数。具体算法如下：

```java
	static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
```

假设输入初始容量是17，那么期望得到的容量就是32，计算过程如下：

```
  0001 0001  cap
  0001 0000  cap-1
| 0000 1000  n>>>1 
  0001 1000  n
| 0000 0110  n>>>2
  0001 1110  n
| 0000 0001  n>>>4
  0001 1111  n
继续右移的话所有位都是0，所以得到的n最终是 0001 1111 ，即31，31+1=32
```

#### put一个key，value

第一步先判断数组有没有初始化，如果为null，先初始化一个数组，大小为默认值16，再计算key的数组下标，将Node<key,value>放到相应位置，若对应的位置没有放元素，则直接放入即可；若对应位置已经有元素了（即产生了hash冲突），则判断已有的元素和要放入的元素是否相同，通过比较key的hash值，key值得到，（这也就是为什么重写equals()必须重写hashCode()，因为相等的对象必须有同样的hashCode才能放到散列表的相同位置。）若相同，则替换掉原来的Node节点；若不同，则看当前节点是链表节点还是树节点，若是链表节点，则遍历链表，如果遇到相同的key则替换，没有遇到就插入到尾部；若是树节点就执行红黑树的插入操作。

1. 数组下标是怎么计算的

   首先对传入的key进行hash()，jdk8中的hash方法是将key的hashCode异或上key的hashCode无符号右移16位，如下代码：

   ```java
   	static final int hash(Object key) {
           int h;
           return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
       }
   ```

   得到计算好的hash值后，显然不能直接存入，需要进行对数组长度取余这种类似的操作，HashMap中使用 hash & length-1  计算得到数组下标，为什么这样能得到下标，这也是HashMap的数组大小必须是二的倍数的原因。假设数组大小为16，求得的hash值为1100 0100，那么计算数组下标的具体步骤为：

   ```
     1100 0100 
   & 0000 1111
     0000 0100
   ```

    即下标是4。

   所以为什么HashMap的数组大小是二的倍数，因为 length-1 低位都为1，高位都为0，这样不管来的hash值高位有多少个1，在进行“与”0操作后都会变成0，下标都会完美落在 [0,length-1]这个区间，而低位“与”上1之后还是低位数字本身，因为任何数“与”1还是自己本身。

2. 何时链表转化成红黑树

   当原链表的长度>=8（当put第9个元素时）且数组大小>=64时。

3. 何时扩容

   当元素个数（size）>=threshold 时进行扩容，或者链表长度超过8但数组大小还未到64时

4. 链表转红黑树的阈值为什么是8

   HashMap的作者通过计算概率得到在良好的hash函数下，链表的长度概率遵循泊松分布，超过8的可能性微乎其微，如下代码

   ```
   	 * Because TreeNodes are about twice the size of regular nodes, we
        * use them only when bins contain enough nodes to warrant use
        * (see TREEIFY_THRESHOLD). And when they become too small (due to
        * removal or resizing) they are converted back to plain bins.  In
        * usages with well-distributed user hashCodes, tree bins are
        * rarely used.  Ideally, under random hashCodes, the frequency of
        * nodes in bins follows a Poisson distribution
        * (http://en.wikipedia.org/wiki/Poisson_distribution) with a
        * parameter of about 0.5 on average for the default resizing
        * threshold of 0.75, although with a large variance because of
        * resizing granularity. Ignoring variance, the expected
        * occurrences of list size k are (exp(-0.5) * pow(0.5, k) /
        * factorial(k)). The first values are:
        *
        * 0:    0.60653066
        * 1:    0.30326533
        * 2:    0.07581633
        * 3:    0.01263606
        * 4:    0.00157952
        * 5:    0.00015795
        * 6:    0.00001316
        * 7:    0.00000094
        * 8:    0.00000006
        * more: less than 1 in ten million
        
   翻译了一下：
        因为树状节点的大小大约是常规节点的两倍，所以我们只在容器中包含足够多的节点可以使用时才使用它们(参见TREEIFY_THRESHOLD)。当它们变得太小(由于移除或调整大小)，它们被转换回普通的箱子。在使用分布良好的用户哈希码时，很少使用树容器。理想情况下，在随机hashcode下，容器中节点的频率遵循泊松分布(http://en.wikipedia.org/wiki/Poisson_distribution)，参数平均约为0.5，默认的调整阈值为0.75，尽管由于调整粒度的原因，方差很大。忽略方差，列表大小k的期望出现次数为(exp(-0.5) * pow(0.5, k) / factorial(k))。第一个值是:
       * 0: 0.60653066
       * 1: 0.30326533
       * 2: 0.07581633
       * 3: 0.01263606
       * 4: 0.00157952
       * 5: 0.00015795
       * 6: 0.00001316
       * 7: 0.00000094
       * 8: 0.00000006
       *更多:不到千万分之一
   ```

   大概意思是在好的哈希函数下，链表转化为树的可能性极小，只有在不得已的时候才转为树，因为树节点的大小是常规节点的两倍。但为确保万无一失，在hash函数有缺陷的情况下，将链表转化为红黑树能大大加快查询。但个人觉得可能也考虑到8个节点使用链表查询的平均次数是4次，使用红黑树的平均次数是log2(8)=3次，使用红黑树能更优一些，但为啥红黑树转链表的阈值是6呢，个人理解6/2=3，log2(6)=2.6，红黑树还是比链表要快的，所以可能是综合了两种考虑吧，可能觉得链表节点数为6出现的次数算较为频繁了。

#### get一个key

先对key进行hash，计算出下标后去对应位置寻找，若table[index]=key，则返回node.value，若不相等，则遍历链表或者红黑树，直到找到对应的key为止，找不到则返回null

