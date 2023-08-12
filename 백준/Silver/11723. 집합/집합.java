import java.io.*;
import java.util.*;

class Main {

    static Set<Integer> s = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        while (N-- > 0) {
            String comm = sc.next();
            switch (comm) {
                case "add": {
                    s.add(sc.nextInt());
                    break;
                }
                case "remove": {
                    s.remove(sc.nextInt());
                    break;
                }
                case "check": {
                    sb.append(s.contains(sc.nextInt()) ? 1 : 0).append("\n");
                    break;
                }
                case "toggle": {
                    int num = sc.nextInt();
                    if (s.contains(num)) {
                        s.remove(num);
                    } else {
                        s.add(num);
                    }
                    break;
                }
                case "all": {
                    s = new HashSet<>();
                    for (int i = 1; i <= 20; i++) {
                        s.add(i);
                    }
                    break;
                }
                case "empty": {
                    s.clear();
                }
            }
        }
        System.out.println(sb);
    }
}
