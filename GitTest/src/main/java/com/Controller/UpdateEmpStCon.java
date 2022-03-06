package com.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.AreaDAO;
import com.DAO.EmployeeDAO;


@WebServlet("/UpdateEmpStCon")
public class UpdateEmpStCon extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String type = request.getParameter("type");
		String id = request.getParameter("id");
		// ���°��� ���� �Ѿ�� ���(��������)
		String status = request.getParameter("status");
		// ���°��� �ڵ����� �����ؾ� �ϴ� ���
		if(status.equals("")) {
			// Ÿ�Կ� ���� ���, ��� �� Ÿ���� �ٸ��� �ؾ� �ϳ� �ϴ���...
			status = "1";
		}
		EmployeeDAO dao = new EmployeeDAO();
		int cnt = dao.updateStatus(id, status);
		
		if(cnt>0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateEmpStCon");
			request.setAttribute("status", status);
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("main.jsp");
		}
	}

}
