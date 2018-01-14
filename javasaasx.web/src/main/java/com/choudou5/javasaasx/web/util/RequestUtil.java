package com.choudou5.javasaasx.web.util;

import com.xiaoleilu.hutool.date.DateUtil;
import com.xiaoleilu.hutool.util.ArrayUtil;
import com.xiaoleilu.hutool.util.CollectionUtil;
import com.xiaoleilu.hutool.util.StrUtil;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

/**
 * @Name：请求工具类
 * @Author：xuhaowende@sina.cn
 * @Date：2018-01-14
 * @Site：http://solrhome.com
 * @License：MIT
 * @Copyright：xuhaowende@sina.cn (@Copyright 2018-2020)
 */
public class RequestUtil {

    public static Short getShortParameter(HttpServletRequest request, String paramName) {
        String id = request.getParameter(paramName);
        if (StrUtil.isNotBlank(id)) {
            try {
                return new Short(id);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public static Integer getIntParameter(HttpServletRequest request, String paramName) {
        return getIntParameter(request, paramName, null);
    }

    public static Integer getIntParameter(HttpServletRequest request, String paramName, Integer defVal) {
        String id = request.getParameter(paramName);
        if (StrUtil.isNotBlank(id)) {
            try {
                return new Integer(id);
            } catch (Exception e) {
                return defVal;
            }
        }
        return defVal;
    }


    public static List<Integer> getIntParameterList(HttpServletRequest request, String paramName) {
        List<Integer> list = new ArrayList<Integer>(5);
        String[] strInts = request.getParameterValues(paramName + "[]");
        if(ArrayUtil.isNotEmpty(strInts)){
            for(String strInt:strInts){
                list.add(Integer.valueOf(strInt));
            }
        }
        return list;
    }


    public static BigDecimal getBigDecimalParameter(HttpServletRequest request, String paramName) {
        String id = request.getParameter(paramName);
        if (StrUtil.isNotBlank(id)) {
            try {
                return new BigDecimal(id);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }


    public static Date getDateParameter(HttpServletRequest request, String paramName) {
        String dateString = request.getParameter(paramName);
        if (StrUtil.isNotEmpty(dateString)) {
            try {
                return DateUtil.parseDate(dateString);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public static boolean getBooleanParameter(HttpServletRequest request,String paramName){
        String paramValue = request.getParameter(paramName);
        try{
            if(StrUtil.isNotEmpty(paramValue)){
                if(paramValue.equalsIgnoreCase("true") || paramValue.equalsIgnoreCase("Y") || paramValue.equalsIgnoreCase("1")){
                    return true;
                }
            }
        }catch (Exception e) {
        }
        return false;
    }
    /**
     * 获取 Boolean 参数
     * @param request
     * @param paramName
     * @param defVal
     * @return
     */
    public static Boolean getBoolParameter(HttpServletRequest request,String paramName, Boolean defVal){
        String paramValue = request.getParameter(paramName);
        try{
            return Boolean.valueOf(paramValue);
        }catch (Exception e) {
            return defVal;
        }
    }


    public static String getStrParameter(HttpServletRequest request, String paramName) {
        return getStrParameter(request, paramName, null);
    }

    public static String getStrParameter(HttpServletRequest request, String paramName, String defaultValue) {
        String ret = request.getParameter(paramName);
        if(StrUtil.isEmpty(ret))
            return defaultValue;
        return ret;
    }

    public static String[] getStrParameters(HttpServletRequest request, String paramName) {
        String[] strValues = request.getParameterValues(paramName + "[]");
        if(strValues == null)
            strValues = request.getParameterValues(paramName);
        if(strValues == null)
            strValues = new String[]{};
        return strValues;
    }

    public static List<String> getStrParameterList(HttpServletRequest request, String paramName) {
        List<String> list = new ArrayList<String>(5);
        String[] strs = request.getParameterValues(paramName + "[]");
        if(ArrayUtil.isNotEmpty(strs)){
            for(String id:strs){
                list.add(id);
            }
        }
        return list;
    }

    public static List<String> getStrParameterList(HttpServletRequest request, String paramName, String separator) {
        List<String> list = new ArrayList<String>(5);
        String str = getStrParameter(request, paramName);
        if(StrUtil.isBlank(str))
            return list;
        String[] strs = str.split(separator);
        if(ArrayUtil.isNotEmpty(strs)){
            for(String id:strs){
                list.add(id);
            }
        }
        return list;
    }


    public static Long getLongParameter(HttpServletRequest request,String paramName){
        String paramValue = request.getParameter(paramName);
        try{
            return Long.valueOf(paramValue);
        }catch (Exception e) {
            return null;
        }
    }

    public static List<Long> getLongParameterList(HttpServletRequest request, String paramName, String separator) {
        List<Long> list = new ArrayList<Long>(5);
        String str = getStrParameter(request, paramName);
        if(StrUtil.isBlank(str))
            return list;
        String[] strLongs = str.split(separator);
        if(ArrayUtil.isNotEmpty(strLongs)){
            for(String strLong:strLongs){
                list.add(Long.valueOf(strLong));
            }
        }
        return list;
    }

    public static List<Long> getLongParameterList(HttpServletRequest request, String paramName) {
        List<Long> list = new ArrayList<Long>(5);
        Map map = request.getParameterMap();
        String[] strs = request.getParameterValues(paramName+"[]");
        if(ArrayUtil.isEmpty(strs))
            strs = request.getParameterValues(paramName);
        if(ArrayUtil.isNotEmpty(strs)){
            for(String id : strs){
                list.add(Long.valueOf(id));
            }
        }
        return list;
    }

    public static Date getParameterDateTime(HttpServletRequest request, String paramName) {
        try{
            String ret = getStrParameter(request, paramName, null);
            if (ret == null) {
                return null;
            }
            return DateUtil.parse(ret, "yyyy-MM-dd HH:mm:ss");
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static Map<String,Object> getMapRequest(final HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        for(Iterator<String> it = request.getParameterMap().keySet().iterator();it.hasNext();){
            String key = it.next();
            String[] values = request.getParameterValues(key);
            if (values != null) {
                if (values.length == 1) {
                    params.put(key, values[0]);
                } else {
                    params.put(key, values);
                }
            }
        }
        return Collections.unmodifiableMap(params);
    }

    /**
     * 获得 上传文件列表
     * @param request
     * @return
     * @throws Exception
     */
    public static List<MultipartFile> getUploadFiles(HttpServletRequest request) throws Exception{
        return getUploadFiles(request, false);
    }

    /**
     * 获得 上传文件
     * @param request
     * @return
     * @throws Exception
     */
    public static MultipartFile getUploadFile(HttpServletRequest request) throws Exception{
        List<MultipartFile> list = getUploadFiles(request, true);
        return CollectionUtil.isNotEmpty(list)?list.get(0):null;
    }

    /**
     * 获得 上传文件
     * @param request
     * @param single 是否单个
     * @return
     * @throws Exception
     */
    private static List<MultipartFile> getUploadFiles(HttpServletRequest request, boolean single) throws Exception{
        if (!(request instanceof MultipartHttpServletRequest)) {
            throw new Exception("Request is not a MultipartHttpServletRequest");
        }
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
        List<MultipartFile> result = new ArrayList<MultipartFile>();
        //获得文件
        for (Iterator<String> it = multipartRequest.getFileNames(); it.hasNext();) {
            String key = it.next();
            result.add(multipartRequest.getFile(key));
            if(single)
                break;
        }
        if (CollectionUtil.isEmpty(result)) {
            throw new Exception("没有上传文件！");
        }
        return result;
    }

}
