package com.entity.domain;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class TreeItemDo implements Comparable{

    private Object id;

    private Object parentId;

    private Object text;

    Set<TreeItemDo> children;

    private Object value;

    @Override
    public int compareTo(Object o) {
        if(o instanceof  TreeItemDo) {
           TreeItemDo itemDo =  (TreeItemDo) o;
           if(itemDo.getId().equals(id) && itemDo.getParentId().equals(parentId) && itemDo.getText().equals(text)) {
               return 0;
           } else {
               return 1;
           }
        }

        return 0;
    }
}