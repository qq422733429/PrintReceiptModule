/**
 * 
 */
package com.thoughtworks.printReceiptModule.entity;

/**
 * 该类描述了购买的所有商品数量
 * @author Peter King
 *
 */
public class GoodsItem {
	private Goods goods;
	private int num;
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
