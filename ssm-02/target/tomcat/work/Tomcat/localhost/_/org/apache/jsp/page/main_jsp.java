/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-02-12 05:01:57 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.page;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>至尊管理系统</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/js/easyui/themes/default/easyui.css\">   \r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/js/easyui/themes/icon.css\">   \r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery-1.7.2.js\"></script>   \r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/easyui/jquery.easyui.min.js\"></script> \r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function(){\r\n");
      out.write("\t$('#main_tree').tree({    \r\n");
      out.write("\t    url:'showMenu',\r\n");
      out.write("\t    onClick:function(node){\r\n");
      out.write("\t    \tif($(\"#main_tabs\").tabs(\"getTab\",node.text)==null){\r\n");
      out.write("\t\t    \t//alert(node.text);\r\n");
      out.write("\t\t    \t$('#main_tabs').tabs('add',{\r\n");
      out.write("\t\t    \t\ttitle: node.text,\r\n");
      out.write("\t\t    \t\tselected: true,\r\n");
      out.write("\t\t    \t\t//content:'<b>adsfadsf</b>'\r\n");
      out.write("\t\t    \t\t//只能引进来<body>标签的内容\r\n");
      out.write("\t\t    \t\thref:node.attributes.filename,\r\n");
      out.write("\t\t    \t\tclosable:true\r\n");
      out.write("\t\t    \t});\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\t$(\"#main_tabs\").tabs(\"select\",node.text);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t    }\r\n");
      out.write("\t}); \r\n");
      out.write("})\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"easyui-layout\">   \r\n");
      out.write("    <div data-options=\"region:'north',title:'至尊管理系统'\" style=\"height:100px;\">\r\n");
      out.write("    \t<div style=\"width:400px;height:70px; float:left;font-size:20px; font-weight:bold;line-height: 70px;padding-left:20px;\">\r\n");
      out.write("    \t\t至尊管理系统\r\n");
      out.write("    \t</div>\r\n");
      out.write("    \t<div style=\"width:200px;height:70px;float:right;line-height: 70px;\">\r\n");
      out.write("    \t\t您好,");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.username }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(",欢迎登录!\r\n");
      out.write("    \t</div>\r\n");
      out.write("    </div>   \r\n");
      out.write("    <div data-options=\"region:'south',title:'底部声明'\" style=\"height:100px;\">\r\n");
      out.write("    \t<div style=\"height:70px; line-height: 70px; text-align:center;color:gray\">\r\n");
      out.write("    \t\tCopyright &copy; 2017 尚学堂202班级\r\n");
      out.write("    \t</div>\r\n");
      out.write("    </div>   \r\n");
      out.write("    <div data-options=\"region:'west',title:'菜单'\" style=\"width:200px;\">\r\n");
      out.write("    \t<ul id=\"main_tree\"></ul> \r\n");
      out.write("    </div>   \r\n");
      out.write("    <div data-options=\"region:'center',title:'内容'\" style=\"padding:5px;background:#eee;\">\r\n");
      out.write("    \t<div id=\"main_tabs\" class=\"easyui-tabs\" style=\"width:500px;height:250px;\" data-options=\"fit:true\">   \r\n");
      out.write("\t\t    <div title=\"首页\" style=\"padding:20px;\">   \r\n");
      out.write("\t\t        tab1    阿斯蒂芬\r\n");
      out.write("\t\t    </div>  \r\n");
      out.write("\t\t     \r\n");
      out.write("\t\t</div>\r\n");
      out.write("    </div>   \r\n");
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
