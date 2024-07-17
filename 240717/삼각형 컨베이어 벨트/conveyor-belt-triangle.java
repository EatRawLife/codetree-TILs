import java.util.Scanner;
public class Main{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int t = scan.nextInt();

        int[][] array = new int[3][n];
        for(int i = 0; i< 3; i++){
            for(int j = 0; j< n; j++){
                array[i][j] = scan.nextInt();
            }
        }

        int temp = array[2][n-1];
        for(int j = 0; j< t; j++){
        for(int z = 2; z>=0; z--){
            for(int i = n-1; i>0;i-- ){
                array[z][i] = array[z][i-1];
            }
            if(z==0)
            array[0][0] = temp;
            else{
                array[z][0] = array[z-1][n-1];
            }
        }
        }

        for(int i = 0; i<3; i++){
            for(int j = 0; j< n; j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }
}