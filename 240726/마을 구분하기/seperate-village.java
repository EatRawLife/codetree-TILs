//한사람 잡고 상하 좌우로 이동하며 이동가능하면 그쪽에서도 또 상하좌우이동.
//카운트를 올림. 그리고 해당 카운트를 리스트에 저장.
//모든 주변이 벽또는 비지티드 일경우에 카운트를 올림
//모든 좌표에 대하여 해당 행위를 시행. 단 벽인 좌표와 비지티드인 좌표는제외.
import java.util.*;
public class Main {

    public static int n;
    public static int count= 0;

    public static int[][] array =new int[25][25];
    public static boolean[][] visited = new boolean[25][25];
    public static ArrayList<Integer> villege = new ArrayList<>();

    public static boolean movable(int x, int y){
        if(x>=0&&x<n&&y>=0&&y<n&&visited[x][y] == false&&array[x][y]==1)
        return true;
        return false;
    }

    public static void visit(int x, int y){
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        boolean moved = false;

        for(int i = 0; i< 4; i++){
            int newX = x+dx[i];
            int newY = y+dy[i];
            if(movable(newX,newY)){
                moved = true;
                visited[newX][newY] = true;
                count++;
                visit(newX,newY);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();

        for(int i = 0;i< n; i++){
            for(int j = 0 ;j<n; j++){
                array[i][j] = scan.nextInt();

            }
        }

        for(int i = 0;i< n; i++){
            for(int j = 0 ;j<n; j++){
                if(array[i][j]==1&&visited[i][j]== false){
                visited[i][j] = true;
                count++;
                visit(i, j);
                villege.add(count);
                count = 0;
            }

            }
        }
        Collections.sort(villege);
        System.out.println(villege.size());
                for(int i = 0; i< villege.size(); i++){
                    System.out.println(villege.get(i));
                }
    }
}