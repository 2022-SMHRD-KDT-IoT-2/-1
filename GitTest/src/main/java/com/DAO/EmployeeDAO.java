package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.VO.EmployeeVO;


public class EmployeeDAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	public void connect() {
		try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net";
			String dbid = "campus_d_3_0216";
			String dbpw = "smhrd3";			
			conn = DriverManager.getConnection(url, dbid, dbpw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public EmployeeVO login(String id, String pw) {
		EmployeeVO vo = null;
		
		try {
			connect();

			String sql = "select * from t_employee where emp_id = ? and emp_pw = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);

			
			rs = psmt.executeQuery();
			
			if(rs.next()){
				String getid = rs.getString(1);
				String getpw = rs.getString(2);
				String getname = rs.getString(3);
				String getseat = rs.getString(4);
				String getphone = rs.getString(5);
				String getstatus = rs.getString(6);
				String getjoindate = rs.getString(7);
				String getsuperid = rs.getString(8);
				String getadminyn = rs.getString(9);
				String getrfid = rs.getString(10);
				String getarea = rs.getString(11);
				int getplug = rs.getInt(12);
			
			    vo = new EmployeeVO(getid, getname, getseat, getstatus, getsuperid, getadminyn, getrfid, getarea, getplug);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}
	
	public ArrayList<EmployeeVO> selectAll(){

		ArrayList<EmployeeVO> al = new ArrayList<EmployeeVO>();
		
		try {
			connect();
			
			String sql = "select emp_id, emp_name, emp_seat_no, emp_status, emp_super_id, admin_yn, rfid_uid, area_id, plug_seq from t_employee";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();	
			
			while(rs.next()){
				String getid = rs.getString(1);
				String getname = rs.getString(2);
				String getseat = rs.getString(3);
				String getstatus = rs.getString(4);
				String getsuperid = rs.getString(5);
				String getadminyn = rs.getString(6);
				String getrfid = rs.getString(7);
				String getarea = rs.getString(8);
				int getplug = rs.getInt(9);
				
				EmployeeVO vo = new EmployeeVO(getid, getname, getseat, getstatus, getsuperid, getadminyn, getrfid, getarea, getplug);
				al.add(vo);
			}		
						
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close();
		}
		return al;

	}

	public EmployeeVO selectOne(String id) {
		EmployeeVO vo = null;
	
		try {
			connect();
			
			String sql = "select emp_id, emp_name, emp_seat_no, emp_phone, emp_status, emp_joindate, emp_super_id, admin_yn, rfid_uid, area_id, plug_seq from t_employee where emp_id = ?";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			psmt.setString(1, id);
			
			if(rs.next()){
				String getid = rs.getString(1);
				String getname = rs.getString(2);
				String getseat = rs.getString(3);
				String getphone = rs.getString(4);
				String getstatus = rs.getString(5);
				String getjoindate = rs.getString(6);
				String getsuperid = rs.getString(7);
				String getadminyn = rs.getString(8);
				String getrfid = rs.getString(9);
				String getarea = rs.getString(10);
				int getplug = rs.getInt(11);
				
				vo = new EmployeeVO(getid, getname, getseat, getphone, getstatus, getjoindate, getsuperid, getadminyn, getrfid, getarea, getplug);
			}		
						
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;

	}
		
	
	// ���� ���� ��, �⺻ pw�� id�� �����ϰ� ����(����ڰ� ���� pw �����ϰԲ�)
	// ���� ���� ��, ���� ���� D(����Ʈ)�� ����
	public int regEmp(String id, String name, String seat, String phone, String superid, String yn, String rfid, String area, int plug) {
		int cnt = 0;
		
		try {
			connect();
			
			String sql = "insert into t_employee values (?, ?, ?, ?, ?, D, sysdate, ?, ?, ?, ?, ?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, id);
			psmt.setString(3, name);
			psmt.setString(4, seat);
			psmt.setString(5, phone);
			psmt.setString(6, superid);
			psmt.setString(7, yn);
			psmt.setString(8, rfid);
			psmt.setString(9, area);
			psmt.setInt(10, plug);
			
			cnt = psmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close();
		}
		return cnt;
	}
	
	//�����ڿ� ������������
	public int updateEmp1(String id, String name, String seat, String phone, String superid, String yn, String rfid, String area, int plug) {
		int cnt = 0;
		
		try {
			connect();
			
			String sql = "update t_employee set emp_name = ?, emp_seat_no = ?, emp_phone = ?, emp_super_id = ?, admin_yn = ?, rfid_uid = ?, plug_seq = ? where emp_id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			psmt.setString(2, seat);
			psmt.setString(3, phone);
			psmt.setString(4, superid);
			psmt.setString(5, yn);
			psmt.setString(6, rfid);
			psmt.setString(7, area);
			psmt.setInt(8, plug);
			psmt.setString(9, id);
			
			cnt = psmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close();
		}
		return cnt;
	}
	
	//������ ������������
	public int updateEmp2(String id, String pw, String phone) {
			int cnt = 0;
			
			try {
				connect();
				
				String sql = "update t_employee set emp_pw = ?, emp_phone = ? where emp_id = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, pw);
				psmt.setString(2, phone);
				psmt.setString(3, id);
				
				cnt = psmt.executeUpdate();
				
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				close();
			}
			return cnt;
		}
	
	// ���� ���� ����
	public int deleteEmp(String id) {
		int cnt = 0;
		
		try {
			connect();
			
			String sql = "delete from t_employee where emp_id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			cnt = psmt.executeUpdate();
					
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close();
		}
		return cnt;
	}
}

