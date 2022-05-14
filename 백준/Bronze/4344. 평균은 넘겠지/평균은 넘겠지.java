import java.util.Scanner;
 
public class Main {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0) {
			int N = sc.nextInt();
			float score[] = new float[N];
			float sum = 0;
			for(int i = 0; i < N; i++) {
				score[i] = sc.nextFloat();
				sum += score[i];
			}
			float avg = sum / N;
			float cnt = 0;
			for(int i = 0 ; i < N; i++) {
				if(score[i]>avg) cnt ++;
			}
			float ans = (cnt*100/N);
			System.out.printf("%.3f",ans);
			System.out.println("%");
			
		}
	}
}