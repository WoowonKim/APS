import java.util.*;

public class Main {
    static final int MAX = 4_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[MAX + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int p = i * i; p <= MAX; p += i) isPrime[p] = false;
            }
        }
        for (int i = 2; i <= MAX; i++) {
            if (isPrime[i]) primes.add(i);
        }
        int left = 0, right = 0;
        int ans = 0, sum = 2;
        int size = primes.size();
        while (left <= right) {
            if (sum == n) {
                ans++;
                sum -= primes.get(left++);
            } else if (sum > n) {
                sum -= primes.get(left++);
            } else {
                if (++right >= size) break;
                sum += primes.get(right);
            }
        }

        System.out.println(ans);
    }
}