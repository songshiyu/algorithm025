//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//
//        push(x) —— 将元素 x 推入栈中。
//        pop() —— 删除栈顶的元素。
//        top() —— 获取栈顶元素。
//        getMin() —— 检索栈中的最小元素。
//         
//
//        示例:
//        输入：
//        ["MinStack","push","push","push","getMin","pop","top","getMin"]
//        [[],[-2],[0],[-3],[],[],[],[]]
//        输出：
//        [null,null,null,null,-3,null,0,-2]
//
//        解释：
//        MinStack minStack = new MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        minStack.getMin();   --> 返回 -3.
//        minStack.pop();
//        minStack.top();      --> 返回 0.
//        minStack.getMin();   --> 返回 -2.


/**
 * @author songshiyu 最小栈 TODO
 * @create: 2021/4/7 09:18:08
 **/
public class Leetcode155 {

    class MinStack {


        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int val) {

        }

        public void pop() {

        }

        public int top() {
            return -1;
        }

        public int getMin() {
            return -1;
        }
    }


}
