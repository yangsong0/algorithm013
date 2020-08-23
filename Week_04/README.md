学习笔记

**使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方**

该问题可以转换为：寻找半有序数组中的最小值（或最大值）

思路：通过二分查找，找到中间元素，与第0个元素比较，若nums[mid]>nums[0]，则说明还未出现最小值，最小值在数组的后半段，可以往右缩小范围，使low=mid+1，继续寻找后半段；若nums[mid]<nums[0]，说明已经出现了最小值，可以往左缩小范围，使high=mid，直到最后low>=high时，返回nums[low]，得到最小值

```java
public int findMin(int[] nums){
        if(nums==null || nums.length==0){
            return -1;
        }
        int n=nums.length-1;
    	//去掉尾部重复值
        for(;nums[0]==nums[n];n--);
    	//若if成立，说明数组本身有序
        if(nums[0]<nums[n]){
            return nums[0];
        }
        int l=0,h=n;
        while(l<h){
            int mid=l+h>>1;
            if(nums[mid]<nums[0]){
                h=mid;
            }else if(nums[mid]>nums[0]){
                l=mid+1;
            }
        }
        return nums[l];
    }
```

**变形：使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中的某个值，返回其下标**

假设数组中不存在重复的元素。 

思路：虽然整体数组不是有序，但从中间某个位置开始，左右两边都是升序有序的，可以通过判断中间元素和最后一个元素的大小来判断中间元素位于数组的左半有序段还是右半有序段（如举例中的{4,5,6,7}属于左半有序段，{0,1,2}属于右半有序段）。

若nums[mid]<nums[high]，说明nums[mid]属于右半有序段，右半有序段我们无法判断其最小值是多少，但是可以知道最大值一定是nums[high]，可以通过比较target与nums[mid]以及target与nums[high]来确定应该往哪个范围寻找，若nums[mid]<target && nums[high]>=target则说明target位于mid和high之间的位置，可以使low=mid+1缩小范围继续查找，否则使high=mid-1;

若nums[mid]>nums[high]，说明nums[mid]属于左半有序段，左半有序段无法判断其最大值是多少，但是可以知道最小值一定是nums[low]，所以可以通过比较target与nums[mid]以及target与nums[low]来确定应该往哪个范围寻找，若nums[mid]>target && nums[low]<=target则说明target位于low和mid之间的位置，可以使high=mid-1缩小范围继续查找，否则使low=mid+1

```java
int low=0,high=nums.length-1;
        while(low<=high){
            int mid=low+high>>1;
            if(target==nums[mid]){
                return mid;
            }
            //判断mid在哪一段，若在右半段，中间值小于high值，若在左半段，中间值大于high值
            if(nums[mid]<nums[high]){
                //mid在右半段
                if(nums[mid]<target && nums[high]>=target){
                    //往右查找
                    low=mid+1;
                }else{
                    //往左查找
                    high=mid-1;
                }
            }else{
                //mid在左半段
                if(nums[mid]>target && nums[low]<=target){
                    //往左查找
                    high=mid-1;
                }else{
                    //往右查找
                    low=mid+1;
                }
            }
        }
        return -1;
```

