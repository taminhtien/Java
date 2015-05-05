package com.tientm.hibernate.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Thực thể Phòng ban
 * 
 * @author tientm
 *
 */

// Phần tử (element) name của @Entity là không bắt buộc.
// Entity khớp với một bảng lấy theo tên theo thứ tự ưu tiên:
// 1 - name trong @Table
// 2 - name trong @Entity
// 3 - name của class.
// @Entity chú thích một class là một Entity.
// Việc chỉ định rõ name của @Entity cho phép viết ngắn câu HSQL
@Entity
// @Table cho phép chú thích tên bảng
// Các giàng buộc duy nhất trong bảng.
// Phần tử name không bắt buộc.
// Nếu bạn không chỉ rõ tên bảng trong phần tử name ...
// .. Hibernate sẽ dựa vào phần tử name của @Entity sau đó mới
// tới tên của class.
@Table(name = "DEPARTMENT", uniqueConstraints = { @UniqueConstraint(columnNames = { "DEPT_NO" }) })
public class Department {
	private Integer deptId;
	private String deptNo;
	private String deptName;
	private String location;

	private Set<Employee> employees = new HashSet<Employee>(0);

	public Department() {
	}

	public Department(Integer deptId, String deptName, String location) {
		this.deptId = deptId;
		this.deptNo = "D" + this.deptId;
		this.deptName = deptName;
		this.location = location;
	}

	@Id
	// Khóa chính của bảng
	@Column(name = "DEPT_ID")
	// Tên cột trong bảng
	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	@Column(name = "DEPT_NAME", nullable = false)
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Column(name = "DEPT_NO", length = 20, nullable = false)
	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	@Column(name = "LOCATION")
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	// Một department có nhiều employee -> quan hệ 1 - N
	// -> OneToMany
	// 1 object department sẽ có một set các Employee
	// -> nó sẽ qua class Employee tìm những employee có cùng "department"
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}
