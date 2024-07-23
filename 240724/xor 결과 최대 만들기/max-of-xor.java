import java.util.*;
import java.io.*;

public class Main {

    public static int n;//주어지는 정수개수
    public static int m;//정수중 몇개를 선택할 것인가.

    public static Stack<Integer> st = new Stack<>();
    public static int[] array;
    public static int maxi = 0;

    public static void select(int arraypoint, int count){
        if(arraypoint>=n-1){
            if(count == m){
                int temp = 0; 
                for(int i = 0; i< m; i++){
                    temp = temp^st.get(i);

                }
                maxi = Math.max(maxi, temp);
            }
            return;
        }

        select(arraypoint+1, count);

        st.push(array[arraypoint]);
        select(arraypoint+1, count+1);
        st.pop();
    }

    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       n =scan.nextInt();
       m = scan.nextInt();

       array = new int[n];
       for(int i = 0; i< n; i++){
        array[i] = scan.nextInt();
       }

       select(0,0);

       System.out.print(maxi);
    }
}