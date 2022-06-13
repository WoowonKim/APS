import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<String, Integer> trees = new HashMap<String, Integer>();
		int cnt = 0;
		String input;
		while((input = br.readLine())!=null) {
			cnt++;
			if(trees.containsKey(input)) {
				trees.put(input, trees.get(input)+1);
			}else {
				trees.put(input, 1);
			}
		}
		
		Object[] treeNames = trees.keySet().toArray();
		Arrays.sort(treeNames);
		
		for(Object treeName : treeNames) {
			String name = (String) treeName;
			int nums = trees.get(name);
			double ans = (double)(nums*100)/cnt;
			sb.append(name + " " + String.format("%.4f", ans)+"\n");
		}
		System.out.println(sb);
	}
}