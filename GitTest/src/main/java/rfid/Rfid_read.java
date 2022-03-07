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
		String status = R_dao.select_status(uid); // rfid ��� ���� ���� ����

		System.out.println(empid);
		System.out.println(status);
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
		if(time > 0600 && time <= 1000) {
				if(status.equals("0")) {
					System.out.println("�������");
					type = "1";					
				}else {
					System.out.println("������");
					type = "6";										
				}
		
		}else if(time > 1000 && time <= 1200) {
			if(status.equals("0")) {
				System.out.println("����");
				type = "2";					
			}else {
				System.out.println("����");
				type = "3";										
			}
		}else if(time > 1200 && time <= 1300) {
			if(status.equals("0")) {
				System.out.println("����");
				type = "9";					
			}else {
				System.out.println("����");
				type = "8";										
			}
		}else if(time > 1300 && time <= 1900) {
			if(status.equals("0")) {
				System.out.println("�߰�");
				type = "A";					
			}else {
				System.out.println("����");
				type = "3";										
			}
		}else if(time > 1900 && time <= 0600) {
			if(status.equals("0")) {
				System.out.println("�߰�");
				type = "A";					
			}else {
				System.out.println("���");
				type = "0";										
			}
		}
		// �ָ��� ��� �ָ����, �ָ���ٷ� ����
		
		if(type.equals("1") || type.equals("2") || type.equals("4") || type.equals("9") || type.equals("A")) {
			status = "1";
		}else {
			status = "0";
		}
		
		
		EmployeeDAO eDao = new EmployeeDAO();
		PlugDAO pDao = new PlugDAO();
		RfidDAO rDao = new RfidDAO();
		rDao.regLog(type, empid);
		
		eDao.updateStatus(empid, status);
		
		AreaDAO aDao = new AreaDAO();
		ArrayList<EmployeeVO> al1 = eDao.selectArea(); //����ڰ� �ִ� ����
		ArrayList<EmployeeVO> al2 = eDao.selectArea2(); //��Ǳ���

		if(al1.size() != 0) {
			for(int i = 0; i<al1.size(); i++) {
				aDao.updateStatus(al1.get(i).getAreaId(), "1");
			}			
		}
		if(al2.size() != 0) {			
			for(int i = 0; i<al2.size(); i++) {
				aDao.updateStatus(al2.get(i).getAreaId(), "0");				
			}
		}
		
		ArrayList<PlugVO> al3 = pDao.selectList1(empid);
		for(int i = 0; i<al3.size(); i++) {
			pDao.updateStatus(al3.get(i).getPlugSeq(), status);
		}
		
	
		ArrayList<PlugVO> al4 = pDao.selectList2("1");
		for(int i = 0; i<al4.size(); i++) {
			pDao.updateStatus(al4.get(i).getPlugSeq(), status);				
		}
		
		// �溰 ����(�⺻ �����ð�)
		if(time > 0600 && time <= 2000) {
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
					pDao.updateStatus(al8.get(i).get(j).getPlugSeq(), "0");
					System.out.println("al8:"+al8.get(i).get(j).getPlugSeq());
				}
			}
			for(int i = 0; i<al7.size(); i++) {
				for(int j = 0; j<al7.get(i).size(); j++) {				
					pDao.updateStatus(al7.get(i).get(j).getPlugSeq(), "1");
					System.out.println("al7:"+al7.get(i).get(j).getPlugSeq());
				}
			}
			
		}else {
			// ���������� (���ܽð���)
			ArrayList<AreaVO> al13 = aDao.getArea("1");
			ArrayList<AreaVO> al14 = aDao.getArea("0");
			ArrayList<ArrayList<PlugVO>> al15 = new ArrayList<ArrayList<PlugVO>>();
			ArrayList<ArrayList<PlugVO>> al16 = new ArrayList<ArrayList<PlugVO>>();
			
			
			for(int i = 0; i<al13.size(); i++) {
				al15.add(pDao.selectList3(al13.get(i).getAreaId()));
			}
			for(int i = 0; i<al14.size(); i++) {
				al16.add(pDao.selectList3(al14.get(i).getAreaId()));				
			}
			for(int i = 0; i<al15.size(); i++) {
				for(int j = 0; j<al15.get(i).size(); j++) {				
					pDao.updateStatus(al15.get(i).get(j).getPlugSeq(), "1");
					System.out.println("al15:"+al15.get(i).get(j).getPlugSeq());
				}
			}
			for(int i = 0; i<al16.size(); i++) {
				for(int j = 0; j<al16.get(i).size(); j++) {				
					pDao.updateStatus(al16.get(i).get(j).getPlugSeq(), "0");
					System.out.println("al16:"+al16.get(i).get(j).getPlugSeq());
				}
			}
		}
		
		
		
		
		ArrayList<PlugVO> al9 = pDao.selectFixed("1");
		ArrayList<PlugVO> al10 = pDao.selectFixed("2");
		for(int i = 0; i<al9.size(); i++) {
			pDao.updateStatus(al9.get(i).getPlugSeq(), "1");
		}
		for(int i = 0; i<al10.size(); i++) {
			pDao.updateStatus(al10.get(i).getPlugSeq(), "0");
		}
		
		ArrayList<PlugVO> al11 = pDao.selectStatus("1");
		ArrayList<PlugVO> al12 = pDao.selectStatus("0");
		
		for(int i = 0; i<al11.size(); i++) {
			System.out.println("al11:"+al11.get(i).getPlugSeq());
		}
		for(int i = 0; i<al12.size(); i++) {
			System.out.println("al12:"+al12.get(i).getPlugSeq());
		}
		


	}

}
