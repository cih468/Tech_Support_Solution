/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.34
 * Generated at: 2018-12-05 08:13:38 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.technicalSupport;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class technicalSupportCreate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(6);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1542254324508L));
    _jspx_dependants.put("/layout/sideNavi.jsp", Long.valueOf(1543989087729L));
    _jspx_dependants.put("jar:file:/D:/web_workspace_sol/sol/WebContent/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
    _jspx_dependants.put("/layout/header.jsp", Long.valueOf(1542775693796L));
    _jspx_dependants.put("/layout/head.jsp", Long.valueOf(1543892283752L));
    _jspx_dependants.put("/layout/javaScriptFile.jsp", Long.valueOf(1543897146044L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

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
      out.write("  <head>\r\n");
      out.write("  <!-- head 부분 -->\r\n");
      out.write("  ");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write(" <head>\r\n");
      out.write(" \t \t\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <title>메인 페이지</title>\r\n");
      out.write("    <meta name=\"description\" content=\"\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <meta name=\"robots\" content=\"all,follow\">\r\n");
      out.write("    <!-- Bootstrap CSS-->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/vendor/bootstrap/css/bootstrap.min.css\">\r\n");
      out.write("    <!-- Font Awesome CSS-->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/vendor/font-awesome/css/font-awesome.min.css\">\r\n");
      out.write("    <!-- Fontastic Custom icon font-->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/fontastic.css\">\r\n");
      out.write("    <!-- Google fonts - Roboto -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Roboto:300,400,500,700\">\r\n");
      out.write("    <!-- jQuery Circle-->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/grasp_mobile_progress_circle-1.0.0.min.css\">\r\n");
      out.write("    <!-- Custom Scrollbar-->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/vendor/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.css\">\r\n");
      out.write("    <!-- theme stylesheet-->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/style.default.css\" id=\"theme-stylesheet\">\r\n");
      out.write("    <!-- Custom stylesheet - for your changes-->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/custom.css\">\r\n");
      out.write("    <!-- Favicon-->\r\n");
      out.write("    <link rel=\"shortcut icon\" href=\"/img/logo.png\">\r\n");
      out.write("    <!-- Tweaks for older IEs--><!--[if lt IE 9]>\r\n");
      out.write("        <script src=\"https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js\"></script>\r\n");
      out.write("        <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script><![endif]-->\r\n");
      out.write("  </head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("  </head>\r\n");
      out.write("   \r\n");
      out.write("  <body>\r\n");
      out.write("    <!-- Side Navbar -->\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<nav class=\"side-navbar\">\r\n");
      out.write("      <div class=\"side-navbar-wrapper\">\r\n");
      out.write("        <!-- Sidebar Header    -->\r\n");
      out.write("        <div class=\"sidenav-header d-flex align-items-center justify-content-center\">\r\n");
      out.write("          <!-- User Info-->\r\n");
      out.write("          <div class=\"sidenav-header-inner text-center\"><img src=\"/img/photos/externalFile.jpg\" alt=\"person\" class=\"img-fluid rounded-circle\">\r\n");
      out.write("          \t<h3><span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${member.company }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span></h3>\r\n");
      out.write("            <h2 class=\"h5\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${member.userName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</h2><span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${member.email}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span>\r\n");
      out.write("          </div>\r\n");
      out.write("          <!-- Small Brand information, appears on minimized sidebar-->\r\n");
      out.write("          <div class=\"sidenav-header-logo\"><a href=\"/index.html\" class=\"brand-small text-center\"> <strong>T</strong><strong class=\"text-primary\">S</strong></a></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Sidebar Navigation Menus-->\r\n");
      out.write("        <div class=\"main-menu\">\r\n");
      out.write("          <h5 class=\"sidenav-heading\">Technical Support</h5>\r\n");
      out.write("          <ul id=\"side-main-menu\" class=\"side-menu list-unstyled\">                  \r\n");
      out.write("            <li><a href=\"/mainNotice.do\"> <i class=\"icon-home\"></i>Home                             </a></li>\r\n");
      out.write("            <li><a href=\"/views/myPage/pwCheck.jsp\"> <i class=\"icon-interface-windows\"></i>My Page                             </a></li>            \r\n");
      out.write("            <li><a href=\"#formDropDown\" aria-expanded=\"false\" data-toggle=\"collapse\"> <i class=\"icon-interface-windows\"></i>Form</a>\r\n");
      out.write("              <ul id=\"formDropDown\" class=\"collapse list-unstyled \">\r\n");
      out.write("                <li><a href=\"/views/notice/noticeCreate.jsp\">공지사항 작성</a></li>\r\n");
      out.write("                <li><a href=\"/views/sharing/sharingCreate.jsp\">기술공유 작성</a></li>\r\n");
      out.write("                <li><a href=\"/views/technicalSupport/technicalSupportCreate.jsp\">기술지원 작성</a></li>\r\n");
      out.write("              </ul>                             \r\n");
      out.write("            </li>\r\n");
      out.write("            <!--  \r\n");
      out.write("            <li><a href=\"/charts.html\"> <i class=\"fa fa-bar-chart\"></i>Charts                             </a></li>\r\n");
      out.write("            <li><a href=\"/tables.html\"> <i class=\"icon-grid\"></i>Tables                             </a></li>\r\n");
      out.write("            -->\r\n");
      out.write("            <li><a href=\"#boardDropDown\" aria-expanded=\"false\" data-toggle=\"collapse\"> <i class=\"icon-interface-windows\"></i>Board</a>\r\n");
      out.write("              <ul id=\"boardDropDown\" class=\"collapse list-unstyled \">\r\n");
      out.write("                <li><a href=\"/noticeView.do\">공지사항</a></li>\r\n");
      out.write("                <li><a href=\"/sharingView.do\">기술공유</a></li>\r\n");
      out.write("                <li><a href=\"/technicalSupportView.do\">기술지원</a></li>\r\n");
      out.write("              </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("            \r\n");
      out.write("            <li> <a href=\"#\"> <i class=\"icon-mail\"></i>Demo\r\n");
      out.write("                <div class=\"badge badge-warning\">6 New</div></a></li>\r\n");
      out.write("          </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("       \t<!-- 어드민 페이지가 아닌경우 display none으로 변경 -->\r\n");
      out.write("       \t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("    </nav>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("   \r\n");
      out.write("    <div class=\"page\">\r\n");
      out.write("      <!-- navbar-->\r\n");
      out.write("      ");
      out.write(" \t<header class=\"header\">\r\n");
      out.write("        <nav class=\"navbar\">\r\n");
      out.write("          <div class=\"container-fluid\">\r\n");
      out.write("            <div class=\"navbar-holder d-flex align-items-center justify-content-between\">\r\n");
      out.write("              <div class=\"navbar-header\"><a id=\"toggle-btn\" href=\"#\" class=\"menu-btn\"><i class=\"icon-bars\"> </i></a><a href=\"/views/main.jsp\" class=\"navbar-brand\">\r\n");
      out.write("                  <div class=\"brand-text d-none d-md-inline-block\"><span>Technical</span><strong class=\"text-primary\">Support</strong></div></a></div>\r\n");
      out.write("              <ul class=\"nav-menu list-unstyled d-flex flex-md-row align-items-md-center\">\r\n");
      out.write("                <!-- Notifications dropdown-->\r\n");
      out.write("                <li class=\"nav-item dropdown\"> <a id=\"notifications\" rel=\"nofollow\" data-target=\"#\" href=\"#\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\" class=\"nav-link\"><i class=\"fa fa-bell\"></i><span class=\"badge badge-warning\">12</span></a>\r\n");
      out.write("                  <ul aria-labelledby=\"notifications\" class=\"dropdown-menu\">\r\n");
      out.write("                    <li><a rel=\"nofollow\" href=\"#\" class=\"dropdown-item\"> \r\n");
      out.write("                        <div class=\"notification d-flex justify-content-between\">\r\n");
      out.write("                          <div class=\"notification-content\"><i class=\"fa fa-envelope\"></i>You have 6 new messages </div>\r\n");
      out.write("                          <div class=\"notification-time\"><small>4 minutes ago</small></div>\r\n");
      out.write("                        </div></a></li>\r\n");
      out.write("                    <li><a rel=\"nofollow\" href=\"#\" class=\"dropdown-item\"> \r\n");
      out.write("                        <div class=\"notification d-flex justify-content-between\">\r\n");
      out.write("                          <div class=\"notification-content\"><i class=\"fa fa-twitter\"></i>You have 2 followers</div>\r\n");
      out.write("                          <div class=\"notification-time\"><small>4 minutes ago</small></div>\r\n");
      out.write("                        </div></a></li>\r\n");
      out.write("                    <li><a rel=\"nofollow\" href=\"#\" class=\"dropdown-item\"> \r\n");
      out.write("                        <div class=\"notification d-flex justify-content-between\">\r\n");
      out.write("                          <div class=\"notification-content\"><i class=\"fa fa-upload\"></i>Server Rebooted</div>\r\n");
      out.write("                          <div class=\"notification-time\"><small>4 minutes ago</small></div>\r\n");
      out.write("                        </div></a></li>\r\n");
      out.write("                    <li><a rel=\"nofollow\" href=\"#\" class=\"dropdown-item\"> \r\n");
      out.write("                        <div class=\"notification d-flex justify-content-between\">\r\n");
      out.write("                          <div class=\"notification-content\"><i class=\"fa fa-twitter\"></i>You have 2 followers</div>\r\n");
      out.write("                          <div class=\"notification-time\"><small>10 minutes ago</small></div>\r\n");
      out.write("                        </div></a></li>\r\n");
      out.write("                    <li><a rel=\"nofollow\" href=\"#\" class=\"dropdown-item all-notifications text-center\"> <strong> <i class=\"fa fa-bell\"></i>view all notifications                                            </strong></a></li>\r\n");
      out.write("                  </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("                <!-- Messages dropdown-->\r\n");
      out.write("                <li class=\"nav-item dropdown\"> <a id=\"messages\" rel=\"nofollow\" data-target=\"#\" href=\"#\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\" class=\"nav-link\"><i class=\"fa fa-envelope\"></i><span class=\"badge badge-info\">10</span></a>\r\n");
      out.write("                  <ul aria-labelledby=\"notifications\" class=\"dropdown-menu\">\r\n");
      out.write("                    <li><a rel=\"nofollow\" href=\"#\" class=\"dropdown-item d-flex\"> \r\n");
      out.write("                        <div class=\"msg-profile\"> <img src=\"/img/avatar-1.jpg\" alt=\"...\" class=\"img-fluid rounded-circle\"></div>\r\n");
      out.write("                        <div class=\"msg-body\">\r\n");
      out.write("                          <h3 class=\"h5\">Jason Doe</h3><span>sent you a direct message</span><small>3 days ago at 7:58 pm - 10.06.2014</small>\r\n");
      out.write("                        </div></a></li>\r\n");
      out.write("                    <li><a rel=\"nofollow\" href=\"#\" class=\"dropdown-item d-flex\"> \r\n");
      out.write("                        <div class=\"msg-profile\"> <img src=\"/img/avatar-2.jpg\" alt=\"...\" class=\"img-fluid rounded-circle\"></div>\r\n");
      out.write("                        <div class=\"msg-body\">\r\n");
      out.write("                          <h3 class=\"h5\">Frank Williams</h3><span>sent you a direct message</span><small>3 days ago at 7:58 pm - 10.06.2014</small>\r\n");
      out.write("                        </div></a></li>\r\n");
      out.write("                    <li><a rel=\"nofollow\" href=\"#\" class=\"dropdown-item d-flex\"> \r\n");
      out.write("                        <div class=\"msg-profile\"> <img src=\"/img/avatar-3.jpg\" alt=\"...\" class=\"img-fluid rounded-circle\"></div>\r\n");
      out.write("                        <div class=\"msg-body\">\r\n");
      out.write("                          <h3 class=\"h5\">Ashley Wood</h3><span>sent you a direct message</span><small>3 days ago at 7:58 pm - 10.06.2014</small>\r\n");
      out.write("                        </div></a></li>\r\n");
      out.write("                    <li><a rel=\"nofollow\" href=\"#\" class=\"dropdown-item all-notifications text-center\"> <strong> <i class=\"fa fa-envelope\"></i>Read all messages    </strong></a></li>\r\n");
      out.write("                  </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("                <!-- Languages dropdown    -->\r\n");
      out.write("                <li class=\"nav-item dropdown\"><a id=\"languages\" rel=\"nofollow\" data-target=\"#\" href=\"#\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\" class=\"nav-link language dropdown-toggle\"><img src=\"/img/flags/16/GB.png\" alt=\"English\"><span class=\"d-none d-sm-inline-block\">English</span></a>\r\n");
      out.write("                  <ul aria-labelledby=\"languages\" class=\"dropdown-menu\">\r\n");
      out.write("                    <li><a rel=\"nofollow\" href=\"#\" class=\"dropdown-item\"> <img src=\"img/flags/16/DE.png\" alt=\"English\" class=\"mr-2\"><span>German</span></a></li>\r\n");
      out.write("                    <li><a rel=\"nofollow\" href=\"#\" class=\"dropdown-item\"> <img src=\"img/flags/16/FR.png\" alt=\"English\" class=\"mr-2\"><span>French                                                         </span></a></li>\r\n");
      out.write("                  </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("                <!-- Log out-->\r\n");
      out.write("                <li class=\"nav-item\"><a href=\"/logout.do\" class=\"nav-link logout\"> <span class=\"d-none d-sm-inline-block\">Logout</span><i class=\"fa fa-sign-out\"></i></a></li>\r\n");
      out.write("              </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("        </nav>\r\n");
      out.write(" \t</header>");
      out.write("\r\n");
      out.write("      <!-- Breadcrumb-->\r\n");
      out.write("      <div class=\"breadcrumb-holder\">\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("          <ul class=\"breadcrumb\">\r\n");
      out.write("            <li class=\"breadcrumb-item\"><a href=\"index.html\">Home</a></li>\r\n");
      out.write("            <li class=\"breadcrumb-item active\">Notice       </li>\r\n");
      out.write("          </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <section class=\"forms\">\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("          <!-- Page Header-->\r\n");
      out.write("          <header> \r\n");
      out.write("            <h1 class=\"h3 display\">기술 지원 게시판</h1>\r\n");
      out.write("          </header>\r\n");
      out.write("          <div class=\"row\">      \r\n");
      out.write("            <div class=\"col-lg-12\">\r\n");
      out.write("              <div class=\"card\">\r\n");
      out.write("                <div class=\"card-header d-flex align-items-center\">\r\n");
      out.write("                  <h4>기술지원 게시글 작성</h4>\r\n");
      out.write("                </div>                \r\n");
      out.write("                  \r\n");
      out.write("                <div class=\"line\"></div>                \r\n");
      out.write("                <div class=\"card-body\">                \r\n");
      out.write("                  <form class=\"form-horizontal\" action=\"/createTechnicalSupport.do\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("                    <div class=\"form-group row\">\r\n");
      out.write("                      <label class=\"col-sm-2 form-control-label\">제목</label>\r\n");
      out.write("                      <div class=\"col-sm-10\">\r\n");
      out.write("                        <input id=\"name\" name=\"name\" type=\"text\" class=\"form-control\" placeholder=\"제목을 입력하세요\">\r\n");
      out.write("                      </div>\r\n");
      out.write("                    </div>               \r\n");
      out.write("                    <div class=\"line\"></div>\r\n");
      out.write("                    <div class=\"form-group row\">\r\n");
      out.write("                      <label class=\"col-sm-2 form-control-label\">내용</label>\r\n");
      out.write("                      <div class=\"col-sm-10 mb-3\">\r\n");
      out.write("                        <textarea id=\"text\" name=\"text\" class=\"form-control\" style=\"height:500px;\" placeholder=\"내용을 입력하세요\"></textarea>\r\n");
      out.write("                      </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                                             \r\n");
      out.write("                    <div class=\"line\"></div>                    \r\n");
      out.write("                    <div class=\"form-group row\">\r\n");
      out.write("                      <label class=\"col-sm-2 form-control-label\">파일 첨부</label>\r\n");
      out.write("                      <div class=\"col-sm-8\">                  \r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                          <div class=\"input-group\">                           \r\n");
      out.write("                            <div class=\"input-group-append\">\r\n");
      out.write("                             <input type=\"text\" id=\"fileName\" name=\"fileName\" class=\"form-control\" placeholder=\"파일명\" style=\"width:500px;\" readonly/>                             \r\n");
      out.write("                             <input type=\"file\" name=\"upfile\" id=\"fileInput\" style=\"display:none;\" readonly/>   \r\n");
      out.write("                             <button type=\"button\" class=\"btn btn-primary\" onclick=\"return inputFile();\" name=\"upfile\" id=\"fileInputBtn\">파일선택</button>\r\n");
      out.write("                             &nbsp;\r\n");
      out.write("                             <button type=\"button\" class=\"btn btn-primary\" onclick=\"deleteFile();\">첨부파일 삭제</button>\r\n");
      out.write("                            </div>                           \r\n");
      out.write("                          </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                      </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"line\"></div>\r\n");
      out.write("                    <div class=\"form-group row\">\r\n");
      out.write("                      <div class=\"col-sm-6 offset-sm-6\">\r\n");
      out.write("                      \t<button type=\"submit\" class=\"btn btn-primary\" onclick=\"return isSave();\">완료</button>\r\n");
      out.write("                        <a href=\"/views/notice/notice.jsp\" onclick=\"return isCancel();\" class=\"btn btn-secondary\">취소</a>                        \r\n");
      out.write("                      </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                  </form>\r\n");
      out.write("                </div>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </section>\r\n");
      out.write("      <footer class=\"main-footer\">\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("          <div class=\"row\">\r\n");
      out.write("            <div class=\"col-sm-6\">\r\n");
      out.write("              <p>Technical Support &copy; 2018-2019</p>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-sm-6 text-right\">\r\n");
      out.write("              <p>Design by <a href=\"https://bootstrapious.com\" class=\"external\">Bootstrapious</a></p>\r\n");
      out.write("              <!-- Please do not remove the backlink to us unless you support further theme's development at https://bootstrapious.com/donate. It is part of the license conditions and it helps me to run Bootstrapious. Thank you for understanding :)-->\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </footer>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- JavaScript files-->\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write(" \t<script src=\"/vendor/jquery/jquery.min.js\"></script>\r\n");
      out.write("    <script src=\"/vendor/popper.js/umd/popper.min.js\"> </script>\r\n");
      out.write("    <script src=\"/vendor/bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("    <script src=\"/js/grasp_mobile_progress_circle-1.0.0.min.js\"></script>\r\n");
      out.write("    <script src=\"/vendor/jquery.cookie/jquery.cookie.js\"> </script>\r\n");
      out.write("    <script src=\"/vendor/chart.js/Chart.min.js\"></script>\r\n");
      out.write("    <script src=\"/vendor/jquery-validation/jquery.validate.min.js\"></script>\r\n");
      out.write("    <script src=\"/vendor/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js\"></script>\r\n");
      out.write("    <script src=\"/js/charts-home.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- cancel 버튼 확인을 위한 JavaScript 코드 -->\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\r\n");
      out.write("\t\tvar isFileExtError=\"\";\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction isCancel(){\r\n");
      out.write("\t\t\tif(window.confirm(\"정말로 취소하시겠습니까? 현재 작성하시던 글이 모두 취소됩니다.\")){\r\n");
      out.write("\t\t\t\treturn true;\r\n");
      out.write("\t\t\t}else\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction isSave(){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif($(\"#name\").val()==\"\" || $(\"#text\").val()==\"\")\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\talert(\"작성되지 않은 부분이 있습니다.\");\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif(window.confirm(\"저장하고 글을 올리시겠습니까?\")){\r\n");
      out.write("\t\t\t\treturn true;\r\n");
      out.write("\t\t\t}else\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction inputFile(){\r\n");
      out.write("\t\t\t$(\"#fileInput\").click();\r\n");
      out.write("\t\t};\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(function(){\r\n");
      out.write("\t\t\t$(\"#fileInput\").change(function(){\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tvar filePath = $(\"#fileInput\").val();\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tconsole.log(filePath);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\tvar fileName = filePath.split('\\\\').pop().trim();\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tvar ext = fileName.split('.').pop().trim();\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tif(ext==\"zip\"||ext==\"jpg\"||ext==\"png\"||ext==\"bmp\"||ext==\"jpeg\"||ext==\"gif\"\r\n");
      out.write("\t\t\t\t\t||ext==\"hwp\"||ext==\"doc\"||ext==\"ppt\"||ext==\"xls\"||ext==\"txt\"||ext==\"pdf\"\r\n");
      out.write("\t\t\t\t\t||ext==\"pptx\"||ext==\"docx\"){\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t$(\"#fileName\").val(fileName);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\telse{\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\talert(\"이미지,일반문서,zip 파일만 업로드 가능합니다.\");\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t$(\"#fileInput\").val(\"\");\r\n");
      out.write("\t\t\t\t\t$(\"#fileName\").val(\"\");\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tisFileExtError = \"error\";\r\n");
      out.write("\t\t\t\t}\t\t\t\t\r\n");
      out.write("\t\t\t});\t\t\t\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction deleteFile(){\r\n");
      out.write("\t\t\t$(\"#fileInput\").val(\"\");\r\n");
      out.write("\t\t\t$(\"#fileName\").val(\"\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//권한이 안되면 글쓰기 화면 로드가 안되도록 설정\r\n");
      out.write("\t\t$(function(){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.member.typeNo}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"!=1 && \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.member.typeNo}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"!=4){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\talert(\"글쓰기 권한이 없습니다.(협력사 직원만 작성이 가능합니다.)\");\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\tlocation.href=\"/technicalSupportView.do\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("    <!-- Main File-->\r\n");
      out.write("    <script src=\"/js/front.js\"></script>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /layout/sideNavi.jsp(55,8) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.member.typeNo==4}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("       \t       \r\n");
          out.write("       \t <div class=\"admin-menu\"  style=\"display:block;\">\r\n");
          out.write("        \t<h5 class=\"sidenav-heading\">Admin menu</h5>\r\n");
          out.write("          \t<ul id=\"side-admin-menu\" class=\"side-menu list-unstyled\"> \r\n");
          out.write("            \t<li> <a href=\"/memberAllView.do\"> <i class=\"icon-screen\"> </i>회원 전체 정보 조회</a></li>\r\n");
          out.write("            \t<li> <a href=\"/views/admin/approval.jsp\"> <i class=\"icon-flask\"> </i>회원 가입 승인</a></li>\r\n");
          out.write("                \t<div class=\"badge badge-info\">Special</div></a></li>\r\n");
          out.write("            \t<li> <a href=\"\"> <i class=\"icon-flask\"> </i>Demo</a></li>\r\n");
          out.write("            \t<li> <a href=\"\"> <i class=\"icon-picture\"> </i>Demo</a></li>\r\n");
          out.write("            </ul>\r\n");
          out.write("         </div>\r\n");
          out.write("        ");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }
}
