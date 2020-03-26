package com.simple;

import com.simple.vo.ListNode;

import java.util.*;

public class Solution {


    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int num = 0;
        int temp = x;
        while (x != 0) {
            num = num * 10 + x % 10;
            x /= 10;
        }

        return num == temp ? true : false;
    }

    /**
     * 罗马数字转整数 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。 字符 数值 I 1 V 5 X 10 L 50 C 100 D
     * 500 M 1000 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做
     * XXVII, 即为 XX + V + II 。
     * <p>
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5
     * 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     * <p>
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和
     * 90。 C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * <p>
     * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        //首先建立一个HashMap来映射符号和值，然后对字符串从左到右来，如果当前字符代表的值不小于其右边，就加上该值；否则就减去该值。
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int curVal = map.get(s.charAt(i));
            int nextVal = i < s.length() - 1 ? map.get(s.charAt(i + 1)) : 0;
            res += curVal < nextVal ? -curVal : curVal;
        }
        return res;
    }

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String reg = strs[0];
        for (String str : strs) {
            while (!str.startsWith(reg)) {
                if (reg.length() == 1) {
                    return "";
                }
                reg = reg.substring(0, reg.length() - 1);
            }
        }
        return reg;
    }

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     *
     * @param
     * @return
     */
    public boolean isValid(String s) {
        while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            s = s.replaceAll("\\(\\)", "");
            s = s.replaceAll("\\[\\]", "");
            s = s.replaceAll("\\{\\}", "");
        }
        return s.length() == 0;

    }


    /**
     * 反转一个单链表。
     * 示例:
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    /**
     * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
     * <p>
     * 初始化 A 和 B 的元素数量分别为 m 和 n。
     * <p>
     * 示例:
     * <p>
     * 输入:
     * A = [1,2,3,0,0,0], m = 3
     * B = [2,5,6],       n = 3
     * <p>
     * 输出: [1,2,2,3,5,6]
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge(int[] A, int m, int[] B, int n) {
        for (int i = 0; i < n; i++)
            A[m + i] = B[i];
        Arrays.sort(A);
        System.out.println(A.toString());
    }

    /**
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成
     * 给定数组 nums = [1,1,2], 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 你不需要考虑数组中超出新长度后面的元素。
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int temp = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[temp] != nums[i]) {
                temp++;
                nums[temp] = nums[i];
            }
        }
        return temp + 1;
    }

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)
            return 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    /**
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (haystack.equalsIgnoreCase(needle)) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.substring(i, haystack.length()).startsWith(needle)) {
                return i;
            }

        }
        return -1;
    }

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int find = -1;
        int insert = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                find = i;
            }
            if (i <= nums.length - 2 && nums[i] < target && target < nums[i + 1]) {
                insert = i + 1;
            }
            if (i == nums.length - 1 && find == -1 && nums[i] < target) {
                insert = nums.length;
            }
        }
        if (find == -1 && insert == -1) {
            return 0;
        }
        return find == -1 ? insert : find;
    }

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0)
                sum += num;
            else
                sum = num;
            res = Math.max(res, sum);
        }
        return res;
    }

    /**
     * 排排坐，分糖果。
     * <p>
     * 我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。
     * <p>
     * 给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。
     * <p>
     * 然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。
     * <p>
     * 重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），这些糖果也会全部发给当前的小朋友。
     * <p>
     * 返回一个长度为 num_people、元素之和为 candies 的数组，以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）。
     * <p>
     * 输入：candies = 7, num_people = 4 输出：[1,2,3,1] 解释： 第一次，ans[0] += 1，数组变为 [1,0,0,0]。 第二次，ans[1] += 2，数组变为 [1,2,0,0]。 第三次，ans[2] += 3，数组变为 [1,2,3,0]。 第四次，ans[3] += 1（因为此时只剩下 1 颗糖果），最终数组变为 [1,2,3,1]。
     *
     * @param candies
     * @param num_people
     * @return
     */
    public int[] distributeCandies(int candies, int num_people) {

        int[] res = new int[num_people];
        int n = 0;
        int sum = 0;
        while (true) {
            for (int i = 0; i < res.length; i++) {
                if (candies - sum <= n) {
                    res[i] += candies - sum;
                    return res;
                }
                res[i] += ++n;
                sum += n;
            }
        }
    }


    /**
     * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
     * <p>
     * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
     * <p>
     * 思路:
     * 譬如说如果有两个连续的数之和等于target，那么相差为1， (target - 1) % 2 == 0，
     * 且数组一定是从 (target - 1) / 2开始的，数组的元素就是2个；
     * 如果是3个连续的数组，那么三个数之间相差为1、2，(target - 1 - 2) % 3 == 0，
     * 且数组一定是从 (target - 1 - 2) % 3开始的，数组元素是3个，
     * 依次类推，但是注意target必须是大于0的数，且res需要倒序。
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        ArrayList<int[]> res = new ArrayList<>();
        int i = 1;
        int max = target / 2 + 1;
        int j = 1;
        int sum = 1;
        while (i <= max) {
            if (sum < target) {
                j++;
                sum += j;
            } else if (sum > target) {
                sum -= i;
                i++;
            } else {
                int[] num = new int[j - i + 1];
                for (int x = i, y = 0; x <= j; x++, y++) {
                    num[y] = x;
                }
                res.add(num);
                sum -= i;
                i++;
            }
        }
        //这里注意奥，为什么是0，看源码
        return res.toArray(new int[0][]);
    }

    public int lengthOfLastWord(String s) {
        if (s.trim().length() == 0) {
            return 0;
        }
        String[] sa = s.split(" ");
        return sa[sa.length - 1].length();
    }

    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * <p>
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * <p>
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        //跳出for循环，说明数字全部是9
        int[] temp = new int[digits.length + 1];
        temp[0] = 1;
        return temp;
    }

    /**
     * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        StringBuffer str = new StringBuffer();
        for (int s : coins) {
            str.append(s);
        }
        for (int i = coins.length - 1; i > -1; i--) {
            if (amount % coins[i] == 0) {
                return amount / coins[i];
            }
            if (amount > coins[i] && str.toString().contains(String.valueOf(amount % coins[i]))) {
                return amount / coins[i] + 1;
            }
        }
        return -1;
    }

    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }

    /**
     * 给定两个二进制字符串，返回他们的和（用二进制表示）。
     * 输入为非空字符串且只包含数字 1 和 0。
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) return b;
        if (b == null || b.length() == 0) return a;

        StringBuilder stb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;

        int c = 0;  // 进位
        while (i >= 0 || j >= 0) {
            if (i >= 0) c += a.charAt(i--) - '0';
            if (j >= 0) c += b.charAt(j--) - '0';
            stb.append(c % 2);
            c >>= 1;
        }

        String res = stb.reverse().toString();
        return c > 0 ? '1' + res : res;
    }

    /**
     * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
     * <p>
     * 形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
     *
     * @param A
     * @return
     */
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int num : A) {
            sum += num;
        }
        // 数组A的和如果不能被3整除返回false
        if (sum % 3 != 0) {
            return false;
        }
        // 遍历数组累加，每累加到目标值cnt加1，表示又找到1段,
        // 找到2段后就返回true（i只能到数组A的倒数第二个元素，保证了有第3段）
        sum /= 3;
        int curSum = 0, cnt = 0;
        for (int i = 0; i < A.length - 1; i++) {
            curSum += A[i];
            if (curSum == sum) {
                cnt++;
                if (cnt == 2) {
                    return true;
                }
                curSum = 0;
            }
        }
        return false;
    }

    /**
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Map map = new HashMap();
        for (int num : nums) {
            if (map.containsKey(num)) {
                int val = (int) map.get(num) + 1;
                if (val > nums.length / 2) {
                    return num;
                }
                map.put(num, val);
            } else {
                map.put(num, 1);
            }
        }
        return 0;
    }

    /**
     * 输入：words = ["cat","bt","hat","tree"], chars = "atach" 输出：6
     * 解释： 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
     *
     * @param words
     * @param chars
     * @return
     */
    public int countCharacters(String[] words, String chars) {
        int res = 0;
        String temp;
        for (String word : words) {
            temp = chars;
            for (int i = 0; word.length() > 0 && i < word.length(); i++) {
                if (!temp.contains(String.valueOf(word.charAt(i)))) {
                    break;
                } else {
                    temp = temp.replaceFirst(String.valueOf(word.charAt(i)), "*");
                    if (i == word.length() - 1) {
                        res += word.length();
                    }
                }
            }
        }
        return res;
    }


    /**
     * @param rec1
     * @param rec2
     * @return
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0] || rec2[2] <= rec1[0] || rec1[3] <= rec2[1] || rec2[3] <= rec1[1]);
    }

    public int climbStairs(int n) {

        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }

    public int minIncrementForUnique(int[] A) {
      int res = 0;
      Arrays.sort(A);
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                int pre = A[i];
                A[i] = A[i - 1] + 1;
                res += A[i] - pre;
            }
        }
      return res;
    }


    public static int MaxChildArrayOrder(int a[]) {
        int n = a.length;
        int temp[] = new int[n];//temp[i]代表0...i上最长递增子序列
        for(int i=0;i<n;i++){
            temp[i] = 1;//初始值都为1
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(a[i]>a[j]&&temp[j]+1>temp[i]){
                    //如果有a[i]比它前面所有的数都大，则temp[i]为它前面的比它小的数的那一个temp+1取得的最大值
                    temp[i] = temp[j]+1;
                }
            }
        }
        int max = temp[0];
        //从temp数组里取出最大的值
        for(int i=1;i<n;i++){
            if(temp[i]>max){
                max = temp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        /*System.out.println(new Solution().isPalindrome(-121));
        System.out.println(new Solution().romanToInt("II"));
        String[] strs={"flower","flow","flight"};
        System.out.println(new Solution().longestCommonPrefix(strs));*/
        //int[] A = {1, 2, 3, 0, 0, 0};
        int[] B = {2, 2, 1, 1, 1, 2, 2};
        String[] words = {"hello", "world", "leetcode"};
        String chars = "welldonehoneyr";
        //new Solution().merge(A, 3, B, 3);
        //System.out.println("123".charAt(1));
        //System.out.println(new Solution().countCharacters(words, chars));
        int [] rec1 = {0,0,1,1};
        int [] rec2 = {1,0,2,1};
        int [] A = {3,2,1,2,1,7};
        int arr[] = {3,1,4,1,5,9,2,6,5};
        System.out.println(new Solution().MaxChildArrayOrder(arr));

    }

}
