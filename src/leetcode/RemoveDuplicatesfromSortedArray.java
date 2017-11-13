package leetcode;

public class RemoveDuplicatesfromSortedArray {
	
	public static void main(String args[]) {
		System.out.println(removeDuplicates(new int[]{1,1,2}));
	}
	
	public static int removeDuplicates(int[] nums) {
		if(nums == null) {
            return 0;
        }
        
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
           if (nums[i] != nums[j]) {
             nums[++j] = nums[i];
           }
        }
        return j + 1;
	}
}