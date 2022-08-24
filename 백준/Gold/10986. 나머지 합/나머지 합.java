import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long ans = 0;
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] nums = new long[n+1];
        int[] mods = new int[m];
        for(int i = 1; i <= n; i++){
            nums[i] += sc.nextInt() + nums[i-1];
            nums[i] %= m;
            mods[(int) nums[i]]++;
            if(nums[i] == 0) ans++;
        }
        for(int i = 0; i < m; i++){
            ans+= (long) mods[i] * (mods[i] - 1)/2;
        }
        System.out.println(ans);
    }
}