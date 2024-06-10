import java.util.*;

public class arrayBasic{

    public static void inc(int arr[]){
        for(int i=0;i<arr.length;i++){
            arr[i]+=1;
        }
    }

    public static void printArr(int arr[]){
        System.out.print("The elements are :");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void linerSearch(int arr[],int key){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==key){
                System.out.print("The element is present at the loacation of :"+i);
            }
        }
    }

    public static int binarySearch(int arr[],int l,int h,int key){
        int high=h;
        int low=0;
        while(high>=low){
            int mid=(high+low)/2;
            if(arr[mid]==key){
                System.out.print("The element found at the index of :"+mid);
                return mid;
            }else if(arr[mid]>key){
                binarySearch(arr,low,mid-1,key);
            }else{
                binarySearch(arr,mid+1,high,key);
            }
        }
        return -1;
    }

    public static int binaryIte(int arr[],int key){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(arr[mid]==key){
                System.out.println("The element is fount at index of :"+mid);
                return mid;
            }else if(arr[mid]>key){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return -1;
    }

    public static void larSmlValue(int arr[]){
        int largest=Integer.MIN_VALUE;
        int smallest=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>largest){
                largest=arr[i];
            }
        }
        System.out.println("The samlles value is "+ largest);
        for(int i=0;i<arr.length;i++){
            if(arr[i]<smallest){
                smallest=arr[i];
            }
        }
        System.out.println("The samlles value is "+ smallest);
    }
    
    public static void revArr(int arr[],int start,int end){

        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }

    public static void pairArr(int arr[]){

        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                System.out.print("{"+ arr[i] +"," +arr[j]+"}  ");
            }
            System.out.println();
        }
    }

    public static void leetArr(int arr[],int key){
        int n = arr.length;
        int start=0;
        int end=arr.length-1;
        key = key % n;
        revArr(arr,start,end);

        revArr(arr,start,key-1);

        int sel=arr.length-1;
        revArr(arr,key,sel);
    }

    public static boolean isMonotonic(int nums[]) {
        if(isinc(nums) || isdec(nums)){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isinc(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                return false;
            }
        }
        return true;
    }

    public static boolean isdec(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]<arr[i+1]){
                return false;
            }
        }
        return true;
    }

    public static void maxSubArr(int arr[]){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=i;j<arr.length;j++){
                sum+=arr[j];
            }
            if(sum>max){
                max=sum;
            }           
        }
        System.out.println(max);
    }        
    
    public static void subArr(int arr[]){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<=arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int sum=0;
                for(int k=i;k<=j;k++){
                    System.out.print(arr[k] +" ");
                    sum+=arr[k];  
                }
                if(sum>max){
                    max=sum;
                }
                // System.out.print("The sum of this subarray is : "+sum);
                System.out.println();  
            }  
            
        }
        System.out.println("The maximum is "+max);
    }
    


    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);

        // int marks[]=new int[50];
        //  int marks[] = {
        //     10, 20, 30, 40, 50, 60, 70, 80, 90, 100,
        //     110, 120, 130, 140, 150, 160, 170, 180, 190, 200,
        //     210, 220, 230, 240, 250, 260, 270, 280, 290, 300,
        //     310, 320, 330, 340, 350, 360, 370, 380, 390, 400,
        //     410, 420, 430, 440, 450, 460, 470, 480, 490, 500
        // };
        // int marks[]={1,2,3,4,5,6,7};
        // int marks[]={1,-2,6,-1,3};
        int marks[]={2,4,6,8,10};
        subArr(marks);
        // maxSubArr(marks);
        // int marks[]={1,1,0};
        // printArr(marks);
        // System.out.print(isMonotonic(marks));
        // int len=marks.length;
        // System.out.print(len);
        // binarySearch(marks,0,len,8);
        // leetArr(marks,3);
        // revArr(marks);
        // printArr(marks);
        // pairArr(marks);
        // binaryIte(marks,140);
      
    }
}
