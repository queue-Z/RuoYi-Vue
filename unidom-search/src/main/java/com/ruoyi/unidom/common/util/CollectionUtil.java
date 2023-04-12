package com.ruoyi.unidom.common.util;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public final class CollectionUtil {
    private CollectionUtil() {
    }

    public static boolean isEmpty(Collection<?> collection) {
        return null == collection ? true : collection.isEmpty();
    }

    public static boolean isEmpty(Object[] objects) {
        return objects == null || objects.length == 0;
    }

//    public static List<?> arrayToList(Object[] arr) {
//        List<?> list = new ArrayList();
//        if (arr == null) {
//            return list;
//        } else {
//            List<?> list = Arrays.asList(arr);
//            return list;
//        }
//    }

    public static String toSplitString(Collection<?> collections, String separator) {
        if (isEmpty(collections)) {
            return null;
        } else {
            Object[] array = collections.toArray(new Object[collections.size()]);
            int length = array.length;
            StringBuilder stringBuilder = new StringBuilder();

            for(int i = 0; i < length; ++i) {
                stringBuilder.append(array[i]);
                if (i != length - 1) {
                    stringBuilder.append(separator);
                }
            }

            return stringBuilder.toString();
        }
    }
}
