import java.util.Scanner;
 
public class Main {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int max = 0;
		float[] score = new float[N];
		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if( num > max ) max = num;
			score[i] = num;
		}
		
		float sum = 0;
		for(int i = 0; i < N; i++) {
			sum += (score[i]/max)*100 ;
		}
		
		System.out.println(sum/N);
	}
}