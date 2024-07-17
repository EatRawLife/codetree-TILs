import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] array = new int[n][n];

        for(int i= 0; i< n; i++){
            for(int j = 0; j< n; j++){
                array[i][j] = scan.nextInt();
            }
        }

        int yIndex = scan.nextInt()-1;
        int xIndex = scan.nextInt()-1;

        // x인덱, y 인덱의 좌표에서 폭탄을 터트리고 그상태로 배열을 변경
        int explosion = array[yIndex][xIndex];
        for(int i = yIndex-(explosion-1); i<=yIndex+(explosion-1);i++ ){
            if(i<0 || i>n-1)
            continue;
            array[i][xIndex] = 0;
        }
        for(int i = xIndex-(explosion-1); i<=xIndex+(explosion-1);i++ ){
            if(i<0 || i>n-1)
            continue;
            array[yIndex][i] = 0;
        }


        for(int i =0; i< n; i++){
            int temp[] = new int[n];
            int tempSize = 0;
            for(int j =0; j<n; j++){
                if(array[j][i] != 0)
                temp[tempSize++] = array[j][i];
            }
            newArray(array,i);
        }

        for(int i = 0; i< n; i++){
            for(int j = 0; j< n; j++){
                System.out.print(array[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static void newArray(int[][] array,int x){
        int[] temp =new int[array[0].length];
        int tempSize = 0;
        
        for(int i = array[0].length-1; i>=0;i--){
            if(array[i][x]!=0){
                temp[array[0].length-1-tempSize] = array[i][x];
                tempSize++;
            }
        }
        for(int i = 0;i<tempSize;i++){
            array[array[0].length-1-i][x] = temp[array[0].length-1-i];
        }

    }
}