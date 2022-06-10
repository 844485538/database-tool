package com.sijing.tools.service.impl;

import com.sijing.tools.entity.vo.database.TableInfo;
import com.sijing.tools.mapper.TableMapper;
import com.sijing.tools.service.TableWordService;
import com.sijing.tools.util.DownUtil;
import com.sijing.tools.util.TableToWordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

/**
 * @Author 李健新
 * @Date 2022/6/9
 * @Description
 */
@Service
public class TableWordServiceImpl implements TableWordService {

    @Autowired
    private TableToWordUtil tableToWordUtil;

    @Autowired
    private TableMapper tableMapper;

    /**
     * 导出数据库信息
     */
    @Override
    public void exportTableInfo(HttpServletResponse response) {
        List<TableInfo> tables = tableMapper.getTables("business_hall");
        File file = tableToWordUtil.toWord(tables, "数据字典.doc");
        DownUtil.buildExcelDocument("数据字典.doc", file, response);
    }

}
