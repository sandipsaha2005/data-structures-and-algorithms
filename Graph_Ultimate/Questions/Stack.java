public class Stack {
    private  int maxSize;
    private int arr[];
    private int top;
    Stack(int s){
        this.top=-1;
        this.maxSize=s;
        this.arr=new int[maxSize];
    }
    void add(int a){
        if(isFull()){
            System.out.println("Your Stack is Full");
            return;
        }
        arr[++top]=a;
    }
    int pop(){
        if(isEmpty()){
            System.out.println("Your Stack is empty");
            return -9999999;
        }
        int removedItem=arr[top];
        top--;
        return removedItem;
    }
    boolean isEmpty(){
        return top==-1;
    }

    boolean isFull(){
        return top==maxSize-1;
    }

    int peek(){
        if(!isEmpty()){
            return arr[top];
        }
        return -99999;
    }
    public static void main(String[] args) {
        Stack a=new Stack(2);
        a.add(10);
        a.add(12);

        System.out.println(a.peek());
    }
}
