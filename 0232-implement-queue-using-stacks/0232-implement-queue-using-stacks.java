class MyQueue {

        private final Deque<Integer> stack1;
        private final Deque<Integer> stack2;


        public MyQueue() {
            this.stack1 = new ArrayDeque<>();
            this.stack2 = new ArrayDeque<>();
        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            if (stack2.isEmpty()) {
                move();
            }
            return stack2.pop();
        }

        public int peek() {
            if (stack2.isEmpty()) {
                move();
            }
            return stack2.peek();
        }

        private void move() {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }