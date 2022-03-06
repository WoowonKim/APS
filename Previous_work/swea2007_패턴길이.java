import java.util.Scanner;

public class swea2007_패턴길이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			boolean flag = false;
			String stn = sc.next();
			for (int i = 1; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (i+j<30 && stn.charAt(j) == stn.charAt(j + i)) {
						flag = true;
					}else {
						flag = false;
						break;
					}
				}
				if (flag == true) {
					ans = i;
					break;
				}
			}
			System.out.println("#"+tc+" "+ans);
		}//tc
		sc.close();
	}

}
