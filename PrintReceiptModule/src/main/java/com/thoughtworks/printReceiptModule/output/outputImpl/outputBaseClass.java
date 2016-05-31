/**
 * 
 */
package com.thoughtworks.printReceiptModule.output.outputImpl;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.thoughtworks.printReceiptModule.entity.ComputedGoods;
import com.thoughtworks.printReceiptModule.entity.ComputedItem;

/**
 * 输出基础类，方法包含小计的商品价格的链表进行逐一处理，获得输出字符串
 * @author Peter King
 *
 */
public class outputBaseClass {

	static Logger logger = Logger.getLogger (outputBaseClass.class.getName());
	public outputBaseClass() {
		super();
	}
	
	/**
	 * 通过对包含小计的商品价格的链表进行逐一处理，获得输出字符串
	 * @param computedItem
	 * @return
	 */
	public String getOutputString(ComputedItem computedItem){
		StringBuilder builder = new StringBuilder();
		builder.append(gettHead());
		builder.append(getBeforeFreeGoods(computedItem.getAllPayGoods()));
		builder.append(getLine());
		if(computedItem.getFreegoods().size()==0){
			builder.append("总结 ："+computedItem.getTotalPrice()+" 元\n");
			builder.append(getLine());
		}else{
			builder.append(getFreedGoods(computedItem.getFreegoods()));
			builder.append(getLine());
			builder.append("总结 ："+(computedItem.getTotalPrice()-computedItem.getFreeTotalPrice())+" 元 节省 ："+computedItem.getFreeTotalPrice()+" 元\n");
			builder.append(getLine());
		}
		
		logger.info("build output string success:"+builder.toString());
		return builder.toString();
		
	}
	/**
	 * 打印商店名
	 * @return
	 */
	private String gettHead(){
		return "\n                  *<没钱赚商店>购物清单*                  \n\n";
	}
	/**
	 * 打印横线
	 * @return
	 */
	private String getLine(){
		return "------------------------------------------------------\n";
	}
	/**
	 * 生成打折前所有商品明细
	 * @param computedGoods
	 * @return
	 */
	private String getBeforeFreeGoods(ArrayList<ComputedGoods> computedGoods){
		StringBuilder builder = new StringBuilder();
		for (ComputedGoods item : computedGoods) {
			builder.append(getEachBeforeFreeGoods(item));
		}
		return builder.toString();
	}
	/**
	 * 逐行打印未打折商品明细
	 * @param computedGoods
	 * @return
	 */
	private String getEachBeforeFreeGoods(ComputedGoods computedGoods){
		
		return "名称："+computedGoods.getName()+"，数量："+computedGoods.getNum()+computedGoods.getUnit()+"，单价："+computedGoods.getPrice()+"(元)，小计："+computedGoods.getTotalPrice()+"(元)\n\n";
		
	}
	/**
	 * 生成打折后所有商品明细
	 * @param computedGoods
	 * @return
	 */
	private String getFreedGoods(ArrayList<ComputedGoods> computedGoods){
		StringBuilder builder = new StringBuilder();
		builder.append("买三免一商品：");
		int index = 0;
		for (ComputedGoods item : computedGoods) {
			builder.append(getEachFreedGoods(item));
			if(index++==3){
				builder.append("\n");
				index=0;
			}
		}
		builder.append("\n");
		return builder.toString();
	}
	/**
	 * 逐行打印已打折商品明细
	 * @param computedGoods
	 * @return
	 */
	private String getEachFreedGoods(ComputedGoods computedGoods){
		return "名称："+computedGoods.getName()+"，数量："+computedGoods.getNum()+computedGoods.getUnit()+" ";
	}
}
