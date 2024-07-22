import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        call(i);
    }

    public static void call(int i){
        if(i<=0)
        return;
        System.out.println("HelloWorld");
        call(i-1);
        
    }
}