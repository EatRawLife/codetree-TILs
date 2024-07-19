import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static int N;
    public static int x=0;
    public static int y=0;

    public static void calc(String direction, int distance){
        int[] dx = {-1,0,0,1};
        int[] dy = {0,-1,1,0};
        String[] ddrection = {"W", "S", "N", "E"};
        for(int i = 0; i<distance ; i++){

        x+= dx[Arrays.asList(ddrection).indexOf(direction)];
        y+= dy[Arrays.asList(ddrection).indexOf(direction)];
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        
        String direction;
        int distance;

        for(int i = N; i>0; i--){
            direction = scan.next();
            distance = scan.nextInt();
            calc(direction, distance);
        }

        System.out.print(x+" "+y);
        
    }
}