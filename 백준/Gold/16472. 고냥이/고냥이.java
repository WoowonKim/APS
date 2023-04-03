import java.util.Scanner;

/*
[16472] 고냥이
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String str = sc.next();

        int[] cnt = new int[26];
        int ans = 0;
        int type = 0;
        int st = 0;
        int ed = 0;

        while (ed < str.length()) {
            if (type <= N) {
                int curr = str.charAt(ed) - 'a';
                cnt[curr]++;
                ed++;
                if (cnt[curr] == 1) type++;
            } else {
                int curr = str.charAt(st) - 'a';
                cnt[curr]--;
                st++;
                if (cnt[curr] == 0) type--;
            }
            if (type <= N) ans = Math.max(ans, ed - st);
        }
        System.out.println(ans);
    }

}
