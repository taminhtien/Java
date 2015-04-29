package com.tientm.hibernate.beans;

// Trong trường hợp cần lấy dữ liệu một số cột trên một số bảng -> dùng Java Bean
// Class Java Bean sẽ có một cấu tử để khởi tạo giá trị các trường của nó
// Cấu tử này tham gia vào câu truy vấn HQL

public class ShortEmpInfo {
	private Long empId;
	private String empNo;
	private String empName;

	// Cấu tử có 3 tham số, sẽ được sử dụng trong Hibenate Query
	public ShortEmpInfo(Long empId, String empNo, String empName) {
		super();
		this.empId = empId;
		this.empNo = empNo;
		this.empName = empName;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public String toString() {
		return "ShortEmpInfo [empId=" + empId + ", empNo=" + empNo
				+ ", empName=" + empName + "]";
	}
}
