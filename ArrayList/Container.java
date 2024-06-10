import java.util.*;
public class Container{
    public static int mostWater(int arr[]){
        int waterLevel=0;
        for(int i=0;i<arr.length;i++){

            for(int j=1+1;j<arr.length;j++){
                int height=Math.min(arr[i],arr[j]);
                int width=j-i;
                int res=height*width;
                if(res>waterLevel){
                    waterLevel=res;
                }
            }
        }
        return waterLevel;
    }
    public static int optimalMostWater(int arr[]){
        int leftP=0;
        int rightp=arr.length-1;
        int waterLevel=0;
        while(leftP<rightp){
            int height=Math.min(arr[leftP],arr[rightp]);
            int width=rightp-leftP;
            int area=height*width;
            if(area>waterLevel){
                waterLevel=area;
            }
            if(arr[leftP]>arr[rightp]){
                rightp--;
            }else{
                leftP++;
            }

        }
        return waterLevel;
    }
    public static int optimalMostWaterUsingArrayList(ArrayList<Integer> arr){
        int leftP=0;
        int rightp=arr.size()-1;
        int waterLevel=0;
        while(leftP<rightp){
            int height=Math.min(arr.get(leftP),arr.get(rightp));
            int width=(rightp-leftP);
            int res=height*width;
            if(arr.get(leftP)>arr.get(rightp)){
                rightp--;
            }else{
                leftP++;
            }
            if(res>waterLevel){
                waterLevel=res;
            }
        }
        return waterLevel;
    }
    public static boolean pairSumInSortedRotatedArr(ArrayList<Integer> arr,int key){
        int bp=-1;
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)>arr.get(i+1)){
                bp=i;
                break;
            }
        }

        int lp=bp+1;
        int rp=bp;
        int n=arr.size();
        while(lp!=rp){
            if(arr.get(lp)+arr.get(rp)==key){
                return true;
            }else if(arr.get(lp)+arr.get(rp)>key){
                rp=(n+rp-1)%n;
            }else{
                lp=(lp+1)%n;
            }
        }
        return false;
    }
    public static void main(String args[]){
        // int arr[]={1,8,6,2,5,4,8,3,7};
        // System.out.print(optimalMostWater(arr));

        ArrayList<Integer> myList=new ArrayList<>();
        myList.add(11);
        myList.add(15);
        myList.add(6);
        myList.add(8);
        myList.add(9);
        myList.add(10);
        System.out.print(pairSumInSortedRotatedArr(myList,16));
        // System.out.print(optimalMostWaterUsingArrayList(myList));

    }
}