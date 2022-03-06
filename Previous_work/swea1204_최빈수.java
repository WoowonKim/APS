import java.util.Scanner;

public class swea1204_최빈수 {
	
	public static void main(String[] args)throws Exception {
		//testCase수 입력
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int testCase=1; testCase <= T; testCase++ ) {
			//school:testCase번호
			//scores:점수 입력
			int school = sc.nextInt();
			int[] scores = new int[1000];
			for (int i = 0; i <1000; i++) {
				scores[i] = sc.nextInt();
			}
			//scoreNum: 0~100점 빈도수를 저장
			//scoreNum[0] = 0점의 빈도수
			int[] scoreNum= new int[101];
			for(int i=0; i<=100; i++) {
				for(int j=0; j<1000; j++) {
					if(scores[j]==i) {
						scoreNum[i] += 1;
					}
				}
			}
			//max = 최대 빈도수
			//ans = 최빈수
			int max = 0;
			int ans = 0;
			for (int i=0;i<=100;i++) {
				if(scoreNum[i]>=max) {
					max = scoreNum[i];
					ans = i;
				}
			}
			System.out.println("#"+school+" "+ans);
		}
	}
}
