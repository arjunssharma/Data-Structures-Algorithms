package leetcode;

public class ProductOfArrayExceptSelf {

	public int[] productExceptSelf(int[] nums) {
	        int result[] = new int[nums.length];
	        if(nums == null || nums.length == 0)
	            return result;
	        
	        for(int i = 0; i < result.length; i++)
	            result[i] = 1;
	        
	        int left = 1;
	        int right = 1;
	        for(int i = 0, j = nums.length - 1; i < nums.length - 1 && j > 0; i++, j--) {
	            left *= nums[i];
	            result[i + 1] *= left;
	            right *= nums[j];
	            result[j - 1] *= right;
	        }
	        
	        return result;
	    }
}
