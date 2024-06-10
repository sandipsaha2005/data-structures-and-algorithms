import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FirstNonRepeating {
    public static int firstUnique(String str){
        Queue<Character> q=new LinkedList<>();
        int arr[]=new int[26];
        for (int i = 0; i < str.length(); i++) {
            q.add(str.charAt(i));
            arr[str.charAt(i)-97]+=1;
        }
        int i=0;
        for(Character item : q){
            char ch=item;
            if(arr[ch-97]==1){
                return i;
            }
            i++;
        }
        return -1;
    }
    public static void interLeave(Queue<Integer> q){
        int size=q.size();
        Queue<Integer> firstHalve=new LinkedList<>();
        for (int i = 0; i < size/2; i++) {
            firstHalve.add(q.remove());
        }
        while (!firstHalve.isEmpty()){
            q.add(firstHalve.remove());
            q.add(q.remove());
        }
    }
    public static void revQueue(Queue<Integer> q){
        Stack<Integer> s=new Stack<>();
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }

    }
    public static void main(String args[]){
        String str="loveleetcode";
//        System.out.println(firstUnique(str));
//        firstUnique(str);
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<11;i++){
            q.add(i);
        }
//        interLeave(q);
        revQueue(q);
        for(Integer item : q){
            System.out.print(item+" ");
        }
    }

}