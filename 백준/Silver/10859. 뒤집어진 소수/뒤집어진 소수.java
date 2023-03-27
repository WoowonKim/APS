import java.util.Scanner;

public class Main {//[10859] 뒤집어진 소수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        System.out.println(isSosu(N) && isFlipSosu(N) ? "yes" : "no");
    }

    private static boolean isFlipSosu(long n) {
        String[] flipNum = {"0","1","2","e","e","5","9","e","8","6"};
        char[] origin = String.valueOf(n).toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = origin.length - 1; i >= 0; i--) {
            sb.append(flipNum[origin[i] - '0']);
        }

        try {
            long flip = Long.parseLong(sb.toString());
            return isSosu(flip);
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean isSosu(long n) {
        for (int i = 3; i <= Math.sqrt(n); i+=2) {
            if (n % i == 0) return false;
        }
        return n != 1;
    }

}
