package com.choudou5.javasaasx.common.util.tree.model;

import java.io.Serializable;

/**
 * @Name：树节点 状态实体
 * @Author：xuhaowende@sina.cn
 * @Date：2018-01-11 22:33
 * @Site：http://solrhome.com
 * @License：MIT
 */
public class TreeNodeState implements Serializable{

    private boolean opened = false;
    private boolean selected = false;
    private boolean disabled = false;

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
}
