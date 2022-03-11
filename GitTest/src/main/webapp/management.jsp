<%@page import="com.VO.EmployeeVO"%>
<%@page import="com.VO.AreaVO"%>
<%@page import="com.VO.PlugVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.DAO.PlugDAO"%>
<%@page import="com.DAO.AreaDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>

<head>
<title>Management</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css'
	rel='stylesheet'>
<style>
/* Style the tab */
.tab {
	overflow: hidden;
	border: 1px solid #ccc;
	background-color: #f1f1f1;
}

/* Style the buttons that are used to open the tab content */
.tab button {
	background-color: inherit;
	float: left;
	border: none;
	outline: none;
	cursor: pointer;
	transition: 0.3s;
	width: 150px;
	box-shadow: none;
	border-bottom: solid 1px #5da62b;
	border-radius: 0%
}

/* Change background color of buttons on hover */
.tab button:hover {
	background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
	background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
	display: none;
	padding: 6px 12px;
	border: 1px solid #ccc;
	border-top: none;
}

.logout {
	text-decoration: none;
	float: right;
	border-block: 0;
}
</style>
</head>

<body class="is-preload">

	<%
	PlugDAO pDao = new PlugDAO();
	AreaDAO aDao = new AreaDAO();
	ArrayList<PlugVO> al1 = pDao.selectAll();
	ArrayList<AreaVO> al2 = aDao.getList();
	
	String aa = "";
	String ab = "";
	String ac = "";
	String ad = "";
	%>
	<%
   EmployeeVO evo = (EmployeeVO)session.getAttribute("loginvo");
   String ss = "";
   String sq = "";

   if(evo != null){
   	if(evo.getEmpStatus().equals("1")){
   		ss = "�ٹ���";
   	}else{
   		ss = "���";
   	}
   	
   	if(evo.getAdminYn().equals("Y")){
   		sq = "������";
   	}else{
   		sq = "����";
   	}
   }

   %>
   		<!-- Wrapper -->
   			<div id="wrapper">

   				<!-- Main -->
   					<div id="main">
   						<div class="inner">
   						<div style="position: absolute; right: 16px; top: 5px;">
   					<a class="logout" href="LogoutCon.do">LOGOUT</a>
   					<span style="float: right;"><%=evo.getEmpName()%>(<%=sq%>)[<%=ss%>] /&nbsp;</span>
   				</div>


				<!-- Header -->
				<header id="header">
					<strong>��ɰ���</strong>

					<ul class="icons">
						<li><a href="#" class="icon brands fa-twitter"><span
								class="label">Twitter</span></a></li>
						<li><a href="#" class="icon brands fa-facebook-f"><span
								class="label">Facebook</span></a></li>
						<li><a href="#" class="icon brands fa-snapchat-ghost"><span
								class="label">Snapchat</span></a></li>
						<li><a href="#" class="icon brands fa-instagram"><span
								class="label">Instagram</span></a></li>
						<li><a href="#" class="icon brands fa-medium-m"><span
								class="label">Medium</span></a></li>
					</ul>
				</header>

				<!-- Content -->
				<!-- ���� ���� -->

				<!-- Tab links -->
				<div class="tab">
					<button class="tablinks" onclick="openMng(event, 'Plug')"
						id="defaultOpen">�÷���</button>
					<button class="tablinks" onclick="openMng(event, 'Area')">����</button>
				</div>

				<div id="Plug" class="tabcontent">
					<div class="table-wrapper">
						<table>
							<thead>
								<tr>
									<th>SEQ</th>
									<th>EMP_ID</th>
									<th>STATUS</th>
									<th>DATE</th>
									<th>AREA</th>
									<th>DEVICE</th>
									<th>FIXED</th>
								</tr>
								<%
								for (int i = 0; i < al1.size(); i++) {
									if(al1.get(i).getPlugStatus().equals("1")){
										aa = "ON";
									}else{
										aa = "OFF";
									}
									
									
									if(al1.get(i).getFixed().equals("0")){
										ac = "��������";
									}else if(al1.get(i).getFixed().equals("1")){
										ac = "ON����";
									}else if(al1.get(i).getFixed().equals("2")){
										ac = "OFF����";
									}
									out.print("<tr>");
									out.print("<td>" + al1.get(i).getPlugSeq() + "</td>");
									out.print("<td>" + al1.get(i).getId() + "</td>");
									out.print("<td>" + aa + "</td>");
									out.print("<td>" + al1.get(i).getPlugInsDate() + "</td>");
									out.print("<td>" + al1.get(i).getAreaId() + "</td>");
									out.print("<td>" + al1.get(i).getDevice() + "</td>");
									out.print("<td><form style='display:inline; margin:0px' action='UpdatePlugFxCon.do'>"
									        + "<input type='hidden' value='" + al1.get(i).getPlugSeq() + "' id='plug' name='plug'>"
											+ "<input type='hidden' value='" + al1.get(i).getFixed() + "' id='fixed' name='fixed'>"
											+ "<input type='submit' value='" + ac + "' style='padding: 0; color: #7f888f !important;  box-shadow: none; font-size: 0.8em'>"
											+ "</form>");
									out.print("<td><form style='display:inline; margin:0px' action='update_plug.jsp'>" + "<input type='hidden' value='"
									+ al1.get(i).getPlugSeq() + "' id='seq' name='seq'>"
									+ "<input type='submit' value='����' style='padding: 0; color: #7f888f !important;  box-shadow: none; font-size: 0.8em'>"
									+ "</form>  /  <form style='display:inline; margin:0px' action='DeletePlugCon.do'>"
									+ "<input type='hidden' value='" + al1.get(i).getPlugSeq() + "' id='seq' name='seq'>"
									+ "<input type='submit' value='����' style='padding: 0; color: #7f888f !important;  box-shadow: none; font-size: 0.8em'>"
									+ "</form></td>");
									out.print("</tr>");
								}
								%>
							</thead>
						</table>
					</div>
					<br>
					<ul class="actions">
						<li><a href="reg_plug.jsp" class="button primary">�߰�</a></li>
					</ul>
				</div>

				<div id="Area" class="tabcontent">
					<div class="table-wrapper">
						<table>
							<thead>
								<tr>
									<th>ID</th>
									<th>STATUS</th>
									<th>NAME</th>
								</tr>
								<%
								for (int i = 0; i < al2.size(); i++) {
									if(al2.get(i).getAreaStatus().equals("0")){
										ad = "OFF";
									}else if(al2.get(i).getAreaStatus().equals("1")){
										ad = "ON";
									}
									out.print("<tr>");
									out.print("<td>" + al2.get(i).getAreaId() + "</td>");
									out.print("<td>" + ad + "</td>");
									out.print("<td>" + al2.get(i).getAreaName() + "</td>");
									out.print("<td><form style='display:inline; margin:0px' action='update_area.jsp'>" + "<input type='hidden' value='"
									+ al2.get(i).getAreaId() + "' id='id' name='id'>"
									+ "<input type='submit' value='����' style='padding: 0; color: #7f888f !important;  box-shadow: none; font-size: 0.8em'>"
									+ "</form>  /  <form style='display:inline; margin:0px' action='DeleteAreaCon.do'>"
									+ "<input type='hidden' value='" + al2.get(i).getAreaId() + "' id='id' name='id'>"
									+ "<input type='submit' value='����' style='padding: 0; color: #7f888f !important;  box-shadow: none; font-size: 0.8em'>"
									+ "</form></td>");
									out.print("</tr>");
								}
								%>
							</thead>
						</table>
					</div>
					<br>
					<ul class="actions">
						<li><a href="reg_area.jsp" class="button primary">�߰�</a></li>
					</ul>
				</div>

			</div>

			<!-- ���� �� -->

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
					<p class="copyright">
						&copy; Untitled. All rights reserved. Demo Images: <a
							href="https://unsplash.com">Unsplash</a>. Design: <a
							href="https://html5up.net">HTML5 UP</a>.
					</p>
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
	<script>
		function openMng(evt, mngName) {
			var i, tabcontent, tablinks;
			tabcontent = document.getElementsByClassName("tabcontent");
			for (i = 0; i < tabcontent.length; i++) {
				tabcontent[i].style.display = "none";
			}
			tablinks = document.getElementsByClassName("tablinks");
			for (i = 0; i < tablinks.length; i++) {
				tablinks[i].className = tablinks[i].className.replace(
						" active", "");
			}
			document.getElementById(mngName).style.display = "block";
			evt.currentTarget.className += " active";
		}

		// Get the element with id="defaultOpen" and click on it
		document.getElementById("defaultOpen").click();
	</script>


</body>

</html>