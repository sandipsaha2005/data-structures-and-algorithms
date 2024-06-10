import javax.sound.midi.MidiSystem;
import java.util.*;

public class Example {
    static class Student implements Comparable<Student>{
        int roll;
        int marks;
        Student(int r,int m){
            this.roll=r;
            this.marks=m;
        }


        @Override
        public int compareTo(Student o) {
            return this.marks - o.marks;
        }
    }
    static class Heap{
        ArrayList<Integer> list=new ArrayList<>();

        // Insert into a Heap
        public void add(int a){
            list.add(a);
            int x=list.size()-1;
            int parent=( x-1 )/2;
            while (list.get(x) < list.get(parent)){  // > for maxheap
                int temp=list.get(x);
                list.set(x, list.get(parent));
                list.set(parent, temp);
                x=parent;
                parent=(x-1)/2;
            }
        }

        // Peek operation in Heap
        public int peek(){
            if(!list.isEmpty()){
                return list.get(0);
            }
           return -1;
        }

        // Remove operaion
        public int delete(){
            int data=list.get(0);
            int temp=list.get(0);
            list.set(0,list.get(list.size()-1));
            list.set(list.size()-1, temp);

            list.remove(list.size()-1);
            heapify(0);
            return data;

        }
        private void heapify(int i){
            int left=2*i +1;
            int right=2*i +2;
            int min=i;
            if(left < list.size() && list.get(min) > list.get(left)){  // second wala < for maxHeap
                min=left;
            }
            if(right < list.size() && list.get(min) > list.get(right)){  // second wala < for maxHeap
                min=right;
            }
            if(min!=i){
                int temp=list.get(i);
                list.set(i,list.get(min));
                list.set(min,temp);
                heapify(min);
            }
        }
        public boolean isEmpty(){
            return list.size()==0;
        }
        public static void heapsort(int arr[]){
            int n=arr.length;
            for (int i = n/2; i >= 0 ; i--) {
                heapifys(arr,i,n);
            }
            for (int i = n-1; i > 0 ; i--) {
                int temp=arr[0];
                arr[0]=arr[i];
                arr[i]=temp;

                heapifys(arr,0,n);
            }
        }
        public static void heapifys(int arr[],int idx,int n){
            int left=2*idx+1;
            int right=2*idx+2;
            int maxIdx= idx;
            if(left<n && arr[left]> arr[maxIdx]){
                maxIdx=left;
            }
            if(right < n && arr[right] > arr[maxIdx]){
                maxIdx=right;
            }
            if(maxIdx !=idx){
                int temp=arr[idx];
                arr[idx]=arr[maxIdx];
                arr[maxIdx]=temp;

                heapifys(arr,maxIdx,n);
            }

        }

        static class Point implements Comparable<Point>{
            int x;
            int y;
            int idx;
            int dist;
            Point(int x,int y,int idx,int dist){
                this.x=x;
                this.y=y;
                this.idx=idx;
                this.dist=dist;
            }

            @Override
            public int compareTo(Point p2) {
                return this.dist - p2.dist;
            }
        }
        public static void nearBy(int arr[][],int k){
            PriorityQueue<Point> pq=new PriorityQueue<>();
            for (int i = 0; i < arr.length; i++) {
                int distSqr=arr[i][0]* arr[i][0] + arr[i][1] * arr[i][1];
                pq.add(new Point(arr[i][0],arr[i][1],i,distSqr));
            }

            for (int i = 0; i < k; i++) {
                System.out.print("c"+pq.remove().idx + " ");
            }
        }
        public static int connectNRope(int rope[]){
            PriorityQueue<Integer> pq=new PriorityQueue<>();
            for (int i = 0; i < rope.length; i++) {
                pq.add(rope[i]);
            }
            int cost=0;
            while (pq.size()>1){
                int min=pq.remove();
                int min2=pq.remove();
                cost+=min + min2;
                pq.add(min+min2);
            }
            return cost;
        }
    }
    public static void main(String args[]){
        PriorityQueue<Student> pq=new PriorityQueue<>(Comparator.reverseOrder());
//        pq.add(2);
//        pq.add(1);
//        pq.add(3);
//        while (!pq.isEmpty()){
//            System.out.print(pq.poll());
////            pq.poll();
//        }

//        pq.add(new Student(1,10));
//        pq.add(new Student(2,5));
//        pq.add(new Student(2,29));
//        while (!pq.isEmpty()){
//            System.out.println(pq.peek().marks + " "+ " roll is "+pq.peek().roll);
//            pq.remove();
//        }

        Heap h=new Heap();
//        h.add(3);
//        h.add(4);
//        h.add(2);
//        h.add(5);
//        h.add(1);
//        while (!h.isEmpty()){
//            System.out.print(h.peek());
//            h.delete();
//        }

//        int arr[]={1,5,3,2,4};
//        h.heapsort(arr);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        int arr[][]={{3,3},{5,-1},{-1,4}};
//        int arr2[]=new int[10];
////        h.nearBy(arr,2);
////        System.out.println(Arrays.toString(arr[0]));
//        arr2[0]= Integer.parseInt(Arrays.toString(arr[0]));
//        System.out.println(arr2[0]);
        int rope[]={2,3,3,4,6};
        System.out.println(h.connectNRope(rope));
    }
}
