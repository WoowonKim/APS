import java.util.PriorityQueue;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (N-- > 0) {
            int num = sc.nextInt();
            if(num == 0) {
                if(pq.isEmpty()) System.out.println(0);
                else System.out.println(pq.poll());
            } else pq.add(num);
        }
    }
}