import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ17225_선물가게 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Bt = sc.nextInt(); // 파란색 하나 포장 걸리는 시간
		int Rt = sc.nextInt(); // 빨간색 하나 포장 걸리는 시간
		int N = sc.nextInt(); // 가게의 손님 수
		Queue<Integer> Bq = new LinkedList<>();
		Queue<Integer> Rq = new LinkedList<>();
		HashMap<Integer, Integer> Border = new HashMap<>(); // B 주문받은 시각, 주문한 선물 수
		HashMap<Integer, Integer> Rorder = new HashMap<>(); // R 주문받은 시각, 주문한 선물 수

		int total = 0; // 총 포장한 선물 수
		for (int i = 1; i <= N; i++) {
			int t = sc.nextInt(); // 주문 받은 시각
			String c = sc.next(); // 주문한 색깔
			int m = sc.nextInt(); // 주문한 선물 수
			total += m;
			if ("B".equals(c))
				Border.put(t, m);
			else
				Rorder.put(t, m);
		}

		int time = 0; // 시간
		int giftNo = 0; // 선물 번호
		int Btopack = 0, Rtopack = 0; // 포장해야하는 선물 수
		int Bst = -Bt, Rst = -Rt; // 포장 시작 시간
		while (giftNo < total) {
			// B 주문 받음 -> B 포장해야하는 선물 수 추가
			if (Border.get(time) != null)
				Btopack += Border.get(time);
			// R 주문 받음 -> R 포장해야하는 선물 수 추가
			if (Rorder.get(time) != null)
				Rtopack += Rorder.get(time);

			// 이전 것의 포장이 끝났고, 포장할 것이 남았다면, 포장 시작
			// while -> 포장하는데 걸리는 시간이 0이면 계속 포장할 수도 있음
			while (time >= Bst + Bt && Btopack > 0) {
				Bq.offer(++giftNo); // 다음 선물 번호 포장
				Bst = time; // 포장 시작 시간
				Btopack--; // 포장 해야하는 수 - 1
			}
			// 이전 것의 포장이 끝났고, 포장할 것이 남았다면, 포장 시작
			while (time >= Rst + Rt && Rtopack > 0) {
				Rq.offer(++giftNo); // 다음 선물 번호 포장
				Rst = time; // 포장 시작 시간
				Rtopack--; // 포장 해야하는 수 - 1
			}
			time++;
		}
		System.out.println(Bq.size());
		System.out.println(Bq.toString().replaceAll("[\\[\\,\\]]", ""));
		System.out.println(Rq.size());
		System.out.println(Rq.toString().replaceAll("[\\[\\,\\]]", ""));
		sc.close();
	}

}// main
