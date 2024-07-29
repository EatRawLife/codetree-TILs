//나이트는 판 밖이 아니면서 방문한 지점만 아니면 저기로 가면된다.
import java.util.*;

class Pair{
    int x;
    int y;
    public Pair(int x, int y){
        this.x = x; 
        this.y = y;
    }
}

public class Main {
    public static int[] dx = {-2,-1,1,2,2,1,-1,-2};
    public static int[] dy = {1,2,2,1,-1,-2,-2,-1};

    public static Pair start;
    public static Pair end;

    public static int n;

    public static boolean[][] visited = new boolean[100][100];
    public static int[][] step = new int[100][100];

    public static Queue<Pair> q = new LinkedList<Pair>();

    public static boolean notOut(int x, int y){
        if(x>=0&&x<n-1&&y>=0&&y<n-1)
        return true;
        return false;
    }
    public static boolean notVisited(int x, int y){
        if(visited[x][y] == false)
        return true;
        return false;
    }

    public static void visit(){
        while(!q.isEmpty()){
            Pair currVer = q.poll();
            
            for(int i = 0; i< 8; i++){
                int newX = currVer.x+dx[i];
                int newY = currVer.y+dy[i];

                if(notOut(newX,newY)&&notVisited(newX,newY)){
                    visited[newX][newY] = true;
                    step[newX][newY] = step[currVer.x][currVer.y]+1;
                    q.add(new Pair(newX,newY));
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        n = scan.nextInt();
        
        start = new Pair(scan.nextInt()-1, scan.nextInt()-1);
        end = new Pair(scan.nextInt()-1, scan.nextInt()-1);

        visited[start.x][start.y] = true;
        step[start.x][start.y] = 0;
        q.add(new Pair(start.x,start.y));

        visit();

        if(visited[end.x][end.y]==true){
            System.out.print(step[end.x][end.y]);
        }
        else{
            System.out.print("-1");
        }
    }
}