import java.util.*;

/**
 * @author yxl
 * @version 1.0
 * @date 2021/1/17 下午9:32
 */
public class FirstQuestion {

    /**
     * 1. 两数之和
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     *
     * 你可以按任意顺序返回答案。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     */

    /**
     * 示例 1：
     *
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     * 示例 2：
     *
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     * 示例 3：
     *
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     */


    /**
     * 个人解题思路
     */
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            List<Integer> result = new ArrayList();
            Set<Integer> set = new HashSet();
            Set<Integer> set2 = new HashSet();
            for (int i = 0; i < nums.length; i++) {
                int b = target - nums[i];
                if (set.contains(b)) {
                    set2.add(nums[i]);
                    break;
                } else {
                    set.add(nums[i]);
                }
            }
            set.stream().forEach(num -> {
                int b = target - num;
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == num) {
                        result.add(i);
                        System.out.println(i);
                    }
                    if (b == nums[i] && b != num) {
                        result.add(i);
                        System.out.println(i);
                    }
                }
            });
            int[] ints = result.stream().mapToInt(Integer::valueOf).toArray();
            return ints;
        }
    }

    /**
     * 大佬解题思路
     */
    static class Solution2 {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int i = 0; i < nums.length; i++){
                if(map.containsKey(nums[i])){
                    return new int[]{map.get(nums[i]), i};
                }
                map.put(target - nums[i], i);
            }
            return null;
        }


    }


    public static void main(String[] args) {
        Solution s=new Solution();
        int[] nums ={3,3};
        int target = 6;
        s.twoSum(nums,target);
    }

}
