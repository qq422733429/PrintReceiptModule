package com.thoughtworks.printReceiptModule.entity;
/**
 * 该类描述了商品的全部信息
 * @author Peter King
 *
 */

public class Goods {
	
	
	private String name;
	private String barcode;
	private Unit unit;
	private GoodsCategory goodsCategory;
	private double price;
	
	
	public Goods(String name, String barcode, Unit unit,
			GoodsCategory goodsCategory, double price) {
		super();
		this.name = name;
		this.barcode = barcode;
		this.unit = unit;
		this.goodsCategory = goodsCategory;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Unit getUnit() {
		return unit;
	}
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	public GoodsCategory getGoodsCategory() {
		return goodsCategory;
	}
	public void setGoodsCategory(GoodsCategory goodsCategory) {
		this.goodsCategory = goodsCategory;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getBarcode() {
		return barcode;
	}
	
	public Boolean checkNull(){
		if(barcode.equals("")||name.equals("")||barcode.equals(0)||unit==null||goodsCategory==null)
			return false;
		else
			return true;
	}
	
	
	
	
	
	


}
