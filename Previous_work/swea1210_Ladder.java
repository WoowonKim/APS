import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			//입력
			int t = sc.nextInt();
			int[][] ladder = new int[100][100];
			int edIdx = 0;
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					ladder[i][j] = sc.nextInt();
					if (ladder[i][j] == 2) {
						edIdx = j;
					}
				}
			}//입력
			int r = 99;
			int c = edIdx;
			for(int d=0; d<10000; d++) {
				if(c==0) {
					if(ladder[r][c+1]==1) {
						while(true) {
							c++;
							if(c==99 || ladder[r][c+1]==0) break;
						}
					}
					r--;
				}
				else if(c==99) {
					if(ladder[r][c-1]==1) {
						while(true) {
							c--;
							if(c==00 || ladder[r][c-1]==0) break;
						}
					}
					r--;
				}
				else if(ladder[r][c-1]==1) {
					while(true) {
						c--;
						if(c==00 || ladder[r][c-1]==0) break;
					}
					r--;
				}
				else if(ladder[r][c+1]==1) {
					while(true) {
						c++;
						if(c==99 || ladder[r][c+1]==0) break;
					}
					r--;
				}
				else r--;
				if(r == 0) break;
			}

			System.out.println("#"+t+" "+c);
		}//tc
	}//main
}//class
