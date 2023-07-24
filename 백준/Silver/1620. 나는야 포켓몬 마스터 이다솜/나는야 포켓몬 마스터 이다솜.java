import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> dogam = new HashMap<>();
        int N = sc.nextInt();
        int M = sc.nextInt();
        for(int i = 1; i <= N; i++ ) {
            String in = sc.next();
            dogam.put(in, String.valueOf(i));
            dogam.put(String.valueOf(i), in);
        }
        while (M-- > 0) System.out.println(dogam.get(sc.next()));
    }
}