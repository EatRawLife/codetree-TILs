//지정받은 수열 > 다음과 지금 같은면 +1, 아니면 0으로, 목표 길이 도달하면 +1.
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int satis = scan.nextInt();
        int[][] array = new int[size][size];

        for(int i = 0; i< size; i++){
            for(int j = 0; j<size; j++){
                array[i][j] = scan.nextInt();
            }
        }

        //배열의 길이x2 만큼. i와 j 사용하자. 
        int happy = 0;
        for(int i = 0; i< size; i++){
           happy += calc(array, i, satis);
        }

        System.out.print(happy);
    }


    public static int calc(int[][] array, int coor, int target){
        int sum = 0;
        int cont = 1;

        if(array.length ==1){
            if(target<=1)
            return 2;
            else
            return 0;
        }

        for(int i = 0; i<array[0].length-1;i++){
            if(array[coor][i] == array[coor][i+1])
            cont++;
            else{
                cont = 1;
            }

            if(cont>=target){
                cont = 1;
                sum++;
                break;
            }
        }

        for(int i = 0; i<array[0].length-1;i++){
            if(array[i][coor] == array[i+1][coor])
            cont++;
            else{
                cont = 1;
            }
            
            if(cont>=target){
                cont = 1;
                sum++;
                break;
            }
        }
        return sum;
    }

}