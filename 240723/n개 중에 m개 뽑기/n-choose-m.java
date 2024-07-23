//n입력되고 이중 m개를 선택해서 조합 만드는 걸로 할거임. 
//선택한것보다 선택해야하는 m 이 많은 경우 종료.
//선택할것은 반드시 방금 선택된것 보다 큰 것들로.
//인수로는 현재 선택한것 수, 방금 선택한 수
//종료조건은 인수가 m개만큼 선택되었을 경우.

import java.util.*;
public class Main {
    public static int n;
    public static int m;

    public static Stack<Integer> st = new Stack<Integer>();
    public static void pick(int count, int before){
        if(count == m){
            for(int i = 0; i< m; i++){
                System.out.print(st.get(i)+ " ");
            }
            System.out.println();
            return;
        }
        if(n-before<m-count)
        return;

        for(int i = before+1; i<=n; i++){
            st.push(i);
            pick(count+1, i);
            st.pop();
        }
    }

    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);

        n = scan.nextInt();
        m = scan.nextInt();

        pick(0,0);
    }
}