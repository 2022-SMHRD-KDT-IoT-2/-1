package com.POJO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Command.Command;
import com.DAO.EmployeeDAO;

public class UpdateEmpStCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String status = request.getParameter("status");
		
		EmployeeDAO dao = new EmployeeDAO();
		dao.updateStatus(id, status);
		
		return "main2.jsp";
		
	}

}