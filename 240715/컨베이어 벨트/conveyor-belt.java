import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int t = scan.nextInt();
        int array[][] = new int[2][n];
        for(int i = 0; i< n; i++){
            array[0][i] = scan.nextInt();
        }
        for(int i = n-1;i>=0; i-- ){
            array[1][i] = scan.nextInt();
        }

        for(int i = 0; i< t; i++){
            int temp = array[0][n-1]; 
            for(int j = n-1; j >=1; j--){
                array[0][j] = array[0][j-1];
            }
            array[0][0] = array[1][0];
            for(int j = 0; j<n-1; j++){
                array[1][j] = array[1][j+1];
            }
            array[1][n-1] = temp;
        }

        for(int i = 0; i< n; i++){
            System.out.print(array[0][i]+" ");
        }
        System.out.println();
        for(int i = n-1; i>= 0 ; i--){
            System.out.print(array[1][i]+" ");
        }
    }
}