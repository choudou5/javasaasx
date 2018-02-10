package com.choudou5.javasaasx.common.util;

import com.choudou5.base.mapper.BeanMapper;
import com.choudou5.javasaasx.framework.bean.BasePo;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 查询构建器
 * @author xuhaowende
 * @date 2017年4月22日
 */
public class QueryBuilder {

	/**
	 * 查询字段 前缀<br>
	 * 查询类型：EQ=等于， NEQ=不等于，RG=范围，EGT=大于等于，ELT=小于等于
	 */
	private static final String Q_F_PREFIX = "QF__"; //格式：QF__{查询类型}__{数据类型}__{字段名}
	/** 排序 前缀*/
	private static final String SORT_PREFIX = "SORT__"; //格式：SORT__{字段名}
	
	//分页
	private static final int MAX_PAGE_SIZE = 100;
	
	
	/**
	 * 构建查询
	 * @param req
	 * @return
	 */
	public static <T extends BasePo> T buildQuery(HttpServletRequest req, Class<T> clasz){
		Map query = new LinkedHashMap();
		//构建 分页
		buildQueryPaging(req, query);
    	//构建 查询参数
		buildQueryParam(req, query);
		return BeanMapper.map(query, clasz);
//		return query;
	}

	
	//构建查询分页
	private static void buildQueryPaging(HttpServletRequest req, Map query){
		String pageNoStr = req.getParameter("pageNo");
		String pageSizeStr = req.getParameter("pageSize");
		int pageNo = StringUtils.isBlank(pageNoStr)?1:Integer.parseInt(pageNoStr);
		int pageSize = StringUtils.isBlank(pageSizeStr)?10:Integer.parseInt(pageSizeStr);
		if(pageSize > MAX_PAGE_SIZE)
			pageSize = 20;

		query.put("pageNo", pageNo);
		query.put("pageSize", pageSize);
		req.setAttribute("pageNo", pageNo);
		req.setAttribute("pageSize", pageSize);
	}
	
	//构建查询参数
	@SuppressWarnings("unchecked")
	private static void buildQueryParam(HttpServletRequest req, Map query){
		Enumeration<String> paramNames = req.getParameterNames();
		Map<String, String> searchParamMap = new HashMap<String, String>();
		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			String paramVal = req.getParameter(paramName);
			searchParamMap.put(paramName, paramVal);
			if(StringUtils.isNotBlank(paramVal)){
				//查询字段
				if(paramName.startsWith(Q_F_PREFIX)){
					addParam(paramName, paramVal, query);
				}
			}//排序
			else if(paramName.startsWith(SORT_PREFIX)){
//				query.addSort(getSortField(paramName), getSortOrder(paramVal));
			}
		}
		req.setAttribute("searchParamMap", searchParamMap);
	}

	private static String getSortField(String paramName){
		//格式：SORT__{字段名}
		String[] paramArr = paramName.split("__"); 
		if(paramArr.length == 2){
			return paramArr[1];
		}
		return "";
	}

	//获得参数
	private static void addParam(String paramName, Object paramVal, Map query){
		//格式：QF__{查询类型}__{数据类型}__{字段名}
		String[] paramArr = paramName.split("__"); 
		if(paramArr.length == 4){
			String qType = paramArr[1];
			String dType = paramArr[2];
			String qField = paramArr[3];
			
			//等于
			if("EQ".equals(qType)){
				query.put(qField, packParamVal(dType, paramVal));
			}
//			//不等于
//			if("NEQ".equals(qType)){
//				return qField+":"+packParamVal(dType, paramVal);
//			}
//			//范围
//			if("RG".equals(qType)){
//				String[] vals = paramVal.toString().split(",");
//				if(vals.length == 2){
//					return qField+":["+packParamVal(dType, vals[0])+" TO "+packParamVal(dType, vals[1])+"]";
//				}
//				return "";
//			}
//			//大于等于
//			if("EGT".equals(qType)){
//				return qField+":["+packParamVal(dType, paramVal)+" TO *]";
//			}
//			//小于等于
//			if("ELT".equals(qType)){
//				return qField+":[* TO "+packParamVal(dType, paramVal)+"]";
//			}
		}
	}
	
	/**
	 * 包装数据
	 * @param dataType
	 * @param paramVal
	 * @return
	 */
	private static String packParamVal(String dataType, Object paramVal){
		if("date".equals(dataType)){
			return "\""+formatSolrDate(paramVal)+"\"";
		}else{
			return paramVal.toString();
		}
	}
	
	/**
	 * 格式化 成solr格式时间
	 * @param paramVal
	 * @return
	 */
	public static String formatSolrDate(Object paramVal){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		try {
			return sdf.format(sdf.parse(paramVal.toString()));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	/**
	 * 构建查询语句
	 * @param isExcludeMode 是否排除
	 * @param isAndCond 是否是 并且(AND)条件, 否则是 OR 条件
	 * @param params
	 * @return  String
	 * @exception 
	 * @since  1.0.0
	 */
	public static String builderQueryStatements(boolean isExcludeMode, boolean isAndCond, Map<String, Object> params){
		StringBuilder builder = new StringBuilder();
		String not = "", join = " AND ";
		if(isExcludeMode)
			not = "NOT ";
		if(!isAndCond)
			join = " OR ";
		if(params != null && params.size() > 0){
			for(String field : params.keySet()){
				if(params.get(field) != null && params.get(field).toString().trim().length() > 0){
					builder.append(not + field+":" + params.get(field) + join);
				}
			}
			if(builder.length() != 0)
				return builder.substring(0, builder.length()-5);
		}
		return builder.toString();
	}
	
	/** 构建 指定返回哪些些字段内容
	 * @param query 查询参数
	 * @param fields  指定返回那些字段内容
	 * @exception 
	 * @since  1.0.0
	 */
	public static void builderReturnField(Map<String, Object> query, String fields){
		if(StringUtils.isNotBlank(fields)){
			if(fields.endsWith(",")){
				fields = fields.substring(0, fields.length()-1);
			}
			query.put("fl", fields);//返回 字段
		}
	}
	
}
