import java.util.*;

public class Main {

    static StringBuilder t;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        t = new StringBuilder(sc.nextLine());
        while (s.length() < t.length()) {
            delete(t.length() - 1);
        }
        System.out.println(t.toString().equals(s) ? 1 : 0);
    }

    private static void delete(int idx) {
        char lastChar = t.charAt(idx);
        t.deleteCharAt(idx);
        if (lastChar == 'B') t.reverse();
    }
}
