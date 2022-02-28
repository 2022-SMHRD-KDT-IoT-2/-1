package com.VO;

public class PlugVO {
	// �÷��� ���� 
    private int plugSeq;
    // �¼� ��ȣ 
    private String seatNo;
    // ������� �� 
    private Double plugPower;
    // �÷��� ���� 
    private String plugStatus;
    // ��ġ ���� 
    private String plugInsDate;
    // ���� ���̵� 
    private String areaId;
    
	public PlugVO(int plugSeq, String seatNo, Double plugPower, String plugStatus, String plugInsDate, String areaId) {
		super();
		this.plugSeq = plugSeq;
		this.seatNo = seatNo;
		this.plugPower = plugPower;
		this.plugStatus = plugStatus;
		this.plugInsDate = plugInsDate;
		this.areaId = areaId;
	}
	public int getPlugSeq() {
		return plugSeq;
	}
	public String getSeatNo() {
		return seatNo;
	}
	public Double getPlugPower() {
		return plugPower;
	}
	public String getPlugStatus() {
		return plugStatus;
	}
	public String getPlugInsDate() {
		return plugInsDate;
	}
	public String getAreaId() {
		return areaId;
	}

}
