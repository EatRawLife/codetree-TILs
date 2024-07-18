import java.util.Scanner;
public class Main{
    public static final int Max_N = 100;

    public static int n;
    public static int[] array = new int[Max_N];

    public static void remove(int s, int e){
        int[] temp = new int[Max_N];
        int endOfArray = 0;
        
        for(int i = s; i<= e; i++){
            array[i] = 0;
        }
        for(int i = 0; i < n; i++){
            if(array[i] != 0){
                temp[endOfArray++] = array[i];
            }
        }
        array = temp;
        n = endOfArray;

    }

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);

        int s1;
        int e1;
        int s2;
        int e2;

        n = scan.nextInt();

        for(int i = 0; i< n; i++){
            array[i] = scan.nextInt();
        }

        s1 = scan.nextInt()-1;
        e1 = scan.nextInt()-1;
        s2 = scan.nextInt()-1;
        e2 = scan.nextInt()-1;

        remove(s1,e1);
        remove(s2,e2);

        System.out.println(n);
        for(int i = 0; i< n; i++){
            System.out.println(array[i]);
        }
    }
}