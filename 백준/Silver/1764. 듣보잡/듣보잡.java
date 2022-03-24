import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		String[] nevers = new String[N];
		String[] neverh = new String[M];
		ArrayList<String> neversh = new ArrayList<String>();
		for (int i = 0; i < N; i++) {
			nevers[i] = sc.next();
		}
		for (int i = 0; i < M; i++) {
			neverh[i] = sc.next();
		}

		if (N < M) {
			Arrays.sort(neverh);
			Arrays.sort(nevers);
			for (int i = 0; i < N; i++) {
				int head = 0;
				int tail = M - 1;
				int center = (head + tail) / 2;
				if(nevers[i].equals(neverh[center])) {
					neversh.add(nevers[i]);
					continue;
				}
				while (!nevers[i].equals(neverh[center])) {
					if (head > tail)
						break;
					if (nevers[i].compareTo(neverh[center]) > 0) {
						head = center + 1;
						center = (head + tail) / 2;
					} else {
						tail = center - 1;
						center = (head + tail) / 2;
					}
					if (nevers[i].equals(neverh[center])) {
						neversh.add(nevers[i]);
						break;
					}
				}
			}
		} else {
			Arrays.sort(nevers);
			Arrays.sort(neverh);
			for (int i = 0; i < M; i++) {
				int head = 0;
				int tail = N - 1;
				int center = (head + tail) / 2;
				if(neverh[i].equals(nevers[center])) {
					neversh.add(neverh[i]);
					continue;
				}
				while (!neverh[i].equals(nevers[center])) {
					if (head > tail)
						break;
					if (neverh[i].compareTo(nevers[center]) > 0) {
						head = center + 1;
						center = (head + tail) / 2;
					} else {
						tail = center - 1;
						center = (head + tail) / 2;
					}
					if (neverh[i].equals(nevers[center])) {
						neversh.add(neverh[i]);
						break;
					}
				}
			}
		}

		System.out.println(neversh.size());
		for(String string : neversh) {
			System.out.println(string);
		}
	}

}
