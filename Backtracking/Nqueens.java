public class Nqueens{
public static boolean isSafe(char board[][], int row, int column) {
    // vertical up
    for (int i = row - 1; i >= 0; i--) {
        if (board[i][column] == 'Q' || board[i][column] == 'q') {
            return false;
        }
    }
    // diagonal left
    for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
        if (board[i][j] == 'Q' || board[i][j] == 'q') {
            return false;
        }
    }
    // diagonal right
    for (int i = row - 1, j = column + 1; i >= 0 && j < board[i].length; i--, j++) {
        if (board[i][j] == 'Q' || board[i][j] == 'q') {
            return false;
        }
    }
    return true;
}

    static int count=0;
    public static void nQueens(char board[][],int row){
        
        if(row==board.length){
            printBoard(board);
            count++;
            return;
        }
        for(int j=0;j<board.length;j++){
            if(isSafe(board,row,j)){
                board[row][j]='Q';
                nQueens(board,row+1);
                board[row][j]='.';
            }
        }
    }
    // public static boolean nQueens(char board[][],int row){
    //     if(row==board.length){
    //         // printBoard(board);
    //         return true;
    //     }   

    //     for(int j=0;j<board[0].length;j++){
    //         if(isSafe(board,row ,j)){
    //             board[row][j]='Q';
    //             if(nQueens(board,row+1)){
    //                 return true;
    //             }
    //             board[row][j]='.';
    //         }
    //     }
    //     return false;
    // }
    public static void printBoard(char board[][]){
        System.out.println("----");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        
    }
    public static void sortColors(int[] nums) {
        int aux[]=new int[3];
        for(int i=0;i<nums.length;i++){
            aux[nums[i]]++;
        }
        
        int j=0;
        for(int i=0;i<aux.length;i++){
            while(aux[i]>0){
                nums[j]=i;
                j++;
                aux[i]--;
            }
        }
    }
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        
    }
    public static void main(String args[]){
        int n=5;
        char board[][]=new char[n][n];
        // for(int i=0;i<board.length;i++){
        //     for(int j=0;j<board[0].length;j++){
        //         board[i][j]='.';
        //     }
        // }
        // if(nQueens(board,0)){
        //     printBoard(board);
        // }else{
        //     System.out.print("Solution is not possible");
        // }
        nQueens(board,0);
        System.out.print(count);
        // int arr[]={2,0,2,1,1,0};
        // sortColors(arr);
        // printArr(arr);
    }
}