/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-01-28 09:35:17 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.page.sys;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class role_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function abc(obj){\r\n");
      out.write("\t$('#role_dialog').dialog({    \r\n");
      out.write("\t    title: '分配权限',    \r\n");
      out.write("\t    width: 400,    \r\n");
      out.write("\t    height: 200,    \r\n");
      out.write("\t    closed: false,    \r\n");
      out.write("\t    cache: false,    \r\n");
      out.write("\t    href: 'sys/privilege.jsp',    \r\n");
      out.write("\t    modal: true,\r\n");
      out.write("\t    onLoad:function(){\r\n");
      out.write("\t    \t/* $(\"#role_edit_form :text:eq(0)\").val($(\"#role_table\").datagrid(\"getSelected\").name);\r\n");
      out.write("\t    \t$(\"#role_edit_form :text:eq(1)\").val($(\"#role_table\").datagrid(\"getSelected\").sort);\r\n");
      out.write("\t    \t$(\"#role_edit_form :text:eq(2)\").val($(\"#role_table\").datagrid(\"getSelected\").remark);\r\n");
      out.write("\t    \t$(\"#role_edit_form :hidden:eq(0)\").val($(\"#role_table\").datagrid(\"getSelected\").id); */\r\n");
      out.write("\t    \t$(\"#privilege_form :hidden:eq(0)\").val($(obj).parent().parent().siblings(\"[field='id']\").children().eq(0).html());\r\n");
      out.write("\t    \t$('#privilege_tree').tree({    \r\n");
      out.write("\t    \t    url:'showPrivilege?id='+$(obj).parent().parent().siblings(\"[field='id']\").children().eq(0).html(),\r\n");
      out.write("\t    \t    checkbox:true\t\t\r\n");
      out.write("\t    \t}); \r\n");
      out.write("\t    }\r\n");
      out.write("\t}); \r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("$(function(){\r\n");
      out.write("\t$('#role_table').datagrid({    \r\n");
      out.write("\t    url:'showRole',    \r\n");
      out.write("\t    columns:[[    \r\n");
      out.write("\t        {field:'id',title:'编号',width:100,hidden:true},    \r\n");
      out.write("\t        {field:'name',title:'角色名称',width:100},    \r\n");
      out.write("\t        {field:'sort',title:'排序id',width:100,align:'right'},    \r\n");
      out.write("\t        {field:'remark',title:'备注',width:100,align:'right'},\r\n");
      out.write("\t        {field:'qwe',title:'操作',width:100,align:'right',\r\n");
      out.write("\t        \tformatter: function(value,row,index){\r\n");
      out.write("\t\t\t\t\treturn \"<a href='javascript:void(0)' onclick='javascript:abc(this);return false;'>分配权限</a>\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t        }\r\n");
      out.write("\t    ]],\r\n");
      out.write("\t    pagination:true,\r\n");
      out.write("\t    pageList:[2,4,6],\r\n");
      out.write("\t    fitColumns:true,\r\n");
      out.write("\t    striped:true,\r\n");
      out.write("\t    rownumbers:true,\r\n");
      out.write("\t    toolbar: [{\r\n");
      out.write("\t\t\ticonCls: 'icon-add',\r\n");
      out.write("\t\t\ttext:'增加',\r\n");
      out.write("\t\t\thandler: function(){alert('正在建设中')}\r\n");
      out.write("\t\t},'-',{\r\n");
      out.write("\t\t\ticonCls: 'icon-remove',\r\n");
      out.write("\t\t\ttext:'删除',\r\n");
      out.write("\t\t\thandler: function(){alert('正在建设中')}\r\n");
      out.write("\t\t},'-',{\r\n");
      out.write("\t\t\ticonCls: 'icon-edit',\r\n");
      out.write("\t\t\ttext:'修改',\r\n");
      out.write("\t\t\thandler: function(){\r\n");
      out.write("\t\t\t\tif($(\"#role_table\").datagrid(\"getSelections\").length==1){\r\n");
      out.write("\t\t\t\t\t//弹出窗口\r\n");
      out.write("\t\t\t\t\t$('#role_dialog').dialog({    \r\n");
      out.write("\t\t\t\t\t    title: '修改角色',    \r\n");
      out.write("\t\t\t\t\t    width: 400,    \r\n");
      out.write("\t\t\t\t\t    height: 200,    \r\n");
      out.write("\t\t\t\t\t    closed: false,    \r\n");
      out.write("\t\t\t\t\t    cache: false,    \r\n");
      out.write("\t\t\t\t\t    href: 'sys/role_edit.jsp',    \r\n");
      out.write("\t\t\t\t\t    modal: true,\r\n");
      out.write("\t\t\t\t\t    onLoad:function(){\r\n");
      out.write("\t\t\t\t\t    \t$(\"#role_edit_form :text:eq(0)\").val($(\"#role_table\").datagrid(\"getSelected\").name);\r\n");
      out.write("\t\t\t\t\t    \t$(\"#role_edit_form :text:eq(1)\").val($(\"#role_table\").datagrid(\"getSelected\").sort);\r\n");
      out.write("\t\t\t\t\t    \t$(\"#role_edit_form :text:eq(2)\").val($(\"#role_table\").datagrid(\"getSelected\").remark);\r\n");
      out.write("\t\t\t\t\t    \t$(\"#role_edit_form :hidden:eq(0)\").val($(\"#role_table\").datagrid(\"getSelected\").id);\r\n");
      out.write("\t\t\t\t\t    }\r\n");
      out.write("\t\t\t\t\t}); \r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t$.messager.alert(\"系统信息\",\"请选择<b style='color:red;'>一行</b>\")\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t},'-',{\r\n");
      out.write("\t\t\ticonCls: 'icon-excel',\r\n");
      out.write("\t\t\ttext:'导出excel',\r\n");
      out.write("\t\t\thandler: function(){\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tvar info=$(\"#role_table\").datagrid(\"getData\");\r\n");
      out.write("\t\t\t\t//这里举例获取某列所有数据的和，当然你也可以进行其它处理或遍历操作\r\n");
      out.write("\t\t\t\tvar total=0;\r\n");
      out.write("\t\t\t\tfor(var i=0;i<info.rows.length;i++){\r\n");
      out.write("\t\t\t\t\ttotal=info.rows[i].name;  //假设Table中有列名number\r\n");
      out.write("\t\t\t\t\talert(total);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("// \t\t\t\t$(\"#AllAmount\").text(\"total\")\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}]\r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("})\r\n");
      out.write("</script>\r\n");
      out.write("<table id=\"role_table\"></table> \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"role_dialog\">Dialog Content.</div>  \r\n");
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
