import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] format = {"____", 
				"\"재귀함수가 뭔가요?\"",
				"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
				"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.",
				"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"",
				"\"재귀함수는 자기 자신을 호출하는 함수라네\"",
				"라고 답변하였지."};
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		recur(0,N,format);
	}

	private static void recur(int cnt, int n, String[] format) {
		// TODO Auto-generated method stub
		String line = "";
		for(int i = 0; i < cnt; i++) {
			line += format[0];
		}
		if(cnt == n) {
			System.out.println(line+format[1]);
			System.out.println(line+format[5]);
			System.out.println(line + format[6]);
			return;
		}
		System.out.println(line+format[1]);
		System.out.println(line+format[2]);
		System.out.println(line+format[3]);
		System.out.println(line+format[4]);
		recur(cnt+1,n,format);
		System.out.println(line + format[6]);
		
	}
}