package com.sijing.tools.controller;

import com.sijing.tools.entity.dto.ConnectionDatabaseVO;
import com.sijing.tools.entity.vo.ResponseTemplate;
import com.sijing.tools.service.SqlSessionFactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 李健新
 * @Date 2022/6/9
 * @Description
 */
@RestController
@RequestMapping("/connection")
public class ConnectionController {

    @Autowired
    private SqlSessionFactoryService sqlSessionService;

    @PostMapping
    public ResponseTemplate getStudentInfo(@Validated @RequestBody ConnectionDatabaseVO connectionDatabase) {
        return ResponseTemplate.success(sqlSessionService.getSqlSessionFactory(
                connectionDatabase.getHost(), connectionDatabase.getPort(), connectionDatabase.getUsername(), connectionDatabase.getPassword()));
    }

}
