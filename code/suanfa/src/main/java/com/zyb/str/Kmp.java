package com.zyb.str;

import java.util.ArrayList;
import java.util.List;

import cn.hutool.json.JSONUtil;
/**
 * kmp算法
 * 主串：被对比串；从串：对比串；坏字符：第一个匹配不上的字符
 *      查询从串在主串中是否存在，返回第一次匹配的下标
 * 逻辑：查询最长公共前后缀，即从串坏字符前的字符串中，从前往后截取字符串和相同长度的后缀字符串对比是否相同，（一共长度为5，substring(0,3)和substring(2,5)对比是否相同）。
 *      让从串在主串中对比的起点下标移动到，最后公共前后缀中后缀的下标处。
 */
public class Kmp {

    public static void main(String[] args) {
        // System.out.println("1:" + Math.random());
        // List<Integer> next = getPublicPre("encodenco");
        System.out.println("same index:" + getSameStrIndex("encotenencoencodencoco", "encodenco"));
    }

    private static int getSameStrIndex(String primary, String slave) {
        List<Integer> next = getPublicPre(slave);
        System.out.println("next: " + JSONUtil.toJsonStr(next));
        int index = 0;
        int length = 1;
        while (index < primary.length()) {
            if (index + length > primary.length()) {
                return -1;
            }
            String primaryStr = primary.substring(index, index + length);
            String slaveStr = slave.substring(0, length);
            if (primaryStr.equals(slaveStr)) {
                if (length == slave.length()) {
                    break;
                }
                length++;
            } else {
                int nextIndex = next.get(length);
                if (nextIndex == -1) {
                    index += length;
                } else {
                    index = index + nextIndex;
                }
                System.out.println("index:" + index);
                length = 1;
            }
        }
        return index;
    }

    /**
     * 查询最长公共前后缀
     * 
     * @param str 模式串
     */
    private static List<Integer> getPublicPre(String str) {
        if (str.length() <= 1) {
            return null;
        }
        List<Integer> publicPre = new ArrayList<>();
        publicPre.add(-1);
        for (int i = 1; i < str.length() - 1; i++) {
            String childStr = str.substring(0, i + 1);
            int index = str.length();
            // System.out.println("i:" + i + ",------------childStr:" + childStr);
            for (int j = 0; j < childStr.length() - 1; j++) {
                String head = childStr.substring(0, j + 1);
                String tail = childStr.substring(childStr.length() - j - 1, childStr.length());
                // System.out.println("j:" + j + ",head:" + head);
                // System.out.println("j:" + j + ",tail:" + tail);
                if (head.equals(tail) && index > childStr.length() - j - 1) {
                    index = childStr.length() - j - 1;
                }
            }
            if (index == str.length()) {
                publicPre.add(-1);
                
            } else {
                publicPre.add(index);
            }
            // System.out.println("index:" + JSONUtil.toJsonStr(publicPre) + "**************");
        }
        publicPre.add(-1);
        return publicPre;
    }

}
