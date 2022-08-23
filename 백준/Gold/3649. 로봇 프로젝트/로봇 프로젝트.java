import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int x = sc.nextInt() * 10000000;
            int n = sc.nextInt();
            int[] legos = new int[n];
            for (int i = 0; i < n; i++) {
                legos[i] = sc.nextInt();
            }
            Arrays.sort(legos);
            int left = 0;
            int right = n - 1;
            String ans = "danger";
            while (left < right) {
                int sum = legos[left] + legos[right];
                if (sum < x) {
                    left++;
                } else if (sum > x) {
                    right--;
                } else {
                    ans = "yes " + legos[left] + " " + legos[right];
                    break;
                }
            }
            System.out.println(ans);
        }
    }
}