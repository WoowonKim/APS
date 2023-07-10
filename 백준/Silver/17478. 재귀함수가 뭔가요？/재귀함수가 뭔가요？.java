import java.util.Scanner;

public class Main {
    static String[] format = {"____",
            "\"재귀함수가 뭔가요?\"\n",
            "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n",
            "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n",
            "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n",
            "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n",
            "라고 답변하였지.\n"};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        recur(0, N);
        System.out.println(sb);
    }

    private static void recur(int cnt, int n) {
        String dash = format[0].repeat(cnt);
        sb.append(dash).append(format[1]);
        if (cnt == n) {
            sb.append(dash).append(format[5]).append(dash).append(format[6]);
            return;
        }
        sb.append(dash).append(format[2]).append(dash).append(format[3]).append(dash).append(format[4]);
        recur(cnt + 1, n);
        sb.append(dash).append(format[6]);
    }
}