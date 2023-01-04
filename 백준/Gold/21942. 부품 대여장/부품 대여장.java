import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    static long L;
    static int F;

    public static void main(String[] args) throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " /:");
        int N = Integer.parseInt(stk.nextToken());
        L = Integer.parseInt(stk.nextToken()) * 60L * 24L + Integer.parseInt(stk.nextToken()) * 60L + Integer.parseInt(stk.nextToken());
        F = Integer.parseInt(stk.nextToken());
        Map<String, String> log = new HashMap<>();
        Map<String, Long> fine = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            String date = stk.nextToken() + " " + stk.nextToken();
            String stuff = stk.nextToken();
            String writer = stk.nextToken();
            String key = stuff + " " + writer;
            if (log.containsKey(key)) {
                long toPay = calF(log.get(key), date);
                if (toPay > 0) {
                    fine.put(writer, fine.containsKey(writer) ? fine.get(writer) + toPay : toPay);
                }
                log.remove(key);
            } else {
                log.put(key, date);
            }
        }
        if(fine.isEmpty()) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for(String curr : fine.keySet()) {
                sb.append(curr).append(" ").append(fine.get(curr)).append("\n");
            }
            System.out.println(sb);
        }
    }

    public static long calF(String date1, String date2) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        long diff = (sdf.parse(date2).getTime() - sdf.parse(date1).getTime()) / (60 * 1000);
        if (diff > L) {
            return (diff - L) * F;
        }
        return -1;
    }
}