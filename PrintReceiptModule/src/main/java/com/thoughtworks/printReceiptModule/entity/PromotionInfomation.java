/**
 * 
 */
package com.thoughtworks.printReceiptModule.entity;

import java.util.ArrayList;

/**
 * 该类描述了所有的打折信息
 * @author Peter King
 *
 */
public class PromotionInfomation {
	private String promotionName;
	private ArrayList<String> promotionBarcodes;
	
	public PromotionInfomation(String promotionName,
			ArrayList<String> promotionBarcodes) {
		super();
		this.promotionName = promotionName;
		this.promotionBarcodes = promotionBarcodes;
	}
	public String getPromotionName() {
		return promotionName;
	}
	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}
	public ArrayList<String> getPromotionBarcodes() {
		return promotionBarcodes;
	}
	public void setPromotionBarcodes(ArrayList<String> promotionBarcodes) {
		this.promotionBarcodes = promotionBarcodes;
	}

}
