class MyCircularQueue {


        private final int[] queue;
        private int front = 0;
        private int rear = -1;
        private int length = 0;

        public MyCircularQueue(int k) {
            this.queue = new int[k];
        }

        public boolean enQueue(int value) {
            if (this.isFull()) {
                return false;
            }
            this.rear = (this.rear + 1) % this.queue.length;
            this.queue[rear] = value;
            this.length++;

            return true;
        }

        public boolean deQueue() {
            if (this.isEmpty()) {
                return false;
            }
            this.front = (this.front + 1) % this.queue.length;
            this.length--;

            return true;
        }

        public int Front() {
            if (this.isEmpty()) {
                return -1;
            }
            return this.queue[this.front];
        }

        public int Rear() {
            if (this.isEmpty()) {
                return -1;
            }
            return this.queue[this.rear];
        }

        public boolean isEmpty() {
            return this.length == 0;
        }

        public boolean isFull() {
            return this.length == this.queue.length;
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