import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans = 0;
        int h = sc.nextInt();
        int w = sc.nextInt();
        int[] blocks = new int[w];
        for(int i = 0; i < w; i++){
            blocks[i] = sc.nextInt();
        }
        for(int i = 1; i < w - 1 ; i++){
            int curr = blocks[i];
            int left = curr;
            int right = curr;
            for(int j = i-1 ; j >= 0; j--){
                left = Math.max(left, blocks[j]);
            }
            for(int j = i+1 ; j < w; j++){
                right = Math.max(right, blocks[j]);
            }
            if (Math.min(left, right) > curr) { // 현재 벽보다 높은 벽이 양쪽에 있는 경우
                ans += (Math.min(left, right) - blocks[i]);
            }
        }
        System.out.println(ans);
    }
}