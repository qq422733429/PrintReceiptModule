/**
 * 
 */
package com.thoughtworks.printReceiptModule.receiptCompute.receiptComputeIpml;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.json.JSONArray;

import com.thoughtworks.printReceiptModule.entity.GoodsItem;
import com.thoughtworks.printReceiptModule.goodsAndCategoryManager.GoodsAndCategoryManager;
import com.thoughtworks.printReceiptModule.output.outputImpl.outputBaseClass;

/**
 * @author Peter King
 *
 */
public class ReceiptComputeBaseClass {
	static Logger logger = Logger.getLogger (ReceiptComputeBaseClass.class.getName());
	public ReceiptComputeBaseClass() {
		super();
	}

	/**
	 * 将获得的barcode的json数组，进行处理获得一个购买商品的对象及数量的链表，该方法已经在处理的父类中默认实现
	 * @param jsonArray
	 * @param goodsAndCategoryManager
	 * @return HashMap<String,GoodsItem>
	 */
	public HashMap<String,GoodsItem> dealInput(JSONArray jsonArray,GoodsAndCategoryManager goodsAndCategoryManager){
		HashMap<String,GoodsItem> dealedMap = new HashMap<String, GoodsItem>();
		for (Object object : jsonArray) {
			String[] itemString = ((String)object).split("-");
			if(dealedMap.containsKey(itemString[0])){
				//若map中已经有该商品了，则添加
				if(itemString.length==1){
					dealedMap.get(itemString[0]).setNum(dealedMap.get(itemString[0]).getNum()+1);
				}else{
					dealedMap.get(itemString[0]).setNum(dealedMap.get(itemString[0]).getNum()+Integer.parseInt(itemString[1]));
				}
			}else{
				//若map中还没有该商品，则new GoodsItem，并对其赋值
				GoodsItem goodsItem =new GoodsItem();
				goodsItem.setGoods(goodsAndCategoryManager.getGoods(itemString[0]));
				if(itemString.length==1){
					goodsItem.setNum(1);
				}else{
					goodsItem.setNum(Integer.parseInt(itemString[1]));
				}
				dealedMap.put(goodsItem.getGoods().getBarcode(), goodsItem);
				
			}
		}
		logger.info("all goods json dealed success!");
		return dealedMap;
	}
		

}
