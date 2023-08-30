/**
 * Copyright (c) by Shanghai PoleLink Information Technology Co.,Ltd. All rights reserved.
 * <p>
 * This software is copyright protected and proprietary to Shanghai PoleLink
 * Information Technology. Shanghai PoleLink Information Technology Co.,Ltd
 * grants to you only those rights as set out in the license conditions.
 * All other rights remain with Shanghai PoleLink Information Technology Co.,Ltd.
 **/

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: LCR011
 * Description:
 * 实现记录前缀和的出现次数可以使用哈希表（也称为字典或映射），以前缀和作为键（key），出现次数作为值（value）。
 * 这样可以有效地在O(1)的时间内查找、插入和更新前缀和出现次数。
 *
 * @author ganph
 * @since 2023-08-30 23:06:03
 **/
public class LCR011 {
    public int findMaxLength(int[] nums) {

        Map<Integer, Integer> prefixSumIndex = new HashMap<>();
        prefixSumIndex.put(0, -1);
        int maxLen = 0;
        int currSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currSum += (nums[i] == 0) ? -1 : 1;

            if (prefixSumIndex.containsKey(currSum)) {
                int prevIndex = prefixSumIndex.get(currSum);
                maxLen = Math.max(maxLen, i - prevIndex);
            } else {
                prefixSumIndex.put(currSum, i);
            }
        }
        return maxLen;

    }
}
