//0,1로 된 n*n 격자. 상하 좌우 인접한 곳 계속 이동, 도달 가능한 칸수 구하기.
//0이 이동 가능, 1이 이동불가. << 이거 신경쓰기.
//n이 격자크기 k는 시작할 좌표 개수.

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

    public static int n;
    public static int k;
    public static int count = 0;

    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};

    //이번엔 기존 하던데로 인덱스 0부터 시작.

    public static int[][] array = new int[100][100];
    public static boolean[][] visited;

    public static Queue<Pair> q = new LinkedList<Pair>();

    public static boolean isNotOut(int x, int y){
        if(x>=0&&x<n&&y>=0&&y<n)
        return true;
        return false;  
    }
    public static boolean isZero(int x, int y){
        if(array[x][y]==0)
        return true;
        return false;
    }
    public static boolean isNotVisited(int x, int y){
        if(visited[x][y] == false)
        return true;
        return false;
    }

    public static void visit(){
        while(!q.isEmpty()){
            Pair currVer = q.poll();
            int x = currVer.x;
            int y = currVer.y;

            for(int i = 0; i< 4; i++){
                int newX = x+dx[i];
                int newY = y+dy[i];

                if(isNotOut(newX, newY)&&isZero(newX,newY)&&isNotVisited(newX, newY)){
                    q.add(new Pair(newX, newY));
                    visited[newX][newY] =true;
                    count++;

                }
            }

        }
        
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        k = scan.nextInt();

        for(int i = 0; i< n; i++){
            for(int j = 0; j<n;j++){
                array[i][j] = scan.nextInt();

            }
        }

        int x;
        int y;
        visited = new boolean[100][100];
        

        for(int i = 0; i< k; i++){
            x = scan.nextInt()-1;
            y = scan.nextInt()-1;
            
            if(visited[x][y]!= true){
            visited[x][y] = true;
            count++;
            }
            q.add(new Pair(x,y));
            visit();

        }

        System.out.print(count);
    }
}