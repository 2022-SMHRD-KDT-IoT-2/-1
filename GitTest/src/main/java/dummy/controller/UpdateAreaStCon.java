package dummy.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.AreaDAO;
import com.DAO.EmployeeDAO;
import com.VO.EmployeeVO;


@WebServlet("/UpdateAreaStCon")
public class UpdateAreaStCon extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("euc-kr");
//		int cnt = 0;
//		AreaDAO dao = new AreaDAO();
//		String statusA = "Z";
//		
//		// ���°��� ���� �Ѿ�� ���(��������)
//		String aid = request.getParameter("aid");	
////			statusA = request.getParameter("statusA");
//		
//		// ���°��� �ڵ����� �����ؾ� �ϴ� ���
//		if(statusA.equals("Z")) {
//			// A -> ��ǻ��·� ����, B-A(������) -> ��ǻ��·� ����
//			EmployeeDAO eDao = new EmployeeDAO();
////			ArrayList<EmployeeVO> al1 = eDao.selectArea("1"); //����ڰ� �ִ� ����
////			ArrayList<EmployeeVO> al2 = eDao.selectArea("0"); //����ڰ� �ִ� ����
////			al2.removeAll(al1);
////			for(int i = 0; i<al1.size(); i++) {
////				cnt = dao.updateStatus(al1.get(i).getAreaId(), "1");
////			}
////			for(int i = 0; i<al2.size(); i++) {
////				cnt = dao.updateStatus(al2.get(i).getAreaId(), "0");				
////			}
////		}else {
////			cnt = dao.updateStatus(aid, statusA);			
////		}
//		
//		
//		if(cnt>0) {
//			RequestDispatcher dispatcher = request.getRequestDispatcher("UpdatePlugStCon");
//			dispatcher.forward(request, response);
//		}else {
//			response.sendRedirect("main.jsp");
//		}
	}

}
