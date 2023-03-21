import java.util.Scanner;

public class Main {//[17252] 삼삼한 수

    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();
        boolean flag = N != 0;
        while (N > 0) {
            if (N % 3 == 2) {
                flag = false;
                break;
            }
            N /= 3;
        }
        System.out.println(flag ? "YES" : "NO");
    }

}