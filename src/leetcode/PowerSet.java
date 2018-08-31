package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSet {

	public static void main(String args[]) {
		PowerSet s = new PowerSet();
		List<List<Integer>> result = s.subsets(new int[]{3,1,2});
		for(int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
	
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        
        powerset(list, new ArrayList<Integer>(), nums, 0);
        
        return list;
    }
    
    public void powerset(List<List<Integer>> list, List<Integer> temp, int []nums, int start) {
        list.add(new ArrayList<>(temp));
        for(int i = start; i < nums.length; i++) {
            if(i > 0 && nums[i - 1] == nums[i])
                continue;
            
            temp.add(nums[i]);
            powerset(list, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
