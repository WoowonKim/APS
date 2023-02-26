import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int ans = 0;
            int num = Integer.parseInt(br.readLine());
            for(int i = 5 ; i <= num; i*=5) ans += num/i;
            System.out.println(ans);
        }
    }
}
