import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String game = sc.next();
        Map<String, Integer> req = new HashMap<>();
        req.put("Y", 2);
        req.put("F", 3);
        req.put("O", 4);

        Set<String> people = new HashSet<>();

        while (N-- > 0)  people.add(sc.next());

        System.out.println(people.size()/ (req.get(game) - 1));
    }
}
