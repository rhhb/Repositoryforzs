/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-01-24 13:09:49 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class emp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery-1.7.2.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function uploadFile() {\r\n");
      out.write("\tvar file = $(\"#upload\").val();\r\n");
      out.write("\tfile = file.substring(file.lastIndexOf('.'), file.length);\r\n");
      out.write("\tif (file == '') {\r\n");
      out.write("\t\talert(\"上传文件不能为空！\");\r\n");
      out.write("\t} else if (file != '.xlsx' && file != '.xls') {\r\n");
      out.write("\t\talert(\"请选择正确的excel类型文件！\");\r\n");
      out.write("\t} else {\r\n");
      out.write("\t\tajaxFileUpload();\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function ajaxFileUpload() {\r\n");
      out.write("\r\n");
      out.write("\tvar formData = new FormData();\r\n");
      out.write("\tvar name = $(\"#upload\").val();\r\n");
      out.write("\tformData.append(\"file\", $(\"#upload\")[0].files[0]);\r\n");
      out.write("\tformData.append(\"name\", name);\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\turl : \"/InputExcel\",\r\n");
      out.write("\t\ttype : \"POST\",\r\n");
      out.write("\t\tasync : false,\r\n");
      out.write("\t\tdata : formData,\r\n");
      out.write("\t\tprocessData : false,\r\n");
      out.write("\t\tcontentType : false,\r\n");
      out.write("\t\tbeforeSend : function() {\r\n");
      out.write("\t\t\tconsole.log(\"正在进行，请稍候\");\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tsuccess : function(e) {\r\n");
      out.write("\t\t\tif (e == \"01\") {\r\n");
      out.write("\t\t\t\talert(\"导入成功\");\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\talert(\"导入失败\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function OutputExce() {\r\n");
      out.write("\twindow.location.href = \"/OutputExcel\";\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<body>\r\n");
      out.write("<table>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t    <td><input type=\"file\" id=\"upload\" name=\"upload\" value=\"\" /></td>\r\n");
      out.write("\t    <td><button onclick=\"uploadFile()\">上传</button></td>\r\n");
      out.write("\t    <td><button onclick=\"OutputExce()\">导出</button></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
