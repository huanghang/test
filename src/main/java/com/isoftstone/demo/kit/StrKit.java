package com.isoftstone.demo.kit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrKit {

    /**
     * 首字母变小写
     */
    public static String firstCharToLowerCase(String str) {
        char firstChar = str.charAt(0);
        if (firstChar >= 'A' && firstChar <= 'Z') {
            char[] arr = str.toCharArray();
            arr[0] += ('a' - 'A');
            return new String(arr);
        }
        return str;
    }

    /**
     * 首字母变大写
     */
    public static String firstCharToUpperCase(String str) {
        char firstChar = str.charAt(0);
        if (firstChar >= 'a' && firstChar <= 'z') {
            char[] arr = str.toCharArray();
            arr[0] -= ('a' - 'A');
            return new String(arr);
        }
        return str;
    }

    /**
     * 字符串为 null 或者内部字符全部为 ' ' '\t' '\n' '\r' 这四类字符时返回 true
     */
    public static boolean isBlank(String str) {
        if (str == null) {
            return true;
        }
        int len = str.length();
        if (len == 0) {
            return true;
        }
        for (int i = 0; i < len; i++) {
            switch (str.charAt(i)) {
                case ' ':
                case '\t':
                case '\n':
                case '\r':
                    // case '\b':
                    // case '\f':
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    public static boolean notBlank(String str) {
        return !isBlank(str);
    }

    public static boolean notBlank(String... strings) {
        if (strings == null || strings.length == 0) {
            return false;
        }
        for (String str : strings) {
            if (isBlank(str)) {
                return false;
            }
        }
        return true;
    }

    public static boolean notNull(Object... paras) {
        if (paras == null) {
            return false;
        }
        for (Object obj : paras) {
            if (obj == null) {
                return false;
            }
        }
        return true;
    }

    public static String toCamelCase(String stringWithUnderline) {
        if (stringWithUnderline.indexOf('_') == -1) {
            return stringWithUnderline;
        }

        stringWithUnderline = stringWithUnderline.toLowerCase();
        char[] fromArray = stringWithUnderline.toCharArray();
        char[] toArray = new char[fromArray.length];
        int j = 0;
        for (int i = 0; i < fromArray.length; i++) {
            if (fromArray[i] == '_') {
                // 当前字符为下划线时，将指针后移一位，将紧随下划线后面一个字符转成大写并存放
                i++;
                if (i < fromArray.length) {
                    toArray[j++] = Character.toUpperCase(fromArray[i]);
                }
            } else {
                toArray[j++] = fromArray[i];
            }
        }
        return new String(toArray, 0, j);
    }

    public static String join(String[] stringArray) {
        StringBuilder sb = new StringBuilder();
        for (String s : stringArray) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static String join(String[] stringArray, String separator) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stringArray.length; i++) {
            if (i > 0) {
                sb.append(separator);
            }
            sb.append(stringArray[i]);
        }
        return sb.toString();
    }

    public static boolean slowEquals(String a, String b) {
        byte[] aBytes = (a != null ? a.getBytes() : null);
        byte[] bBytes = (b != null ? b.getBytes() : null);
        return HashKit.slowEquals(aBytes, bBytes);
    }

    public static boolean equals(String a, String b) {
        return a == null ? b == null : a.equals(b);
    }

    public static String getRandomUUID() {
        return java.util.UUID.randomUUID().toString().replace("-", "");
    }


    public static final Pattern UPPER_CASE = Pattern.compile("[A-Z]");

    /* START */
    public static String toUnderlineCase(String methodName) {
        if (methodName.equals(methodName.toLowerCase())) {
            return methodName;
        }

        StringBuffer sb = new StringBuffer();

        Matcher m = UPPER_CASE.matcher(methodName);

        while (m.find()) {
            m.appendReplacement(sb, "_".concat(m.group().toLowerCase()));
        }

        m.appendTail(sb);

        return sb.toString();
    }

    public static String getRandomUUID8() {
        return getRandomUUID8(getRandomUUID());
    }

    private static final String[] CHARS = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6",
            "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
            "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public static String getRandomUUID8(final String uuid) {
        if (uuid == null || uuid.length() != 32) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            final String str = uuid.substring(i * 4, (i * 4) + 4);
            final int x = Integer.parseInt(str, 16);
            sb.append(CHARS[x % 0x3E]);
        }
        return sb.toString();
    }


    /**
     * 产生随机密码
     *
     * @return 8位字母4位数字的随机密码
     */
    public static String createPassWord() {
        double temp = Math.random() * 100000;
        //如果数据等于100000，则减少1
        if (temp >= 100000) {
            temp = 99999;
        }
        int tempint = (int) Math.ceil(temp);
        Random rd = new Random(tempint);
        final int maxNum = 62;
        StringBuilder sb = new StringBuilder();
        int rdGet;//取得随机数
        char[] str = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
                'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
                'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
                'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
                'X', 'Y', 'Z'};
        char[] num = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int count = 0;
        while (count < 8) {
            rdGet = Math.abs(rd.nextInt(maxNum));
            if (rdGet >= 0 && rdGet < str.length) {
                sb.append(str[rdGet]);
                count++;
            }
        }
        int c = 0;
        while (c < 4) {
            rdGet = Math.abs(rd.nextInt(maxNum));
            if (rdGet >= 0 && rdGet < num.length) {
                sb.append(num[rdGet]);
                c++;
            }
        }
        return sb.toString();
    }


    /**
     * 取A和B两个字符串的并集
     *
     * @param a 字符串1
     * @param b 字符串2
     * @return 两个字符串的并集
     */
    public static String intersection(String a, String b, String separator) {
        if (StrKit.isBlank(a) || StrKit.isBlank(b)) {
            return "";
        } else if (a.equals(b)) {
            return a;
        } else {
            String[] as = a.split(separator);
            List<String> bl = Arrays.asList(b.split(separator));
            List<String> ret = new ArrayList<>();
            for (String ai : as) {
                if (bl.contains(ai)) {
                    ret.add(ai);
                }
            }

            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for (String r : ret) {
                if (first) {
                    first = false;
                } else {
                    sb.append(separator);
                }
                sb.append(r);
            }

            return sb.toString();
        }
    }

}





