<%@page import="com.model.AreaVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.controller.AreaDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	INSERT
	<form action="A_joincon" method="post">
		<li><input type="text" name="area_i_id"
			placeholder="area_id�� �Է��ϼ���"></li>
		<li><input type="text" name="area_i_name"
			placeholder="area_name�� �Է��ϼ���"></li>
		<li><input type="submit" value="����!!!"></li> 
	</form>

	DELETE
	<form action="A_delete" method="post">
		<li><input type="text" name="area_d_id"
			placeholder="area_id�� �Է��ϼ���"></li>
		<li><input type="submit" value="����!!!"></li>
	</form>

	UPDATE
	<form action="A_update" method="post">
		<li><input type="text" name="area_u_tid" placeholder="ID �� �Է��ϼ���"></li>
		<li><input type="text" name="area_u_id"
			placeholder="���� ID �� �Է��ϼ���"></li>
		<li><input type="text" name="area_u_name"
			placeholder="���� name �� �Է��ϼ���"></li>
		<li><input type="text" name="area_u_status"
			placeholder="���� state�� �Է��ϼ���"></li>
		<li><input type="submit" value="����!!!"></li>
	</form>

	GETLIST
		<%
			AreaDAO dao = new AreaDAO();
			ArrayList<AreaVO> al = dao.getList();
			System.out.print(al.size());
			String st = "<table border = '1'>";
			for (int i = 0; i < al.size(); i++) {
				st+= "<td>"+ al.get(i).getAreaId()+"</td>";
				st+= "<td>"+ al.get(i).getAreaName()+"</td>";
				st+= "<td>"+ al.get(i).getAreaStatus()+"</td></tr>";
			}
			st += "</table>";
			%>
			<%=st %>
	

</body>
</html>