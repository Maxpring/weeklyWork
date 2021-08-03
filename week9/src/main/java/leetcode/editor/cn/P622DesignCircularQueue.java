//设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”
//。 
//
// 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环
//队列，我们能使用这些空间去存储新的值。 
//
// 你的实现应该支持如下操作： 
//
// 
// MyCircularQueue(k): 构造器，设置队列长度为 k 。 
// Front: 从队首获取元素。如果队列为空，返回 -1 。 
// Rear: 获取队尾元素。如果队列为空，返回 -1 。 
// enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。 
// deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。 
// isEmpty(): 检查循环队列是否为空。 
// isFull(): 检查循环队列是否已满。 
// 
//
// 
//
// 示例： 
//
// MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
//circularQueue.enQueue(1);  // 返回 true
//circularQueue.enQueue(2);  // 返回 true
//circularQueue.enQueue(3);  // 返回 true
//circularQueue.enQueue(4);  // 返回 false，队列已满
//circularQueue.Rear();  // 返回 3
//circularQueue.isFull();  // 返回 true
//circularQueue.deQueue();  // 返回 true
//circularQueue.enQueue(4);  // 返回 true
//circularQueue.Rear();  // 返回 4 
//
// 
//
// 提示： 
//
// 
// 所有的值都在 0 至 1000 的范围内； 
// 操作数将在 1 至 1000 的范围内； 
// 请不要使用内置的队列库。 
// 
// Related Topics 设计 队列 数组 链表 
// 👍 200 👎 0


package leetcode.editor.cn;

//Java：设计循环队列
public class P622DesignCircularQueue {
    public static void main(String[] args) {
        //Solution solution = new P622DesignCircularQueue().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyCircularQueue {
        int[] queue;
        int size;
        //头指针
        int front;
        //尾指针
        int rear;
        //当前队列中元素的个数
        int E_num;

        public MyCircularQueue(int k) {
            this.queue = new int[k];
            this.size = k;
            this.front = -1;
            this.rear = 0;
            this.E_num = 0;
        }

        public boolean enQueue(int value) {
            if (E_num >= size) return false;
            front = (front + 1) % size;
            queue[front] = value;
            E_num++;
            return true;
        }

        public boolean deQueue() {
            if (E_num == 0) return false;
            rear = (rear + 1) % size;
            E_num--;
            return true;
        }

        public int Front() {
            if (E_num == 0) return -1;
            return queue[rear];

        }

        public int Rear() {
            if (E_num == 0) return -1;
            return queue[front];
        }

        public boolean isEmpty() {
            if (E_num == 0) return true;
            return false;
        }

        public boolean isFull() {
            if (E_num == size) return true;
            return false;
        }
    }

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
