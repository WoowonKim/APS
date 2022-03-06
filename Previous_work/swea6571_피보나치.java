import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class swea6571_피보나치 {
	static ArrayList<BigInteger> fiboArr = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		fiboArr.add(new BigInteger("1"));
		fiboArr.add(new BigInteger("2"));
		while(true) {
			int cnt = 0;
			BigInteger a = sc.nextBigInteger();
			BigInteger b = sc.nextBigInteger();
			BigInteger zero = new BigInteger("0");
			if(a.compareTo(zero)==0&&b.compareTo(zero)==0) break;
			
			while ((b.divide(fiboArr.get(fiboArr.size()-1))).compareTo(zero)!=0) {
				fiboExtend();
			}
			for(int i = 0; i<fiboArr.size(); i++) {
				//compareTo 같으면 0 다르면 -1
				if((a.divide(fiboArr.get(i))).compareTo(zero)==0 && (b.divide(fiboArr.get(i))).compareTo(zero)!=0) {
					cnt++;
				}
				if((a.compareTo(fiboArr.get(i)))==0){
					cnt++;
				}
			}
			System.out.println(cnt);
			sc.close();
		}
	}
	
	static void fiboExtend() {
		fiboArr.add(fiboArr.get(fiboArr.size()-1).add(fiboArr.get(fiboArr.size()-2)));
	}
}
