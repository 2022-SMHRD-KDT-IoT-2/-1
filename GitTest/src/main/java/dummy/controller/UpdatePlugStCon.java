package dummy.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.PlugDAO;
import com.VO.PlugVO;


@WebServlet("/UpdatePlugStCon")
public class UpdatePlugStCon extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		PlugDAO dao = new PlugDAO();
		int cnt = 0;
		String id = request.getParameter("id");
		String set = "1";
		String statusP = "Z";
	
		// ���°��� ���� �Ѿ�� ���(��������)
		int plug = Integer.parseInt(request.getParameter("plug"));
//	    	statusP = request.getParameter("statusP");	    	
		
		// ���⼭�� �÷��� ���� �ʿ�
	    if(statusP.equals("Z")) {
			PlugDAO pDao = new PlugDAO();
			ArrayList<PlugVO> al1 = pDao.selectList1(id);
			ArrayList<PlugVO> al2 = pDao.selectList2("1");
			for(int i = 0; i<al1.size(); i++) {
				cnt = dao.updateStatus(al1.get(i).getPlugSeq(), "1");
			}
			for(int i = 0; i<al2.size(); i++) {
				cnt = dao.updateStatus(al2.get(i).getPlugSeq(), "1");				
			}
		}else {
			cnt = dao.updateStatus(plug, statusP);			
		}
	    
	    // ��� �� ��Ʈ�ѷ��� �������� �ɰ� ������ �б��ϰ� �ϴ°� ��Ȯ�ҵ�
		
	    if(cnt>0) {
	    	RequestDispatcher dispatcher = null;
	    	if(set.equals("1")) {	 
	    	    dispatcher = request.getRequestDispatcher("UpdatePlugStCon2");
	    	}else {
	    		dispatcher = request.getRequestDispatcher("#");	    		
	    	}
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("main.jsp");
		}
	}

}
