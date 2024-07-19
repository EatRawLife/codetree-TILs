import java.util.Scanner;

public class Main {
    
    public static final int Max_N = 100;

    public static int n;
    public static int[][] array = new int[100][100];
    public static int row;
    public static int col;

    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {1,-1,0,0};

    public static boolean isOut(int row, int col){
        if(row<0||row>n-1||col<0||col>n-1)
        return true;
        return false;
    }

    public static void move(int row, int col){
        int max = 0;
        int positionx=-1;
        int positiony=-1;

        for(int i = 0; i< 4; i++){
            int newX = col+dx[i];
            int newY = row +dy[i];

            if(isOut(newY,newX))
            continue;

            if(array[newY][newX] > array[row][col]){
            max = array[newY][newX];                  
            positionx = newX;
            positiony = newY;
            break;
            }

        }

            if(max == 0)
            return;

            row = positionx;
            col = positiony;

            System.out.print(array[positiony][positionx]+" ");
            move(positiony,positionx);
        

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n= scan.nextInt();
        row = scan.nextInt()-1;
        col = scan.nextInt()-1;

        for(int i = 0; i<n;i++){
            for(int j = 0; j<n;j++){
                array[i][j] = scan.nextInt();
            }
        }
        System.out.print(array[row][col]+" ");
        move(row,col);

        
    }
}