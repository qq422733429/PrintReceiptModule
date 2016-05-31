package com.thoughtworks.printReceiptModule.input;


import org.json.JSONArray;
/**
 * 该接口定义了输入类必须实现的方法
 * @author Peter King
 *
 */
public interface BarcodesInput {
	public JSONArray readBarcodes();

}
