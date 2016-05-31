/**
 * 
 */
package com.thoughtworks.printReceiptModule.output;

import com.thoughtworks.printReceiptModule.entity.ComputedItem;

/**
 * 该接口定义了输出类必须实现的方法
 * @author Peter King
 *
 */
public interface OutputResult {
	/**
	 * 通过对包含小计的商品价格的链表进行逐一处理，获得输出字符串
	 * @param computedItem
	 * @return
	 */
	public String getOutputString(ComputedItem computedItem);
	/**
	 * 将输出结果输出到不同的地方
	 * @param result
	 * @return
	 */
	public Boolean outputMethod(String result);

}
