import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int curr = sc.nextInt();
        int target = sc.nextInt();
        int up = sc.nextInt();
        int down = sc.nextInt();
        boolean[] visited = new boolean[total + 1];

        int ans = -1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{curr, 0});

        while (!queue.isEmpty()) {

            int[] status = queue.poll();
            if (visited[status[0]]) continue;

            if (status[0] == target) {
                ans = status[1];
                break;
            }
            visited[status[0]] = true;

            if (status[0] + up <= total) queue.add(new int[]{status[0] + up, status[1] + 1});
            if (status[0] - down > 0) queue.add(new int[]{status[0] - down, status[1] + 1});

        }

        System.out.println(ans == -1 ? "use the stairs" : ans);
    }
}
