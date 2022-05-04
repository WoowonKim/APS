import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
    static int arr[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
        arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        
        int val = arr[1]-arr[0];
        for(int i=2; i<N; i++) {
            val = GCD(val, arr[i] - arr[i-1]);
        }
        for(int i=2; i<=val; i++) {
            if(val%i == 0) {
                System.out.print(i+" ");
            }
        }
        
    }
    public static int GCD(int a, int b) {
        if(a%b == 0) {
            return b;
        }
        
        return GCD(b, a%b);
    }
}
