import java.util.ArrayList;

public class leetcode {
    public static void printSpira(int arr[][]) {
        ArrayList<Integer> newL = new ArrayList<>();
        int sr = 0;
        int sc = 0;
        int er = arr.length - 1;
        int ec = arr[0].length - 1;
        while (sr <= er && sc <= ec) {
            // top
            for (int j = sc; j <= ec; j++) {
                System.out.print(arr[sr][j]);
                newL.add(arr[sr][j]);
            }
            System.out.println("top");
            sr++;
            // right
            for (int i = sr; i <= er; i++) {
                System.err.print(arr[i][ec]);
                newL.add(arr[i][ec]);
            }
            System.out.println("right");
            ec--;
            // bottom
            if (sr <= er) {
                for (int j = ec; j >= sc; j--) {
                    System.err.print(arr[er][j]);
                    newL.add(arr[er][j]);
                }
                er--;
            }
            System.out.println("bottom");
            // left
            if (sc <= ec) {
                for (int i = er; i >= sr; i--) {
                    System.out.print(arr[i][sc]);
                    newL.add(arr[i][sc]);
                }
                sc++;
            }
            System.out.println("left");
            System.out.println(newL);
        }
            
    }
    public static void subArr(int array[],int key){
        int c=0;
        for (int i = 0; i <array.length; i++) {
            
            for (int j = i; j < array.length; j++) {
                int sum=0;
                for (int j2 = i; j2 <=j; j2++) {
                    System.out.print(array[j2] +" ");
                    sum+=array[j2];
                }
                // System.out.print(sum);
                if (sum==key) {
                    c++;
                }
                System.out.println();
                
            }   
        }   
        System.out.println(c);
    }
    public static void main(String[] args) {
        int arr[][]={
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
            
        // printSpira(arr);
        int arr2[]={2,4,6,8,10};
        subArr(arr2,6);
        
    }
}