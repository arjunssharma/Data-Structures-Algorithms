package leetcode;

public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) { 
        int i = 0;
        for(; i<nums.length; i++) {
                if(target <= nums[i]) {
                    return i;
                }
        }
        return i;
    }
}
