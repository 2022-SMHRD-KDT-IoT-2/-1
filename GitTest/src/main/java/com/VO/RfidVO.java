package com.VO;

public class RfidVO {
	// �α� ���� 
    private int logSeq;
    // �α� ���� 
    private String logType;
    // �α� �ð� 
    private String logTime;
    // ��� ���̵� 
    private String empId;
    // �α� �޸� 
    private String logMemo;
    
    
	public RfidVO(int logSeq, String logType, String logTime, String logMemo) {
		super();
		this.logSeq = logSeq;
		this.logType = logType;
		this.logTime = logTime;
		this.logMemo = logMemo;
	}
	
	public int getLogSeq() {
		return logSeq;
	}
	public String getLogType() {
		return logType;
	}
	public String getLogTime() {
		return logTime;
	}
	public String getEmpId() {
		return empId;
	}
	public String getLogMemo() {
		return logMemo;
	}
    
}
