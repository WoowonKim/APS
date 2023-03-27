import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("APS/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            List<Integer> arr = new ArrayList<>();
            int ans = 0;
            StringTokenizer stk = new StringTokenizer(br.readLine());
            while (stk.hasMoreTokens()) arr.add(Integer.parseInt(stk.nextToken()));
            for (int i = 0; i < arr.size(); i++) {
                for (int j = i + 1; j < arr.size(); j++) {
                    ans = Math.max(ans, gcd(arr.get(i), arr.get(j)));
                }
            }
            System.out.println(ans);
        }
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
