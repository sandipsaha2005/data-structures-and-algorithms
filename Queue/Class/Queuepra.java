public class Queuepra {
    static class Queue{
        static int arr[];
        static int rear;
        static int size;
        
        Queue(int n){
            this.size=n;
            arr=new int[n];
            this.rear=-1;
        }
        public static boolean isEmpty(){
            return rear==-1;
        }
        public static void add(int data){
            if(rear==size-1){
                System.out.println("Queue is full");
                return;
            }
            rear=rear+1;
            arr[rear]=data;
        }
        public static int deQueue(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int front=arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i]=arr[i+1];
            }
            rear--;
            return front;
        }
        public static void display(){
            for(int i=0;i<arr.length;i++){
                System.out.println(arr[i]);
            }
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[0];
        }

    }
    static class CircularQueue {
        static int arr[];
        static int size;
        static int front;
        static int rear;

        CircularQueue(int n) {
            size = n;
            front = rear = -1;
            arr = new int[n];
        }

        public static void add(int data) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            if(front==-1){
                front=0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public static boolean isFull() {
            return (rear + 1) % size == front;
        }
        public static boolean isEmpty(){
            return front==-1;
        }
        public static int remove(){
            if(isEmpty()){
                System.out.println("The queue is empty");
                return -1;
            }
            int res=arr[front];

            if(rear==front){
                rear=front=-1;
            }else{
                front=(front+1)%size;
            }
            return res;
        }
        public  int peek() {
            if(isEmpty()){
                System.out.println("The queue is empty");
                return -1;
            }

            return arr[front];
        }
        public void display() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }

            System.out.print("Queue is: ");
            if (rear >= front) {
                for (int i = front; i <= rear; i++) {
                    System.out.print(arr[i] + " ");
                }
            } else {
                for (int i = front; i < size; i++) {
                    System.out.print(arr[i] + " ");
                }
                for (int i = 0; i <= rear; i++) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
//        Queue q=new Queue(10);
//        q.add(1);
//        q.add(2);
//        q.add(3);
//        q.add(4);
//        q.add(5);
//
//        while (!q.isEmpty()){
//            System.out.println(Queue.peek());
//            Queue.deQueue();
//        }
        CircularQueue cq=new CircularQueue(4);
        cq.add(12);
        cq.add(13);
        cq.add(14);
        cq.add(15);

        int g=cq.remove();
        System.out.println(g);
        int fir=cq.peek();
        System.out.println(fir);
        cq.add(16);
        cq.display();

    }
}
