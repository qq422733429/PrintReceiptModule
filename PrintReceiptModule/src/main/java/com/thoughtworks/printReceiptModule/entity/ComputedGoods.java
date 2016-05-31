/**
 * 
 */
package com.thoughtworks.printReceiptModule.entity;

/**
 * 该类描述了经过处理后的商品信息
 * @author Peter King
 *
 */
public class ComputedGoods {
	private String name;
	private int num;
	private double price;
	private double totalPrice;
	private String unit;
	
	
	public ComputedGoods(String name, int num, double price, double totalPrice,String unit) {
		super();
		this.name = name;
		this.num = num;
		this.price = price;
		this.totalPrice = totalPrice;
		this.unit = unit;
	}
	
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	

}
