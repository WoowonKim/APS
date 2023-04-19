import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int L,C;
	static char[] data, sel;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		data = new char[C];
		sel = new char[L];
		for(int i = 0; i < C; i++) {
			data[i] = sc.next().charAt(0);
		}
		Arrays.sort(data);
		comb(0, 0, 0, 0);
		sc.close();
	}
	public static void comb(int cnt, int idx, int vCnt, int cCnt) {
		if (cnt == L) {
			if (cCnt < 2 || vCnt < 1) return;
			System.out.println(Arrays.toString(sel).replace("]","").replaceAll("[\\[\\, ]", ""));
			return;
		}
		if (idx == C) return;
		char next = data[idx]; 
		sel[cnt] = next;
		if ("aeiou".contains(next+"")) {
			comb(cnt + 1, idx + 1,vCnt+1,cCnt);			
		} else {
			comb(cnt + 1, idx + 1,vCnt,cCnt+1);		
		}
		comb(cnt, idx + 1,vCnt,cCnt);
	}

}
