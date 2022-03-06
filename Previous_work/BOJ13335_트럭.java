
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ13335_트럭 {
	/**
	 * n개의 트럭이 다리를 건넌다. 다리위에는 w대의 트럭만 동시에 올라갈 수 있다. 다리의 길이는 w 단위길이이며, 단위시간당 하나의
	 * 단위길이만큼 이동한다. 다리위의 트럭들의 무게 합은 다리의 최대 하중 L보다 작거나 같아야 한다.
	 * 
	 * input : N W L 트럭 수, 길이, 하중 a1, a2 ... 각 트럭의 무게 output : 모든 트럭이 건너는 최단 시간
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();	// 다리를 건너는 트럭의 수 1 ~ 1,000
		int w = sc.nextInt();	// 다리의 길이	1 ~ 100
		int L = sc.nextInt(); 	// 다리의 최대하중 10 ~ 1,000
		int[] truck = new int[n + 1];	// 각 트럭의 번호에 따른 하중 배열
		
		// 트럭 하중 입력
		for (int i = 1; i <= n; i++) {
			truck[i] = sc.nextInt();
		}		
		
		// Queue 를 다리로 활용
		// 다리 길이만큼 0을 채워줌
		Queue<Integer> bridge = new LinkedList<>();
		for (int i = 0; i < w; i++) {
			bridge.add(0);
		}
		
		// 트럭의 다리 건너기
		int sum = 0;	// 다리에 올라간 트럭 하중 합
		int time = 0;	// 이동에 걸리는 시간 저장할 변수
		for (int i = 1; i <= n; i++) {
			// 새로운 트럭이 다리에 올라갈 수 있을때까지 트럭 진행
			while (sum - bridge.peek() + truck[i] > L) {
				time++;
				sum -= bridge.remove();
				bridge.add(0);
			}
			// 새로운 트럭 다리에 올라감
			time++;
			sum -= bridge.remove();
			bridge.add(truck[i]);
			sum += truck[i];
		}
		// 마지막에 오른 트럭이 다리 건너는데 걸리는 시간 w
		time += w;
		
		System.out.println(time);		
		sc.close();
	}
}
