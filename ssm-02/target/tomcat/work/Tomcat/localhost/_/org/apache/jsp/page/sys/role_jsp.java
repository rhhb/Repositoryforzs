/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-02-13 08:55:36 UTC
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
      out.write("<title>至尊管理系统</title>\r\n");
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
      out.write("\t    pageList:[5,10,15,20,30],\r\n");
      out.write("\t    fitColumns:true,\r\n");
      out.write("\t    striped:true,\r\n");
      out.write("\t    rownumbers:true,\r\n");
      out.write("\t    toolbar: [{\r\n");
      out.write("\t\t\ticonCls: 'icon-add',\r\n");
      out.write("\t\t\ttext:'增加',\r\n");
      out.write("\t\t\thandler: function(){\r\n");
      out.write("\t\t\t\tif($(\"#role_table\").datagrid(\"getSelections\").length==0){\r\n");
      out.write("\t\t\t\t\t$('#role_dialog').dialog({\r\n");
      out.write("\t\t\t\t\t\ttitle: '新增角色',\r\n");
      out.write("\t\t\t\t\t\twidth: 400,    \r\n");
      out.write("\t\t\t\t\t    height: 200,    \r\n");
      out.write("\t\t\t\t\t    closed: false,    \r\n");
      out.write("\t\t\t\t\t    cache: false,\r\n");
      out.write("\t\t\t\t\t\thref: 'sys/role_add.jsp',\r\n");
      out.write("\t\t\t\t\t\tmodal: true\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t$.messager.alert(\"系统信息\",\"请勿选择<b style='color:red;'>行</b>\")\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t},'-',{\r\n");
      out.write("\t\t\ticonCls: 'icon-remove',\r\n");
      out.write("\t\t\ttext:'删除',\r\n");
      out.write("\t\t\thandler: function(){\r\n");
      out.write("\t\t\t\tif($(\"#role_table\").datagrid(\"getSelections\").length>0){\r\n");
      out.write("\t\t\t\t\tvar data = $(\"#role_table\").datagrid(\"getSelections\");\r\n");
      out.write("// \t\t\t\t\tvar ids = getSelectionsIds();\r\n");
      out.write("\t\t\t\t\tif(data.length>0){\r\n");
      out.write("\t\t\t\t\t\t$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    \r\n");
      out.write("\t\t\t\t\t\t    if (r){ \r\n");
      out.write("// \t\t\t\t\t\t    \tvar params = {\"ids\":ids};\r\n");
      out.write("\t\t\t\t\t\t    \tvar rid=[];\r\n");
      out.write("                                for(var i=0;i<data.length;i++)\r\n");
      out.write("                                    {\r\n");
      out.write("                                    rid[i]=data[i].id;\r\n");
      out.write("                                    }                               \r\n");
      out.write("//                                 $.ajax({\r\n");
      out.write("//                                 \ttype:\"post\",\r\n");
      out.write("//                                 \turl:\"roleRemove\",\r\n");
      out.write("//                                 \tdata:'{\"rid\":rid}',\r\n");
      out.write("//                                 \tcontextType:\"application/json;charset=utf-8\",\r\n");
      out.write("//                                 \tsuccess:function(data){\r\n");
      out.write("//                                 \t\talert(data.rid);\r\n");
      out.write("//                                 \t}\r\n");
      out.write("//                                 });\r\n");
      out.write("                                \r\n");
      out.write("                                \r\n");
      out.write("//                                 $.post(\"roleRemove\",params,\r\n");
      out.write("// \t\t\t\t\t\t\t          function(data){\r\n");
      out.write("// \t\t\t\t\t\t\t          if(data>0){\r\n");
      out.write("// \t\t\t\t\t\t\t        \t  $.messager.show({title:\"提示\",msg:'删除成功'}); \r\n");
      out.write("// \t\t\t\t\t\t\t        \t  $('#role_table').datagrid('reload'); \r\n");
      out.write("// \t\t\t\t\t\t\t          }\t\t\t\t\t\t          \t\t\t\t\t\t\t          \r\n");
      out.write("// \t\t\t\t\t\t\t          });\r\n");
      out.write("                                \r\n");
      out.write("                                $.get(\"roleRemove?rid=\"+rid,\r\n");
      out.write("                                        function(rtn){                                  \r\n");
      out.write("                                    if(rtn>0)                                       \r\n");
      out.write("                                    $('#role_table').datagrid('reload');                                       \r\n");
      out.write("                                    $.messager.show({title:\"提示\",msg:'删除成功'});                                \r\n");
      out.write("                                });\r\n");
      out.write("\t\t\t\t\t\t           \r\n");
      out.write("\t\t\t\t\t\t    }    \r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\telse{\r\n");
      out.write("\t\t\t\t\t$.messager.alert(\"系统信息\",\"请选择删除<b style='color:red;'>行</b>\")\r\n");
      out.write("\t\t\t\t}   \r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t}\r\n");
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
      out.write("\t\t\t\tif($(\"#role_table\").datagrid(\"getSelections\").length==0){\r\n");
      out.write("\t\t\t\t\t$('#role_dialog').dialog({\r\n");
      out.write("\t\t\t\t\t\ttitle: '导出excel',\r\n");
      out.write("\t\t\t\t\t\twidth: 200,    \r\n");
      out.write("\t\t\t\t\t    height: 120,    \r\n");
      out.write("\t\t\t\t\t    closed: false,    \r\n");
      out.write("\t\t\t\t\t    cache: false,\r\n");
      out.write("\t\t\t\t\t\thref: 'sys/role_excel.jsp',\r\n");
      out.write("\t\t\t\t\t\tmodal: true\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t$.messager.alert(\"系统信息\",\"请勿选择<b style='color:red;'>行</b>\")\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("// \t\t\t\tif($(\"#role_table\").datagrid(\"getSelections\").length<1){\r\n");
      out.write("// \t\t\t\t\tvar data = $(\"#role_table\").datagrid(\"getSelections\");\r\n");
      out.write("// \t\t\t\t\tif(data.length<1){\r\n");
      out.write("// \t\t\t\t\t\t$.messager.confirm('确认','您确认想要导出到excel吗？',function(r){    \r\n");
      out.write("// \t\t\t\t\t\t    if (r){                               \r\n");
      out.write("//                                 $.post(\"role_excel\",\r\n");
      out.write("// \t\t\t\t\t\t\t          function(data){\r\n");
      out.write("// \t\t\t\t\t\t\t          if(data==\"success\"){\r\n");
      out.write("// \t\t\t\t\t\t\t        \t  $.messager.show({title:\"提示\",msg:'导出成功'}); \t\t\t\t\t\t\t        \t   \r\n");
      out.write("// \t\t\t\t\t\t\t          }\t\t\t\t\t\t          \t\t\t\t\t\t\t          \r\n");
      out.write("// \t\t\t\t\t\t\t          });\r\n");
      out.write("                                \r\n");
      out.write("// //                                 $.get(\"role_excel\",\r\n");
      out.write("// //                                         function(rtn){                                  \r\n");
      out.write("// //                                     if(rtn==\"success\")                                                                                                                \r\n");
      out.write("// //                                     $.messager.show({title:\"提示\",msg:'导出成功'});                                \r\n");
      out.write("// //                                 });\t\t\t\t\t\t           \r\n");
      out.write("// \t\t\t\t\t\t    }    \r\n");
      out.write("// \t\t\t\t\t\t});\r\n");
      out.write("// \t\t\t\t\t}\r\n");
      out.write("// \t\t\t\t}\t\t\t\t\r\n");
      out.write("// \t\t\t\telse{\r\n");
      out.write("// \t\t\t\t\t$.messager.alert(\"系统信息\",\"请勿选择<b style='color:red;'>行</b>\")\r\n");
      out.write("// \t\t\t\t} \t\t\t\t\r\n");
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
