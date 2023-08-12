import java.io.*;
import java.util.*;

class Main {
    static final String GOOD = " is acceptable.\n";
    static final String BAD = " is not acceptable.\n";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (true) {
            String curr = sc.next();
            if(curr.equals("end")) break;
            sb.append("<").append(curr).append(">");
            boolean flag = true;
            if(!curr.matches(".*[aeiou].*")) flag = false;
            if(curr.matches(".*[^aeiou]{3}.*")) flag = false;
            if(curr.matches(".*[aeiou]{3}.*")) flag = false;
            if(curr.matches(".*([^eo])\\1.*")) flag = false;
            if(flag) sb.append(GOOD);
            else sb.append(BAD);
        }
        System.out.println(sb);
    }
}
