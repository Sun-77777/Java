class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        int j = 0;
        int k = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i]%2 == 0) {
                ret[j] = nums[i];
                j +=2;
            } else {
                ret[k] = nums[i];
                k +=2;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {4,2,5,7};
        int[] ret = solution.sortArrayByParityII(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(ret[i]);
        }
    }
}