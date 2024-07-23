//1~k사이의 숫자중 하나 고르는 것을 N번 할것이다.
//함수는 1~k 까지의 숫자를 고르는 것을 한다. 그리고 이를 스택에 넣고뺀다.
//인수로 시행횟수를 준다. n과 같아지면 이미 스택이 찼으므로 출력하고 함수를 종료한다.
//조건이 있다. 연속해서 3번 같은 숫자가 나오면 안된다. 이는 함수실행 중간에 막을 수 있다.

import java.util.*;

public class Main{

    public static int K;
    public static int N;

    public static Stack<Integer> st = new Stack<Integer>();

    public static boolean isTriple(int count, int next){
        if(st.get(count-1) == next&& st.get(count-2) == next)
            return true;
        return false;
    }

    public static void select(int count){
        if(count == N){
            for(int i = 0; i< N; i++){
                System.out.print(st.get(i)+" ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i<= K;i++){
            if(count>=2&&isTriple(count, i))
            continue;
            st.push(i);
            select(count+1);
            st.pop();
            
        }
    }

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        K = scan.nextInt();
        N = scan.nextInt();

        select(0);

    }
}