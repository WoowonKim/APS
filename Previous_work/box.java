public class box {

	public static void main(String[] args) {
		// box의 높이가 주어진다.
		int[] box = { 7, 4, 2, 0, 0, 6, 0, 7, 0 };

		// 각 열을 확인을 해보아야겠다.
		int max = 0;

//		i번째 박스를 검사 하겠다. (얼마나 낙하 할 수 있는지)
		for (int i = 0; i < box.length; i++) {
			// 박스 최대 낙하높이는?
//			box의 길이가 9라고 할때
//			0번째 박스는 얼마만큼 떨어질 수 있을까요??? 최대 8만큼 떨어질 수 있다.
//			3번째 박스는 얼마만큼?? 최대 5만큼..
//			i번째는 얼마만큼 떨어질수 있나???? N-2-i
			int cnt = box.length - 2 - i;
			
			for(int j = i+1; j <box.length; j++) {
				// i번째의 박스의 높이보다 크거나 같은 값이 나오면 낮차를 감소 시킴
				if(box[j]>= box[i])
					cnt--;
				//갱신
				if(max < cnt) {
					max = cnt;
				}
			}
		}
		System.out.println(max);
	}

}
