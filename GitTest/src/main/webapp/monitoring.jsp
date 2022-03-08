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
	</style>
</head>

<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main" style="width: calc(100vw - 26em);">
			<div class="inner">

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

								<div class="Sitem">
									<span class="Sicon">A</span>
									<span class="Sname">Apple</span>
								</div>

								<div class="Sitem">
									<span class="Sicon">O</span>
									<span class="Sname">Orange</span>
								</div>

								<div class="Sitem">
									<span class="Sicon">M</span>
									<span class="Sname">Mandarin</span>
								</div>

								<div class="Sitem">
									<span class="Sicon">H</span>
									<span class="Sname">�Ѽ���</span>
								</div>

								<div class="Sitem">
									<span class="Sicon">J</span>
									<span class="Sname">������</span>
								</div>

								<div class="Sitem">
									<span class="Sicon">J</span>
									<span class="Sname">������</span>
								</div>

								<div class="Sitem">
									<span class="Sicon">Y</span>
									<span class="Sname">������</span>
								</div>

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
		let renewTime = 3000;
		let chartId = 'myChart';
		// ĭ ����
		let chartLabels = ['1', '2', '3', '4', '5'];
		let chartDatas = ['0.5', '1', '1.5', '2', '2.5'];
		let chart = chartInit(
			chartId,
			chartLabels,
			chartDatas
		);

		setInterval(() => {			
			// ���⿡ �� ������ �ȴ�!! 6�� db�� �ð� ���̺�
			fetch('/GitTest/Api').then(response => {
				return response.json();
			}).then(json => {
				addData(chart, json.min, json.value);			
			});

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
	<script>
	</script>
</body>
</html>