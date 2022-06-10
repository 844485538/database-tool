package com.sijing.tools.controller;

import com.sijing.tools.entity.vo.ResponseTemplate;
import com.sijing.tools.service.TableWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author 李健新
 * @Date 2022/6/10
 * @Description
 */
public class TableExportController {


    @Autowired
    private TableWordService tableWordService;

    @GetMapping
    public ResponseTemplate getStudentInfo(HttpServletResponse response) {
        tableWordService.exportTableInfo(response);
        return ResponseTemplate.success();
    }

}
