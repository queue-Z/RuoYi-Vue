package com.ruoyi.unidom.util;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.nio.charset.StandardCharsets;
import java.util.concurrent.ThreadLocalRandom;

public final class StringUtil {
    private StringUtil() {
    }

    public static boolean isBlank(String str) {
        return null == str ? true : "".equals(str.trim());
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static String toString(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    public static String setUpperCaseForFirstLetter(String name) {
        if (name.length() == 1) {
            return name.toUpperCase();
        } else {
            String firstLetter = name.substring(0, 1);
            String others = name.substring(1, name.length());
            return firstLetter.toUpperCase() + others;
        }
    }

    public static String toFirstWordUpperCase(String key) {
        if (null == key) {
            return null;
        } else {
            if ("".equals(key.trim())) {
                key = "";
            } else if (key.length() == 1) {
                key = key.toUpperCase();
            } else {
                key = key.substring(0, 1).toUpperCase() + key.substring(1, key.length());
            }

            return key;
        }
    }

    public static String getVarName(String bofieldName) {
        if (null == bofieldName) {
            return null;
        } else {
            bofieldName = bofieldName.toLowerCase();
            char[] objchars = bofieldName.toCharArray();

            for(int j = 0; j < objchars.length; ++j) {
                if (objchars[j] == '_' && j != objchars.length - 1) {
                    objchars[j + 1] = Character.toUpperCase(objchars[j + 1]);
                }

                if (j == 0) {
                    objchars[j] = Character.toLowerCase(objchars[j]);
                }
            }

            String str = String.valueOf(objchars);
            str = str.replaceAll("_", "");
            return str;
        }
    }

//    public static String trim(String strSrc, int iMaxLength) {
//        if (strSrc == null) {
//            return null;
//        } else if (iMaxLength <= 0) {
//            return strSrc;
//        } else {
//            String strResult = strSrc;
//            byte[] b = null;
//            int iLength = strSrc.length();
//            if (iLength > iMaxLength) {
//                strResult = strSrc.substring(0, iMaxLength);
//                iLength = iMaxLength;
//            }
//
//            while(true) {
//                byte[] b = strResult.getBytes();
//                if (b.length <= iMaxLength) {
//                    return strResult;
//                }
//
//                --iLength;
//                strResult = strResult.substring(0, iLength);
//            }
//        }
//    }

    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int n = str.length();
        StringBuilder buf = new StringBuilder();

        for(int i = 0; i < length; ++i) {
            buf.append(str.charAt(ThreadLocalRandom.current().nextInt(n)));
        }

        return buf.toString();
    }

    public static String getRandomCode(int length) {
        String str = "ABCDEFGHJKLMNPQRSTUVWXYZ123456789";
        int n = str.length();
        StringBuilder buf = new StringBuilder();

        for(int i = 0; i < length; ++i) {
            buf.append(str.charAt(ThreadLocalRandom.current().nextInt(n)));
        }

        return buf.toString();
    }

    public static String lPad(String target, String fix, int length) {
        if (target != null && fix != null && target.length() < length) {
            StringBuilder newStr = new StringBuilder();

            for(int i = 0; i < length - target.length(); ++i) {
                newStr.append(fix);
            }

            return newStr.append(target).toString();
        } else {
            return target;
        }
    }

    public static String rPad(String target, String fix, int length) {
        if (target != null && fix != null && target.length() < length) {
            StringBuilder newStr = new StringBuilder();
            newStr.append(target);

            for(int i = 0; i < length - target.length(); ++i) {
                newStr.append(fix);
            }

            return newStr.toString();
        } else {
            return target;
        }
    }

    public static String join(String[] strs, String spi) {
        StringBuilder buf = new StringBuilder();
        int step = 0;
        String[] var4 = strs;
        int var5 = strs.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            String str = var4[var6];
            buf.append(str);
            if (step++ < strs.length - 1) {
                buf.append(spi);
            }
        }

        return buf.toString();
    }

    public static String replaceServiceNumBar(String str) {
        return isBlank(str) ? null : str.replaceAll("\\-", "");
    }

    public static int getByteLength(String str) {
        try {
            byte[] b = str.getBytes(StandardCharsets.UTF_8);
            return b.length;
        } catch (Exception var2) {
            return 0;
        }
    }
}
