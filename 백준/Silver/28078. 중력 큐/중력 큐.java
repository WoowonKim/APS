import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static Deque<Character> pipe = new LinkedList<>();
    static int countB = 0, countW = 0;

    //파이프 뒤쪽의 방향 0: 좌, 1: 상, 2: 우, 3: 하;
    static int back = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(br.readLine());

        for (int i = 0; i < Q; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            String comm = stk.nextToken();
            if(comm.equals("push")) push(stk.nextToken().charAt(0));
            if(comm.equals("rotate")) rotate(stk.nextToken().charAt(0));
            if(comm.equals("count")) count(stk.nextToken().charAt(0));
            if(comm.equals("pop")) pop();
        }
        System.out.println(sb);
    }

    static void push(char q) {
        if(q == 'w') {
            pipe.addLast(q);
            countW++;
        } else {
            if (back == 3) return;
            if (back == 1 && pipe.isEmpty()) return;
            pipe.addLast(q);
            countB++;
        }
    }

    static void rotate(char q) {
        if (q == 'l') back = (back + 3) % 4;
        else back = (back + 1) % 4;
        gravity();
    }

    static void count(char q) {
        if (q == 'b') sb.append(countB);
        else sb.append(countW);
        sb.append("\n");
    }

    static void pop() {
        if (pipe.isEmpty()) return;
        char curr = pipe.pollFirst();
        if (curr == 'b') countB--;
        else {
            countW--;
            gravity();
        }
    }

    static void gravity() {
        if (back == 1) {
            while (!pipe.isEmpty() && pipe.peekFirst() != 'w') {
                pipe.pollFirst();
                countB--;
            }
        } else if (back == 3) {
            while (!pipe.isEmpty() && pipe.peekLast() != 'w') {
                pipe.pollLast();
                countB--;
            }
        }
    }
}
