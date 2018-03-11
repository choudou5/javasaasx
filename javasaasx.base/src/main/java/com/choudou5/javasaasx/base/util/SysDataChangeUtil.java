package com.choudou5.javasaasx.base.util;

import com.choudou5.base.util.CollUtil;
import com.choudou5.base.util.JsonUtil;
import com.choudou5.base.util.StrUtil;
import com.choudou5.javasaasx.base.bean.AbstractBasePo;
import com.choudou5.javasaasx.base.dao.SysDataChangeLogDao;
import com.choudou5.javasaasx.base.dao.po.SysDataChangeLogPo;
import com.choudou5.javasaasx.common.util.CompareField;
import com.choudou5.javasaasx.common.util.CompareObjUtil;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Name：系统数据变更 工具类
 * @Author：xuhaowen
 * @Date：2018-03-11
 */
public class SysDataChangeUtil {

    private static SysDataChangeLogDao dao = SpringContextHolder.getBean(SysDataChangeLogDao.class);

    /**
     * 保存 编辑
     * @param newObj
     * @param oldObj
     */
    public static <P extends AbstractBasePo> void saveEdit(P newObj, P oldObj){
        SysDataChangeLogPo po = buildChangePo(oldObj, newObj);
        //插入数据
        if (po != null) {
            ThreadUtil.execute(new Runnable() {
                @Override
                public void run() {
                    dao.insert(po);
                }
            });

        }
    }

    /**
     * 保存 删除
     */
    public static <P extends AbstractBasePo> void saveDel(P oldObj){
        if (oldObj != null) {
            String module = oldObj.getClass().getSimpleName();
            SysDataChangeLogPo changeLogPo = new SysDataChangeLogPo();
            changeLogPo.setBizKey(module);
            changeLogPo.setBizId(oldObj.getId());
            changeLogPo.setOptType("del");
            changeLogPo.setOldValList(JsonUtil.toStr(oldObj));
            changeLogPo.setCreateBy(UserUtil.getUserId());
            changeLogPo.setCreateDate(new Date());
            ThreadUtil.execute(new Runnable() {
                @Override
                public void run() {
                    dao.insert(changeLogPo);
                }
            });

        }
    }

    /**
     * 构建 修改对象
     * @param oldObj
     * @param newObj
     * @return
     */
    private static <P extends AbstractBasePo> SysDataChangeLogPo buildChangePo(P oldObj, P newObj) {
        List<CompareField> list = CompareObjUtil.compareObj(oldObj, newObj);
        if(CollUtil.isEmpty(list))
            return null;
        String module = newObj.getClass().getSimpleName();
        SysDataChangeLogPo changeLogPo = new SysDataChangeLogPo();
        changeLogPo.setBizKey(module);
        changeLogPo.setBizId(oldObj.getId());
        changeLogPo.setOptType("edit");
        List<String> fields = new ArrayList(list.size());
        List<String> oldStrs = new ArrayList(list.size());
        List<String> newStrs = new ArrayList(list.size());
        for (CompareField fieldCompare : list) {
            // 设置字段名和新旧值
            fields.add(fieldCompare.getFieldName());
            oldStrs.add(fieldCompare.getOldVal());
            newStrs.add(fieldCompare.getNewVal());
        }
        changeLogPo.setFieldList(StrUtil.join("___", fields));
        changeLogPo.setOldValList(StringUtils.join(oldStrs, "___"));
        changeLogPo.setNewValList(StringUtils.join(newStrs, "___"));
        changeLogPo.setCreateBy(UserUtil.getUserId());
        changeLogPo.setCreateDate(new Date());
        return changeLogPo;
    }
}
