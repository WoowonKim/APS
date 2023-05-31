import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        double v = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (n-->0) {
            int cur = Integer.parseInt(st.nextToken());
            v = cur + v - v*cur/100;
            sb.append(v).append('\n');
        }
        System.out.print(sb);    }
}
