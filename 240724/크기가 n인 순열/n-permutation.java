import java.util.*;
public class Main {

    public static int n;

    public static int[] visited;
    public static Stack<Integer> st = new Stack<Integer>();

    public static boolean iIsVisited(int i){
       if(visited[i] != 0)
       return true;
       return false;
    }

    public static void visit(int count){
        //만약에 카운트가 초과 됐으면 출력하고 리턴
        if(count>=n){
            for(int i = 0; i< n; i++){
                System.out.print(st.get(i)+" ");
            }
            System.out.println();
            return;
        }

        //포문돌아가면서 출력할 리스트에 숫자 넣어줌.
        //이때 기존 리스트에 있는 것을 배제하고 들어감.
        for(int i = 1; i<=n; i++ ){
            if(iIsVisited(i))
            continue;
            visited[i] = 1;
            st.push(i);
            visit(count+1);
            st.pop();
            visited[i] = 0;
        }
    }
    

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        visited = new int[n+1];
        
        visit(0);
    }
}