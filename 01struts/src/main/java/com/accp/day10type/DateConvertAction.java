package cn.ognl.action;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class DateConvertAction extends ActionSupport {
	private Date timeDate;

	public String execute(){
		return SUCCESS;
	}
	
	public Date getTimeDate() {
		return timeDate;
	}

	public void setTimeDate(Date timeDate) {
		this.timeDate = timeDate;
	}
}
