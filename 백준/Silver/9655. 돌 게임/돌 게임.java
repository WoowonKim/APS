import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() % 4;
        System.out.println(n % 2 != 0 ? "SK" : "CY");
    }
}
