import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static ArrayList<Long> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        list = new ArrayList<>();

        if(n > 1022) System.out.println("-1");
        else {
            for(int i = 0; i < 10; i++) {
                recur(i, 1);
            }
            Collections.sort(list);
//            System.out.println(list.size());
            System.out.println(list.get(n));
        }
    }

    public static void recur(long num, int idx) {
        if(idx > 10) return;
        list.add(num);
        for(int i = 0; i < num % 10; i++) {
            recur((num * 10) + i, idx + 1);
        }
    }
}
