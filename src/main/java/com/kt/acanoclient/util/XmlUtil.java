package com.kt.acanoclient.util;

import org.dom4j.Node;

/**
 * Created by Vega on 2017/8/16.
 */
public class XmlUtil {
    public static String readTextValue(Node node) {
        if (node == null) {
            return null;
        } else {
            return node.getText();
        }
    }

    public static Integer readIntValue(Node node) {
        return transformToInt(readTextValue(node));
    }

    public static Long readLongValue(Node node) {
        return transformToLong(readTextValue(node));
    }

    public static Double readDoubleValue(Node node) {
        return transformToDouble(readTextValue(node));
    }

    public static Boolean readBooleanValue(Node node) {
        return transformToBoolean(readTextValue(node));
    }

    private static Integer transformToInt(String v) {
        if (v != null) {
            try {
                return Integer.valueOf(v);
            } catch (NumberFormatException e) {
                return 0;
            }
        } else {
            return 0;
        }
    }


    private static Long transformToLong(String v) {
        if (v != null) {
            try {
                return Long.valueOf(v);
            } catch (NumberFormatException e) {
                return 0L;
            }
        } else {
            return 0L;
        }
    }


    private static Double transformToDouble(String v) {
        if (v != null) {
            try {
                return Double.valueOf(v);
            } catch (NumberFormatException e) {
                return (double) 0;
            }
        } else {
            return (double) 0;
        }
    }

    private static boolean transformToBoolean(String v) {
        return Boolean.valueOf(v);
    }
}
