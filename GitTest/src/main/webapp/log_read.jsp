<%@page import="com.VO.RfidVO"%>
<%@page import="com.DAO.AreaDAO"%>
<%@page import="com.DAO.RfidDAO"%>
<%@page import="com.VO.EmployeeVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.DAO.EmployeeDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
      <title>State </title>
      <meta charset="utf-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
      <link rel="stylesheet" href="assets/css/main.css" />
   </head>
   <body class="is-preload">
   <%
   String id = request.getParameter("id");
   EmployeeDAO eDao = new EmployeeDAO();
   RfidDAO rDao = new RfidDAO();
   AreaDAO aDao = new AreaDAO();
   
   ArrayList<RfidVO> al = rDao.selectAll(id);
   %>

      <!-- Wrapper -->
         <div id="wrapper">

            <!-- Main -->
               <div id="main">
                  <div class="inner">

                     <!-- Header -->
                        <header id="header">
                           <strong>직원별 근태 세부이력 : (id) <%=id %></strong>
                           <ul class="icons">
                              <li><a href="#" class="icon brands fa-twitter"><span class="label">Twitter</span></a></li>
                              <li><a href="#" class="icon brands fa-facebook-f"><span class="label">Facebook</span></a></li>
                              <li><a href="#" class="icon brands fa-snapchat-ghost"><span class="label">Snapchat</span></a></li>
                              <li><a href="#" class="icon brands fa-instagram"><span class="label">Instagram</span></a></li>
                              <li><a href="#" class="icon brands fa-medium-m"><span class="label">Medium</span></a></li>
                           </ul>
                        </header>

                     <!-- Content -->
                        <sectio class="in">
                           <header class="main">

                           </header>
                        

                           <!-- 본문 시작 -->
                           
                           <div class="table-wrapper">
                              <table>
                                 <thead>
                                    <tr>
                                       <th>SEQ</th>
                                       <th>TYPE</th>
                                       <th>LOG_TIME</th>
                                       <th>MEMO</th>
                                       
                                       <%
            
                                          for(int i=0; i<al.size(); i++){
                                             out.print("<tr>");
                                             out.print("<td><a href='log_update.jsp?seq="+al.get(i).getLogSeq()+"'>"+al.get(i).getLogSeq()+"</td>");
                                             out.print("<td>"+al.get(i).getLogType()+"</td>");
                                             out.print("<td>"+al.get(i).getLogTime()+"</td>");
                                             out.print("<td>"+al.get(i).getLogMemo()+"</td>");
                                             out.print("</tr>");
                                          }

                                          %>
                                 
                                    </tr>
                                 </thead>
                              </table>
                           </div>
                           <!-- 본문 끝 -->
                           
                        </section>

                  </div>
               </div>

            <!-- Sidebar -->
               <div id="sidebar">
                  <div class="inner">

                     <!-- Search -->
                        <section id="search" class="alt">
                           <form method="post" action="#">
                              <input type="text" name="query" id="query" placeholder="Search" />
                           </form>
                        </section>

                     <!-- Menu -->
                        <nav id="menu">
                           <header class="major">
                              <h2>Menu</h2>
                           </header>
                           <ul>
                        <li><a href="main.jsp">Home</a></li>
                        <li><a href="state.jsp">근태확인</a></li>
                        <li><a href="monitoring.jsp">모니터링</a></li>
                        <li><a href="cnt_light.jsp">조명관리</a></li>
                        <li><a href="mng_emp.jsp">사원관리</a></li>
                        <li><a href="management.jsp">기능관리</a></li>
                        <li><a href="ck_elec.jsp">전기사용량</a></li>
                           </ul>
                        </nav>

                     <!-- Section -->
                        

                     <!-- Section -->
                        

                     <!-- Footer -->
                        <footer id="footer">
                           <p class="copyright">&copy; Untitled. All rights reserved. Demo Images: <a href="https://unsplash.com">Unsplash</a>. Design: <a href="https://html5up.net">HTML5 UP</a>.</p>
                        </footer>

                  </div>
               </div>

         </div>

      <!-- Scripts -->
         <script src="assets/js/jquery.min.js"></script>
         <script src="assets/js/browser.min.js"></script>
         <script src="assets/js/breakpoints.min.js"></script>
         <script src="assets/js/util.js"></script>
         <script src="assets/js/main.js"></script>

   </body>
</html>