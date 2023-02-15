package io.github.jihch.boot;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class getProperties {

    public static void main(String[] args) throws IOException {

        Properties pps = new Properties();
        pps.load(new FileInputStream("a.properties"));
        Enumeration<?> enumeration = pps.propertyNames(); //得到配置文件的名字
        while (enumeration.hasMoreElements()) {
            String strKey = (String) enumeration.nextElement();
            String strValue = pps.getProperty(strKey);
            System.out.println(strKey + "=" + strValue);
            /**
             * 封装到 Java Bean
             * ……
             */

        }

    }

}
