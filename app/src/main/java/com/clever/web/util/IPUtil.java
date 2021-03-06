package com.clever.web.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * User: zhongjiaren
 * Date: 2013-5-17
 * Time: 20:46:20
 * To change this template use File | Settings | File Templates.
 */
public class IPUtil {
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
        	ip = request.getHeader("x-forwarded-for");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
        	ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
        	ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        //防止多级代理时返回过个ip。
        if(ip != null && ip.indexOf(",") != -1){
            ip= ip.substring(0,ip.indexOf(","));
        }
        return ip;
    }
    
    public static String getCookie(HttpServletRequest request){
		String cname = "ttu";
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for (Cookie c : cookies) {
				if (c.getName().equals(cname)) {
					return c.getValue();
				}
			}
		}
		
		return null;
	}
}
