import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static char[][] stars;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		stars = new char[N][N];
		recur(N, 1);
		System.out.println(Arrays.deepToString(stars).replace("], ", "\n").replace(", ", "").replaceAll("[\\[\\]]", ""));
	}

	static void recur(int N, int size) {
		if (size == N)
			return;
		if (size == 1) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (i == 1 && j == 1) {
						stars[i][j] = ' ';
						continue;
					}
					stars[i][j] = '*';
				}
			}
		} else {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (i == 1 && j == 1){
						for(int m = 0, k=i*size; m<size; m++, k++ ) {
							for(int n = 0, l=j*size; n < size; n++, l++) {
								stars[k][l] = ' ';
							}
						}
						continue;
					}
					for(int m = 0, k=i*size; m<size; m++, k++ ) {
						for(int n = 0, l=j*size; n < size; n++, l++) {
							stars[k][l] = stars[m][n];
						}
					}
				}
			}
			
		}
		recur(N, size * 3);
	}
}
