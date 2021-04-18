学习笔记

递归
    
        递归-循环
            通过函数体来进行循环，找最近重复子问题
        模板：
            public void recur(int level, int param) { 
             // terminator 
             if (level > MAX_LEVEL) { 
             // process result 
             return; 
             } 
             // process current logic 
             process(level, param); 
             // drill down 
             recur( level: level + 1, newParam); 
             // restore current status 
            }
         思维要点:
            不要进行人肉递归
            找到最近最简方法，将其拆解成可重复解决的问题(也就是找最小子问题)
            数学归纳法
            
分治

        大问题由小的子问题组成，不断的将大问题拆解为小问题，然后把子问题的结果进行组合
        
回溯
        
        回溯法采用试错的思想，它尝试分步的去解决一个问题。在分步解决的过程中，当它通过尝试发现
     现有的分步答案不能  得到有效的正确的解答的时候，它将取消上一步甚至上几步的计算，再通过其他
     的分步解答在次尝试寻找问题答案。
     
        回溯法通常用最简单的递归来实现，在反复重复上述步骤后可能会出现两种情况：
        1.找到一个可能存在的正确答案
        2.在尝试了所有的分步方法后，宣告该问题没有答案
                    