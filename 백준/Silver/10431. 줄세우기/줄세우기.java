import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        while (T-- > 0) {
            sb.append(sc.nextInt()).append(" ");
            int cnt = 0;
            int[] arr = new int[20];
            for (int i = 0; i < 20; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = 1; i < 20; i++) {
                for (int j = 0; j < i; j++) {
                    if (arr[j] > arr[i]) {
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
