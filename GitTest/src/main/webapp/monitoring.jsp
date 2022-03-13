<%@page import="com.VO.EmployeeVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.DAO.AreaDAO"%>
<%@page import="com.DAO.RfidDAO"%>
<%@page import="com.DAO.EmployeeDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<title>Monitoring</title>
	<meta charset="euc-kr" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="assets/css/main.css" />
	<style>
		.swal-button {
			padding-top: 0;
			color: white !important;
			background-color: rgb(197, 197, 197);
		}

		.swal-button:not([disabled]):hover {

			background-color: rgb(143, 188, 149);
		}

		.actions li {
			width: 110px;
		}

		.actions p {
			margin: 0;
			padding: 0;
		}

		.actions label {
			margin: 0;
			padding: 0;
		}

		.justified {
			display: flex;
			justify-content: space-between;
			align-items: center;
			margin-top: 37px ;
		}
		.location{
			text-align: center;
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
   
   EmployeeDAO eDao = new EmployeeDAO();
   RfidDAO rDao = new RfidDAO();
   AreaDAO aDao = new AreaDAO();
   
   ArrayList<EmployeeVO> al = eDao.selectAll();
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
					<strong>����͸�</strong>
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
				<section>
					<header class="main">
						<div class="location">
						<li>���: �Ѽ��� ��</li>
						</div>
					</header>
					<!-- ���� ����! -->
					<canvas id="myChart" width="1000px" height="350px"></canvas>

					<!-- ����ġ -->
					<ul class="actions" style="display: flex;  justify-content: space-evenly;
						 text-align: center; ">

						<li class="justified">
							<p>����</p>
							<label class="messageButton">
								<img src="assets/image/greenMessage.png" alt="" width="60px" />
							</label>
						</li>

						<li class="justified">
							<p>����</p>
							<label class="switch-button">
								<input type="checkbox" />
								<span class="onoff-switch"></span>
							</label>
						</li>
					</ul>


					<!-- ����ġ �� -->

					<!-- ����@@@@@@@@@@@ -->
					<input type="checkbox" id="menuicon">
					<ul>
						<li>
							<label for="menuicon">

							</label>
						</li>

					</ul>
					<!-- �������Ʈ�ڽ� �� -->

					<!--��¥ ��ġ�ڽ�  -->
					<div class="sidebarRight">
						<!-- ��ġ�ڽ� -->

						<div class="searchbox">
							<div class="Sheader">
								<h1 id="searchboxname">��� �˻�</h1>
								<input onkeyup="filter()" type="text" id="Svalue" placeholder="Type to Search">
							</div>

							<div class="Scontainer">
							
							<%  for(int i=0; i<al.size(); i++){
                                             out.print("<div class='Sitem'>");
                                             out.print("<span class='Sicon'>"+al.get(i).getEmpName()+"</span>");
                                             out.print("<span class='Sname'>"+al.get(i).getEmpName()+"</span>");
                                             out.print("</div>");
                                  }

                            %>

							</div>
						</div>




					</div>
					<!-- ���ڼ�ġ�ڽ� �� -->





					<!-- ���� ��! -->

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

	<script src="assets/js/chart.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/chart.js@3.7.1/dist/chart.min.js"
		integrity="sha256-ErZ09KkZnzjpqcane4SCyyHsKAXMvID9/xwbl/Aq1pc=" crossorigin="anonymous"></script>

	<script>
	const ctx = 'myChart';
    let renewTime = 3000;
    var config = {
              type: 'line',
              data: {
                  labels: ['1', '2', '3', '4', '5'],
                  datasets: [
                      {
                          data: ['0.5', '1', '1.5', '2', '2.5'],
                      }
                  ]
              }
    };
    const myChart = new Chart(ctx, config);
    
    setInterval(() => {         
       fetch('/GitTest/Api').then(response => {
          return response.json();
       }).then(json => {
          addData(myChart, json.min, json.value);         
       });

       var df = config.data.datasets[0].data;
       var dg = config.data.labels;
       console.log(dg);
       df.shift();      //�������� ���� ���� ���� ����
       dg.shift();      //�������� ���� ���� ���� ����
       console.log(df);
       console.log(dg);
    }, renewTime);
	</script>

	<!-- �˸�â -->
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script>
		document.getElementsByClassName('messageButton')[0].onclick = () => {

			swal({
				title: "���� �̻��� �˸�",
				text: "<<�Ѽ��� �Կ��� �˸��� ���½��ϴ�."
				//    alert()
			})

		}
	</script>
<script type="text/javascript">
   function filter(){

     var Svalue, Sname, Sitem, i;

     Svalue = document.getElementById("Svalue").value.toUpperCase();
     Sitem = document.getElementsByClassName("Sitem");

     for(i=0;i<Sitem.length;i++){
      Sname = Sitem[i].getElementsByClassName("Sname");
      if(Sname[0].innerHTML.toUpperCase().indexOf(Svalue) > -1){
        Sitem[i].style.display = "flex";
      }else{
        Sitem[i].style.display = "none";
      }
     }
   }
</script>

</body>
</html>