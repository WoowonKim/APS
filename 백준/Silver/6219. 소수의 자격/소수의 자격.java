import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int MAX = 4000000;
    static boolean[] isPrime;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int D = sc.nextInt();
        isPrime = new boolean[MAX + 1];
        setIsPrime();

        int ans = 0;
        for (int i = A; i <= B; i++) {
            if(isPrime[i] && containsD(i, D)) ans++;
        }
        System.out.println(ans);
    }

    private static boolean containsD(int p, int d) {
        char[] num = String.valueOf(p).toCharArray();
        for (char digit : num) {
            if(digit - '0' == d) return true;
        }
        return false;
    }

    private static void setIsPrime() {
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i <= MAX; i++) {
            for (int j = i * i; j <= MAX; j+=i) {
                isPrime[j] = false;
            }
        }
    }

}
