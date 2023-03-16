import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[11];
		int idx = 0;
		
		for (int i = 1; i < 11; i++) {
			arr[i] = arr[i-1] + Integer.parseInt(br.readLine());
			if(Math.abs(arr[idx] - 100) >= Math.abs(arr[i] - 100)) idx = i;
		}
		System.out.println(arr[idx]);
	}
	
}
