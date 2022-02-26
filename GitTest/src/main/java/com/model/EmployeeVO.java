package com.model;

public class EmployeeVO {
	// ��� ���̵� 
    private String empId;
	// ��� ��й�ȣ 
    private String empPw;
    // ��� �̸� 
    private String empName;
    // ��� �¼���ȣ 
    private String empSeatNo;
    // ��� ��ȭ 
    private String empPhone;
    // ��� ���� 
    private String empStatus;
    // ��� �������� 
    private String empJoindate;
    // ��� ���̵� 
    private String empSuperId;
    // ������ ���� 
    private String adminYn;
    // �˿����ڵ� 
    private String rfidUid;
    // ���� ���̵� 
    private String areaId;
    // �÷��� ���� 
    private int plugSeq;
    
    // ��ü
    public EmployeeVO(String empId, String empPw, String empName, String empSeatNo, String empPhone, String empStatus,
			String empJoindate, String empSuperId, String adminYn, String rfidUid, String areaId, int plugSeq) {
		super();
		this.empId = empId;
		this.empPw = empPw;
		this.empName = empName;
		this.empSeatNo = empSeatNo;
		this.empPhone = empPhone;
		this.empStatus = empStatus;
		this.empJoindate = empJoindate;
		this.empSuperId = empSuperId;
		this.adminYn = adminYn;
		this.rfidUid = rfidUid;
		this.areaId = areaId;
		this.plugSeq = plugSeq;
	}
    
    // ��ȸ��
	public EmployeeVO(String empId, String empName, String empSeatNo, String empStatus, String empSuperId,
			String adminYn, String rfidUid, String areaId, int plugSeq) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSeatNo = empSeatNo;
		this.empStatus = empStatus;
		this.empSuperId = empSuperId;
		this.adminYn = adminYn;
		this.rfidUid = rfidUid;
		this.areaId = areaId;
		this.plugSeq = plugSeq;
	}

	// �����ڿ� ȸ������ ����
	public EmployeeVO(String empId, String empName, String empSeatNo, String empPhone, String empStatus,
			String empJoindate, String empSuperId, String adminYn, String rfidUid, String areaId, int plugSeq) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSeatNo = empSeatNo;
		this.empPhone = empPhone;
		this.empSuperId = empSuperId;
		this.adminYn = adminYn;
		this.rfidUid = rfidUid;
		this.areaId = areaId;
		this.plugSeq = plugSeq;
	}

	//������ ȸ������ ����
	public EmployeeVO(String empId, String empPw, String empPhone) {
		super();
		this.empId = empId;
		this.empPw = empPw;
		this.empPhone = empPhone;

	}

	public String getEmpId() {
    	return empId;
    }
    public String getEmpPw() {
    	return empPw;
    }
    public String getEmpName() {
    	return empName;
    }
    public String getEmpSeatNo() {
    	return empSeatNo;
    }
    public String getEmpPhone() {
    	return empPhone;
    }
    public String getEmpStatus() {
    	return empStatus;
    }
    public String getEmpJoindate() {
    	return empJoindate;
    }
    public String getEmpSuperId() {
    	return empSuperId;
    }
    public String getAdminYn() {
    	return adminYn;
    }
    public String getRfidUid() {
    	return rfidUid;
    }
    public String getAreaId() {
    	return areaId;
    }
    public int getPlugSeq() {
    	return plugSeq;
    }
}
