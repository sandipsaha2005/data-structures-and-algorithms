import java.util.LinkedList;

public class Hashmapcode<E,K> {
    private class Node{
        K key;
        E value;
        Node(K key,E value){
            this.key=key;
            this.value=value;
        }
    }
    private int n;
    private  int N;
    private int[] arr;
    private LinkedList<Node>[] bucket;    // an array of linkedList<Node> type
    @SuppressWarnings("unchecked")
    public Hashmapcode(){
        this.N=4;
        this.bucket= new LinkedList[4];
        for (int i = 0; i < 4; i++) {
            this.bucket[i]=new LinkedList<>();
        }
    }
    private int hashFunction(K key){
        return Math.abs( key.hashCode()) % bucket.length;
    }
    private void rehash(){
        LinkedList<Node> oldBucket[]= bucket;
        bucket=new LinkedList[N * 2];
        N = N*2;
        for (int i = 0; i < bucket.length; i++) {
            bucket[i]=new LinkedList<>();
        }
        for (int i = 0; i < oldBucket.length; i++) {
            LinkedList<Node> ll =oldBucket[i];
            for (int j = 0; j < ll.size(); j++) {
                Node node= ll.remove();
                put(node.key,node.value);
            }
        }
    }
    private int searchINLL(K key,int bIdx){
        LinkedList<Node> ll =bucket[bIdx];
        int di=0;
        for (int i = 0; i < ll.size(); i++) {
            if(ll.get(i).key==key){
                return di;
            }
            di++;
        }
        return -1;
    }
    public void put(K key, E value){
        int bIdx=hashFunction(key);
        int dIdx=searchINLL(key,bIdx);
        if(dIdx != -1){
            Node currNode=bucket[bIdx].get(dIdx);
            currNode.value=value;
        }else{
            bucket[bIdx].add(new Node(key,value));
            n++;
        }
        double lambda= (double)n/N;
        if(lambda>2.0){
            rehash();
        }
    }
    public boolean containsKey(K key){
        int bi=Math.abs( key.hashCode()) % bucket.length;
        LinkedList<Node> ll =bucket[bi];
        for (Node item: ll){
            if(item.key==key){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Hashmapcode<String, Integer> hm=new Hashmapcode<>();
        hm.put(21, "India");
        System.out.println(hm.containsKey(Integer.valueOf("India")));
        ;
    }


}
