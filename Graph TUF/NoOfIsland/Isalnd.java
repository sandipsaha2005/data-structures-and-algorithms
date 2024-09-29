import java.lang.reflect.Parameter;
import java.util.LinkedList;
import java.util.Queue;

 class Isalnd {
    static class Pair{
        int first;
        int second;
        Pair(int f,int s){
            this.first=f;
            this.second=s;
        }
    }
    public static void bfs(int row, int col, int grid[][], boolean vis[][]){
        vis[row][col]=true;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(row,col));
        int dx[]={1,-1,0,0};
        int dy[]={0,0,-1,1};

        while (!q.isEmpty()){
            Pair res=q.remove();
            int r=res.first;
            int c=res.second;
            for (int k = 0; k < dy.length; k++) {
                int rowN=r + dx[k]; // 1 0
                int colN=c + dy[k];
                if(rowN >= 0 && rowN< grid.length && colN >= 0 && colN < grid[0].length && vis[rowN][colN]!=true && grid[rowN][colN]==1){

                    vis[rowN][colN]=true;
                    q.add(new Pair(rowN,colN));
                }
            }
        }
    }
    public static void dfs(int row,int col,int grid[][],boolean vis[][]){
        vis[row][col]=true;

        int dx[]={1,-1,0,0};
        int dy[]={0,0,-1,1};

        for (int k = 0; k < dy.length; k++) {
            int rowN=row + dx[k];
            int colN=col + dy[k];
            if(rowN >= 0 && rowN < grid.length && colN >=0 && colN < grid[0].length && grid[rowN][colN]==1 && vis[rowN][colN] != true){
                dfs(rowN,colN,grid,vis);
            }
        }

    }

    public static int noOfIsland(int grid[][]){
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        boolean vis[][]=new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                vis[i][j]=false;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(vis[i][j]!=true && grid[i][j]==1){
                    dfs(i,j,grid,vis);
                    count++;
                }
            }
        }
        return count;

    }
    public static void main(String[] args) {
        int grid[][] = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };
        int n=noOfIsland(grid);
        System.out.println(n);
    }
}
