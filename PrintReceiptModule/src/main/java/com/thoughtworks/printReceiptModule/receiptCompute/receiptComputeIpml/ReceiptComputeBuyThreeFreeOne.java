/**
 * 
 */
package com.thoughtworks.printReceiptModule.receiptCompute.receiptComputeIpml;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.thoughtworks.printReceiptModule.entity.ComputedGoods;
import com.thoughtworks.printReceiptModule.entity.ComputedItem;
import com.thoughtworks.printReceiptModule.entity.GoodsItem;
import com.thoughtworks.printReceiptModule.entity.PromotionInfomation;
import com.thoughtworks.printReceiptModule.receiptCompute.ReceiptCompute;

/**
 * 该类是买三减一的具体实现类
 * @author Peter King
 *
 */
public class ReceiptComputeBuyThreeFreeOne extends ReceiptComputeBaseClass
		implements ReceiptCompute {
	static Logger logger = Logger.getLogger (ReceiptComputeBuyThreeFreeOne.class.getName());
	

	public ReceiptComputeBuyThreeFreeOne() {
		super();
	}

	/**
	 *  通过配置文件配置的优惠方案，对购买商品链表进行分类以及处理，返回包含小计的商品价格的链表，该链表将用于输入
	 * @param goodsItems
	 * @param promotionInfomation
	 * @return ComputedItem
	 * @see com.thoughtworks.printReceiptModule.receiptCompute.ReceiptCompute#freeMethod(java.util.ArrayList, com.thoughtworks.printReceiptModule.entity.PromotionInfomation)
	 */
	public ComputedItem freeMethod(HashMap<String,GoodsItem> goodsItems,
			PromotionInfomation promotionInfomation) {
		ArrayList<ComputedGoods> allPayGoods = new ArrayList<ComputedGoods>();
		ArrayList<ComputedGoods> freegoods = new ArrayList<ComputedGoods>();
		double totalPrice = 0;
		double freeTotalPrice = 0;
		for (GoodsItem goodsItem : goodsItems.values()) {
			String name = goodsItem.getGoods().getName();
			int num = goodsItem.getNum();
			double price = goodsItem.getGoods().getPrice();
			double itemTotalPrice = price*num;
			String unit = goodsItem.getGoods().getUnit().getName();
			ComputedGoods computedGoods = new ComputedGoods(name, num, price, itemTotalPrice,unit);
			allPayGoods.add(computedGoods);
			totalPrice+=itemTotalPrice;
			if(isInFreeList(goodsItem.getGoods().getBarcode(),promotionInfomation.getPromotionBarcodes())){
				int freeNum = num/3;
				if(freeNum!=0){
					ComputedGoods freeComputedGoods = new ComputedGoods(name, freeNum, price, price*freeNum,unit);
					freegoods.add(freeComputedGoods);
					freeTotalPrice+=price*freeNum;
				}
			}
		}
		logger.info("free goods has deal finish!");
		return new ComputedItem(allPayGoods, freegoods, totalPrice, freeTotalPrice);
	}
	/**
	 * 检查某个商品是否是免单商品
	 * @param barcode
	 * @param freeList
	 * @return
	 */
	private Boolean isInFreeList(String barcode,ArrayList<String> freeList) {
		Boolean bool = false;
		for (String item : freeList) {
			if(barcode.equals(item))
				bool = true;
		}
		return bool;
	}

}
