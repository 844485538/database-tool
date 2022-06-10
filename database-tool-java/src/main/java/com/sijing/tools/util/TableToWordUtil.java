package com.sijing.tools.util;

import cn.hutool.core.util.StrUtil;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.rtf.RtfWriter2;
import com.sijing.tools.entity.vo.database.TableFiledInfo;
import com.sijing.tools.entity.vo.database.TableInfo;
import com.sijing.tools.mapper.TableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.*;
import java.util.List;

/**
 * @Author 李健新
 * @Date 2022/6/9
 * @Description
 */
public class TableToWordUtil {

    /**
     * 生成word文档
     *
     * @param info：该数据库下所有表信息
     * @param fileName：生成文件地址
     * @return: void
     */
    public static File toWord(Map<TableInfo, List<TableFiledInfo>> info, String fileName) {

        // 获取临时目录并创建文件
        String tmpPath = System.getProperty("java.io.tmpdir");

        File file = new File(tmpPath + File.separator + fileName);
        if (file.exists() && file.isFile()) {
            file.delete();
        }

        // 创建Word文档，并设置纸张大小
        Document document = new Document(PageSize.A4);
        try {
            file.createNewFile();

            // 为 Document 创建 Writer 实例
            RtfWriter2.getInstance(document, new FileOutputStream(file));

            // 打开当前 Document
            document.open();

            List<TableInfo> tables = new LinkedList<>(info.keySet());

            for (int i = 0; i < tables.size(); i++) {

                String tableName = tables.get(i).getName();
                String tableComment = tables.get(i).getComment();

                //写入表说明
                String all = "" + (i + 1) + " 表名称:" + tableName + "（" + tableComment + "）";
                Paragraph title = new Paragraph(all);
                document.add(title);

                //生成表格
                document.add(buildTable(info.get(tables.get(i))));
            }
            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    /**
     * 生成表格
     *
     * @param tableInfo 表信息
     * @return
     */
    private static Table buildTable(List<TableFiledInfo> filedInfos) throws BadElementException {

        // 设置Table属性
        Table table = new Table(4);
        table.setBorderWidth(1);
        table.setPadding(0);
        table.setSpacing(0);

        // 添加表头的元素，并设置表头背景的颜色
        Color background = new Color(79, 129, 189);
        addTableHeader(table, "含义" , background, "35%");
        addTableHeader(table, "列名", background, "28%");
        addTableHeader(table, "数据类型", background, "20%");
        addTableHeader(table, "长度", background, "17%");

        table.endHeaders();

        // 表格的主体
        for (int k = 0; k < filedInfos.size(); k++) {
            if (StrUtil.isEmpty(filedInfos.get(k).getComment())) {
                addTableContent(table, "-");
            } else {
                addTableContent(table, filedInfos.get(k).getComment());
            }
            addTableContent(table, filedInfos.get(k).getField());
            String type = filedInfos.get(k).getType();
            if (type.indexOf("(") == -1){
                addTableContent(table, type.toUpperCase(Locale.ROOT));
                addTableContent(table, "-");
            } else {
                addTableContent(table, type.substring(0, type.indexOf("(")).toUpperCase(Locale.ROOT));
                addTableContent(table, filedInfos.get(k).getType().substring(type.indexOf("(") + 1, type.indexOf(")")));
            }
        }

        return table;
    }

    /**
     * 添加表头到表格
     *
     * @param table
     * @param content
     * @param background
     * @param width
     */
    private static void addTableHeader(Table table, String content, Color background, String width) throws BadElementException {
        Paragraph title = new Paragraph(content, new Font(Font.NORMAL, 11, Font.NORMAL, Color.white));
        Cell cell = new Cell(title);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(background);
        cell.setWidth(width);
        table.addCell(cell);
    }

    /**
     * 添加内容到表格
     *
     * @param table
     * @param content
     */
    private static void addTableContent(Table table, String content) throws BadElementException {
        Paragraph title = new Paragraph(content, new Font(Font.NORMAL, 10, Font.NORMAL, Color.black));
        Cell cell = new Cell(title);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
    }

}

