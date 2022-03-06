package rfid;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.EmployeeDAO;
import com.DAO.RfidDAO;

@WebServlet("/Rfid_read")
public class Rfid_read extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uid = request.getParameter("uid"); // �Ƶ��̳뿡�� uid���� �޾ƿ´�.
		PrintWriter out = response.getWriter();
		System.out.println(uid); // ���Ȯ��
		out.println(uid); // ���Ȯ��

//		String uid = "1234";
		RfidDAO R_dao = new RfidDAO();
		EmployeeDAO E_dao = new EmployeeDAO();

		String empid = R_dao.select_empid(uid);
		System.out.println(empid);
		R_dao.regLog("1", empid); // (LOG_TYPE = 1) �� RFID�α� - ���̺� ����

		if (empid == null) {

			System.out.println("�ش����̾����.");
		}
		// 1. uid�� ������ read�ϰ� ���� status���� �������� �����;���.
		// 1-1. �׷��ٸ� ������ �� Ȯ���ϰ� �����ؾ���.
		// 2. ������ status���� ���� ������ �޶���.

		else {
			String status = E_dao.select_status(uid);
			System.out.println("���°� : " + status);
			
			if (status.equals("0")) {
				E_dao.updateStatus(uid, "1");
				System.out.println("���°��� 0");
			} else {
				E_dao.updateStatus(uid, "0");
				System.out.println("���°��� 1");
			}
		}

	}

}
