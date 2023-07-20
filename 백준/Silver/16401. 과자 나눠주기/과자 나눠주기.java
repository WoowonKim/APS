import java.io.*;
import java.util.*;

public class Main {

    static void solution(int cousinCount, int[] snacks) {
        Arrays.sort(snacks);
        int result = 0;
        int left = 1;
        int right = snacks[snacks.length - 1];
        while (left <= right) {
            int count = 0;
            int mid = (left + right) / 2;
            for (int snack : snacks) {
                count += snack / mid;
            }
            if (count >= cousinCount) {
                result = Math.max(mid, result);
                left = mid + 1;
                continue;
            }
            right = mid - 1;
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cousinCount = Integer.parseInt(st.nextToken());
        int snackCount = Integer.parseInt(st.nextToken());
        int[] snacks = new int[snackCount];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < snackCount; i++) {
            snacks[i] = Integer.parseInt(st.nextToken());
        }
        solution(cousinCount, snacks);
    }
}