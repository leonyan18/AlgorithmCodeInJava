package com.yan.dynamic;

import java.util.*;


/**
 * BM82 买卖股票的最好时机(三)
 * https://www.nowcoder.com/practice/4892d3ff304a4880b7a89ba01f48daf9
 */
public class BM82Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 两次交易所能获得的最大收益
     *
     * @param prices int整型一维数组 股票每一天的价格
     * @return int整型
     */
    public int maxProfit(int[] prices) {
        // write code here
        int buy1, buy2;
        int sell1, sell2;
        buy1 = buy2 = -prices[0];
        sell1 = sell2 = 0;
        for (int i = 1; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}