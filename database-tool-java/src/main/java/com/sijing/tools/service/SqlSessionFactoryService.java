package com.sijing.tools.service;

import org.apache.ibatis.session.SqlSession;

/**
 * @Author 李健新
 * @Date 2022/6/9
 * @Description
 */
public interface SqlSessionFactoryService {

    /**
     * 获取数据库连接
     *
     * @param host
     * @param port
     * @param username
     * @param password
     * @return
     */
    String getSqlSessionFactory(String host, Integer port, String username, String password);

}
