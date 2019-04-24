package com.hksoftworks.model;

import java.io.Serializable;
import java.util.Date;

public class Reimbursement {

	private int requestNum;
	private int empId;
	private String reason;
	private double amount;
	private int approvedBy;
	private String status;
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursement(int requestNum, int empId, String reason, double amount, int approvedBy, String status) {
		super();
		this.requestNum = requestNum;
		this.empId = empId;
		this.reason = reason;
		this.amount = amount;
		this.approvedBy = approvedBy;
		this.status = status;
	}

	public int getRequestNum() {
		return requestNum;
	}

	public void setRequestNum(int requestNum) {
		this.requestNum = requestNum;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(int approvedBy) {
		this.approvedBy = approvedBy;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Reimbursement [requestNum=" + requestNum + ", empId=" + empId + ", reason=" + reason + ", amount="
				+ amount + ", approvedBy=" + approvedBy + ", status=" + status + "]";
	}
	
	
}
