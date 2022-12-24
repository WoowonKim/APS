import java.util.*;

public class Main {
    static final int range = 1000000 + 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] isPrime = new boolean[range];
        isPrime[1] = true;
        for (int i = 2; i * i < range; i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j < range; j += i) {
                    isPrime[j] = true;
                }
            }
        }
        int[] pCnt = new int[range];
        int[] sCnt = new int[range];
        pCnt[2] = sCnt[2] = 1;
        for (int i = 3; i < range; i++) {
            if (!isPrime[i]) pCnt[i] = pCnt[i - 1] + 1;
            else pCnt[i] = pCnt[i-1];
            if(!isPrime[i] && (i % 4) == 1) sCnt[i] = sCnt[i - 1] + 1;
            else sCnt[i] = sCnt[i-1];
        }
        while (true) {
            int L = sc.nextInt();
            int U = sc.nextInt();
            if(L == -1 && U == -1) break;
            if(L > 0) System.out.println(L + " " + U + " " + (pCnt[U] - pCnt[L-1]) + " " + (sCnt[U] - sCnt[L-1]));
            else if (U >= 0) System.out.println(L + " " + U + " " + pCnt[U] + " " + sCnt[U]);
            else System.out.println(L + " " + U + " " + 0 + " " + 0);
        }
    }
}


