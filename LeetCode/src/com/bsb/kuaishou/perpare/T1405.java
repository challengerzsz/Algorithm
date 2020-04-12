package com.bsb.kuaishou.perpare;

import java.util.Arrays;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-12 10:52
 */
public class T1405 {

    // 最长快乐字符串 wtf?
    public String longestDiverseString(int a, int b, int c) {
        MyChar[] myChars = new MyChar[]{
                new MyChar('a', a),
                new MyChar('b', b),
                new MyChar('c', c),
        };
        StringBuilder sb = new StringBuilder();

        while (true) {
            Arrays.sort(myChars);
            // 先放最多的, 如果上个放的2个字符串和剩余个数最多的字符相同，则放置其他字符中次多的

            if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == myChars[2].ch &&
                    sb.charAt(sb.length() - 2) == myChars[2].ch) {
                if (myChars[1].count-- > 0) {
                    sb.append(myChars[1].ch);
                } else {
                    break;
                }

            } else {
                if (myChars[2].count-- > 0) {
                    sb.append(myChars[2].ch);
                } else {
                    break;
                }
            }

        }

        return sb.toString();
    }

    private class MyChar implements Comparable {
        char ch;
        int count;

        public MyChar(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }

        @Override
        public int compareTo(Object o) {
            MyChar other = (MyChar) o;
            return this.count - other.count;
        }
    }
}
