package com.FrontController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Command.Command;
import com.POJO.DeleteAcCon;
import com.POJO.DeleteAcSenCon;
import com.POJO.DeleteAreaCon;
import com.POJO.DeleteEmpCon;
import com.POJO.DeleteLightCon;
import com.POJO.DeleteLightSenCon;
import com.POJO.DeletePlugCon;
import com.POJO.DeletePlugSenCon;
import com.POJO.LoginCon;
import com.POJO.LogoutCon;
import com.POJO.RegAcCon;
import com.POJO.RegAcSenCon;
import com.POJO.RegAreaCon;
import com.POJO.RegEmpCon;
import com.POJO.RegLightCon;
import com.POJO.RegLightSenCon;
import com.POJO.RegPlugCon;
import com.POJO.RegPlugSenCon;
import com.POJO.UpdateAcCon;
import com.POJO.UpdateAcStCon;
import com.POJO.UpdateAreaStCon;
import com.POJO.UpdateEmp1Con;
import com.POJO.UpdateEmp2Con;
import com.POJO.UpdateEmpStCon;
import com.POJO.UpdateLightCon;
import com.POJO.UpdateLightStCon;
import com.POJO.UpdatePlugCon;
import com.POJO.UpdatePlugStCon;


// 확장자패턴 사용 : 어떤 요청이던 뒤에 .do가 붙어 있으면 이 서블릿에서 받아서 처리
@WebServlet("*.do")
public class FrontController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		// 요청 URI
		String reqURI = request.getRequestURI();
		
		// 프로젝트 명
		String path = request.getContextPath();
		
		// 문자열 자르기 -> reqURI - 프로젝트명/
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
		}else if(result.equals("RegAcCon.do")) {
			command = new RegAcCon();
		}else if(result.equals("RegLightCon.do")) {
			command = new RegLightCon();
		}else if(result.equals("RegPlugSenCon.do")) {
			command = new RegPlugSenCon();
		}else if(result.equals("RegLightSenCon.do")) {
			command = new RegLightSenCon();
		}else if(result.equals("RegAcSenCon.do")) {
			command = new RegAcSenCon();
		}else if(result.equals("UpdateAcCon.do")) {
			command = new UpdateAcCon();
		}else if(result.equals("UpdateAcStCon.do")) {
			command = new UpdateAcStCon();
		}else if(result.equals("UpdateLightCon.do")) {
			command = new UpdateLightCon();
		}else if(result.equals("UpdateLightStCon.do")) {
			command = new UpdateLightStCon();
		}else if(result.equals("DeleteAcCon.do")) {
			command = new DeleteAcCon();
		}else if(result.equals("DeleteAcSenCon.do")) {
			command = new DeleteAcSenCon();
		}else if(result.equals("DeleteLightCon.do")) {
			command = new DeleteLightCon();
		}else if(result.equals("DeleteLightSenCon.do")) {
			command = new DeleteLightSenCon();
		}else if(result.equals("DeletePlugSenCon.do")) {
			command = new DeletePlugSenCon();
		}
		
		String url = command.execute(request, response);
		response.sendRedirect(url);
	}

}
