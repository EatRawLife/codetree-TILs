//1234로만 이루어져 있음. 자리수는 10개.
//숫자에서 내부에 n이 있을때, 개수가 kn개여야지 아름다운수.
//연산이 최대 2의 20승. 괜찮다.
//이거는 중간에 확인하면 더귀찮을듯. 그냥 마지막에 체크하자.
//함수의 기능: 이전에 n번 선택했으면 n+1자리를 선택, 내부에서 재귀호출.
//종료조건: 인수로 받은 값이 n과 같아졌으면 조건 맞는지 조사하고 카운트 업.
import java.util.*;
public class Main {

    public static int n;
    public static int count = 0;

    public static Stack<Integer> st = new Stack<Integer>(); 

    public static void beati(int digit){
        if(digit == n){
            int tempMemory = st.get(0);
            int tempCount = 0;
            for(int i = 0; i<n; i++ ){
                if(st.get(i) != tempMemory){
                    if(tempCount%tempMemory!= 0)
                    return;

                    tempCount = 1;
                    tempMemory = st.get(i);

                }
                else{
                    tempCount++;
                }
            }
            if(tempCount%tempMemory!= 0)
            return;
               
            count++;
            return;
        }
        
        for(int i = 1; i<=4; i++){
            st.push(i);
            beati(digit+1);
            st.pop();
        }
        
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();

        beati(0);
        System.out.print(count);
    }
}