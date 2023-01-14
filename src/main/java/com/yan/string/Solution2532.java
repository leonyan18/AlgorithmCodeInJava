package com.yan.string;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 2532. 过桥的时间
 * https://leetcode.cn/problems/time-to-cross-a-bridge/
 */
//@Service
public class Solution2532 implements Solution {
    class Node {
        int time;
        int pos;
        int priority;

        public Node(int time, int pos, int priority) {
            this.time = time;
            this.pos = pos;
            this.priority = priority;
        }
    }

    public int findCrossingTime(int n, int k, int[][] time) {
        Comparator<Node> comparator = (n1, n2) -> {
            if (n1.time == n2.time) {
                if (n1.priority == n2.priority) {
                    return n2.pos - n1.pos;
                }
                return n2.priority - n1.priority;
            }
            return n1.time - n2.time;
        };
        Comparator<Node> comparator2 = (n1, n2) -> {
            if (n1.priority == n2.priority) {
                return n2.pos - n1.pos;
            }
            return n2.priority - n1.priority;
        };
        PriorityQueue<Node> ql = new PriorityQueue<>(k + 3, comparator);
        PriorityQueue<Node> qr = new PriorityQueue<>(k + 3, comparator);
        PriorityQueue<Node> qlw = new PriorityQueue<>(k + 3, comparator2);
        PriorityQueue<Node> qrw = new PriorityQueue<>(k + 3, comparator2);
        for (int i = 0; i < k; i++) {
            ql.add(new Node(0, i, time[i][0] + time[i][2]));
        }
        int cnt = n;
        int timebrige = 0;
        while (!ql.isEmpty() || !qr.isEmpty() || !qlw.isEmpty() || !qrw.isEmpty()) {
            // 等待的全部按照优先级排序
            while (!ql.isEmpty() && ql.peek().time <= timebrige) {
                qlw.add(ql.poll());
            }
            // 等待的全部按照优先级排序
            while (!qr.isEmpty() && qr.peek().time <= timebrige) {
                qrw.add(qr.poll());
            }
            boolean flag;
            Node temp;
            if (!qrw.isEmpty()) {
                flag = true;
                temp = qrw.poll();
            } else if (!qlw.isEmpty()) {
                flag = false;
                temp = qlw.poll();
            } else if (ql.isEmpty()) {
                // 左边空
                flag = true;
                temp = qr.poll();
            } else if (!qr.isEmpty() && qr.peek().time <= ql.peek().time) {
                // 右边时间小于等于桥时时 右边肯定先，或者先在右边等的话
                flag = true;
                temp = qr.poll();
            } else {
                flag = false;
                temp = ql.poll();
            }
            if (temp.time < timebrige) {
                temp.time = timebrige;
            }
            // 去左边
            if (flag) {
                // 过桥
                temp.time += time[temp.pos][2];
                timebrige = temp.time;
                System.out.println(cnt + " " + n + " 工人" + temp.pos + "右到左桥时" + timebrige);
                cnt--;
                // 最后一个
                if (cnt == 0) {
                    return temp.time;
                }
                // 新仓库放完货物
                temp.time += time[temp.pos][3];
                ql.add(temp);
            } else {
                // 工人是否足够
                if (n <= 0) {
                    continue;
                }
                n--;
                // 过桥
                temp.time += time[temp.pos][0];
                timebrige = temp.time;
                System.out.println(cnt + " " + n + " 工人" + temp.pos + "左到右桥时" + timebrige);
                // 旧仓库取完货物
                temp.time += time[temp.pos][1];
                qr.add(temp);
            }
        }
        return 0;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
//        int[][] time = {{867, 913, 934, 966}, {931, 909, 887, 865}, {801, 937, 871, 972}, {979, 879, 829, 848}, {863, 823, 925, 824}, {942, 966, 846, 972}, {807, 873, 991, 952}, {957, 991, 851, 991}, {800, 843, 852, 971}, {884, 861, 855, 914}, {845, 947, 896, 835}, {975, 853, 848, 961}, {828, 926, 942, 987}, {939, 881, 908, 970}, {979, 819, 993, 830}, {996, 875, 814, 850}, {990, 987, 982, 986}, {895, 933, 833, 806}, {874, 933, 917, 917}, {896, 927, 930, 820}, {932, 810, 854, 959}, {848, 921, 949, 922}, {892, 918, 886, 887}, {872, 953, 827, 884}, {952, 869, 933, 906}, {874, 934, 937, 803}, {858, 940, 970, 947}, {932, 824, 834, 929}, {970, 918, 926, 881}, {844, 821, 861, 901}, {929, 887, 970, 822}, {833, 848, 903, 970}, {998, 886, 824, 821}, {887, 992, 802, 843}, {875, 983, 927, 871}, {951, 811, 809, 941}, {995, 943, 968, 964}, {823, 894, 814, 978}, {904, 825, 814, 816}, {985, 934, 926, 938}, {806, 868, 824, 826}, {989, 990, 853, 930}, {826, 849, 963, 808}, {951, 873, 915, 813}, {971, 961, 952, 819}, {962, 879, 832, 951}, {825, 871, 837, 869}, {887, 950, 876, 802}, {829, 976, 914, 945}, {893, 943, 998, 925}, {962, 878, 899, 985}, {850, 852, 946, 897}, {912, 919, 911, 994}, {926, 911, 969, 962}, {800, 972, 861, 970}, {989, 850, 953, 916}, {954, 809, 819, 902}, {810, 906, 815, 850}, {985, 877, 990, 963}, {950, 832, 962, 853}, {999, 974, 964, 949}, {937, 980, 886, 912}, {943, 850, 869, 984}, {841, 913, 846, 968}, {899, 877, 996, 934}, {816, 973, 925, 803}, {815, 851, 946, 844}, {868, 852, 853, 824}, {811, 836, 929, 903}, {826, 837, 940, 805}, {862, 942, 825, 857}, {915, 923, 933, 900}, {868, 812, 863, 850}, {926, 996, 865, 840}, {931, 950, 834, 978}, {982, 985, 855, 821}, {986, 876, 940, 859}, {847, 911, 972, 848}, {838, 938, 843, 910}, {803, 947, 981, 836}, {981, 801, 874, 855}, {993, 949, 882, 949}, {972, 910, 876, 990}, {907, 951, 944, 867}, {865, 860, 863, 910}, {942, 897, 962, 950}, {864, 987, 999, 945}, {931, 877, 999, 966}, {996, 862, 885, 848}, {817, 956, 861, 833}, {850, 973, 936, 934}, {997, 924, 952, 954}, {832, 930, 988, 978}, {892, 934, 930, 808}, {886, 889, 812, 835}, {829, 835, 906, 819}, {817, 965, 909, 981}, {890, 890, 889, 883}, {816, 901, 853, 853}, {969, 999, 998, 885}, {917, 853, 879, 851}, {809, 807, 966, 985}, {892, 827, 857, 966}, {919, 864, 946, 974}, {878, 808, 908, 860}, {850, 937, 926, 832}, {823, 865, 805, 883}, {946, 878, 908, 915}, {964, 932, 965, 863}, {826, 993, 913, 875}, {949, 826, 989, 932}, {916, 878, 926, 832}, {991, 816, 977, 811}, {985, 879, 840, 958}, {894, 943, 912, 912}, {933, 845, 936, 980}, {991, 944, 887, 953}, {948, 871, 855, 866}, {904, 839, 1000, 804}, {883, 825, 889, 930}, {842, 811, 801, 978}, {857, 886, 803, 946}, {844, 917, 833, 838}, {976, 848, 911, 984}, {979, 836, 957, 952}, {932, 803, 956, 889}, {936, 835, 933, 842}, {900, 940, 978, 914}, {838, 934, 934, 848}, {898, 877, 844, 940}, {833, 874, 879, 850}, {963, 880, 925, 964}, {800, 898, 952, 812}};
//        System.out.println(findCrossingTime(10000, 133, time));
//        int[][] time1 = {{2, 10, 5, 8}, {3, 5, 2, 2}, {5, 8, 10, 10}, {7, 8, 8, 5}, {5, 6, 6, 10}, {6, 10, 6, 2}};
//        System.out.println(findCrossingTime(10, 6, time1));
        int[][] time2 = {{2, 6, 9, 4}, {4, 8, 7, 5}, {4, 6, 7, 6}, {2, 3, 3, 7}, {9, 3, 6, 8}, {2, 8, 8, 4}};
//        int[][] time2 = {{2, 6, 9, 4}, {4, 8, 7, 5}, {4, 6, 7, 6}, {2, 3, 3, 7}, {9, 3, 6, 8}, {2, 8, 8, 4}};
        System.out.println(findCrossingTime(9, 6, time2));
    }
}