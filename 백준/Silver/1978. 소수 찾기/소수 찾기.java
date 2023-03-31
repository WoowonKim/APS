import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int ans = 0;
        setMap();
        while (N-->0) {
            int curr = Integer.parseInt(stk.nextToken());
            if(map[curr] == curr) ans++;
        }
        System.out.println(ans);
    }

    private static void setMap() {
        map = new int[1001];
        for(int i = 2; i < 1001; i++) map[i] = i;
        for (int i = 2; i * i < 1001; i++) for (int j = i * i; j < 1001; j += i) map[j] = i;
    }

}
