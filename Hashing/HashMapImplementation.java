import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapImplementation {
    static class HashMap<K,V>{
        private class Node{
            K key;
            V value;
            Node(K key,V val){
                this.key=key;
                this.value=val;
            }
        }

        private int n; // n
        private int N;
        private  double threshValue=2.0;
        private LinkedList<Node> bucket[];

        @SuppressWarnings("unchecked")

        public HashMap(){
            this.N=4;
            this.bucket=new LinkedList[4];
            for (int i = 0; i < bucket.length; i++) {
                bucket[i]=new LinkedList<>();
            }
        }

        private int hashFunc(K key){
            return Math.abs(key.hashCode() % N);
        }
        private  int searchIdx(K key,int bi){
            LinkedList<Node> ll=bucket[bi];
            if(ll!=null){
                int di=0;
                for( Node n: ll){
                    if(n.key == key){
                        return di;
                    }
                    di++;
                }
            }
            return -1;
        }
        private void rehash(){
            System.out.println(" Re hashing");

            LinkedList<Node> oldData[] = bucket; // store the previous data;
            bucket=new LinkedList[N*2]; // increase the size by multiple of 2;
            N=2*N; // make the actual size of N by multiple of 2;
            for(int i=0;i<bucket.length;i++){  // adding a empty linkedlist to its index;
                bucket[i]=new LinkedList<>();
            }
            System.out.println("done");
            for(LinkedList<Node> item : oldData){
                for (int i = 0; i < item.size(); i++) {
                    Node node=item.remove();
                    put(node.key,node.value);
                }
            }
        }

        public void put(K key,V value){
            int bi=hashFunc(key); // getting the bucket index
            int di=searchIdx(key,bi); // getting the data index in the linked list
            if(di!=-1){  // if present
                Node node=bucket[bi].get(di); // getting that node
                node.value=value; // putting this value there
            }else{ // if not present
                bucket[bi].add(new Node(key,value)); // creating a new node in that bucket index;
                n++; // increment the size of n (no of nodes)
            }

            double lambda=(double) n/N;
            if(lambda>threshValue){  // if the lambda value is greater than the threshhold value then calling the rehash function;
                rehash();
            }
        }

        public boolean containsKey(K key){
            int bi=hashFunc(key);
            int di=searchIdx(key,bi);
            if(di!=-1){ // if valid value then the key is present in this hashmap
                return true;
            }
            return false; // otherwise return false;
        }

        public V remove(K key){
            int bi=hashFunc(key);
            int di=searchIdx(key,bi);
            if(di!=-1){
                n--;
                return bucket[bi].remove(di).value;
            }
            return null;
        }

        public V get(K key){
            int bi=hashFunc(key);
            int di=searchIdx(key,bi);
            if(di!=-1){
                return bucket[bi].get(di).value;
            }
            return null;
        }
        public ArrayList<K> keySet(){
            ArrayList<K> list=new ArrayList<>();
            for (int i = 0; i < bucket.length; i++) {
                LinkedList<Node> ll=bucket[i];
                for(Node node : ll){
                    list.add(node.key);
                }
            }
            return list;
        }

        public boolean isEmpty(){
            return n==0;
        }

        public static void main(String[] args) {
            HashMap<String,Integer> hm=new HashMap<>();
            hm.put("sandip9",19);
            hm.put("sandip1",19);
            hm.put("sandip2",19);
            hm.put("sandip3",19);
            hm.put("sandip4",19);
            hm.put("sandip5",19);
            hm.put("sandip6",19);
            hm.put("sandip7",19);
            hm.put("sandip8",19);
            hm.put("sandip8",19);
        }



    }
}
