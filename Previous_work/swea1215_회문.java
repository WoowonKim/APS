import java.util.Scanner;

public class swea1215_회문 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int len = sc.nextInt();
			sc.nextLine();
			
			char[][] map = new char[8][8];
			for (int i = 0; i < 8; i++) {
			
					map[i] = sc.nextLine().toCharArray();
				
			}
			
			int cnt = 0;
			boolean flagr = false;
			boolean flagc = false;
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j <= 8 - len; j++) {
					for(int k = j, m = j + len - 1; j<=m; k++, m--) {
						if(map[i][k] != map[i][m]) {
							flagr = false;
							break;
						}
						flagr = true;
					}
					for(int k = j, m = j + len - 1; j<=m; k++, m--) {
						if(map[k][i] != map[m][i]) {
							flagc = false;
							break;
						}
						flagc = true;
					}
					if (flagr) cnt++;
					if (flagc) cnt++;
					
				}
			}
			System.out.println("#" + tc +" " + cnt);
		} // tc
		sc.close();
	}// main
}