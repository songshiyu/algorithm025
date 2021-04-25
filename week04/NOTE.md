学习笔记

搜索-遍历：
    每个节点都要访问一次
    每个节点仅仅要访问一次
    
对于节点的访问顺序不限：
    
        深度优先搜索：DFS
  
        广度优先搜索：BFS
        
二分查找
    
    前提：
        1.目标函数单调性(单调递增或者递减)
        2.存在上下界
        3.能够通过索引访问
        
牛顿迭代法


动态规划
    
    通过把原问题分解为相对简单的子问题，来求解复杂问题
    思想：
        若要解一个给定问题，我们需要解其不同部分(即子问题)，在根据子问题的解得以解出原问题的解。
     适用情况：
        1.最优子结构性质。如果问题的最优解包含的子问题的解也是最优的。我们就称该问题具有最优子结构性质(即满足最优化原理)。
        2.无后效性。即子问题的解一旦确定，就不在改变，不会受在这之后、包含它的更大的问题的求解而影响
        3.子问题重叠性质。子问题重叠性质是指在用递归算法自顶向下对问题求解时，每次产生的子问题并不总是最新问题，有些子问题会被重复计算多次。
        
作业：使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

         public static int findMin(int[] nums) {
                int beginIndex = 0, endIndex = nums.length - 1, result = 0;
                while (beginIndex <= endIndex) {
                    if (nums[beginIndex] <= nums[endIndex]) {
                        int resultIndex = endIndex + 1;
                        if (resultIndex >= nums.length) {
                            result = nums[beginIndex];
                        } else {
                            result = nums[resultIndex];
                        }
                        break;
                    } else {
                        endIndex--;
        
                    }
                }
                return result;
            }
    