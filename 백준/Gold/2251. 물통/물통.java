import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> ans = new TreeSet<>();
        final int A_MAX = sc.nextInt();
        final int B_MAX = sc.nextInt();
        final int C_MAX = sc.nextInt();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, C_MAX});
        boolean[][][] visited = new boolean[A_MAX + 1][B_MAX + 1][C_MAX + 1];
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (visited[curr[0]][curr[1]][curr[2]]) continue;
            if (curr[0] == 0) {
                ans.add(curr[2]);
            }
            visited[curr[0]][curr[1]][curr[2]] = true;
            if (curr[0] + curr[1] <= B_MAX) {
                queue.add(new int[]{0, curr[0] + curr[1], curr[2]});
            } else {
                queue.add(new int[]{curr[0] + curr[1] - B_MAX, B_MAX, curr[2]});
            }
            if (curr[0] + curr[2] <= C_MAX) {
                queue.add(new int[]{0, curr[1], curr[0] + curr[2]});
            } else {
                queue.add(new int[]{curr[0] + curr[2] - C_MAX, curr[1], C_MAX});
            }
            if (curr[1] + curr[0] <= A_MAX) {
                queue.add(new int[]{curr[1] + curr[0], 0, curr[2]});
            } else {
                queue.add(new int[]{A_MAX, curr[0] + curr[1] - A_MAX, curr[2]});
            }
            if (curr[1] + curr[2] <= C_MAX) {
                queue.add(new int[]{curr[0], 0, curr[1] + curr[2]});
            } else {
                queue.add(new int[]{curr[0], curr[1] + curr[2] - C_MAX, C_MAX});
            }
            if (curr[0] + curr[2] <= A_MAX) {
                queue.add(new int[]{curr[0] + curr[2], curr[1], 0});
            } else {
                queue.add(new int[]{A_MAX, curr[1], curr[0] + curr[2] - A_MAX});
            }
            if (curr[1] + curr[2] <= B_MAX) {
                queue.add(new int[]{curr[0], curr[1] + curr[2], 0});
            } else {
                queue.add(new int[]{curr[0], B_MAX, curr[1] + curr[2] - B_MAX});
            }
        }
        System.out.println(ans.toString().replaceAll("[\\[\\],]", ""));
    }
}
