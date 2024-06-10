public class Sudoku{
    public static boolean isSafe(int arr[][],int row,int col,int dig){
        // column wise check
        for(int i=0;i<9;i++){
            if(arr[i][col]==dig){
                return false;
            }
        }
        // row wise
        for(int j=0;j<9;j++){
            if(arr[row][j]==dig){
                return false;
            }
        }
        int sr=(row/3)* 3;
        int sc=(col/3)* 3;
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(arr[i][j]==dig){
                    return false;
                }
            }
        }
        return true;
    }
public static boolean sudokuSolver(int arr[][], int row, int col) {
    if (row == 9 && col == 0) {
        return true; // Puzzle is solved
    }
    int nextRow = row;
    int nextCol = col + 1;
    if (col + 1 == 9) {
        nextRow = row + 1;
        nextCol = 0;
    }
    if (arr[row][col] != 0) {
        return sudokuSolver(arr, nextRow, nextCol);
    }
    for (int i = 1; i <= 9; i++) {
        if (isSafe(arr, row, col, i)) {
            arr[row][col] = i;
            if (sudokuSolver(arr, nextRow, nextCol)) {
                return true;
            }
            arr[row][col] = 0;
        }
    }
    return false;
}

    public static void printSudo(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int pow(int x,int y){
        if(y==1){
            return x;
        }else if(x==0){
            return 1;
        }else {
            // return x * pow(x,y-1);
            int half=x * pow(x, y/2);

            return half * 2;
        }
    }
    public static boolean isPalindrome(String s) {
        StringBuilder sb=new StringBuilder("");
        int len=s.length();
        for(int i=len-1;i>=0;i--){
            sb.append(s.charAt(i));
        }
        System.out.print(sb.toString());
        if(s==sb.toString()){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String args[]){
        int sudoku[][]={
                        {3, 0, 6, 5, 0, 8, 4, 0, 0},
                        {5, 2, 0, 0, 0, 0, 0, 0, 0},
                        {0, 8, 7, 0, 0, 0, 0, 3, 1},
                        {0, 0, 3, 0, 1, 0, 0, 8, 0},
                        {9, 0, 0, 8, 6, 3, 0, 0, 5},
                        {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
                        {1, 3, 0, 0, 0, 0, 2, 5, 0},
                        {0, 0, 0, 0, 0, 0, 0, 7, 4},
                        {0, 0, 5, 2, 0, 6, 3, 0, 0} 
        };
        // if(sudokuSolver(sudoku,0,0)){
        //     printSudo(sudoku);
        // }else{
        //     System.out.print("Can't find it ");
        // }
        // System.out.print(pow(4,4));
        String s="sandip";
        // System.out.print(s.length());
        isPalindrome(s);
    }
}