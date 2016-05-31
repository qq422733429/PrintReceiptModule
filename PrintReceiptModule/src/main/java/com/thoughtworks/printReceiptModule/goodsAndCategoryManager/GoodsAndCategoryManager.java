package com.thoughtworks.printReceiptModule.goodsAndCategoryManager;

import java.util.HashMap;

import com.thoughtworks.printReceiptModule.entity.Goods;
import com.thoughtworks.printReceiptModule.entity.GoodsCategory;
/**
 * 该接口给出了商品和目录管理的所有方法
 * @author Peter King
 *
 */
public interface GoodsAndCategoryManager {
	/**
	 * 获取所有目录
	 * @return
	 */
	public HashMap<String,GoodsCategory> getGoodsCategories();
	/**
	 * 获取所有商品
	 * @return
	 */
	public HashMap<String, Goods> getAllGoods();
	
	/**
	 * 向商品总目录hashMap中添加新的目录
	 * @param goodsCategory
	 * @return Boolean
	 */
	public Boolean addCategory(GoodsCategory goodsCategory);
	/**
	 * 向总商品hashMap中添加新的商品
	 * @param goods
	 * @return Boolean
	 */
	public Boolean addGoods(Goods goods);
	/**
	 * 从总商品hashMap中删除商品
	 * @param barcode 条形码
	 * @return Boolean
	 */
	public Boolean deleteGoods(String barcode);
	/**
	 * 获取商品实例
	 * @param barcode 条形码
	 * @return Goods
	 */
	public Goods getGoods(String barcode);
	/**
	 * 获取目录实例
	 * @param subCategory  
	 * @return GoodsCategory
	 */
	public GoodsCategory getCategory(String subCategory);
}
