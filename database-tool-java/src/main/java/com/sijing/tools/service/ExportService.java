package com.sijing.tools.service;

import com.sijing.tools.entity.dto.ExportDTO;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author 李健新
 * @Date 2022/6/10
 * @Description
 */
public interface ExportService {

    /**
     * 导出
     *
     * @param response
     * @param export
     */
    void export(HttpServletResponse response, ExportDTO export);

}
