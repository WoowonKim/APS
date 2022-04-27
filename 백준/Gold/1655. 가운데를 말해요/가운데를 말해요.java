import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		
		for(int tc = 0; tc < N; tc++) {
			int num = Integer.parseInt(br.readLine());
			if(maxHeap.size()>minHeap.size())
				minHeap.add(num);
			else 
				maxHeap.add(num);
			if(!minHeap.isEmpty() && minHeap.peek() < maxHeap.peek()) {
				int max = maxHeap.poll();
				int min = minHeap.poll();
				maxHeap.add(min);
				minHeap.add(max);
			}
			bw.write(maxHeap.peek()+"\n");
		}
		bw.flush();
	}

}
