package com.thoughtworks.printReceiptModule.goodsAndCategoryManager.goodsAndCategoryManagerImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.thoughtworks.printReceiptModule.entity.Goods;
import com.thoughtworks.printReceiptModule.entity.GoodsCategory;
import com.thoughtworks.printReceiptModule.goodsAndCategoryManager.GoodsAndCategoryManager;

/**
 * 该类记录了所有商品和目录的信息，单例，全局唯一
 * @author Peter King
 *
 */
public class GoodsAndCategoryManagerImpl implements GoodsAndCategoryManager {
	/*
	 * GoodsAndCategoryManagerImpl日志对象，该对象为单例
	 */
	static Logger logger = Logger.getLogger (GoodsAndCategoryManagerImpl.class.getName());
	/*
	 * 存储所有的商品目录，子目录名为键，目录对象为值
	 */
	private HashMap<String,GoodsCategory> goodsCategories;
	/*
	 * 存储所有的商品详情，条形码为键，商品对象为值
	 */
	private HashMap<String, Goods> allGoods;
	
	/**
	 * 全参数构造方法
	 * @param allCategory
	 * @param allGoods
	 */
	public GoodsAndCategoryManagerImpl(HashMap<String,GoodsCategory> goodsCategories,
			HashMap<String, Goods> allGoods) {
		super();
		if(goodsCategories==null)
			this.goodsCategories = new HashMap<String,GoodsCategory>();
		else
			this.goodsCategories = goodsCategories;
		if(allGoods == null)
			this.allGoods = new HashMap<String, Goods>();
		else
			this.allGoods = allGoods;
	}


	public HashMap<String,GoodsCategory> getGoodsCategories() {
		return goodsCategories;
	}

	public void setGoodsCategories(HashMap<String,GoodsCategory> goodsCategories) {
		this.goodsCategories = goodsCategories;
	}

	public HashMap<String, Goods> getAllGoods() {
		return allGoods;
	}


	public void setAllGoods(HashMap<String, Goods> allGoods) {
		this.allGoods = allGoods;
	}

	/**
	 * 向商品总目录hashMap中添加新的目录
	 * @param goodsCategory
	 * @return Boolean
	 */
	public Boolean addCategory(GoodsCategory goodsCategory) {
		if(goodsCategory!=null&&goodsCategory.checkNull()&&!goodsCategories.containsKey(goodsCategory.getSubCategory())){
			goodsCategories.put(goodsCategory.getSubCategory(), goodsCategory);
			return true;
		}else
			return false;
	}
	/**
	 * 向总商品hashMap中添加新的商品
	 * @param goods
	 * @return Boolean
	 */
	public Boolean addGoods(Goods goods) {
		if(goods!=null&&goods.checkNull()&&!allGoods.containsKey(goods.getBarcode())){
			allGoods.put(goods.getBarcode(), goods);
			return true;
		}else
			return false;
	}
	
	/**
	 * 从总商品hashMap中删除商品
	 * @param barcode 条形码
	 * @return Boolean
	 */
	public Boolean deleteGoods(String barcode) {
		if((!barcode.equals(""))&&allGoods.containsKey(barcode)){
			allGoods.remove(barcode);
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 获取商品实例
	 * @param barcode 条形码
	 * @return Goods
	 */
	public Goods getGoods(String barcode) {
		if((!barcode.equals(""))&&allGoods.containsKey(barcode))
			return allGoods.get(barcode);
		else
			return null;
	}
	
	/**
	 * 获取目录实例
	 * @param subCategory 子目录名
	 * @return GoodsCategory
	 */
	public GoodsCategory getCategory(String subCategory) {
		if(subCategory.equals("")&&goodsCategories.containsKey(subCategory))
			return goodsCategories.get(subCategory);
		else
			return null;
	}

	

}
