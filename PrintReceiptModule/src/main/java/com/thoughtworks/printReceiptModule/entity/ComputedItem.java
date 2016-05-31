/**
 * 
 */
package com.thoughtworks.printReceiptModule.entity;

import java.util.ArrayList;

/**
 * 该类描述了经过打折处理后的所有信息
 * @author Peter King
 *
 */
public class ComputedItem {
	private ArrayList<ComputedGoods> allPayGoods;
	private ArrayList<ComputedGoods> freegoods;
	private double totalPrice;
	private double freeTotalPrice;
	
	public ComputedItem(ArrayList<ComputedGoods> allPayGoods,
			ArrayList<ComputedGoods> freegoods, double totalPrice,
			double freeTotalPrice) {
		super();
		this.allPayGoods = allPayGoods;
		this.freegoods = freegoods;
		this.totalPrice = totalPrice;
		this.freeTotalPrice = freeTotalPrice;
	}
	public ArrayList<ComputedGoods> getAllPayGoods() {
		return allPayGoods;
	}
	public void setAllPayGoods(ArrayList<ComputedGoods> allPayGoods) {
		this.allPayGoods = allPayGoods;
	}
	public ArrayList<ComputedGoods> getFreegoods() {
		return freegoods;
	}
	public void setFreegoods(ArrayList<ComputedGoods> freegoods) {
		this.freegoods = freegoods;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public double getFreeTotalPrice() {
		return freeTotalPrice;
	}
	public void setFreeTotalPrice(double freeTotalPrice) {
		this.freeTotalPrice = freeTotalPrice;
	}
	
	

}
