package com.thoughtworks.printReceiptModule.input.inputImpl;

import java.util.Scanner;
import org.apache.log4j.Logger;

import org.json.JSONArray;

import com.thoughtworks.printReceiptModule.goodsAndCategoryManager.GoodsAndCategoryManager;
import com.thoughtworks.printReceiptModule.input.BarcodesInput;

public class BarcodesInputFromConsole extends BarcodesInputBaseClass implements BarcodesInput {
	static Logger logger = Logger.getLogger (BarcodesInputFromConsole.class.getName());
	

	public BarcodesInputFromConsole(GoodsAndCategoryManager goodsAndCategoryManager) {
		super(goodsAndCategoryManager);
	}

	public JSONArray readBarcodes() {
		
		System.out.println("请输入barcodes:(请逐条输入，格式：ITEM000001或者ITEM000001-2，以输入EOF结束)");
		JSONArray jsonArray = new JSONArray();
		String in = "";
		do{
			Scanner scan = new Scanner(System.in);
			in = scan.nextLine();
			logger.info("user input:"+in);
			if(!in.equals("EOF")){
				if(checkBarcodeFormat(in)){
					if(checkBarcodeValid(in)){
						jsonArray.put(in);
						System.out.println("添加成功，请继续输入");
						logger.info("user input correct,add into array json");
					}else{
						logger.error("user input barcode is not exist!");
						System.out.println("输入条形码不存在，请重新输入！");
					}
				}else{
					logger.error("user input format is wronge");
					System.out.println("输入格式有错，请重新输入！");
				}
			}
		}while(!in.equals("EOF"));
		System.out.println("用户输入完毕！");
		logger.info("user input finish!");
		return jsonArray;
		
	}

	

}
