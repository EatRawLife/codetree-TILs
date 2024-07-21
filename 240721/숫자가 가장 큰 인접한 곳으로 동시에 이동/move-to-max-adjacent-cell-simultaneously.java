/*각 구슬의 위치는 좌표를 리스트로 저장 하지 않고 직접 2차원 배열 선언, 각칸으로 나타내자.
즉 array라는 기존의 좌표마다의 값을 저장한 리스트 하나와 구슬 위치를 저장한 배열 총 두개가 존재한다.
거기다 위치 이동시 여러개를 동시에 이동하기 때문에 현재 1이 있는 위치가 현재 좌표가 있는 곳인지, 
아니면 이미 변경한 위치인지 알 수 없기때문에 이동한 구슬은 새로운 count 안에 저장후 다 저장하면 옮겨줄거임.
*/

//격자 안의 숫자는 1에서 100이하임. 
//m개 구슬중 가장 큰값으로 이동, 그런데 여러개면 상하좌우 우선순위로 이동. 격자 벗어나면 안됨.
//상하좌우 순서로 격자를 살피되, 기존 큰값으로 저장된 것보다 더 큰 값이 나와야 그 값으로 바꿈.
//한타임에 같은자리 두개의 구슬 존재시 둘다 사라짐.

import java.util.Scanner;
public class Main{

    public static final int Max_N = 20;

    public static int n;
    public static int m;
    public static int t;

    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};

    public static int[][] array = new int[Max_N][Max_N];
    public static int[][] count = new int[Max_N][Max_N];

    public static void move(int[][] tempCount, int r, int c){
        //해당 위치 오브가 이동할 다음 위치를 계산함.
        //다음 위치를 계산하면 temp 배열에서 위치 이동 시켜줄거임. 

        int max = 0; 
        int position = -1;

        for(int i = 0; i<4; i++){
            int nextX = r+dx[i];
            int nextY = c+dy[i];

            if(nextX<0||nextX>n-1||nextY<0||nextY>n-1)
            continue;

            if(max<array[nextX][nextY]){
                max = array[nextX][nextY];
                position = i;
            }
        }

        tempCount[r+dx[position]][c+dy[position]]++;
    }

    public static void moveAll(){
        //count를 살피다가 1이 나오면 해당 위치의 구슬의 다음 이동위치를 계산
        //이새로운 위치를 다른 2차원 배열에 저장시킴.
        //마지막으로 1보다 큰 오브는 지워버림. 

        int[][] tempCount = new int[Max_N][Max_N];
        for(int r = 0; r<n; r++){
            for(int c = 0; c<n; c++){
                if(count[r][c]!= 0){
                    move(tempCount, r,c);
                }
            }
        }

        for(int r = 0; r<n; r++){
            for(int c = 0; c<n; c++){
                if(tempCount[r][c]> 1){
                tempCount[r][c] = 0;
                }
            }
        }
        count = tempCount;

        
    }

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        m = scan.nextInt();
        t = scan.nextInt();

        for(int r = 0; r<n; r++){
            for(int c = 0; c<n; c++){
                array[r][c] = scan.nextInt();
            }
        }

        for(int ob = 0; ob<m; ob++){
            int r = scan.nextInt();
            int c = scan.nextInt();
            count[r-1][c-1] = 1;
        }

        for(int i = 0; i< t; i++){
            moveAll();
        }

        int obCount = 0;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(count[i][j] == 1)
                obCount++;
            }
        }

        System.out.println(obCount);

    }
}