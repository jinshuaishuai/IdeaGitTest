package com.dataStruct;

import ch.qos.logback.core.boolex.EvaluationException;
import com.beust.jcommander.IValueValidator;
import com.entity.domain.TreeItemDo;
import com.google.gson.Gson;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.weaver.ArrayReferenceType;

import java.util.*;

/**
 * @author shuai.jin
 * @date 2020/12/8 17:02
 */
public class ListMap2TreeTest {

    public static void main(String[] args) {
        List<Map<String, Object>> queryResult = new ArrayList<>();

        //是目标数据
        Map<String, Object> map1 = new LinkedHashMap<>();
        map1.put("name", "zhangsan");
        map1.put("phone", "1211");
        map1.put("create_time", "2020-12-09 17:03:22");
        map1.put("status", "0");
        map1.put("age", 2);

        //是目标数据
        Map<String, Object> map2 = new LinkedHashMap<>();
        map2.put("name", "zhangsan");
        map2.put("phone", "1");
        map2.put("create_time", "2020-12-08 17:03:22");
        map2.put("status", "1");
        map2.put("age", 20);

        //非目标数据
        Map<String, Object> map6 = new LinkedHashMap<>();
        map6.put("name", "zhangsan");
        map6.put("phone", "234");
        map6.put("age", 24);

        queryResult.add(map1);
        queryResult.add(map2);

        queryResult.add(map6);


        if (queryResult != null && queryResult.size() > 0) {
            Gson gson = new Gson();
            TreeSet<TreeItemDo> treeItemDoList = new TreeSet<>();
            for (int ite = 0; ite < queryResult.size(); ite++) {
                Map<String, Object> map = queryResult.get(ite);

                //已知目标列
                if (map.size() == 5) {

                    Set<TreeItemDo> outterLoop = outterLoop(queryResult, ite);
                    treeItemDoList.addAll(outterLoop);
                    if (queryResult.get(++ite).size() < 5) {
                        Set<TreeItemDo> loop = loop(treeItemDoList, 0, queryResult);
                        System.out.println(gson.toJson(loop));
                    }
                    --ite;


                } else {

                }

            }

        }

        //封装数据完成

    }

    public static Set<TreeItemDo> loop(Collection<TreeItemDo> list, Object parentId, List<Map<String, Object>> queryResult) {
        Set<TreeItemDo> targetList = new TreeSet<>();

        Iterator<TreeItemDo> it = list.iterator();
        while (it.hasNext()) {
            TreeItemDo next = it.next();

            if(next.getParentId().equals(0)) {
                targetList.add(next);
                it.remove();
            } else if(next.getParentId().equals(parentId)) {
                //判断该节点是否属于该父节点

            }
        }
        targetList.forEach(n -> n.setChildren(loop(list, n.getId(), queryResult)));
        return targetList;
    }

    /**
     * 返回半树的数组结构，作为递归的参数
     *
     * @param queryResult
     * @param ite
     * @return
     */
    private static Set<TreeItemDo> outterLoop(List<Map<String, Object>> queryResult, int ite) {
        Set<TreeItemDo> targetList = new TreeSet<>();

        Map<String, Object> map = queryResult.get(ite);
        List<String> list = new ArrayList<>(map.keySet());
        Collection<Object> values = map.values();

        int index = 0;
        for (String key : list) {
            TreeItemDo treeItemDo = new TreeItemDo();
            if (index >= map.keySet().size() - 1) {
                break;
            }
            treeItemDo.setId(key);
            treeItemDo.setText(map.get(key));

            if (index <= 0) {
                treeItemDo.setParentId(0);

            } else {
                treeItemDo.setParentId(list.get(--index));
                ++index;
            }

            index++;
            targetList.add(treeItemDo);
        }

        return targetList;
    }
}
