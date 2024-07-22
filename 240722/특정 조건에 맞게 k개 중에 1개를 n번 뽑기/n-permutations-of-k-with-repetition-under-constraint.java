//k가 입력, 인자로count 전달해서 인자가 k가 되면 실행. 마지막에는 pop.

import java.util.*;
public class Main {
    public static int n;
    public static int k;

    public static Stack<Integer> st = new Stack<Integer>();
    public static void pick(int count){
        for(int i= 1; i<= n; i++){
            if(count >= 3 && i == st.get(count-2)&&i == st.get(count-3)){
                continue;
            }
            st.push(i);
            if(count == k){
                for(int j = 0; j<k; j++){
                    System.out.print(st.get(j)+ " ");
                }
                System.out.println();
                st.pop();
                continue;
            }
            pick(count+1);
            st.pop();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n= scan.nextInt();
        k = scan.nextInt();

        pick(1);
        
    }
}