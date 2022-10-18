import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static StringBuilder sb;
    static String pre;
    static int preIndex;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            sb = new StringBuilder();
            preIndex = 0;
            pre = sc.next();
            String in = sc.next();
            sc.nextLine();
            char root = pre.charAt(preIndex);
            int index = in.indexOf(root);
            String left = in.substring(0, index);
            String right = in.substring(index + 1);
            findPost(root, left, right);
            System.out.println(sb);
        }
    }

    private static void findPost(char root, String left, String right) {
        if (left.length() == 0 && right.length() == 0) {
            sb.append(root);
            return;
        }

        if (left.length() != 0) {
            preIndex++;
            char newRoot = pre.charAt(preIndex);
            int index = left.indexOf(newRoot);
            String newLeft = left.substring(0, index);
            String newRight = left.substring(index + 1);
            findPost(newRoot, newLeft, newRight);
        }
        if (right.length() != 0) {
            preIndex++;
            char newRoot = pre.charAt(preIndex);
            int index = right.indexOf(newRoot);
            String newLeft = right.substring(0, index);
            String newRight = right.substring(index + 1);
            findPost(newRoot, newLeft, newRight);
        }
        sb.append(root);
    }
}