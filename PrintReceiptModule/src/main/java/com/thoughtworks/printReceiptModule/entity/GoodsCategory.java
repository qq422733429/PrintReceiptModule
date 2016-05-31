package com.thoughtworks.printReceiptModule.entity;

/**
 * 该类描述了商品的目录信息
 * @author Peter King
 *
 */
public class GoodsCategory implements Cloneable {
	private String category;
	private String subCategory;
	
	public GoodsCategory(String category, String subCategory) {
		super();
		this.category = category;
		this.subCategory = subCategory;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	
	public String toString(){
		return "主类别："+category+"子类别："+subCategory;
	}
	public GoodsCategory clone(){
		return new GoodsCategory(category, subCategory);
	}
	
	public Boolean checkNull(){
		if(category.equals("")||subCategory.equals(""))
			return false;
		else
			return true;
	}
	
	
	
	
	
	
	
}
