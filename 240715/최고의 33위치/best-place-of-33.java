import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();

        int[][] array = new int[size][size];
        
        for(int i = 0; i < size; i++){
            for(int j = 0; j< size ; j++){
                array[i][j] = scan.nextInt();
            }
        }
        int max = 0;

        for(int x = 0; x<size-2;x++){
            for(int y= 0; y<size-2; y++){
                    int a = x;
                    int b = y;
                    int sum = 0;
                for(int i = 0; i<3;i++){
                    for(int j = 0; j<3;j++){
                        if(array[a+i][b+j] == 1)
                        sum++;
                    }
                }
                if(sum > max)
                max = sum;
            }
        }
        System.out.println(max);       
    }
}