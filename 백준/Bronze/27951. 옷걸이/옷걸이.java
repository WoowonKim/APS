import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] cnt = new int[4];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            cnt[arr[i]]++;
        }
        int U = sc.nextInt();
        int D = sc.nextInt();
        int U3 = U - cnt[1];
        int D3 = D - cnt[2];
        for (int i = 0; i < N; i++) {
            if (arr[i] == 1) {
                sb.append('U');
                U--;
            } else if (arr[i] == 2) {
                sb.append('D');
                D--;
            } else {
                if (U3 > 0) {
                    sb.append('U');
                    U--;
                    U3--;
                } else if (D3 > 0) {
                    sb.append('D');
                    D--;
                    D3--;
                }
            }
        }
        if (U == 0 && D == 0) {
            System.out.println("YES");
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}
