import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(divide(a, b, c));
    }

    private static long divide(int a, int b, int c) {
        if (b == 1) return a % c;
        long k = divide(a, b / 2, c);
        if (b % 2 == 0) return k * k % c;
        return k * k % c * a % c;
    }
}
