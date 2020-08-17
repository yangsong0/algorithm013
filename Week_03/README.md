学习笔记

## 递归

递归代码模板

```java
public void recursion(level, param1, param2, ...){
	// recursion terminator
    if level > MAX_LEVEL{
    	process_result
        return;
    }
    // process logic in current level
    process(level, data...);
    
    // drill down
    self.recursion(level + 1, p1, ...);
    // reverse the current level status if needed
}
    
```

## 分治

分治思路：概括说，将原问题划分成n个规模较小，并且结构与原问题相似的子问题，递归地解决这些子问题，然后再合并其结果，就得到原问题的解。 

```java
private static int divide_conquer(Problem problem, ) {
  
  if (problem == NULL) {
    int res = process_last_result();
    return res;     
  }
  subProblems = split_problem(problem)
  
  res0 = divide_conquer(subProblems[0])
  res1 = divide_conquer(subProblems[1])
  
  result = process_result(res0, res1);
  
  return result;
}
```



## 回溯

回溯思想： 将问题求解的过程分为多个阶段。每个阶段都会面对一个岔路口，先随意选一条路走，当发现这条路走不通的时候，就回退到上一个岔路口，另选一种走法继续。回溯算法非常适合用递归来实现，在实现的过程中，剪枝操作是提高回溯效率的一种技巧。 