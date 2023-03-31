import java.util.Scanner;

//[1407] 2로 몇 번 나누어질까
public class Main {

    public static void main(String[] args) {//[2004] 조합 0의 개수
        Scanner sc = new Scanner(System.in);
        System.out.println(-f(sc.nextLong() - 1) + f(sc.nextLong()));
    }

    private static long f(long n) {
        long res = n;
        for (long l = 2; l <= n; l <<= 1) {
            res += (n / l) * (l >> 1);
        }
        return res;
    }

}
