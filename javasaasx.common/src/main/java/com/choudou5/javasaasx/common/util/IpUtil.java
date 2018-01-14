package com.choudou5.javasaasx.common.util;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpUtil {

	/** 
     * 获取当前网络ip 
     * @param request 
     * @return 
     */  
    public static String getIpAddr(HttpServletRequest request){  
        String ipAddress = request.getHeader("x-forwarded-for");  
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
            ipAddress = request.getHeader("Proxy-Client-IP");  
        }  
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
            ipAddress = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
            ipAddress = request.getRemoteAddr();  
            if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){  
                //根据网卡取本机配置的IP  
                InetAddress inet=null;  
                try {  
                    inet = InetAddress.getLocalHost();  
                } catch (UnknownHostException e) {  
                    e.printStackTrace();  
                }  
                ipAddress= inet.getHostAddress();  
            }  
        }  
        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割  
        if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15  
            if(ipAddress.indexOf(",")>0){  
                ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));  
            }  
        }  
        return ipAddress;   
    }
    
    /** 
     * 获取本机的IP 
     * @return Ip地址 
     */ 
     public static String getLocalHostIP() { 
          String ip; 
          try { 
               InetAddress addr = InetAddress.getLocalHost();
               ip = addr.getHostAddress();  
          } catch(Exception ex) {
              ip = ""; 
          } 
            
          return ip; 
     }
     
     /** 
      * 获取 服务器端口 
      * @param request 
      * @return 
      */  
     public static int getLocalPort(HttpServletRequest request){  
         return request.getLocalPort();
     }
     
     /** 
      * 或者主机名： 
      * @return 
      */ 
     public static String getLocalHostName() { 
          String hostName; 
          try { 
               InetAddress addr = InetAddress.getLocalHost(); 
               /**获取此 IP 地址的主机名。*/ 
               hostName = addr.getHostName(); 
          }catch(Exception ex){ 
              hostName = ""; 
          } 
          return hostName; 
     } 
     
     /** 
      * 获得本地所有的IP地址 
      * @return 
      */ 
     public static String[] getAllLocalHostIP() { 
         String[] ret = null; 
          try { 
               String hostName = getLocalHostName(); 
               if(hostName.length()>0) { 
                   /**在给定主机名的情况下，根据系统上配置的名称服务返回其 IP 地址所组成的数组。*/ 
                    InetAddress[] addrs = InetAddress.getAllByName(hostName); 
                    if(addrs.length>0) { 
                         ret = new String[addrs.length]; 
                         for(int i=0 ; i< addrs.length ; i++) { 
                             /**.getHostAddress()   返回 IP 地址字符串（以文本表现形式）。*/ 
                             ret[i] = addrs[i].getHostAddress(); 
                         } 
                    } 
               } 
          }catch(Exception ex) { 
              ret = null; 
          } 
          return ret; 
     } 
     
     public static void main(String[] args) throws Exception { 
         System.out.println("本机IP：" + getLocalHostIP()); 
         System.out.println("本地主机名字为：" + getLocalHostName()); 
         String[] localIP = getAllLocalHostIP(); 
         for (int i = 0; i < localIP.length; i++) { 
             System.out.println(localIP[i]); 
         } 
          
         InetAddress baidu = InetAddress.getByName("www.baidu.com");
         System.out.println("baidu : " + baidu);
         System.out.println("baidu IP: " + baidu.getHostAddress());
         System.out.println("baidu HostName: " + baidu.getHostName());
     } 
     
     
}
