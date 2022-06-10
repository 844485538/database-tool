package com.sijing.tools.service;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author 李健新
 * @Date 2022/6/9
 * @Description
 */
public interface TableWordService {

    /**
     * 导出数据库信息
     *
     * @param response
     */
    void exportTableInfo(HttpServletResponse response);

}
