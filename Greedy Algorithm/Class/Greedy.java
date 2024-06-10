import java.lang.reflect.Array;
import java.util.*;

public class Greedy {
    public static void activitySelection(int st[],int et[]){ // for sorted End time
        int maxWork=0;
        ArrayList<Integer> list=new ArrayList<>();
        maxWork=1;
        list.add(0);
        int lastEnd=et[0];
        for (int i = 1; i < et.length; i++) {
            if(st[i]>=lastEnd){
                maxWork++;
                list.add(i);
                lastEnd=et[i];
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print("A" + list.get(i) + " ");
        }
    }
    public static void actSelection(int st[],int et[]){ // for un-sorted end
        int arr[][]=new int[et.length][3];
        for (int i = 0; i < et.length; i++) {
            arr[i][0]=i;
            arr[i][1]=st[i];
            arr[i][2]=et[i];
        }
        Arrays.sort(arr, Comparator.comparingDouble(o-> o[2]));
        ArrayList<Integer> list=new ArrayList<>();
        int maxWork=0;

        maxWork=1;
        list.add(arr[0][0]);
        int lastEnd=arr[0][2];
        for (int i = 1; i < st.length; i++) {
            if(arr[i][1]>=lastEnd){
                maxWork++;
                list.add(arr[i][0]);
                lastEnd=arr[i][2];
            }
        }
        System.out.println(maxWork);
    }

    public static void knapsack(int val[],int wei[],int capacity){ // for unsorted
        double arr[][]=new double[wei.length][2];
        for (int i = 0; i < val.length; i++) {
            arr[i][0]=i;
            arr[i][1]=(double) val[i]/wei[i];
        }
        int total=0;
        Arrays.sort(arr,Comparator.comparingDouble(o->o[1]));
        for (int i = wei.length-1; i >= 0 ; i--) {
            int idx=(int)arr[i][0];
            if(capacity>=wei[idx]){
                total+=val[idx];
                capacity-=wei[idx];

            }else{
                total+= arr[i][1] * capacity;
                capacity=0;
                break;
            }
        }
        System.out.println(total);
        return;
    }
    public static int minAbsDiff(int arr1[],int arr2[]){
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int minVal=0;
        for (int i = 0; i < arr1.length; i++) {
            minVal+=Math.abs(arr1[i]-arr2[i]);
        }
        return minVal;

    }
    public static int maxLenChain(int arr[][]){
        Arrays.sort(arr,Comparator.comparingDouble(o->o[1]));
        int maxLen=0;

        maxLen=1;
        int lastEnd=arr[0][1];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i][0]>lastEnd){
                maxLen++;
                lastEnd=arr[i][1];
            }
        }
        return maxLen;
    }
    public static int minNoOfCoin(int key){
        int curr[]= {2000,500,100,50,20,10,5,2,1};
        int total=key;
        int cout=0;
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i < curr.length; i++) {
            if(curr[i]<=total){
                while (curr[i]<=total) {
                    list.add(curr[i]);
                    total = total - curr[i];
                    cout++;
                }
            }
        }
        return cout;
    }
    public static int costOfCuttingChocolate(Integer costH[],Integer costV[]){
        Arrays.sort(costH,Collections.reverseOrder());
        Arrays.sort(costV,Collections.reverseOrder());

        int h=0;
        int v=0;
        int cost=0;
        int hp=1;
        int vp=1;
        while (h< costH.length && v< costV.length){
            if(costH[h] <=costV[v]){  // vertical cut
                cost += hp * costV[v];
                vp++;
                v++;
            }else{
                cost += vp * costH[h];
                hp++;
                h++;
            }
        }
        while (h< costH.length){
            cost += vp * costH[h];
            hp++;
            h++;
        }
        while (v< costV.length){
            cost += hp * costV[v];
            vp++;
            v++;
        }
        return cost;
    }
    public static int jobSequencign(int arr[][]){  // {{4,20},{1,10},{1,40},{1,30}}

        ArrayList<Job> l=new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            l.add(new Job(i,arr[i][0],arr[i][1]));
        }
        Collections.sort(l,(obj1,obj2)->obj2.profit-obj1.profit);
        int time=0;
        ArrayList<Integer> jobs=new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            Job curr=l.get(i);
            if(curr.deadlin > time){
                jobs.add(i);
                time++;
            }
        }
        System.out.println(jobs);
        return time;
    }
    public static void main(String args[]){
//        Integer st[]={1,3,2,5};
//        Arrays.sort(st, Collections.reverseOrder());
//        System.out.println(st[0]);
//        int et[]={2,4,3,6};
//        activitySelection(st,et);
//        actSelection(st,et);

//        int value[]={30,100,120};
//        int weight[]={10,20,30};
//        int totalCapacity=50;
//        knapsack(value,weight,totalCapacity);
//        String sc="Sandip: Saha !";
//        System.out.println(sc.length());
//        System.out.println(sc.charAt(2));
//        sc=sc.replaceAll("[^a-zA-Z0-9]","");
//        System.out.println(sc);
//        int arr[]={1,2,3};
//        int arr2[]={2,1,3};
//        System.out.println(minAbsDiff(st,et));

//        int arr[][]={{5,24},{39,60},{5,28},{27,40},{50,90}};
//        System.out.println(maxLenChain(arr));
//        int amount=590;
//        System.out.println(minNoOfCoin(amount));

//        int jobInfo[][]={{4,20},{1,10},{1,40},{1,30}};
//        int h = jobInfo.length;
//        ArrayList<Job> arr=new ArrayList<>();
//        for (int i = 0; i < jobInfo.length; i++) {
//            arr.add(new  Job(i, jobInfo[i][0], jobInfo[i][1]));
//        }
//
//        Collections.sort(arr,(obj1,obj2)->obj2.profit-obj1.profit);
//        ArrayList<Integer> list=new ArrayList<>();
//        int time=0;
//        for (int i = 0; i < arr.size(); i++) {
//            Job curr=arr.get(i);
//            if(curr.deadlin>time){
//                list.add(curr.id);
//                time++;
//            }
//        }
//        System.out.println("total number of jobs"+ list.size());
//        for (int i = 0; i < list.size(); i++) {
//            System.out.print(list.get(i)+" ");
//        }
//        System.out.println();



//        Integer costH[]={2,1,3,1,4};
//        Integer costV[]={4,1,2};
//        System.out.println(costOfCuttingChocolate(costH,costV));

        int jobInfo[][]={{4,20},{1,10},{1,40},{1,30}};
        System.out.println(jobSequencign(jobInfo));
    }

}
class Job{
    int deadlin;
    int profit;
    int id;
    Job(int id,int d,int p){
        this.deadlin=d;
        this.profit=p;
        this.id=id;
    }
}
