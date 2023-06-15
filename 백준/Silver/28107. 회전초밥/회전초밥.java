import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Map<Integer, List<Integer>> li = new HashMap<>();
        int[] countList = new int[n];

        for (int i = 0; i < n; i++) {
            int k = scanner.nextInt();
            for (int j = 0; j < k; j++) {
                int element = scanner.nextInt();
                List<Integer> indices = li.getOrDefault(element, new ArrayList<>());
                indices.add(i);
                li.put(element, indices);
            }
        }

        List<Integer> orderList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            orderList.add(scanner.nextInt());
        }

        for (int i : orderList) {
            if (li.containsKey(i)) {
                List<Integer> indices = li.get(i);
                int indexToRemove = indices.remove(0);
                countList[indexToRemove]++;
                if (indices.isEmpty()) {
                    li.remove(i);
                }
            }
        }

        for (int count : countList) {
            System.out.print(count + " ");
        }
    }
}
