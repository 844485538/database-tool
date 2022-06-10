package com.sijing.tools.entity.vo.database;

/**
 * @Author 李健新
 * @Date 2022/6/9
 * @Description
 */
public class TableInfo {

    /**
     * 表名
     */
    private String name;

    /**
     * 注释
     */
    private String comment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Table{" +
                "name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
