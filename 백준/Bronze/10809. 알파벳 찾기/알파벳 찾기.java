import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int[] arr = new int[26];
		Arrays.fill(arr, -1);
		for(int i = 0; i < s.length(); i++) {
			if(arr[s.charAt(i)-'a'] == -1)arr[s.charAt(i)-'a'] = i;
		}
		System.out.println(Arrays.toString(arr).replaceAll(", ", " ").replace("[","").replace("]", ""));
	}	
}