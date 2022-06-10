package com.sijing.tools.service.impl;

import com.sijing.tools.entity.vo.database.TableInfo;
import com.sijing.tools.mapper.TableMapper;
import com.sijing.tools.service.DatabaseInfoService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 李健新
 * @Date 2022/6/9
 * @Description
 */
@Service
public class DatabaseInfoServiceImpl implements DatabaseInfoService {

    /**
     * 获取所有数据库名称
     *
     * @return
     */
    @Override
    public List<String> getDatabases(String sqlSessionFactoryId) {
        SqlSession sqlSession = SqlSessionFactoryServiceImpl.SQL_SESSION_POOL.get(sqlSessionFactoryId).openSession();
        TableMapper tableMapper = sqlSession.getMapper(TableMapper.class);
        List<String> databases = tableMapper.getDatabases();
        return databases;
    }

    /**
     * 获取表信息
     *
     * @param sqlSessionFactoryId
     * @return
     */
    @Override
    public List<TableInfo> getTableInfo(String sqlSessionFactoryId, String dbName) {
        SqlSession sqlSession = SqlSessionFactoryServiceImpl.SQL_SESSION_POOL.get(sqlSessionFactoryId).openSession();
        TableMapper tableMapper = sqlSession.getMapper(TableMapper.class);
        List<TableInfo> result = tableMapper.getTables(dbName);
        return result;
    }
}
