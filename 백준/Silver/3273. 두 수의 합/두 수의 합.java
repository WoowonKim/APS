import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//[3273] 두 수의 합
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(stk.nextToken());
        Arrays.sort(arr);
        int x = Integer.parseInt(br.readLine());
        int ans = 0;
        int left = 0; int right = n - 1;

        while (left < right) {
            long temp = arr[left] + arr[right];
            if(temp == x) {
                ans++;
                left++;
            } else if (temp > x) {
                right--;
            } else left++;
        }
        System.out.println(ans);
    }

}
