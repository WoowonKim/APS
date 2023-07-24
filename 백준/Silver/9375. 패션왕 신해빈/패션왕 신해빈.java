import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            Map<String, Integer> cloths = new HashMap<>();
            sc.nextLine();
            int ans = 1;
            for (int i = 0; i < N; i++) {
                String[] line = sc.nextLine().split(" ");
                if (cloths.containsKey(line[1])) cloths.replace(line[1], cloths.get(line[1]) + 1);
                else cloths.put(line[1], 1);
            }
            for (String key : cloths.keySet()) {
                ans *= cloths.get(key) + 1;
            }
            System.out.println(ans - 1);
        }
    }
}