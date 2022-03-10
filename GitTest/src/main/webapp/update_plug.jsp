<%@page import="com.VO.PlugVO"%>
<%@page import="com.DAO.PlugDAO"%>
<%@page import="com.VO.AreaVO"%>
<%@page import="com.VO.EmployeeVO"%>
<%@page import="com.VO.RfidVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.DAO.AreaDAO"%>
<%@page import="com.DAO.RfidDAO"%>
<%@page import="com.DAO.EmployeeDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>

<head>
    <title>�÷��� ��������</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <link rel="stylesheet" href="assets/css/main.css" />
    <style>
.logout {
	text-decoration: none;
	float: right;
	border-block: 0;
}
</style>
</head>

<body class="is-preload">
 <%
 int seq = Integer.parseInt(request.getParameter("seq"));
 PlugDAO pDAO = new PlugDAO();
 EmployeeDAO eDAO = new EmployeeDAO();
 AreaDAO aDAO = new AreaDAO();
 ArrayList<EmployeeVO> al1 = eDAO.selectAll();
 ArrayList<AreaVO> al2 = aDAO.getList();
 PlugVO vo = pDAO.selectSeq(seq);
 
   %>
    <!-- Wrapper -->
    <div id="wrapper">

        <!-- Main -->
        <div id="main">
            <div class="inner">
            <div><a class="logout" href="#">LOGOUT</a></div>

                <!-- Header -->
                <header id="header">
                    <strong>�÷��� ��������</strong>
                    <ul class="icons">
                        <li><a href="#" class="icon brands fa-twitter"><span class="label">Twitter</span></a></li>
                        <li><a href="#" class="icon brands fa-facebook-f"><span class="label">Facebook</span></a></li>
                        <li><a href="#" class="icon brands fa-snapchat-ghost"><span class="label">Snapchat</span></a>
                        </li>
                        <li><a href="#" class="icon brands fa-instagram"><span class="label">Instagram</span></a></li>
                        <li><a href="#" class="icon brands fa-medium-m"><span class="label">Medium</span></a></li>
                    </ul>
                </header>

                <!-- Content -->

                <!-- Form -->
                <section>
                    <h2>�������� �Է� (�÷��� ��ȣ : <%=vo.getPlugSeq() %>)</h2>
                    <form method="post" action="UpdatePlugCon.do">
                        <div class="row gtr-uniform">
                            
                            <div class="col-6">
                                <span style="font-size:0.75em;">�� �÷����� ������� ���� (���簪 : <%=vo.getPlugPower() %>)</span>
                                <select name="power" id="power">
                                    <option value="<%=vo.getPlugPower()%>">������� ����</option>
                                    <option value="0.5">0.5</option>
                                    <option value="1.0">1.0</option>
                                    <option value="1.5">1.5</option>
                                    <option value="2.0">2.0</option>
                                    <option value="2.5">2.5</option>
                                    <option value="3.0">3.0</option>
                                </select>
                            </div>
                            
                             <div class="col-6 col-12-xsmall">
                                <span style="font-size:0.75em;">�� ������ġ ���� [������ �Է�X] (���簪 : <%=vo.getDevice()%>)</span>
                                <input type="text" name="device" id="device" value="<%=vo.getDevice()%>" placeholder="�÷����� �����ġ(������ �Է� X)" />
                            </div>
                            
                            <div class="col-6">
                                <span style="font-size:0.75em;">�� �Ҽ����� ���� (���簪 : <%=vo.getId()%>)</span>
                                <select name="id" id="id">
                                    <option value="<%=vo.getId()%>">�Ҽ����� ����</option>
                                    <option value="">����</option>
                                    <%
                                    for(int i = 0; i<al1.size(); i++){
                                    	out.print("<option value="+al1.get(i).getEmpId()+">"+al1.get(i).getEmpName()+"("+al1.get(i).getEmpId()+")</option>");
                                    }
                                    %>
                                </select>
                            </div>
                            
                            <div class="col-6">
                                <span style="font-size:0.75em;">�� �Ҽӱ��� ���� (���簪 : <%=vo.getAreaId() %>)</span>
                                <select name="area" id="area">
                                    <option value="<%=vo.getAreaId()%>">�Ҽӱ��� ����</option>
                                    <%
                                    for(int i = 0; i<al2.size(); i++){
                                    	out.print("<option value="+al2.get(i).getAreaId()+">"+al2.get(i).getAreaName()+"("+al2.get(i).getAreaId()+")</option>");
                                    }
                                    %>
                                </select>
                            </div>
                           
                            <input type="hidden" name="seq" id="seq" value="<%=seq%>">
                          
                            <div class="col-12">
                                <ul class="actions">
                                    <li><input type="submit" value="����" class="primary" /></li>
                                    <li><input type="reset" value="����" ></li>
                                </ul>
                            </div>
                        </div>
                    </form>
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
                        <li><a href="state.jsp">����Ȯ��</a></li>
                        <li><a href="monitoring.jsp">����͸�</a></li>
                        <li><a href="cnt_light.jsp">�������</a></li>
                        <li><a href="mng_emp.jsp">�������</a></li>
                        <li><a href="management.jsp">��ɰ���</a></li>
                        <li><a href="ck_elec.jsp">�����뷮</a></li>
                    </ul>
                </nav>

                <!-- Section -->


                <!-- Section -->


                <!-- Footer -->
                <footer id="footer">
                    <p class="copyright">&copy; Untitled. All rights reserved. Demo Images: <a
                            href="https://unsplash.com">Unsplash</a>. Design: <a href="https://html5up.net">HTML5
                            UP</a>.</p>
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