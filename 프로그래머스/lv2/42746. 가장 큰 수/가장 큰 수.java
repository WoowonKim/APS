import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            nums[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(nums, new Comparator<String>() {
		@Override
		public int compare(String o1, String o2) {
			return (o2+o1).compareTo(o1+o2);
		    }
	    });
        StringBuilder ans = new StringBuilder();
        for(String num : nums) ans.append(num);
        if(nums[0].equals("0")) return "0"; 
        return ans.toString();
    }
}