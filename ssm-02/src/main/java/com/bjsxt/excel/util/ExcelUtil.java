package com.bjsxt.excel.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
}
