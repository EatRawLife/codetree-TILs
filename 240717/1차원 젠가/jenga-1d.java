import java.util.Scanner;
public class Main {
    public static Scanner scan = new Scanner(System.in);

    public static int bomb(int[] array, int n){
        
        int start = scan.nextInt();
        int end = scan.nextInt();
        for(int i = start-1; i<= end-1; i++){
            array[i] = -1;
        }
        
        Integer[] temp = new Integer[n];
        int tempArraySize = 0;
        for(int i = 0; i< n; i++){
            if(array[i] != -1){
                array[tempArraySize] = array[i];
                tempArraySize++;
            }
        }

        return tempArraySize;

    }

    public static void main(String[] args) {
        int n = scan.nextInt();
        

        int[] array = new int[n];
        int arrayLength = n;
        for(int i = 0; i<n; i++){
            array[i] = scan.nextInt();
        }
        
        arrayLength = bomb(array,arrayLength);
        arrayLength = bomb(array, arrayLength);

        System.out.println(arrayLength);
        for(int i = 0; i< arrayLength; i++){
            System.out.println(array[i]);
        }
    }
}