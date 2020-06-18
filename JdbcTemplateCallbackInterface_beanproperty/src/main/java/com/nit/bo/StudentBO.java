package com.nit.bo;

public class StudentBO {

	private int sno;
	private String sname;
	private String saddress;
	private float savg;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public float getSavg() {
		return savg;
	}
	public void setSavg(float savg) {
		this.savg = savg;
	}
	@Override
	public String toString() {
		return "StudentBO [sno=" + sno + ", sname=" + sname + ", saddress=" + saddress + ", savg=" + savg + "]";
	}
	
	
}
