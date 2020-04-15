package twosum;

class MyBruteForce {
    /**
     * tims O(N^2), space O(1)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int i, j = 0;
        for (i = 0; i < nums.length; i++) {
            for (j = i + 1; j < nums.length; i++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { i, j };
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 7, 11, 15 };
        int[] res = new MyBruteForce().twoSum(nums, 9);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}