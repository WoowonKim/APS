import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final char[] ZERO = "####.##.##.####".toCharArray();
    static final char[] ONE = "..#..#..#..#..#".toCharArray();
    static final char[] TWO = "###..#####..###".toCharArray();
    static final char[] THREE = "###..####..####".toCharArray();
    static final char[] FOUR = "#.##.####..#..#".toCharArray();
    static final char[] FIVE = "####..###..####".toCharArray();
    static final char[] SIX = "####..####.####".toCharArray();
    static final char[] SEVEN = "###..#..#..#..#".toCharArray();
    static final char[] EIGHT = "####.#####.####".toCharArray();
    static final char[] NINE = "####.####..####".toCharArray();
    static final char[][] comp = new char[][]{
            ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] time = {"", "", "", ""};
        for (int i = 0; i < 5; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < 4; j++) time[j] += str[j];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(getMin(time[0]));
        sb.append(getMin(time[1])).append(":");
        sb.append(getMin(time[2]));
        sb.append(getMin(time[3]));

        System.out.println(sb);
    }

    private static int getMin(String s) {
        char[] d = s.toCharArray();
        out:
        for (int i = 0; i < 10; i++) {
            char[] c = comp[i];
            for (int j = 0; j < 15; j++) {
                if (d[j] == '#' && c[j] == '.') {
                    continue out;
                }
            }
            return i;
        }
        return 0;
    }

}
