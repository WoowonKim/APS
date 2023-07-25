import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int Q = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(br.readLine());
        TreeSet<Integer> spot = new TreeSet<>();
        for (int i = 1; i <= N; i++) {
            if (stk.nextToken().equals("1")) spot.add(i);
        }

        int curr = 1;
        while (Q-- > 0) {
            stk = new StringTokenizer(br.readLine());
            switch (stk.nextToken()) {
                case "1": {
                    int spotNum = Integer.parseInt(stk.nextToken());
                    if (spot.contains(spotNum)) spot.remove(spotNum);
                    else spot.add(spotNum);
                    break;
                }
                case "2": {
                    curr = (curr + Integer.parseInt(stk.nextToken())) % N;
                    if (curr == 0) curr = N;
                    break;
                }
                case "3": {
                    if (spot.isEmpty()) sb.append(-1);
                    else if (spot.contains(curr)) sb.append(0);
                    else {
                        Integer higher = spot.higher(curr);
                        if (higher == null) {
                            sb.append((N - curr) + spot.first());
                        } else {
                            sb.append(higher - curr);
                        }
                    }
                    sb.append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }

}