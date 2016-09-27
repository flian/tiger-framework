package com.pharmacodia.dg.utils.tools;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.cxf.message.Message;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.apache.log4j.Logger;

/**
 * 工具类：获取远程和本地IP地址
 * <p/>
 * <p><b>User:</b> charles.wang <a href="mailto:charles.wang0@pactera.com">charles.wang0@pactera.com</a></p>
 * <p><b>Date:</b> 2015-01-06 </p>
 *
 * @author charles.wang
 */

public class IpAddressUtil {
	private static HttpServletRequest httpServletRequest;
	private static final Logger LOGGER = Logger.getLogger(IpAddressUtil.class);
	private static String localIp = "";
	
	static {
	    try {
            localIp = getRealIp();
        } catch (SocketException e) {
            localIp = "";
        }
	}


	private static void getHttpServletRequest() {
		Message message = PhaseInterceptorChain.getCurrentMessage();
		HttpServletRequest httprequest = (HttpServletRequest) message
				.get(AbstractHTTPDestination.HTTP_REQUEST);
		httpServletRequest = httprequest;
	}

	/**
	 * get remote Ip by request
	 * 
	 * @param request
	 * @return
	 */
	public static String getRemoteIp(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip != null && ip.indexOf(",") > 0) {
			String[] arr = ip.split(",");
			ip = arr[arr.length - 1].trim();// 有多个ip时取最后一个ip
		}
		return ip;
	}
	/**
	 * cxf直接获取client IP
	 * @return
	 */
	public static String getRemoteIp() {
		String remoteIp = null;
		try {
			getHttpServletRequest();
			remoteIp = getRemoteIp(httpServletRequest);
		} catch (Exception e) {
			LOGGER.warn("retrieveClientIPFailure");
			remoteIp = null;
		}
		return remoteIp;
	}

	/**
	 * get local IP
	 * 
	 * @return
	 */
	public static String getLocalIp() {
		return localIp;
	}
	
	/**
	 * Get the real ip address
	 * @return
	 * @throws SocketException
	 */
    public static String getRealIp() throws SocketException {
        String localip = null;// 本地IP，如果没有配置外网IP则返回它
        String netip = null;// 外网IP
 
        Enumeration<NetworkInterface> netInterfaces =
            NetworkInterface.getNetworkInterfaces();
        InetAddress ip = null;
        boolean finded = false;// 是否找到外网IP
        while (netInterfaces.hasMoreElements() && !finded) {
            NetworkInterface ni = netInterfaces.nextElement();
            Enumeration<InetAddress> address = ni.getInetAddresses();
            while (address.hasMoreElements()) {
                ip = address.nextElement();
                if (!ip.isSiteLocalAddress()
                        && !ip.isLoopbackAddress()
                        && ip.getHostAddress().indexOf(":") == -1) {// 外网IP
                    netip = ip.getHostAddress();
                    finded = true;
                    break;
                } else if (ip.isSiteLocalAddress()
                        && !ip.isLoopbackAddress()
                        && ip.getHostAddress().indexOf(":") == -1) {// 内网IP
                    localip = ip.getHostAddress();
                    break;
                }
            }
        }
     
        if (netip != null && !"".equals(netip)) {
            return netip;
        } else {
            return localip;
        }
    }
}
