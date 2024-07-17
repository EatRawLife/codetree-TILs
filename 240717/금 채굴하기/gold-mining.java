//마름모 중앙을 위치로 잡고 시작. 각 마름모 중심 위치마다 손해보지않고 채굴가능한 개수 측정. 리턴.
//배열과 위치, 공사 비용 받아서 이득보고 얻을 수 있는 최대 금개수 반환. 아니면 0.
//마름모 각 칸마다 금이 있는지 없는지 확인해줘야함. 
//이를 해주는 함수는 재귀적으로 작동. 배열과 있는 좌표, 이동가능한 횟수를 받음.
//이동가능한 횟수만큼 좌우를 살피고 그다음으로 자신 위쪽 좌표에 호출.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int wage = 2*2+3*3;
        int price = scan.nextInt();
        int max = 0;

        int[][] array = new int[size][size]; 
        for(int i = 0; i< size; i++){
            for(int j = 0; j<size; j++){
                array[i][j] = scan.nextInt();
            }
        }

        for(int i = 0; i<size; i++){
            for(int j = 0; j<size; j++){
                int calc = gold(array, i,j, size, wage , price);
                if(max<=calc)
                max = calc;
            }
        }

        System.out.print(max);
    }

    public static int findGold(int[][] array, int x, int y, int bound, int move){
        int count = 0;
        for(int i = -move;i<=move;i++ ){
            if(x+i<0 || x+i>=bound||y<0||y>=bound)
            continue;
            if(array[y][x+i] == 1)
            count++;
        }
        
        return count;
    }

    public static int gold(int[][] array, int x, int y, int bound, int wage, int price){
        int result = findGold(array, x, y, bound, 2)+findGold(array, x, y-1, bound, 1)+findGold(array, x, y+1, bound, 1)+findGold(array, x, y-2, bound, 0)+findGold(array, x, y+2, bound, 0);
        if(result*price < wage)
        return 0;
        return result;
    }
}