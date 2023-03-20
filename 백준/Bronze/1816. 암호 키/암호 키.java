import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {//[1816] 암호키
    static final int MAX = 1000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> sosu = new ArrayList<>();
        int[] isSosu = new int[MAX];
        isSosu[0] = isSosu[1] = -1;
        for (int i = 2; i < MAX; i++) {
            isSosu[i] = i;
        }
        for (int i = 2; i * i < MAX; i++) {
            if(isSosu[i] != i) continue;
            for(int j = i * i; j < MAX; j += i) {
                isSosu[j] = i;
            }
        }
        for (int i = 2; i < MAX; i++) {
            if(isSosu[i] == i) sosu.add(i);
        }
        int N = sc.nextInt();
        while (N-- > 0) {
            long key = sc.nextLong();
            boolean flag = true;
            for(int i : sosu) {
                if( key % i == 0) {
                    flag = false;
                    break;
                }
            }
            System.out.println(flag ? "YES" : "NO");
        }
    }

}
