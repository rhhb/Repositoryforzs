/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-02-12 07:50:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.page.sys;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class role_005fadd_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function(){\r\n");
      out.write("\t$(\"#role_add_submit\").click(function(){\r\n");
      out.write("\t\t$('#role_add_form').form('submit', {    \r\n");
      out.write("\t\t    url:\"roleAdd\",    \r\n");
      out.write("\t\t    onSubmit: function(){    \r\n");
      out.write("\t\t        // do some check    \r\n");
      out.write("\t\t        // return false to prevent submit;    \r\n");
      out.write("\t\t    },    \r\n");
      out.write("\t\t    success:function(data){    \r\n");
      out.write("\t\t       \tif(data==1){\r\n");
      out.write("\t\t       \t\t$.messager.show({\r\n");
      out.write("\t\t       \t\t\ttitle:'系统消息',\r\n");
      out.write("\t\t       \t\t\tmsg:'新增成功',\r\n");
      out.write("\t\t       \t\t\ttimeout:3000,\r\n");
      out.write("\t\t       \t\t\tshowType:'slide'\r\n");
      out.write("\t\t       \t\t});\r\n");
      out.write("\t\t       \t\t//弹出框关闭\r\n");
      out.write("\t\t       \t\t$(\"#role_dialog\").dialog(\"close\");\r\n");
      out.write("\t\t       \t\t$('#role_table').datagrid('reload');\r\n");
      out.write("\t\t       \t}else{\r\n");
      out.write("\t\t       \t\t$.messager.alert(\"系统信息\",\"新增失败,请重新操作\");\r\n");
      out.write("\t\t       \t}\r\n");
      out.write("\t\t    }    \r\n");
      out.write("\t\t}); \r\n");
      out.write("\t})\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("<div  style=\"padding:10px;\">\r\n");
      out.write("系统设置 >> 角色管理\r\n");
      out.write("<hr/>\r\n");
      out.write("<div align=\"center\">\r\n");
      out.write("<form action=\"\" method=\"post\" id=\"role_add_form\">\r\n");
      out.write("<table>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>角色名称:</td>\r\n");
      out.write("\t\t<td><input type=\"text\" name=\"name\"/> </td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>角色排序:</td>\r\n");
      out.write("\t\t<td><input type=\"text\" name=\"sort\"/> </td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>角色备注:</td>\r\n");
      out.write("\t\t<td><input type=\"text\" name=\"remark\"/> </td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr></tr>\r\n");
      out.write("\t<tr></tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t</td>\t\t\r\n");
      out.write("\t\t<td >\r\n");
      out.write("\t\t<div align=\"center\">\r\n");
      out.write("\t\t<a  id=\"role_add_submit\" href=\"#\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-add'\">新增</a> \r\n");
      out.write("\t\t</div> \r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
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
