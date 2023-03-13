
import java.io.*;
import java.util.*;

public class Main {
	

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int preNow = 0;
		int now = 3;
		int mid = 3;
		
		while(N > now) {
			preNow = now;
			now = now * 2 + (mid + 1);
			mid++;
		}
		
		while(true) {
			if(preNow < N && N <= preNow + mid) {
				N -= preNow;
				break;
			}
			if(N <= preNow) {
				now = preNow;
				mid--;
				preNow = (now - mid)/2;
			}
			else {
				now = preNow;
				N-=preNow + mid	;
				mid--;
				preNow = (now-mid)/2;
			}
		}
		System.out.println(N==1?'m' : 'o');
	}
	
}
