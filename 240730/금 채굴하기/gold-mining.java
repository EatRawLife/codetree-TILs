//n*n사이즈, 손해보지 않는 선에서 금을 채굴. 팔때는 마름모 모양으로만 팔수 있음.
//격자 밖을 파는 것도 비용에 카운트. 그러나 금은 없다.
//K번이내로 갈수있는 모든 영역이 색칠된 모양 == 마름모 모양. K= 0 바로 그자리.
//채굴비용 = 마름모 격자개수 == K*K+(K+1)*(K+1)임. 손해보지 않는 선까지 채굴가능한
//금개수를 출력. 
//기준으로할 좌표는 마름모의 중심. 깊이 탐색하여 금 채굴여부를 찾지 않았다면? 채굴
//visited하나 필요하고. 금 여부 하나 필요. 비용은 식으로.
//K는 N제곱까지 가능하다. 가장 구석 가정시 가장 먼곳은 N제곱 거리.
//최대 20제곱의 칸수에서 20제곱 만큼 k 번. 최대 16만 정도 > 충분!
//k는 입력된 n에 대하여 2n으로 정의한다.
import java.util.*;
import java.io.*;

class Point{
    int x;
    int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main{
    public static int n; //격자 한변 길이
    public static int m; //금하나 가격.
    public static int k;
    public static int maxi = 0;
    public static int goldCount;

    public static int dx[] = {-1,1,0,0};
    public static int dy[] = {0,0,-1,1};

    public static int[][] gold = new int[20][20];
    public static int[][] visited;
    public static Queue<Point> q = new LinkedList<>();

    public static int cost(int i){
        return i*i + (i+1)*(i+1);
    }

    public static boolean isNotOut(int x,int y){
        if(x>=0&&x<n&&y>=0&&y<n)
        return true;
        return false;
    }

    public static boolean isNotVisited(int x, int y){
        if(visited[x][y] ==0)
        return true;
        return false;
    }

    public static boolean thereIsGold(int x, int y){
        if(gold[x][y] == 1)
        return true;
        return false;
    }

    public static void calc(int k){
        //너비 우선 탐색을 이용해 현재 큐에 든 좌표로 부터 k까지 떨어진 모든 점에서
        //금 존재 여부를 살펴주면 됨.

        while(!q.isEmpty()){
            Point currVer = q.poll();

            for(int i = 0; i< 4; i++){

                if(visited[currVer.x][currVer.y] > k)
                continue;
                int newX = currVer.x+dx[i];
                int newY = currVer.y+dy[i];

                if(isNotOut(newX,newY)&&isNotVisited(newX,newY)){

                    if(thereIsGold(newX, newY))
                    goldCount++;

                    visited[newX][newY] = visited[currVer.x][currVer.y]+1;
                    q.add(new Point(newX,newY));
                }
            }
        }
    }

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();


        for(int i = 0; i< n; i++){
            for(int j = 0; j<n; j++){
                gold[i][j] = scan.nextInt();
            }
        }

        for(int i = 0; i< n; i++){
            for(int j = 0; j<n; j++){
                for(int k = 2*(n-1); k>=0; k--){
                q.add(new Point(i,j));
                visited= new int[20][20];
                visited[i][j] = 1;
                if(thereIsGold(i,j))
                goldCount++;

                calc(k);

                if(goldCount*m >= cost(k)){
                    maxi = Math.max(maxi, goldCount);
                    goldCount = 0;
                    break;
                }
                //각 좌표마다 깊이 탐색. 
                //방문하지 않은 곳은 방문표시하고 금 개수 세기.
                //반복하다가 한번이라도 
                //마지막 측정했는데 금값과 같거나 더들었으면 얘로 금값 리셋
                goldCount = 0;
                }
            }
        }

        System.out.print(maxi);

    }

}