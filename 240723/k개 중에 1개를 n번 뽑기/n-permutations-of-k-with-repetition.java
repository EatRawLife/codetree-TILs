//모든조합을 다구하는 것 > 재귀를 사용.
//함수의 기능 > k개의 숫자중 하나를 고르는 기능.
//인수로 받는 것 > n번 선택을 위해서 이 작동을 위한 인수를 전달할거임.
//종료조건 > 전달받은 인수값이 0이면 출력하고 종료.

import java.util.*;
public class Main {
    public static int n;
    public static int k;

    public static ArrayList<Integer> st = new ArrayList<Integer>();

    public static void select(int count){
        if(count == 0){
            for(int i = 0; i< n; i++){
                System.out.print(st.get(i)+ " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i<=k; i++){
            st.add(i);
            select(count-1);
            st.remove(st.size()-1);
        }
    }

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        k = scan.nextInt();
        n = scan.nextInt();

        select(n);
    }
}