import java.util.Scanner;
public class Main {

    public static final int MAX_N = 100;

    public static int n;
    public static int m;
    public static int t;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static int[] mx;
    public static int[] my;
    public static int sizeOfM;

    public static int[][] array = new int[MAX_N][MAX_N];

    public static boolean isOut(int x, int y){
        if(x<0||x>n-1||y<0||y>n-1){
            return true;

        }
        return false;
    } 

    public static void remove(){
        int[] newMxArray = new int[m];
        int[] newMyArray = new int[m];
        int tempSize = 0;

        for(int i = 0; i< sizeOfM; i++){
            if(mx[i] != -1){
                newMxArray[tempSize] = mx[i];
                newMyArray[tempSize++] = my[i];
            }
        }

        mx = newMxArray;
        my = newMyArray;
        sizeOfM = tempSize;
    }

    public static void inspection(){
        for(int i = 0; i< sizeOfM; i++){
            int x = mx[i];
            int y = my[i];
            boolean find = false;

            for(int j = i+1; j< sizeOfM; j++){
                
                if(x == mx[j]&&y == my[j])
                {
                    mx[j] = -1;
                    my[j] = -1; 
                    find = true;
                }
            }
            if(find == true){
                mx[i] = -1;
                my[i] = -1;
            }
        }

        remove();
    }

    public static void move(int mIndex){
        //상하좌우 순서(d)로 살펴보고 
        //바깥이면 그냥 넘어가고
        //상하좌우중 큰쪽으로 넘어가되 상하좌우 순서로 넘어가기.

        int newX = mx[mIndex];
        int newY = my[mIndex];

        for(int i = 0; i< 4; i++){
            int tempX = newX+dx[i];
            int tempY = newY+dy[i];

            if(isOut(tempX,tempY))
            continue;

            if(array[tempX][tempY] >array[newX][newY])
            {
                newX = tempX;
                newY = tempY;
                break;
            }
        }

        mx[mIndex] = newX;
        my[mIndex] = newY;

      

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        m = scan.nextInt();
        mx = new int[m];
        my = new int[m];
        sizeOfM = m;
        t = scan.nextInt();

        for(int i = 0; i< n; i++){
            for(int j = 0; j<n; j++){
                array[i][j] = scan.nextInt();
            }
        }

        
        for(int j = 0; j<m;j++){
            mx[j] = scan.nextInt()-1;
            my[j] = scan.nextInt()-1;
        }
        
        for(int i =0; i< t; i++){
            for(int j = 0; j<sizeOfM;j++){
                move(j);
                //횟수만큼 이동시킴. 
            }
            inspection();
            //겹치는 게 있는지 검사.
        }

        System.out.print(sizeOfM);
        
    }
}