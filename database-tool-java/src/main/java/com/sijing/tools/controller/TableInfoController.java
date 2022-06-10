package com.sijing.tools.controller;

import com.sijing.tools.entity.vo.ResponseTemplate;
import com.sijing.tools.service.DatabaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 李健新
 * @Date 2022/6/9
 * @Description
 *
 *      获取数据库信息
 */
@RestController
@RequestMapping("/info")
public class TableInfoController {

    @Autowired
    private DatabaseInfoService databaseInfoService;


    @GetMapping("/db")
    public ResponseTemplate getDatabaseInfo(@RequestParam String id) {
        return ResponseTemplate.success(databaseInfoService.getDatabases(id));
    }

    @GetMapping("/table")
    public ResponseTemplate getTableInfo(@RequestParam String id, @RequestParam String dbName) {
        return ResponseTemplate.success(databaseInfoService.getTableInfo(id, dbName));
    }

}
