import java.io.IOException;
import java.util.Scanner;

public class BOJ14713_앵무새 {
	public static void main(String[] args) throws IOException  {
		Scanner sc = new Scanner(System.in);
		int birdNum = Integer.parseInt(sc.next());
		sc.nextLine();
		int sum = 0;	
		String[][] wordbox = new String[birdNum][];
		for (int bird = 0; bird < birdNum; bird++) {
			wordbox[bird] = sc.nextLine().split(" ");
			sum += wordbox[bird].length;
		}
		String[] L = sc.nextLine().split(" ");
		int[] index = new int[birdNum];
		
		if (L.length != sum) {

			System.out.println("Impossible");
			sc.close();	
			return;
		}
		
		boolean flag = true;
		for (int i = 0; i < L.length; i++) {
			for (int bird = 0; bird < birdNum; bird++) {
				if (index[bird] == wordbox[bird].length) {
					continue;
				}
				if (L[i].equals(wordbox[bird][index[bird]])) {
					flag = true;
					index[bird]++;
					break;
				}
				flag = false;
			}
			if(!flag) break;
		}
		if (flag) {
			System.out.println("Possible");
		} else {
			System.out.println("Impossible");
		}
		sc.close();
	}
}
