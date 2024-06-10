public class Practice{

    public static void rotate(int arr[],int k){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        for(int i=k%arr.length;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        for(int i=0;i<k%arr.length;i++){
            for(int j=i+1;j<k%arr.length;j++){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
    }
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void removeDuplicates(int arr[]) {
        int newArr[]=new int[arr.length+1];
        newArr[0]=arr[0];
        // for(int i=1;i<arr.length;i++){
        //     for(int j=0;j<newArr.length;j++){
        //         if(newArr[j]==arr[i]){

        //         }
        //     }
        //     if(newArr[i-1]==arr[i]){
        //         i++;
        //     }else{
        //         newArr[i]=arr[i];
        //     }
        // }
        while()
        printArr(newArr);
    }
    public static void main(String args[]){
        int arr[]={1,2,3,4,5,6,6,7};
        printArr(arr);
        removeDuplicates(arr);
    }
}