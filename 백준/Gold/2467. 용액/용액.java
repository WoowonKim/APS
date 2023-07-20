import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] ans = new int[2];
        int temp = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();

        int left = 0; int right = N - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if(Math.abs(sum) < temp) {
                ans = new int[]{arr[left], arr[right]};
                temp = Math.abs(sum);
            }
            if(sum < 0) left++;
            else if (sum > 0) right--;
            else break;
        }

        System.out.println(Arrays.toString(ans).replaceAll("[\\[\\],]", ""));

    }
}