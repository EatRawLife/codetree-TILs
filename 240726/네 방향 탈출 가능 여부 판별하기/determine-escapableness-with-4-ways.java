//상하좌우 인접한 곳으로만 이동가능.
//뱀있는 곳은 못지나감(간선 못그음.)
//n*m 크기의 격자.
//풀이시에 1번 인덱스부터 이용함.


import java.util.*;

class Pair{
    
    public int x;
    public int y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static int n;
    public static int m;

    public static int[][] array = new int[101][101];
    public static boolean[][] visited = new boolean[101][101];
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static Queue<Pair> q = new LinkedList<Pair>();

    //1부터 인덱스 시작하고 사이즈는 n과 m보다 1씩 큼.

    public static boolean notVisited(int x, int y){
        if(visited[x][y]!= true)
        return true;
        return false;
    }
     public static boolean notOut(int x, int y){
        if(x>=1&&x<=n&&y>=1&&y<=m)
        return true;
        return false;
    }
     public static boolean noSnake(int x, int y){
        if(array[x][y]!= 0)
        return true;
        return false;
    }

    public static void visit(){
        while(!q.isEmpty()){
            Pair curr =  q.poll();
            
            for(int i = 0; i< 4; i++){
                int newX = curr.x+dx[i];
                int newY = curr.y+dy[i];

                if(notOut(newX,newY)&&notVisited(newX,newY)&&noSnake(newX,newY)){
                    visited[newX][newY] = true;
                    q.add(new Pair(newX,newY));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        m = scan.nextInt();
        for(int i = 1; i<= n; i++){
            for(int j = 1; j<=m; j++){
                array[i][j] = scan.nextInt();
            }
        }


        q.add(new Pair(1,1));
        visited[1][1] = true;
        visit();

        if(visited[n][m] == true){
            System.out.print("1");
        }
        else
        System.out.print("0");
        
    }
}