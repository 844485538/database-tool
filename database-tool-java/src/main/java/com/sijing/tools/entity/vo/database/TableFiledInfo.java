package com.sijing.tools.entity.vo.database;

/**
 * @Author 李健新
 * @Date 2022/6/9
 * @Description
 */
public class TableFiledInfo {

    /**
     * 字段
     */
    private String field;

    /**
     * 类型
     */
    private String type;

    /**
     * 长度
     *
     * 需要从类型中截取
     */
    private Integer length;

    /**
     * 键
     */
    private String key;

    /**
     * 注释
     */
    private String comment;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "TableFiled{" +
                "field='" + field + '\'' +
                ", type='" + type + '\'' +
                ", length=" + length +
                ", key='" + key + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
