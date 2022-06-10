package com.sijing.tools.service.impl;

import com.sijing.tools.entity.dto.ExportDTO;
import com.sijing.tools.entity.vo.database.DatabaseInfo;
import com.sijing.tools.entity.vo.database.TableFiledInfo;
import com.sijing.tools.entity.vo.database.TableInfo;
import com.sijing.tools.mapper.TableMapper;
import com.sijing.tools.service.ExportService;
import com.sijing.tools.util.DownUtil;
import com.sijing.tools.util.TableToWordUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 李健新
 * @Date 2022/6/10
 * @Description
 */
@Service
public class ExportServiceImpl implements ExportService {

    private static final String FILE_NAME = "数据字典.doc";

    /**
     * 导出
     *
     * @param response
     * @param export
     */
    @Override
    public void export(HttpServletResponse response, ExportDTO export) {
        SqlSession sqlSession = SqlSessionFactoryServiceImpl.SQL_SESSION_POOL.get(export.getId()).openSession();
        TableMapper tableMapper = sqlSession.getMapper(TableMapper.class);
        Map<TableInfo, List<TableFiledInfo>> info = new HashMap<>(export.getTableName().size());
        List<TableInfo> tables = tableMapper.getTables(export.getDbName());
        for (int i= 0; i < tables.size(); i++){
            if (export.getTableName().contains(tables.get(i).getName())){
                List<TableFiledInfo> tableFiledInfos = tableMapper.getTableFiled(export.getDbName() + "." +tables.get(i).getName());
                info.put(tables.get(i), tableFiledInfos);
            }
        }
        sqlSession.close();
        File file = TableToWordUtil.toWord(info, FILE_NAME);
        DownUtil.buildExcelDocument("数据字典.doc", file, response);
    }
}
