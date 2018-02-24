package com.choudou5.javasaasx.codegen;

import cn.org.rapid_framework.generator.Generator;
import cn.org.rapid_framework.generator.GeneratorFacade;
import cn.org.rapid_framework.generator.GeneratorProperties;
import cn.org.rapid_framework.generator.provider.db.table.TableFactory;
import cn.org.rapid_framework.generator.provider.db.table.model.Table;
import cn.org.rapid_framework.generator.util.BeanHelper;
import com.choudou5.base.util.DateUtil;
import com.choudou5.base.util.StrUtil;
import com.choudou5.javasaasx.codegen.model.GenTableColumnStyle;

import java.util.List;

public class GeneratorMain {

	/** 抽象字段，Po的 get/set 会忽略 采用继承的 **/
	public static final String[] ABSTRAC_TFIELDS = new String[]{"id", "createBy", "createTime", "updateBy", "updateTime", "delFlag"};
	/** 是否添加 验证注解到Bo */
	public static final boolean IS_ADD_VALID_ANNOTATION_TO_BO = true;
	public static final String DEL_FLAG_FIELD = "del_flag";
	public static final int DEL_FLAG_DELETED = 0; //已删除
	public static final int DEL_FLAG_NORMAL = 1; //正常
	/** 忽略字段（新增）*/
	public static final String[] IGNORE_FIELD_BY_CREATE = new String[]{"updateBy", "updateTime"};
	/** 忽略字段（更新）*/
	public static final String[] IGNORE_FIELD_BY_UPDATE = new String[]{"createBy", "createTime"};

	/**
	 * 请直接修改以下代码调用不同的方法以执行相关生成任务.
	 */
	public static void main(String[] args) throws Exception {
		String outDir = "D:\\data\\code_out";
		String author = "xuhaowen";
		String moduleName = "sys";
		String table = "sys_user";
		genCode(outDir, author, moduleName, table);
	}

	/**
	 * 生成代码
	 * @param outDir
	 * @param author
	 * @param moduleName
	 * @throws Exception
	 */
	public static void genCode(String outDir, String author, String moduleName, String table) throws Exception {
		Generator busCodeGenerator = new Generator();
		String tplPath = "classpath:template";//模板路径
		busCodeGenerator.addTemplateRootDir(tplPath);
		//输出目录
		busCodeGenerator.setOutRootDir(outDir);
		GeneratorFacade generatorFacade = new GeneratorFacade();
		generatorFacade.setGenerator(busCodeGenerator);
        generatorFacade.deleteOutRootDir();//删除生成目录

		//项目名
		GeneratorProperties.setProperty("projectName", "javasaasx");
		GeneratorProperties.setProperty("mavenGroup", "com.choudou5");

		//作者
		GeneratorProperties.setProperty("author", author);
		GeneratorProperties.setProperty("site", "http://solrhome.com");
		GeneratorProperties.setProperty("createTime", DateUtil.today());
		GeneratorProperties.setProperty("copyright", "xuhaowende@sina.cn (@Copyright 2018-2020)");
		GeneratorProperties.setProperty("license", "MIT");

		//包名前缀
		GeneratorProperties.setProperty("packageNamePrefix", "com.choudou5.javasaasx");
		GeneratorProperties.setProperty("packageNamePrefixDir", "com/choudou5/javasaasx");
		GeneratorProperties.setProperty("isAddValidAnnotationToBo", "true");

		//需要移除的表名前缀,使用逗号进行分隔多个前缀,示例值: t_,v_
		GeneratorProperties.setProperty("tableRemovePrefixes", "");

		//模块名
		GeneratorProperties.setProperty("moduleName", moduleName);
		GeneratorProperties.setProperty("lowerClassName", StrUtil.toCamelCase(table));
//		GeneratorProperties.set("columnStyles", columnStyles);

		//表名 sys_user  gen_table_column_style  sys_menu
//		String[] tables = new String[]{table};
//		generatorFacade.generateByTable(tables);

		//自定义 方式
		Table tbl = TableFactory.getInstance().getTable(table);
		Generator.GeneratorModel gm = GeneratorFacade.GeneratorModelUtils.newGeneratorModel("table", tbl);
		gm.templateModel.put("table", tbl);
		gm.templateModel.put("columnStyles", TableFactory.getInstance().getColumnStyleList(table));
		gm.filePathModel.putAll(BeanHelper.describe(tbl));
		generatorFacade.generateBy(gm);
	}


}
