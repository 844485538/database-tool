package com.sijing.tools.mapper;

import com.sijing.tools.entity.vo.database.DatabaseInfo;
import com.sijing.tools.entity.vo.database.TableFiledInfo;
import com.sijing.tools.entity.vo.database.TableInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author 李健新
 * @Date 2022/6/9
 * @Description
 */
public interface TableMapper {

    /**
     * 获取所有数控库
     * @return
     */
    List<DatabaseInfo> getDatabases();

    /**
     * 获取指定数据库下所有表名和注释
     *
     * @param dbName 数据库名
     * @return
     */
    List<TableInfo> getTables(@Param("dbName") String dbName);

    /**
     * 获取指定表信息
     *
     * @param tableName 表名
     * @return
     */
    List<TableFiledInfo> getTableFiled(@Param("tableName") String tableName);

}
