package com.sijing.tools.service;

import com.sijing.tools.entity.vo.database.DatabaseInfo;
import com.sijing.tools.entity.vo.database.TableFiledInfo;
import com.sijing.tools.entity.vo.database.TableInfo;

import java.util.List;

/**
 * @Author 李健新
 * @Date 2022/6/9
 * @Description
 */
public interface DatabaseInfoService {

    /**
     * 获取所有数据库名称
     * @param sqlSessionFactoryId
     * @return
     */
    List<DatabaseInfo> getDatabases(String sqlSessionFactoryId);

    /**
     * 获取表信息
     * @param sqlSessionFactoryId
     * @param dbName
     * @return
     */
    List<TableInfo> getTableInfo(String sqlSessionFactoryId, String dbName);

}
