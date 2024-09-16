package com.example.demo;

public class Products implements Comparable<Products> {
	public int productId;
	public String productName;
	public int productPrice;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public Products(int productId, String productName, int productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	@Override
	public int compareTo(Products o) {
		// TODO Auto-generated method stub
		return productId-o.productId;
	}
	public String toString()
	{
		return getProductId()+" "+getProductName()+" "+getProductPrice();
	}
	}
	
