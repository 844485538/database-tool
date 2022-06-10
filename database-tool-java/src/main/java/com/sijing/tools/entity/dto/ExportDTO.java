package com.sijing.tools.entity.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @Author 李健新
 * @Date 2022/6/10
 * @Description
 */
public class ExportDTO {

    @NotEmpty(message = "id不可为空")
    private String id;

    @NotEmpty(message = "dbName不可为空")
    private String dbName;

    @NotNull(message = "tableName不可为空")
    @Size(min = 1, message = "tableName不可为空")
    private List<String> tableName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public List<String> getTableName() {
        return tableName;
    }

    public void setTableName(List<String> tableName) {
        this.tableName = tableName;
    }
}
