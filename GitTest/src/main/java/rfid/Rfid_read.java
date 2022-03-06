package rfid;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.AreaDAO;
import com.DAO.EmployeeDAO;
import com.DAO.PlugDAO;
import com.DAO.RfidDAO;
import com.VO.AreaVO;
import com.VO.EmployeeVO;
import com.VO.PlugVO;

@WebServlet("/Rfid_read")
public class Rfid_read extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String uid = request.getParameter("uid"); // �Ƶ��̳뿡�� uid���� �޾ƿ´�.
//		PrintWriter out = response.getWriter();
//		System.out.println(uid); // ���Ȯ��
//		out.println(uid); // ���Ȯ��

		String uid = "1234";
		RfidDAO R_dao = new RfidDAO();
		EmployeeDAO E_dao = new EmployeeDAO();

		String empid = R_dao.select_empid(uid);
		System.out.println(empid);
//		R_dao.regLog("1", empid); // (LOG_TYPE = 1) �� RFID�α� - ���̺� ����

//		if (empid == null) {
//
//			System.out.println("�ش����̾����.");
//		}
		// 1. uid�� ������ read�ϰ� ���� status���� �������� �����;���.
		// 1-1. �׷��ٸ� ������ �� Ȯ���ϰ� �����ؾ���.
		// 2. ������ status���� ���� ������ �޶���.

//		else {
//			String status = E_dao.select_status(uid);
//			System.out.println("���°� : " + status);
//			
//			if (status.equals("0")) {
//				E_dao.updateStatus(uid, "1");
//				System.out.println("���°��� 0");
//			} else {
//				E_dao.updateStatus(uid, "0");
//				System.out.println("���°��� 1");
//			}
//		}
		
		String type = "";
		Date date_now = new Date(System.currentTimeMillis()); // ����ð��� ������ Date������ �����Ѵ�
		SimpleDateFormat fourteen_format = new SimpleDateFormat("HHmm");  // ����
		int time =  Integer.parseInt(fourteen_format.format(date_now));
		System.out.println(time); // �ð�, �и� ��������.
		
		// ���ǽ��� �ٲ� ��(���� ����)
		if(time >= 0600 && time <= 1800) {
			System.out.println("�������");
			type = "1";
		}
		else {
			System.out.println("�������");
			type = "3";
		}
		
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		int e = 0;
		int f = 0;
		int g = 0;
		int h = 0;
		
		
		RfidDAO rDao = new RfidDAO();
		a = rDao.regLog(type, empid);
		
		EmployeeDAO eDao = new EmployeeDAO();
		String status = "1";
		b = eDao.updateStatus(uid, status);
		
		AreaDAO aDao = new AreaDAO();
		ArrayList<EmployeeVO> al1 = eDao.selectArea(); //����ڰ� �ִ� ����
		ArrayList<EmployeeVO> al2 = eDao.selectArea2(); //��Ǳ���

		if(al1.size() != 0) {
			for(int i = 0; i<al1.size(); i++) {
				c += aDao.updateStatus(al1.get(i).getAreaId(), "1");
			}			
		}
		if(al2.size() != 0) {			
			for(int i = 0; i<al2.size(); i++) {
				d += aDao.updateStatus(al2.get(i).getAreaId(), "0");				
			}
		}
		
		PlugDAO pDao = new PlugDAO();
		ArrayList<PlugVO> al3 = pDao.selectList1(empid);
		ArrayList<PlugVO> al4 = pDao.selectList2("1");
		for(int i = 0; i<al3.size(); i++) {
			e += pDao.updateStatus(al3.get(i).getPlugSeq(), "1");
		}
		for(int i = 0; i<al4.size(); i++) {
			f += pDao.updateStatus(al4.get(i).getPlugSeq(), "1");				
		}
		
		ArrayList<AreaVO> al5 = aDao.getRoom("1");
		ArrayList<AreaVO> al6 = aDao.getRoom("0");
		ArrayList<ArrayList<PlugVO>> al7 = new ArrayList<ArrayList<PlugVO>>();
		ArrayList<ArrayList<PlugVO>> al8 = new ArrayList<ArrayList<PlugVO>>();

		for(int i = 0; i<al5.size(); i++) {
			al7.add(pDao.selectList3(al5.get(i).getAreaId()));
		}
		for(int i = 0; i<al6.size(); i++) {
			al8.add(pDao.selectList3(al6.get(i).getAreaId()));				
		}
		for(int i = 0; i<al8.size(); i++) {
			for(int j = 0; j<al8.get(i).size(); j++) {				
				h += pDao.updateStatus(al8.get(i).get(j).getPlugSeq(), "0");
				System.out.println("al8:"+al8.get(i).get(j).getPlugSeq());
			}
		}
		for(int i = 0; i<al7.size(); i++) {
			for(int j = 0; j<al7.get(i).size(); j++) {				
				g += pDao.updateStatus(al7.get(i).get(j).getPlugSeq(), "1");
				System.out.println("al7:"+al7.get(i).get(j).getPlugSeq());
			}
		}
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
		System.out.println(h);

	}

}
