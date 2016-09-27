package com.pharmacodia.dg.utils.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;





import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.pharmacodia.dg.utils.tools.HashMapUtil;



/**
 * 工具类：提供了各种类型文件生成的一般方法
 * <p/>
 * <p><b>User:</b> charles.wang <a href="mailto:charles.wang0@pactera.com">charles.wang0@pactera.com</a></p>
 * <p><b>Date:</b> 2015-01-06 </p>
 *
 * @author charles.wang
 */
public final class FileGeneratorUtil<T> {
	
	
	private FileGeneratorUtil(){}
	

    /**
     * 导出csv文件
     * @param response
     * @param columns : 要导出的列名
     * @param dataFields : 要导出的数据属性名， 要跟列名一一对应
     * @param dataList : 导出的数据
     * @param fileName : 导出的文件名
     * @throws Exception
     */
    public static <T> void exportCsvFile(OutputStream out, String[] columns, String[] dataFields, List<T> dataList, String fileName) throws Exception {
    	
    	OutputStreamWriter osw=null;
    	BufferedWriter bw = null;

        try {
            out.write(new byte []{( byte ) 0xEF ,( byte ) 0xBB ,( byte ) 0xBF });
            osw = new OutputStreamWriter(out, "UTF-8");
            bw = new BufferedWriter(osw);

            for (int i = 0; i < columns.length; i++) {
                bw.append(columns[i]);
                if (i == columns.length - 1) {
                    bw.newLine();
                } else {
                    bw.append(", ");
                }
            }

            for (int i = 0; i < dataList.size(); i++) {
                T userTemp = dataList.get(i);
                HashMap<String, Object> userMap = HashMapUtil.objToHash(userTemp);

                for (int j = 0; j < dataFields.length; j++) {
                    String dataField = dataFields[j];

                    Object value = userMap.get(dataField);
                    if (value != null) {
                        bw.append(value.toString()+"\t");
                    } else {
                        bw.append("");
                    }

                    if (j == dataFields.length - 1) {
                        bw.newLine();
                    } else {
                        bw.append(", ");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                    bw = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (osw != null) {
                try {
                    osw.close();
                    osw = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                    out = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 导出excel文件 (xls, xlsx)
     * 
     * @param response
     * @param columns : 要导出的列名
     * @param dataFields : 要导出的数据属性名， 要跟列名一一对应
     * @param dataList : 导出的数据
     * @param wb : Workbook
     * @param fileName : 导出的文件名
     * @throws Exception
     */
    public static <T> void exportExcel(OutputStream out,String[] columns, String[] dataFields, List<T> dataList, Workbook wb, String fileName) throws Exception {
        // 创建第一个sheet（页），并命名
        Sheet sheet = wb.createSheet(fileName);
        // 创建第一行
        Row row = sheet.createRow((short) 0);
        Cell cell = null;

        // 创建title
        for (int i = 0; i < columns.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(columns[i]);
        }

        for (int i = 0; i < dataList.size(); i++) {
            row = sheet.createRow(i + 1);
            T userTemp = dataList.get(i);
            HashMap<String, Object> userMap = HashMapUtil.objToHash(userTemp);

            for (int j = 0; j < dataFields.length; j++) {
                cell = row.createCell(j);
                String dataField = dataFields[j];
                Object value = userMap.get(dataField);
                if (value != null) {
                    cell.setCellValue(value.toString());
                } else {
                    cell.setCellValue("");
                }
            }
        }

        ByteArrayOutputStream os = new ByteArrayOutputStream();

        try {
            wb.write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);


        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);

            byte[] buff = new byte[2048];
            int bytesRead;

            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }

        } catch (final IOException e) {
            e.getMessage();
        } finally {
            if (bis != null) {
                bis.close();
            }
            if (bos != null){
                bos.close();
            }
        }
    }

}
