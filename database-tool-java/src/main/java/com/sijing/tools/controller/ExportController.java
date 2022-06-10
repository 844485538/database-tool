package com.sijing.tools.controller;

import com.sijing.tools.entity.dto.ExportDTO;
import com.sijing.tools.entity.vo.ResponseTemplate;
import com.sijing.tools.service.ExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author 李健新
 * @Date 2022/6/10
 * @Description
 */
@RestController
@RequestMapping("/export")
public class ExportController {

    @Autowired
    private ExportService exportService;

    @PostMapping
    public ResponseTemplate getStudentInfo(HttpServletResponse response, @Validated @RequestBody ExportDTO export) {
        exportService.export(response, export);
        return ResponseTemplate.success();
    }

}
