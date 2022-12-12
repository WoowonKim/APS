import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int ans = 0;
        Queue<Integer>[] tasks = new Queue[k + 1];
        int[] order = new int[k];
        Set<Integer> plug = new HashSet<>();
        for (int i = 1; i <= k; i++) tasks[i] = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            int task = sc.nextInt();
            tasks[task].add(i);
            order[i] = task;
        }
        for (int i = 0; i < k; i++) {
            int toPlug = order[i];
            tasks[toPlug].poll();
            if (plug.contains(toPlug)) {
                continue;
            }
            if (plug.size() < n) {
                plug.add(toPlug);
                continue;
            }
            int toRemove = order[i - 1];
            for (int plugged : plug) {
                if (tasks[plugged].isEmpty()) {
                    toRemove = plugged;
                    break;
                } else if (!tasks[toRemove].isEmpty()) {
                    toRemove = tasks[plugged].peek() > tasks[toRemove].peek() ? plugged : toRemove;
                }
            }
            switchPlug(plug, toRemove, toPlug);
            ans++;
        }
        System.out.println(ans);
    }

    static private void switchPlug(Set<Integer> plug, int from, int to) {
        plug.remove(from);
        plug.add(to);
    }

}
