//n*m크기, 격자 밖으로 나가면 안되고, 한번 간곳 또가면 안되고, 뱀있는곳 못감.
//뱀있는곳은 0 없는곳은 1으로 나타낸다.

import java.util.*;

public class Main {

    public static int n;
    public static int m ; 
    
    public static int[][] array= new int[100][100];;
    public static boolean[][] visited= new boolean[100][100];


    public static boolean movable(int x, int y){
        if(x>=0&&x<n&&y>=0&&y<m&&array[x][y]!=0&&visited[x][y]==false){
            return true;
        }
        return false;
    }

    public static void find(int x, int y){
        
        int[] dx = {1,0};
        int[] dy = {0,1};

        for(int i = 0; i<2; i++){
            int nextX = x+dx[i];
            int nextY = y+dy[i];

            if(movable(nextX,nextY)){
                visited[nextX][nextY] = true;
                find(nextX,nextY);
                            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();

        for(int i = 0; i< n; i++){
            for(int j = 0; j<m; j++){
                array[i][j] = scan.nextInt(); 
                            }
        }
        find(0,0);

        if(visited[n-1][m-1] == true)
        System.out.println("1");
        else
        System.out.println("0");
    }
}