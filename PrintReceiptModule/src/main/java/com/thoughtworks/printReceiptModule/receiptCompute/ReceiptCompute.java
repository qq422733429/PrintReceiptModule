package com.thoughtworks.printReceiptModule.receiptCompute;


import java.util.HashMap;

import org.json.JSONArray;

import com.thoughtworks.printReceiptModule.entity.ComputedItem;
import com.thoughtworks.printReceiptModule.entity.GoodsItem;
import com.thoughtworks.printReceiptModule.entity.PromotionInfomation;
import com.thoughtworks.printReceiptModule.goodsAndCategoryManager.GoodsAndCategoryManager;
/**
 * 该接口给出了处理优惠的类必须实现的方法
 * @author Administrator
 *
 */
public interface ReceiptCompute {
	/**
	 * 将获得的barcode的json数组，进行处理获得一个购买商品的对象及数量的链表，该方法已经在处理的父类中默认实现
	 * @param jsonArray
	 * @param goodsAndCategoryManager
	 * @return HashMap<String,GoodsItem>
	 */
	public HashMap<String,GoodsItem> dealInput(JSONArray jsonArray,GoodsAndCategoryManager goodsAndCategoryManager);
	/**
	 * 通过配置文件配置的优惠方案，对购买商品链表进行分类以及处理，返回包含小计的商品价格的链表，该链表将用于输入
	 * @param goodsItems
	 * @param promotionInfomation
	 * @return
	 */
	public ComputedItem freeMethod(HashMap<String,GoodsItem> goodsItems,PromotionInfomation promotionInfomation);
	
	

}
