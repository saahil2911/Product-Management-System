package com.productSpringBoot.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class ProductInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	private int prodID;
	private String prodName;
	private int prodQty;
	private int prodPrice;
	
	

	public ProductInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductInfo(int iD, int prodID, String prodName, int prodQty, int prodPrice) {
		super();
		ID = iD;
		this.prodID = prodID;
		this.prodName = prodName;
		this.prodQty = prodQty;
		this.prodPrice = prodPrice;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getProdID() {
		return prodID;
	}

	public void setProdID(int prodID) {
		this.prodID = prodID;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getProdQty() {
		return prodQty;
	}

	public void setProdQty(int prodQty) {
		this.prodQty = prodQty;
	}

	public int getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}

	@Override
	public String toString() {
		return "ProductInfo [ID=" + ID + ", prodID=" + prodID + ", prodName=" + prodName + ", prodQty=" + prodQty
				+ ", prodPrice=" + prodPrice + "]";
	}

}
