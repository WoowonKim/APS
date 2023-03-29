import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A = sc.nextInt();
        int ans = N / A;
        N /= A;
        while (N >= A) {
            ans += N / A;
            N /= A;
        }
        System.out.println(ans);
    }

}
