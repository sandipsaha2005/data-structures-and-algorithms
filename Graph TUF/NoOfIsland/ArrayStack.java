interface Stack<T>{
    void push(T item);
    T pop();
    T peek();
    boolean isEmpty();
    boolean isFull();
    int size();
}
public class ArrayStack<T> implements Stack<T> {
    private T stack[];
    static int top;
    private static final int DEFAULT_CAPACITY = 10;
    static int s;
    ArrayStack(int s){
        this.s=s;
        this.stack=(T[]) new Object[s];
        top=-1;
    }
    @Override
    public int size() {
        return top+1;
    }

    @Override
    public T pop() {
        if(isEmpty()){
            System.out.println("The stack is empty");
            return null;
        }
        return stack[top--];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top==DEFAULT_CAPACITY-1;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public void push(T item) {
        if(isFull()){
            System.out.println("The stack is full");
            return;
        }
        stack[++top]=item;
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack=new ArrayStack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.push(10);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
//        System.out.println(stack.pop());






    }
}