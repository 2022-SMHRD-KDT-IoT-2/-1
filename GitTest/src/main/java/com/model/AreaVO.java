package com.model;

public class AreaVO {
	 // ���� ���̵� 
    private String areaId;
    // ��� ���� 
    private String areaStatus;
    // ���� �� 
    private String areaName;
    
	public AreaVO(String areaId, String areaStatus, String areaName) {
		super();
		this.areaId = areaId;
		this.areaStatus = areaStatus;
		this.areaName = areaName;
	}
	
	public String getAreaId() {
		return areaId;
	}
	public String getAreaStatus() {
		return areaStatus;
	}
	public String getAreaName() {
		return areaName;
	}
}
