//nxn 크기 격자, 0이빈칸, 1이 채워짐.
//하나의 블럭은 높이가 1이고 가로로 하나의 덩어리이다.
//블럭의 기준점은 최 좌측 블럭하나로 잡으면 됨.
//하나 좌표, 옆의 길이로 계산하면 귀찮아질듯. 낙하 멈추는 쪽이 햇갈림.
//그래도 블럭 옮기면서 이 옮긴것과 충돌할일은 없음. 그냥 좌표로 해보자.(이미 옮긴것과 충돌할일이있는가)
//이미 사용하던 배열도 위치 정보외엔 없음. 그배열 그대로 쓰면 될듯.
//블럭이 4타임 이상 이동하면 밖으로 떨어질 수도 있음. 따라서 이동은 최대 4타임만.

//이동 메소드는 밑에 이동이 가능하면 이동시키고 트루를 바노한
//이동 메소드가 밑에 이동이 불가능하면 위치 그대로두고 false 반환.
//true면 계속 수행, 아니면 멈춤.
//

import java.util.Scanner;
public class Main {
    
    public static final int MAX_N = 100;
    public static int[][] array = new int[MAX_N][MAX_N];
    public static int[][] tempArray = new int[MAX_N][MAX_N];

    public static int n;
    public static int m;
    public static int k; 
    public static int dx = 1;
    public static int dy = 0;

    public static int column = k;
    public static int row = -1;
    

    public static boolean move(){
        row += dx;
        for(int i = column; i < k+ m-1; i++){
            tempArray[row][column+i] = 1;
        }
        for(int i = 0; i< n; i++){
            if(tempArray[row][i]==1&& array[row][i]==1)
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        m = scan.nextInt();
        k = scan.nextInt();

        for(int i = 0; i< n; i++){
            for(int j = 0;j< n;j++){
                array[i][j] = scan.nextInt();
            }
        }

        boolean ctinue = true;
       

        for(int i = 0; i< n+1; i++){
            if(i == n+1){
                ctinue = false;
            }
            else
            ctinue = move();
            if(ctinue == false){
            
            for(int j = 0; j< n; j++){
                if(tempArray[i-1][j] == 1)
                array[i-1][j] = 1;
            }
            
            break;
            }
        }
        

        for(int i = 0; i< n; i++){
            for(int j = 0; j<n; j++){
               System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }

    }
}