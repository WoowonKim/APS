import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] decks = new int[3][];
    static int[] player = new int[3];
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        player = new int[3];
        for (int i = 0; i < 3; i++) player[i] = Integer.parseInt(stk.nextToken());
        for (int i = 0; i < 3; i++) {
            stk = new StringTokenizer(br.readLine());
            decks[i] = new int[player[i]];
            for (int j = 0; j < player[i]; j++) decks[i][j] = Integer.parseInt(stk.nextToken());
            Arrays.sort(decks[i]);
        }
        solve();
        System.out.println(ans);
    }

    private static void solve() {
        for (int i = 0; i < player[0]; i++) {
            int[] sel = new int[3];
            sel[0] = decks[0][i];
            sel[1] = getClosest(1, sel[0]);
            sel[2] = getClosest(2, sel[0]);
            ans = Math.min(ans, getScore(sel));
            sel[2] = getClosest(2, sel[1]);
            ans = Math.min(ans, getScore(sel));
        }
    }

    private static int getScore(int[] sel) {
        int min = 100000001;
        int max = -100000001;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, sel[i]);
            max = Math.max(max, sel[i]);
        }
        return Math.abs(max - min);
    }

    private static int getClosest(int num, int target) {
        int idx = Arrays.binarySearch(decks[num], target);
        if (idx < 0) {
            idx = idx * -1 - 1;
        }
        if (idx == player[num]) idx--;
        else if (idx != 0) {
            if (Math.abs(target - decks[num][idx]) > Math.abs(target - decks[num][idx - 1])) idx--;
        }
        return decks[num][idx];
    }

}
