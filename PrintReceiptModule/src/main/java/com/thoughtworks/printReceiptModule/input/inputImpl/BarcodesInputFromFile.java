package com.thoughtworks.printReceiptModule.input.inputImpl;

import java.io.File;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thoughtworks.printReceiptModule.goodsAndCategoryManager.GoodsAndCategoryManager;
import com.thoughtworks.printReceiptModule.input.BarcodesInput;
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class BarcodesInputFromFile extends BarcodesInputBaseClass implements BarcodesInput {
	static Logger logger = Logger.getLogger (BarcodesInputFromFile.class.getName());
	public BarcodesInputFromFile(GoodsAndCategoryManager goodsAndCategoryManager) {
		super(goodsAndCategoryManager);
	}

	public JSONArray readBarcodes() {
		System.out.println("请输入文件位置：（请输入绝对路径，格式：D：//test.json）");
		System.out.println("文件内容格式：['ITEM000001', 'ITEM000001', 'ITEM000001', 'ITEM000001', 'ITEM000003-2']");
		String path = "";
		do{
			Scanner scan = new Scanner(System.in);
			path = scan.nextLine();
			logger.info("user input:"+path);
			File file=new File(path);
			if(file.exists()){
				JSONArray jsonArray = checkAndReturnFileContentCorrect(file);
				if(jsonArray==null){
					System.out.println("文件格式错误或者商品条形码不正确，请检查文件格式问题");
				}else{
					System.out.println("文件输入成功！");
					logger.info("user input is correct,add into array json");
					return jsonArray;
				}
			}else{
				System.out.println("输入的文件不存在，请重新输入");
			}
		}while(true);
		
	}

}
