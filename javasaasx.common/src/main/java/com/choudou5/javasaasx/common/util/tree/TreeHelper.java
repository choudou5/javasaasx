package com.choudou5.javasaasx.common.util.tree;

/**
 * @Name：树结构 助手
 * @Author：xuhaowende@sina.cn
 * @Date：2018-01-11 22:32
 * @Site：http://solrhome.com
 * @License：MIT
 */
public class TreeHelper {

//    public final static String ROOT_ID = "1";
//
//    private static Map<String, Object> getRoot(){
//        Map<String, Object> root = new LinkedHashMap<>();
//        root.put("id", ROOT_ID);
//        root.put("text", "Root");
//        root.put("type", "root");
//        return root;
//    }
//
//
//    /**
//     * 构建树结构
//     * @param list
//     * @return
//     */
//    public static Map<String, Object> buildTreeData(List<SysMenu> list){
//        if(CollectionUtil.isEmpty(list))
//            return null;
//        Map<String, Object> root = getRoot();
//        root.put("children", buildTree(ROOT_ID, list, 0));
//        return root;
//    }
//
//
//    /**
//     * 构建树结构
//     * @param parentId
//     * @param datas 要求 已按父节点排好序
//     * @param startEachIndex 开始遍历下标
//     * @return
//     */
//    private static List<Map<String, Map>> buildTree(String parentId, List<SysMenu> datas, int startEachIndex){
//        if(CollectionUtil.isEmpty(datas))
//            return null;
//        List<Map<String, Map>> childrens = new ArrayList<>();
//        for (int i = startEachIndex; i < datas.size(); i++) {
//            SysMenu menu = datas.get(i);
//            if(parentId.equals(menu.getParentId())){
//                Map children = new LinkedHashMap<>();
//                children.put("id", menu.getId());
//                children.put("text", menu.getName());
//                children.put("children", buildTree(menu.getId(), datas, startEachIndex));
//                childrens.add(children);
//            }else{
////                break; //实际 datas已排好序 则可以使用这个 来优化 对上千个菜单的遍历
//            }
//        }
//        return childrens;
//    }
//
//    private Map<String, SysMenu> toMap(List<SysMenu> datas){
//        if(CollectionUtil.isEmpty(datas))
//            return null;
//        Map<String, SysMenu> mapList = new LinkedHashMap<>();
//        for(SysMenu data : datas) {
//            mapList.put(data.getId(), data);
//        }
//        return mapList;
//    }

}
