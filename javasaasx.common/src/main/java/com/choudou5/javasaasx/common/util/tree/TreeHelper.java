package com.choudou5.javasaasx.common.util.tree;

import com.choudou5.javasaasx.framework.bean.TreeNodeBo;
import com.xiaoleilu.hutool.util.CollectionUtil;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Name：树结构 助手
 * @Author：xuhaowende@sina.cn
 * @Date：2018-01-11 22:32
 * @Site：http://solrhome.com
 * @License：MIT
 */
public class TreeHelper {

    public final static String ROOT_ID = "1";

    private static Map<String, Object> getRoot(){
        Map<String, Object> root = new LinkedHashMap<>();
        root.put("id", ROOT_ID);
        root.put("text", "系统");
        root.put("type", "root");
        return root;
    }


    /**
     * 构建树结构
     * @param list
     * @return
     */
    public static <T extends TreeNodeBo> Map<String, Object> buildTreeData(List<T> list){
        if(CollectionUtil.isEmpty(list))
            return null;
        Map<String, Object> root = getRoot();
        root.put("children", buildTree(ROOT_ID, list, 0));
        return root;
    }


    /**
     * 构建树结构
     * @param parentId
     * @param datas 要求 已按父节点排好序
     * @param startEachIndex 开始遍历下标
     * @return
     */
    private static <T extends TreeNodeBo> List<Map<String, Map>> buildTree(String parentId, List<T> datas, int startEachIndex){
        if(CollectionUtil.isEmpty(datas))
            return null;
        List<Map<String, Map>> childrens = new ArrayList<>();
        for (int i = startEachIndex; i < datas.size(); i++) {
            TreeNodeBo node = datas.get(i);
            if(parentId.equals(node.getParentId())){
                Map children = new LinkedHashMap<>();
                children.put("id", node.getId());
                children.put("text", node.getName());
                children.put("children", buildTree(node.getId(), datas, startEachIndex));
                childrens.add(children);
            }else{
//                break; //实际 datas已排好序 则可以使用这个 来优化 对上千个菜单的遍历
            }
        }
        return childrens;
    }

    private Map<String, TreeNodeBo> toMap(List<TreeNodeBo> datas){
        if(CollectionUtil.isEmpty(datas))
            return null;
        Map<String, TreeNodeBo> mapList = new LinkedHashMap<>();
        for(TreeNodeBo node : datas) {
            mapList.put(node.getId(), node);
        }
        return mapList;
    }

}
