package com.tiger.utils.tools;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


/**
 * 工具类，根据手机号码定位手机归属地
 * <p/>
 * <p><b>User:</b> charles.wang <a href="mailto:charles.wang0@pactera.com">charles.wang0@pactera.com</a></p>
 * <p><b>Date:</b> 2015-01-06 </p>
 *
 * @author charles.wang
 */
public class MobileUtil {

    private MobileUtil() {
    }

    /**
     * 通过手机号码来定位号码归属地
     * 
     * @param mobileNo 输入手机号码
     * @return   归属地
     */
    public static String locateAttributionByMobileNo(String mobileNo) {

        String mobileServiceURL = "http://webservice.webxml.com.cn/WebServices/MobileCodeWS.asmx/getMobileCodeInfo";
        StringBuilder sbRequestURL = new StringBuilder(mobileServiceURL);
        sbRequestURL.append("?").append("mobileCode=").append(mobileNo);
        sbRequestURL.append("&").append("userID=");
        String requestURL = sbRequestURL.toString();
        URL url = null;
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            url = new URL(requestURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(2000);
            connection.setReadTimeout(2000);
            connection.connect();

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String lines;
            StringBuilder sb = new StringBuilder();
            while ((lines = reader.readLine()) != null) {
                sb.append(lines);
            }
            reader.close();
            String result = sb.toString();

            SAXReader sax = new SAXReader();
            Document doc = sax.read(new ByteArrayInputStream(result.getBytes("UTF-8")));
            Element root = doc.getRootElement();
            return root.getText();

        } catch (MalformedURLException ex) {
            ex.printStackTrace();
            return null;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        } catch (DocumentException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            if(connection !=null){
                connection.disconnect();
            }

        }

    }

}
