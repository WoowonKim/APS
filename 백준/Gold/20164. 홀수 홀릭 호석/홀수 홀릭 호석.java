import java.util.Scanner;

public class Main {

	static int min = Integer.MAX_VALUE;
	static int max = 0;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String N = sc.nextLine();
		int cnt = 0;
		degaza(N, 0);
		System.out.println(min + " " + max);
	}

	private static void degaza(String n, int cnt) {
		for (char digit : n.toCharArray()) {
			int num = digit - '0';
			if (num % 2 == 1)
				cnt++;
		}
		if (n.length() == 1) {
			if (cnt > max)
				max = cnt;
			if (cnt < min)
				min = cnt;
		} else if (n.length() == 2) {
			String newNum = Integer.toString(n.charAt(0) - '0' + n.charAt(1) - '0');
			degaza(newNum, cnt);
		} else if (n.length() == 3) {
			String newNum = Integer.toString(n.charAt(0) - '0' + n.charAt(1) - '0' + n.charAt(2) - '0');
			degaza(newNum, cnt);
		} else {
			for (int i = 1; i < n.length() - 1; i++) {
				for (int j = i + 1; j < n.length(); j++) {
					int newNum1 = Integer.parseInt(n.substring(0, i));
					int newNum2 = Integer.parseInt(n.substring(i, j));
					int newNum3 = Integer.parseInt(n.substring(j));
					String newNum = Integer.toString(newNum1 + newNum2 + newNum3);
					degaza(newNum, cnt);
				}
			}
		}
	}
}