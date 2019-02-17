package com.bjsxt.excel.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.CollectionUtils;

import com.bjsxt.pojo.Emp;

public class ExcelUtil {
	private static final int MEMORY_THRESHOLD = 100;
	private static final long MAX_FILE_SIZE = 1000;
	private static final long MAX_REQUEST_SIZE = 1000;
	private static final String UPLOAD_DIRECTORY = "files";
	private static String filePath;

	public static String upload(HttpServletRequest request, HttpServletResponse response) {
		 
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(MAX_FILE_SIZE);
		upload.setSizeMax(MAX_REQUEST_SIZE);
		upload.setHeaderEncoding("UTF-8");
		String uploadPath = request.getSession().getServletContext().getRealPath("/") + UPLOAD_DIRECTORY;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		
		try {
			@SuppressWarnings("unchecked")
			List<FileItem> formItems = upload.parseRequest(request);
			if (formItems != null && formItems.size() > 0) {
				for (FileItem item : formItems) {
					if (!item.isFormField()) {
						String fileName = new File(item.getName()).getName();
						 filePath = uploadPath + File.separator + fileName;
						File storeFile = new File(filePath);
						item.write(storeFile);
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return filePath;
	}
	
	public static ArrayList<ArrayList<Object>> readExcel2003(InputStream is) {
		try {
			ArrayList<ArrayList<Object>> rowList = new ArrayList<ArrayList<Object>>();
			ArrayList<Object> colList;
			HSSFWorkbook wb = new HSSFWorkbook(is);
			HSSFSheet sheet = wb.getSheetAt(0);
			HSSFRow row;
			HSSFCell cell;
			Object value = null;
			for (int i = sheet.getFirstRowNum() + 1, rowCount = 0; rowCount < sheet.getPhysicalNumberOfRows(); i++) {
				row = sheet.getRow(i);
				colList = new ArrayList<Object>();
				if (row == null) {
					if (i != sheet.getPhysicalNumberOfRows()) {// 判断是否是最后一行
						rowList.add(colList);
					}
					System.out.println(rowList);
					return rowList;
				} else {
					rowCount++;
				}
				//防止出现空 导致出现超出指针异常错误 
				for (int j = 0; j <= sheet.getRow(0).getPhysicalNumberOfCells(); j++) {
					cell = row.getCell(j);
					if (cell == null || cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
						if (j != row.getLastCellNum()) {
							colList.add("");
						}
						continue;
					}
					if (null != cell) {
						switch (cell.getCellType()) {
						case HSSFCell.CELL_TYPE_NUMERIC:
							if (HSSFDateUtil.isCellDateFormatted(cell)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
								value = sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue())).toString();
								break;
							} else {
								Double d = cell.getNumericCellValue();
								DecimalFormat df = new DecimalFormat("#.##");
								value = df.format(d);
							}
							break;
						case HSSFCell.CELL_TYPE_STRING:
							value = cell.getStringCellValue();
							break;
						case HSSFCell.CELL_TYPE_BOOLEAN:
							value = cell.getBooleanCellValue() + "";
							break;
						case HSSFCell.CELL_TYPE_FORMULA:
							value = cell.getCellFormula() + "";
							break;
						case HSSFCell.CELL_TYPE_BLANK:
							value = "";
							break;
						case HSSFCell.CELL_TYPE_ERROR:
							value = "非法字符";
							break;
						default:
							value = "未知类型";
							break;
						}
 
					}
					colList.add(value);
				}
				rowList.add(colList);
			}
			if (is != null) {
				is.close();
			}
			return rowList;
		} catch (Exception e) {
			return null;
		}
	}
 
	public static ArrayList<ArrayList<Object>> readExcel2007(InputStream is) {
		try {
			ArrayList<ArrayList<Object>> rowList = new ArrayList<ArrayList<Object>>();
			ArrayList<Object> colList;
			XSSFWorkbook wb = new XSSFWorkbook(is);
			XSSFSheet sheet = wb.getSheetAt(0);
			XSSFRow row;
			XSSFCell cell;
			Object value = null;
 
			for (int i = sheet.getFirstRowNum() + 1, rowCount = 0; rowCount < sheet.getPhysicalNumberOfRows(); i++) {
				row = sheet.getRow(i);
				colList = new ArrayList<Object>();
				if (row == null) {
					if (i != sheet.getPhysicalNumberOfRows()) {
						rowList.add(colList);
					}
					return rowList;
				} else {
					rowCount++;
				}
				//防止出现空 导致出现超出指针异常错误 
				for (int j = 0; j <= sheet.getRow(0).getPhysicalNumberOfCells(); j++) {
					cell = row.getCell(j);
					if (cell == null || cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
						if (j != row.getLastCellNum()) {
							colList.add("");
						}
						continue;
					}
 
					if (null != cell) {
						switch (cell.getCellType()) {
						case HSSFCell.CELL_TYPE_NUMERIC:
							if (HSSFDateUtil.isCellDateFormatted(cell)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
								value = sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue())).toString();
								break;
							} else {
								Double d = cell.getNumericCellValue();
								DecimalFormat df = new DecimalFormat("#.##");
								value = df.format(d);
							}
							break;
 
						case HSSFCell.CELL_TYPE_STRING:
							value = cell.getStringCellValue();
							break;
 
						case HSSFCell.CELL_TYPE_BOOLEAN:
							value = cell.getBooleanCellValue() + "";
							break;
 
						case HSSFCell.CELL_TYPE_FORMULA:
							value = cell.getCellFormula() + "";
							break;
 
						case HSSFCell.CELL_TYPE_BLANK:
							value = "";
							break;
 
						case HSSFCell.CELL_TYPE_ERROR:
							value = "非法字符";
							break;
 
						default:
							value = "未知类型";
							break;
						}
 
					}
					colList.add(value);
				}
				rowList.add(colList);
			}
			if (is != null) {
				is.close();
			}
			return rowList;
		} catch (Exception e) {
			System.out.println("exception");
			return null;
		}
	}
	//导出excel文件
	public static String OutExcel(HttpServletRequest request, HttpServletResponse response, List<Emp> list,String tilte) throws Exception {
		 
		String message = "fail";
		String dir = request.getSession().getServletContext().getRealPath("/output");
		File fileLocation = new File(dir);
		if (!fileLocation.exists()) {
			boolean isCreated = fileLocation.mkdir();
			if (!isCreated) {
			}
		}
		String webUrl = request.getSession().getServletContext().getRealPath("/output");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd mm-ss");
		String createExcelname = df.format(new Date()) + "OutputExcel.xls";
		String outputFile = webUrl + File.separator + createExcelname;
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		workbook.setSheetName(0,tilte);
		HSSFRow row1 = sheet.createRow(0);
		HSSFCell cell0 = row1.createCell(0, HSSFCell.CELL_TYPE_STRING);
		HSSFCell cell1 = row1.createCell(1, HSSFCell.CELL_TYPE_STRING);
		HSSFCell cell2 = row1.createCell(2, HSSFCell.CELL_TYPE_STRING);
		HSSFCell cell3 = row1.createCell(3, HSSFCell.CELL_TYPE_STRING);
		HSSFCell cell4 = row1.createCell(4, HSSFCell.CELL_TYPE_STRING);		
		cell0.setCellValue("id");
		cell1.setCellValue("name");
		cell2.setCellValue("sex");
		cell3.setCellValue("email");
		cell4.setCellValue("dept_id");
		response.setContentType("text/html;charset=UTF-8");	
		for (int j = 0; j < list.size(); j++) {	
			Emp empt = new Emp();
			empt = list.get(j);
			HSSFRow row = sheet.createRow(j + 1);
			HSSFCell c0 = row.createCell(0, HSSFCell.CELL_TYPE_STRING);
			HSSFCell c1 = row.createCell(1, HSSFCell.CELL_TYPE_STRING);
			HSSFCell c2 = row.createCell(2, HSSFCell.CELL_TYPE_STRING);
			HSSFCell c3 = row.createCell(3, HSSFCell.CELL_TYPE_STRING);
			HSSFCell c4 = row.createCell(4, HSSFCell.CELL_TYPE_STRING);
			c0.setCellValue(empt.getId());
			c1.setCellValue(empt.getName());
			c2.setCellValue(empt.getSex());
			c3.setCellValue(empt.getEmail());
			c4.setCellValue(empt.getDept_id());	
		}
		FileOutputStream fOut = new FileOutputStream(outputFile);
		workbook.write(fOut);
		fOut.flush();
		fOut.close();
		File f = new File(outputFile);
		if (f.exists() && f.isFile()) {
			try {
				FileInputStream fis = new FileInputStream(f);
				URLEncoder.encode(f.getName(), "utf-8");
				byte[] b = new byte[fis.available()];
				fis.read(b);
				response.setCharacterEncoding("utf-8");
				response.setHeader("Content-Disposition", "attachment; filename=" + createExcelname + "");
				ServletOutputStream out = response.getOutputStream();
				out.write(b);
				out.flush();
				out.close();
				if (fis != null) {
					fis.close();
				}
				f.delete();
				message = "success";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return message;
	}
	
	//导出excel文件 通用方法
	/**
     * 利用JAVA的反射机制，将放置在JAVA集合中并且符号一定条件的数据以EXCEL 的形式输出到指定IO设备上<br>
     * 用于单个sheet
     *
     * @param <T>
     * @param headers   表格属性列名数组
     * @param dataset   需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的
     *                  javabean属性的数据类型有基本数据类型及String,Date,String[],Double[]
     * @param filePath  excel文件输出路径     
     */
    public static <T> String exportExcel(HttpServletRequest request, HttpServletResponse response,String[] headers, Collection<T> dataset) {        
    	exportExcel(request,response,headers, dataset, null);
		return "success";
    }

    /**
     * 利用JAVA的反射机制，将放置在JAVA集合中并且符号一定条件的数据以EXCEL 的形式输出到指定IO设备上<br>
     * 用于单个sheet
     *
     * @param <T>
     * @param headers 表格属性列名数组
     * @param dataset 需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的
     *                javabean属性的数据类型有基本数据类型及String,Date,String[],Double[]
     * @param filePath  excel文件输出路径
     * @param pattern 如果有时间数据，设定输出格式。默认为"yyy-MM-dd"
     */
    public static <T> void exportExcel(HttpServletRequest request, HttpServletResponse response,String[] headers, Collection<T> dataset, String pattern) {
        try {
        	String dir = request.getSession().getServletContext().getRealPath("/output");
    		File fileLocation = new File(dir);
    		if (!fileLocation.exists()) {
    			boolean isCreated = fileLocation.mkdir();
    			if (!isCreated) {
    			}
    		}
    		String webUrl = request.getSession().getServletContext().getRealPath("/output");
    		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd mm-ss");
    		String createExcelname = df.format(new Date()) + "OutputExcel.xls";
    		String outputFile = webUrl + File.separator + createExcelname;
        	// 声明一个工作薄
            @SuppressWarnings("resource")
			Workbook workbook = new HSSFWorkbook();
            if (workbook != null) {
                // 生成一个表格
                Sheet sheet = workbook.createSheet();

                write2Sheet(sheet, headers, dataset, pattern);
                FileOutputStream fOut = new FileOutputStream(outputFile);
        		workbook.write(fOut);
        		fOut.flush();
        		fOut.close();
        		File f = new File(outputFile);
        		if (f.exists() && f.isFile()) {
        			try {
        				FileInputStream fis = new FileInputStream(f);
        				URLEncoder.encode(f.getName(), "utf-8");
        				byte[] b = new byte[fis.available()];
        				fis.read(b);
        				response.setCharacterEncoding("utf-8");
        				response.setHeader("Content-Disposition", "attachment; filename=" + createExcelname + "");
        				ServletOutputStream out = response.getOutputStream();
        				out.write(b);
        				out.flush();
        				out.close();
        				if (fis != null) {
        					fis.close();
        				}
        				f.delete();
//        				message = "success";
        			} catch (Exception e) {
        				e.printStackTrace();
        			}
        			
        		}
            }
        } catch (IOException e) {
//            mLogger.error(e.toString(), e);
        	e.printStackTrace();
        }
    }

    /**
     * 导出数据到Excel文件
     * @param dataList 要输出到Excel文件的数据集
     * @param filePath  excel文件输出路径
     */
    public static void exportExcel(String[][] dataList, String filePath) {
        try {
            // 声明一个工作薄
            Workbook workbook =  new HSSFWorkbook();
            if (workbook != null) {
                // 生成一个表格
                Sheet sheet = workbook.createSheet();

                for (int i = 0; i < dataList.length; i++) {
                    String[] r = dataList[i];
                    Row row = sheet.createRow(i);
                    for (int j = 0; j < r.length; j++) {
                        Cell cell = row.createCell(j);
                        // cell max length 32767
                        if (r[j].length() > 32767) {
//                            mLogger.warn("异常处理", "--此字段过长(超过32767),已被截断--" + r[j]);
                            r[j] = r[j].substring(0, 32766);
                        }
                        cell.setCellValue(r[j]);
                    }
                }
                // 自动列宽
                if (dataList.length > 0) {
                    int colcount = dataList[0].length;
                    for (int i = 0; i < colcount; i++) {
                        sheet.autoSizeColumn(i);
                    }
                }
                OutputStream out = new FileOutputStream(new File(filePath));
                workbook.write(out);
                out.close();
            }
        } catch (IOException e) {
//            mLogger.error(e.toString(), e);
        	e.printStackTrace();
        }
    }

    /**
     * 利用JAVA的反射机制，将放置在JAVA集合中并且符号一定条件的数据以EXCEL 的形式输出到指定IO设备上<br>
     * 用于多个sheet
     * @param sheets ExcelSheet的集体
     * @param filePath excel文件路径
     */
    public static <T> void exportExcel(List<ExcelSheet<T>> sheets, String filePath) {
        exportExcel(sheets, filePath, null);
    }

    /**
     * 利用JAVA的反射机制，将放置在JAVA集合中并且符号一定条件的数据以EXCEL 的形式输出到指定IO设备上<br>
     * 用于多个sheet
     *
     * @param sheets    ExcelSheet的集合
     * @param filePath  excel文件输出路径
     * @param pattern   如果有时间数据，设定输出格式。默认为"yyy-MM-dd"
     */
    public static <T> void exportExcel(List<ExcelSheet<T>> sheets, String filePath, String pattern) {
        
    	
    	if (CollectionUtils.isEmpty(sheets)) {
            return;
        }
        try {
            // 声明一个工作薄
            Workbook workbook = new HSSFWorkbook();
            if (workbook != null) {
                for (ExcelSheet<T> sheetInfo : sheets) {
                    // 生成一个表格
                    Sheet sheet = workbook.createSheet(sheetInfo.getSheetName());
//                    write2Sheet(sheet, sheetInfo.getHeaders(), sheetInfo.getDataset(), pattern);
                }
                OutputStream out = new FileOutputStream(new File(filePath));
                workbook.write(out);
                out.close();
            }
        } catch (IOException e) {
//            mLogger.error(e.toString(), e);
        	e.printStackTrace();
        }
    }

    /**
     * 每个sheet的写入
     * @param sheet   页签
     * @param headers 表头
     * @param dataset 数据集合
     * @param pattern 日期格式
     */
    public static <T> void write2Sheet(Sheet sheet, String[] headers, Collection<T> dataset, String pattern) {
        // 产生表格标题行
        Row row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(headers[i]);
        }
        // 遍历集合数据，产生数据行
        Iterator<T> it = dataset.iterator();
        int index = 0;
        while (it.hasNext()) {
            index++;
            row = sheet.createRow(index);
            T t = (T) it.next();
            if (t instanceof Map) { // row data is map
                @SuppressWarnings("unchecked")
                Map<String, Object> map = (Map<String, Object>) t;
                int cellNum = 0;
                for (String k : headers) {
                    if (map.containsKey(k) == false) {
//                        mLogger.error("Map 中 不存在 key [" + k + "]");
                        continue;
                    }
                    Cell cell = row.createCell(cellNum);
                    Object value = map.get(k);
                    if (value == null) {
                        cell.setCellValue(StringUtils.EMPTY);
                    } else {
                        cell.setCellValue(String.valueOf(value));
                    }
                    cellNum++;
                }
            } else if (t instanceof Object[]) { // row data is Object[]
                Object[] tObjArr = (Object[]) t;
                for (int i = 0; i < tObjArr.length; i++) {
                    Cell cell = row.createCell(i);
                    Object value = tObjArr[i];
                    if (value == null) {
                        cell.setCellValue(StringUtils.EMPTY);
                    } else {
                        cell.setCellValue(String.valueOf(value));
                    }
                }
            } else if (t instanceof List<?>) { // row data is List
                List<?> rowData = (List<?>) t;
                for (int i = 0; i < rowData.size(); i++) {
                    Cell cell = row.createCell(i);
                    Object value = rowData.get(i);
                    if (value == null) {
                        cell.setCellValue(StringUtils.EMPTY);
                    } else {
                        cell.setCellValue(String.valueOf(value));
                    }
                }
            } else { // row data is vo
                // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
            	System.out.println("执行遍历操作...");
                Field[] fields = t.getClass().getDeclaredFields();
                for (int i = 0; i < fields.length; i++) {
                    Cell cell = row.createCell(i);
                    Field field = fields[i];
                    String fieldName = field.getName();
                    String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

                    try {
                        Class<?> tClazz = t.getClass();
                        Method getMethod = tClazz.getMethod(getMethodName, new Class[] {});
                        Object value = getMethod.invoke(t, new Object[] {});                    
                        String textValue = null;
                        if (value instanceof Integer) {
                            int intValue = (Integer) value;
                            System.out.println(intValue);
                            cell.setCellValue(intValue);
                        } else if (value instanceof Float) {
                            float fValue = (Float) value;
                            cell.setCellValue(fValue);
                        } else if (value instanceof Double) {
                            double dValue = (Double) value;
                            cell.setCellValue(dValue);
                        } else if (value instanceof Long) {
                            long longValue = (Long) value;
                            cell.setCellValue(longValue);
                        } else if (value instanceof Boolean) {
                            boolean bValue = (Boolean) value;
                            cell.setCellValue(bValue);
                        } else if (value instanceof Date) {
                            Date date = (Date) value;
                            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                            textValue = sdf.format(date);
                        } else if(value!=null) {
                            // 其它数据类型都当作字符串简单处理
                            //防止出现空指针异常
                            	textValue = value.toString();                            	
                            	cell.setCellValue(textValue); 
                            	
                        }
//                        else if (textValue != null) {
//                            // HSSFRichTextString richString = new
//                            // HSSFRichTextString(textValue);                            
//                        } 
                        else {                       	
                            cell.setCellValue(StringUtils.EMPTY);
                            System.out.println("空...");
                        }
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (SecurityException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
        // 设定自动宽度
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }
    }

    /**
     * EXCEL文件下载
     * @param path
     * @param response
     */
    public static void download(String path, HttpServletResponse response) {
        try {
            // path是指欲下载的文件的路径。
            File file = new File(path);
            // 取得文件名。
            String filename = file.getName();
            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/vnd.ms-excel;charset=gb2312");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
