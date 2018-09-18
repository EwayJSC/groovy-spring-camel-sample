package com.eway.common.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by Tu Pham Phuong on 2/7/15.
 */
public class ExceptionUtil {
    public static String toString(Exception e) {
        String result;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);

            StringBuilder builder = new StringBuilder(e.toString());
            builder.append("\n");
            builder.append(sw.toString());

            result = builder.toString();
        } catch (Exception ex) {
            result = "";
        }
        return result;
    }
}
