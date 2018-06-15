package com.example;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 获取ip接口
 *
 * @author micah.shi
 */
public final class IpUtil {
	/**
	 * 根据请求,获取用户真实ip, 如果请求包涵了ipv6的,该方法不能使用
	 *
	 * @param request 请求
	 * @return 用户真实ip
	 */
	public static String getRemoteIp(HttpServletRequest request) {

		String ipAddress = request.getHeader("X-Real-IP");
		if (ipAddress == null || ipAddress.isEmpty()) {
			ipAddress = request.getHeader("X-Cluster-Client-Ip");
		}
		if (ipAddress == null || ipAddress.isEmpty()) {
			ipAddress = request.getHeader("X-Forwarded-For");
		}
		if (ipAddress == null || ipAddress.isEmpty()) {
			ipAddress = request.getRemoteAddr();
		}
		if (ipAddress != null && !ipAddress.isEmpty()) {
			int index = ipAddress.indexOf(":");
			if (index > 0) {
				ipAddress = ipAddress.substring(0, index);
			}
		}
		return ipAddress;
	}

	private static int str2Ip(String ip) {
		String[] ss = ip.split("\\.");
		int a, b, c, d;
		a = Integer.parseInt(ss[0]);
		b = Integer.parseInt(ss[1]);
		c = Integer.parseInt(ss[2]);
		d = Integer.parseInt(ss[3]);
        System.out.println("a=" + a + "----b=" + b + "----c=" + c + "----d=" + d);
        return (a << 24) | (b << 16) | (c << 8) | d;
	}

	private static long int2long(int ipInt) {
		System.out.println(ipInt);
		long l = ipInt & 0x7fffffffL;
		if (ipInt < 0) {
			l |= 0x080000000L;
		}
		return l;
	}

	public static long ip2long(String ip) {
		try {
			return int2long(str2Ip(ip));
		} catch (Exception e) {
			return -1;
		}
	}

	/**
	 * 获得发起请求的客户端IP列表信息
	 *
	 * @param request 请求
	 * @return 客户端IP信息
	 */
	public static List<String> getRemoteIpList(HttpServletRequest request) {
		List<String> ipList = new ArrayList<>();
		String proxyIp = request.getHeader("X-Forwarded-For");
		if (proxyIp != null && !proxyIp.isEmpty()) {
			String[] ipParts = proxyIp.split(",");
			for (String ip : ipParts) {
				ip = formatIp(ip.trim());
				if (!ip.isEmpty() && !isValidIp(ip)) {
					ipList.add(ip);
				}
			}
		} else {
			ipList.add(getRemoteIp(request));
		}
		return ipList;
	}

	private static String formatIp(String ip) {
		if (ip.indexOf(":") > 0) {
			return ip.substring(0, ip.indexOf(":"));
		} else {
			return ip;
		}
	}

	/**
	 * 判断是否为可信任ip
	 *
	 * @return 是否成功
	 */
	private static boolean isValidIp(String ip) {
		return ip.startsWith("10.") || ip.startsWith("180.97.165.") ||
				ip.startsWith("180.97.166.") || ip.startsWith("180.97.88.") ||
				ip.startsWith("116.211.163.") || ip.startsWith("116.211.164.") ||
				ip.startsWith("116.211.165.") || ip.startsWith("218.60.116.") ||
				ip.startsWith("218.60.117.") || ip.startsWith("218.60.120.") ||
				ip.startsWith("218.11.4.") || ip.startsWith("121.29.52.") ||
				ip.startsWith("121.29.53.") || ip.startsWith("120.55.146.") ||
				ip.startsWith("120.55.147.") || ip.startsWith("120.55.177.") ||
				ip.startsWith("120.27.173.") || ip.startsWith("118.178.15.") ||
				ip.startsWith("14.1.112.") || ip.startsWith("14.1.113.") ||
				ip.startsWith("14.1.114.") || ip.startsWith("47.88.196.") ||
				ip.startsWith("47.88.197.") || ip.startsWith("47.89.1.");
	}

	public static void main(String [] args) throws Exception {
		System.out.println(IpUtil.ip2long("192.168.50.60"));
	}
}
