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
 

    public static int column;
    public static int row = 0;
    public static int dx = 1;



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        m = scan.nextInt();
        k = scan.nextInt()-1;
        column = k;

        for(int i = 0; i< n; i++){
            for(int j = 0;j< n;j++){
                array[i][j] = scan.nextInt();
            }
        }
        //기존의 array 배열의 세팅 완료.

        //블럭이 바닥이나 다른 블럭을 만날때까지 가다가 맞는위치에 색칠.
        //블럭은 따로따로 움직이지 않고 다같이 움직임.
        //최 좌측 블럭을 추적, 0번재 행부터 3번재 행까지 array의 k~k+m-1열에 1이 있는지 살핌.
        //1이 발견되면 현재 처리하는 행 이전행에 1 넣어주럭임.
        //끝까지 발견 못하면 마지막행에 넣어줌.
        boolean escape = false;
        for(int r = row; r <=n; r++){
            for(int col = column;col<column+m; col++ ){
                if(r ==n || array[r][col] == 1){
                    escape = true;
                    row = r-1;
                    break;
                }
                
            }
            if(escape == true)
                break;
        }


        for(int col = column;col<column+m; col++ ){
            array[row][col] = 1;
        }



        //tempArray에 색칠된 것을 array로 옮겨줌.
        

        //이 아래로는 array에 색칠다된 것을 출력하는 것.
        for(int i = 0; i< n; i++){
            for(int j = 0; j<n; j++){
               System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }

    }
}