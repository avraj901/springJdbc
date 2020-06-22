package com.nt.vo;

public class EmployeeVO {

	private String employeename;
	private double employeesalary;
	private String employeeemail;
	private String employeegender;
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public double getEmployeesalary() {
		return employeesalary;
	}
	public void setEmployeesalary(double employeesalary) {
		this.employeesalary = employeesalary;
	}
	public String getEmployeeemail() {
		return employeeemail;
	}
	public void setEmployeeemail(String employeeemail) {
		this.employeeemail = employeeemail;
	}
	public String getEmployeegender() {
		return employeegender;
	}
	public void setEmployeegender(String employeegender) {
		this.employeegender = employeegender;
	}
	@Override
	public String toString() {
		return "EmployeeVO [employeename=" + employeename + ", employeesalary=" + employeesalary + ", employeeemail="
				+ employeeemail + ", employeegender=" + employeegender + "]";
	}
	
	
}
