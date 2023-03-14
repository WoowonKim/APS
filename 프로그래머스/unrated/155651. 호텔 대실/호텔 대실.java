import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
		int answer = 0;
		int[][] books = new int[book_time.length][2];
		for (int i = 0; i < book_time.length; i++) {
			books[i][0] = Integer.parseInt(book_time[i][0].replace(":", ""));
			books[i][1] = Integer.parseInt(book_time[i][1].replace(":", ""));
			books[i][1] = add10Min(books[i][1]);
		}
		
		Arrays.sort(books, new Comparator<int[]>() {
			@Override
			public int compare(int[] s1, int[] s2) {
				int s1H = s1[0]/100;
				int s1M = s1[0]%100;
				int s2H = s2[0]/100;
				int s2M = s2[0]%100;
				if (s1H != s2H)
					return s1H - s2H;
				else
					return s1M - s2M;
			}
		});
		
		ArrayList<Stack<Integer>> rooms = new ArrayList<>();
		rooms.add(new Stack<>());
		rooms.get(0).add(books[0][1]);
		
		for(int i = 1; i < books.length; i++) {
			int[] curr = books[i];
			boolean added = false;
			for(Stack<Integer> room : rooms) {
				if(room.peek() <= curr[0]) {
					room.add(curr[1]);
					added = true;
					break;
				}
			}
			if(!added) {
				Stack<Integer> newRoom = new Stack<>();
				newRoom.add(curr[1]);
				rooms.add(newRoom);
			}
		}
		
		return rooms.size();
	
    }
    static int add10Min(int time) {
		int H = time/100;
		int M = time%100;
		M+=10;
		if(M >= 60) {
			M -= 60;
			H++;
		}
		return H*100+M;
	}
}