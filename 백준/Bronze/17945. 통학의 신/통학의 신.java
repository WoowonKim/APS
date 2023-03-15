
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(stk.nextToken());
		int B = Integer.parseInt(stk.nextToken());
		
		//TreeSet 자료구조를 사용하면 알아서 중복제거 및 정렬
		Set<Integer> ansSet = new TreeSet<>();
		//짝수 근의 공식
		ansSet.add((int) (-A + Math.pow(Math.pow(A, 2)-B, 0.5)));
		ansSet.add((int) (-A - Math.pow(Math.pow(A, 2)-B, 0.5)));
	
		System.out.println(ansSet.toString().replaceAll("[\\[,\\]]", ""));
		
	}

}
