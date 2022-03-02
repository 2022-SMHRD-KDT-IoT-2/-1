package com.FrontController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Command.Command;
import com.POJO.AreaCheckCon;
import com.POJO.DeleteAreaCon;
import com.POJO.DeleteEmpCon;
import com.POJO.DeletePlugCon;
import com.POJO.DeletePlugSenCon;
import com.POJO.IdCheckCon;
import com.POJO.LoginCon;
import com.POJO.LogoutCon;
import com.POJO.RegAreaCon;
import com.POJO.RegEmpCon;
import com.POJO.RegPlugCon;
import com.POJO.RegPlugSenCon;
import com.POJO.UpdateAreaStCon;
import com.POJO.UpdateEmp1Con;
import com.POJO.UpdateEmp2Con;
import com.POJO.UpdateEmpStCon;
import com.POJO.UpdatePlugCon;
import com.POJO.UpdatePlugStCon;

//import dummy.POJO.DeleteAcCon;
//import dummy.POJO.DeleteAcSenCon;
//import dummy.POJO.DeleteLightCon;
//import dummy.POJO.DeleteLightSenCon;
//import dummy.POJO.RegAcCon;
//import dummy.POJO.RegAcSenCon;
//import dummy.POJO.RegLightCon;
//import dummy.POJO.RegLightSenCon;
//import dummy.POJO.UpdateAcCon;
//import dummy.POJO.UpdateAcStCon;
//import dummy.POJO.UpdateLightCon;
//import dummy.POJO.UpdateLightStCon;


// Ȯ�������� ��� : � ��û�̴� �ڿ� .do�� �پ� ������ �� �������� �޾Ƽ� ó��
@WebServlet("*.do")
public class FrontController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		// ��û URI
		String reqURI = request.getRequestURI();
		
		// ������Ʈ ��
		String path = request.getContextPath();
		
		// ���ڿ� �ڸ��� -> reqURI - ������Ʈ��/
		String result = reqURI.substring(path.length()+1);
		
		Command command = null;
		
		if(result.equals("LoginCon.do")) {
			command = new LoginCon();
		}else if(result.equals("LogoutCon.do")) {
			command = new LogoutCon();
		}else if(result.equals("RegEmpCon.do")) {
			command = new RegEmpCon();
		}else if(result.equals("RegAreaCon.do")) {
			command = new RegAreaCon();
		}else if(result.equals("UpdateEmp1Con.do")) {
			command = new UpdateEmp1Con();
		}else if(result.equals("UpdateEmp2Con.do")) {
			command = new UpdateEmp2Con();
		}else if(result.equals("DeleteEmpCon.do")) {
			command = new DeleteEmpCon();
		}else if(result.equals("DeleteAreaCon.do")) {
			command = new DeleteAreaCon();
		}else if(result.equals("RegPlugCon.do")) {
			command = new RegPlugCon();
		}else if(result.equals("UpdatePlugCon.do")) {
			command = new UpdatePlugCon();
		}else if(result.equals("DeletePlugCon.do")) {
			command = new DeletePlugCon();
		}else if(result.equals("UpdatePlugStCon.do")) {
			command = new UpdatePlugStCon();
		}else if(result.equals("UpdateAreaStCon.do")) {
			command = new UpdateAreaStCon();
		}else if(result.equals("UpdateEmpStCon.do")) {
			command = new UpdateEmpStCon();
		}else if(result.equals("RegPlugSenCon.do")) {
			command = new RegPlugSenCon();
		}else if(result.equals("DeletePlugSenCon.do")) {
			command = new DeletePlugSenCon();
		}else if(result.equals("IdCheckCon.do")) {
			command = new IdCheckCon();
		}else if(result.equals("AreaCheckCon.do")) {
			command = new AreaCheckCon();
		}
		
		
		String url = command.execute(request, response);
		
		if(url.equals("true") || url.equals("false")) {
			PrintWriter out = response.getWriter();
			out.print(url);
		}else if(url.equals("")) {
			RequestDispatcher dis = request.getRequestDispatcher(url);
			dis.forward(request, response);
		}else {			
			response.sendRedirect(url);
		}
	}

}
