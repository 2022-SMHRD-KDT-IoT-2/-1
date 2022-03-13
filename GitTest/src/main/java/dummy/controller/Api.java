package dummy.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.EmployeeDAO;
import com.DAO.PlugSenDAO;
import com.VO.EmployeeVO;
import com.google.gson.Gson;
import com.google.gson.JsonObject;


@WebServlet("/Api")
public class Api extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String seq = request.getParameter("seq"); // �÷��׹�ȣ ���޹���
		System.out.println("seq : "+seq);
		Date date_now = new Date(System.currentTimeMillis()); // ����ð��� ������ Date������ �����Ѵ�
		SimpleDateFormat fourteen_format = new SimpleDateFormat("HHmmss");  // ����
		int time =  Integer.parseInt(fourteen_format.format(date_now));
//		System.out.println(time); // �ð�, �и� ��������.
		String a = "" + time;
		String b = a.substring(0,2);
		String c = a.substring(2,4);
		String d = a.substring(4,6);
		String e = b+ ":" + c + ":"+d;
		
		if(seq.equals("-1") ) {
			Gson gson = new Gson();
			JsonObject jsonObject = new JsonObject();
			PlugSenDAO dao = new PlugSenDAO();
			jsonObject.addProperty("min", e);
			jsonObject.addProperty("value", dao.selectall());
			System.out.println("-1�϶� if���� ���Ӵ�.");
//			System.out.println("�ֱ� ���°� : "+ dao.selectone(seq1));
			// JsonObject�� Json ���ڿ��� ��ȯ
			String jsonStr = gson.toJson(jsonObject);
			// ������ Json ���ڿ� ���
			
			response.setStatus(200);
			response.setCharacterEncoding("euc-kr");				
			response.setContentType("application/json");
			response.getWriter().write(jsonStr);
		}
		else {
			int seq1 = Integer.parseInt(seq);
			System.out.println("���޹��� seq : "+ seq1);
			Gson gson = new Gson();
			JsonObject jsonObject = new JsonObject();
			PlugSenDAO dao = new PlugSenDAO();
			jsonObject.addProperty("min", e);
			jsonObject.addProperty("value", dao.selectone(seq1));	
			System.out.println("�ֱ� ���°� : "+ dao.selectone(seq1));
			// JsonObject�� Json ���ڿ��� ��ȯ
			String jsonStr = gson.toJson(jsonObject);
			// ������ Json ���ڿ� ���
			
			response.setStatus(200);
			response.setCharacterEncoding("euc-kr");				
			response.setContentType("application/json");
			response.getWriter().write(jsonStr);
		}
		
	}

}
