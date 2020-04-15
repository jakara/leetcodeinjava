package twosum;

import java.util.HashMap;
import java.util.Map;

public class OnePassHash {

    /**
     * time O(N), space O(N)
     * 
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    
    public static void main(String[] args) {
        int[] nums = new int[] { 2, 7, 11, 15 };
        int[] res = new OnePassHash().twoSum(nums, 9);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}