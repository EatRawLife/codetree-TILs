//N제곱 크기의 격자안. 각칸에는 정수값이. 이중 열과 행당 하나의 칸만 골라서 색칠. 그리고 색칠된 값의 합을 구함.
//이때 모든 경우중 가장 큰수를 출력.
//행을 내려가면서 하나하나 선택해주면됨.
//이때 중복된 열은 선택하지 않되 모두한번씩 선택하는 순열.
//n칸짜리 배열 > 칸마다 배정할수있는 모든 줄의 좌표를 적어줌.
import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX_N = 10;

    public static int maxi = 0;    
    public static int n;
    public static int[][] array = new int[MAX_N][MAX_N];
    public static Stack<Integer> st = new Stack<Integer>();
    public static boolean[] visited;

    public static boolean indexIIsVisited(int i){
        if(visited[i] == true)
        return true;
        return false;
    }

    public static void updateMaximum(){
        int temp = 0; 
        for(int i = 0; i< n; i++){
            temp+= array[i][st.get(i)];
        }
        maxi = Math.max(maxi, temp);
    }

    public static void paint(int count){
        //만약 카운트 다찼으면 기존 맥시멈과 비교해서 더큰놈을 저장한다.

        if(count == n)
        updateMaximum();

        for(int i = 0; i<n; i++){
            if(indexIIsVisited(i))
            continue;

            st.push(i);
            visited[i] = true;
            paint(count+1);
            visited[i] = false;
            st.pop();
        }

        //n이내의 수 차례대로 스택에 넣음.
        //스택 넣기전에 방문한 행을 또 방문하면 안되므로 visited 에 true바꿔주기.
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        visited = new boolean[n];

        for(int i = 0; i< n; i++){
            for(int j = 0; j < n; j++){
                array[i][j] = scan.nextInt();
            }
        }

        paint(0);
        System.out.print(maxi);

    }
}