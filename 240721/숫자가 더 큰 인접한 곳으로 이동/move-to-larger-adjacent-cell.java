//현재 위치보다 더큰 위치의 숫자가 있는 위치로 이동, 우선순위는 상하좌우.

import java.util.Scanner;
public class Main {

    public static final int MAX_N = 100;

    public static int n;
    public static int row;
    public static int column;

    public static int[][] array = new int[MAX_N][MAX_N];
    
    public static int dx[] = {-1,1,0,0};
    public static int dy[] = {0,0,-1,1};

    public static boolean move(int x, int y){
        

        for(int i = 0; i < 4; i++){
            int nextX = x+dx[i];
            int nextY = y+dy[i];
            if(isOk(nextX,nextY)&&array[nextX][nextY]>array[x][y]){
            row = nextX;
            column = nextY;
            break;
            }
            if(i == 3){
                return false;
            }

        }
        return true;
    }
    
    public static boolean isOk(int x, int y){
        if(x>=0&&x<=n-1&&y>=0&&y<=n-1)
        return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        row = scan.nextInt()-1;
        column= scan.nextInt()-1;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                array[i][j] = scan.nextInt();
            }
        }

        boolean ctinue = true;
        System.out.print(array[row][column]+" ");
        while(ctinue){
            ctinue = move(row,column);
            if(ctinue == true){
                System.out.print(array[row][column]+" ");
            }
            else
            break;
        }

    }
}