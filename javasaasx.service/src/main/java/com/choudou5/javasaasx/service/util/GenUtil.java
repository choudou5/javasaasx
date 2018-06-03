/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.util;

import com.choudou5.javasaasx.codegen.GeneratorMain;
import com.choudou5.javasaasx.common.util.SysUtil;
import com.choudou5.javasaasx.common.constants.GenConstants;
import com.choudou5.javasaasx.service.gen.vo.GenCodeVo;

/**
 * @Name：生成 工具类
 * @Author：xuhaowende
 * @Date：2018-01-18
 */
public class GenUtil {

    /**
     * 获取 生成页面类型 枚举列表
     * @return
     */
    public static GenConstants.GenPageTypeEnum[] genPageTypeEnums(){
        return GenConstants.GenPageTypeEnum.values();
    }


    /**
     * 生成代码
     * @param genCodeVo
     * @throws Exception
     */
    public static void genCode(GenCodeVo genCodeVo) throws Exception {
        String outDir = SysUtil.getGenCodePath();
        String author = genCodeVo.getAuthor();
        String moduleName = genCodeVo.getModuleName();
        String table = genCodeVo.getTable();
        GeneratorMain.genCode(outDir, author, moduleName, table);
    }


}
