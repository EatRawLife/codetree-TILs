//최단 거리 > BFS를 이용해야함.
//뱀이 있는곳은 못간다. 
//뱀 없는 갈수있는 곳이 1이다.
import java.util.*;

class Pair{
    int x;
    int y;
    public Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int n;
    public static int m;
    public static boolean escaped = false;

    public static int[][] step = new int[100][100];
    public static int[][] array = new int[100][100];
    public static boolean[][] visited = new boolean[100][100];
    public static Queue<Pair> q = new LinkedList<Pair>();

    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};

    public static boolean isNotOut(int x,int y){
        if(x>=0&&x<n&&y>=0&&y<m)
        return true;
        return false;
    }
    public static boolean isNotSnake(int newX,int newY){
        if(array[newX][newY] == 1)
        return true;
        return false;
    }
    public static boolean isNotVisited(int newX,int newY){
        if(visited[newX][newY] == false)
        return true;
        return false;
    }

    public static void visit(){
        while(!q.isEmpty()){
            Pair currVer = q.poll();

            for(int i = 0; i< 4; i++){
                int newX = currVer.x+dx[i];
                int newY = currVer.y+dy[i];

                if(isNotOut(newX,newY)&&isNotSnake(newX,newY)&&isNotVisited(newX,newY)){
                    visited[newX][newY] = true;
                    step[newX][newY] = step[currVer.x][currVer.y]+1;
                    q.add(new Pair(newX,newY));
                }
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

            step[0][0] = 0;
            q.add(new Pair(0,0));
            visited[0][0] = true;
            visit();
        

        if(visited[n-1][m-1] == true)
        System.out.print(step[n-1][m-1]);
        else
        System.out.print("-1");

    }
}