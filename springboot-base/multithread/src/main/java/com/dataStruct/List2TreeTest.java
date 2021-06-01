package com.dataStruct;

import com.entity.domain.TreeItemDo;
import com.google.gson.Gson;

import java.util.*;

/**
 * @description 将list转换为树形的数据结构
 * @author shuai.jin
 * @date 2020/12/8 14:54
 */
public class List2TreeTest {


    public static void main(String[] args) {
        TreeItemDo node1 = new TreeItemDo();
        node1.setText("张三");
        node1.setValue(23);
        node1.setId(1L);
        node1.setParentId(0L);

        TreeItemDo node2 = new TreeItemDo();
        node2.setText("张三");
        node2.setValue(23);
        node2.setId(2L);
        node2.setParentId(1L);

        TreeItemDo node3 = new TreeItemDo();
        node3.setText("张三");
        node3.setValue(23);
        node3.setId(3L);
        node3.setParentId(1L);

        TreeItemDo node4 = new TreeItemDo();
        node4.setText("张三");
        node4.setValue(23);
        node4.setId(4L);
        node4.setParentId(2L);

        TreeItemDo node5 = new TreeItemDo();
        node5.setText("maliu");
        node5.setValue("66");
        node5.setId(5L);
        node5.setParentId(2L);

        List<TreeItemDo> list = new ArrayList<>();
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        list.add(node5);
        Set<TreeItemDo> loop = loop(list, 0L);
        Gson gson = new Gson();
        String json = gson.toJson(loop);
        System.out.println(json);

    }
    public static Set<TreeItemDo> loop(Collection<TreeItemDo> list, Object parentId) {
        Set<TreeItemDo> targetList = new TreeSet<>();
        Iterator<TreeItemDo> it = list.iterator();
        while (it.hasNext()) {
            TreeItemDo next = it.next();

            if(next.getParentId().equals(parentId)  || next.getParentId().equals(0)) {
                Object text = next.getText();
                if(next.getParentId().equals(0)) {
                    continue;
                }
                //添加之前，判断该子节点是否属于这个父节点的
                targetList.add(next);
                it.remove();
            }
        }
        targetList.forEach(n -> n.setChildren(loop(list, n.getId())));
        return targetList;
    }


    /*@Data
    static class TreeItemDo {

        private Long id;

        private Long parentId;

        private Object text;

        List<TreeItemDo> children;

        private Object value;
    }*/
}
