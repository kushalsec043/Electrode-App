package com.shopping.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class CardInfo
{
	@Id
	private int user_id;
	private String card_no;
	private String nameon;
	private String expirn;
	private int cvv;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getCard_no() {
		return card_no;
	}
	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}
	public String getNameon() {
		return nameon;
	}
	public void setNameon(String nameon) {
		this.nameon = nameon;
	}
	public String getExpirn() {
		return expirn;
	}
	public void setExpirn(String expirn) {
		this.expirn = expirn;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	
	
}
