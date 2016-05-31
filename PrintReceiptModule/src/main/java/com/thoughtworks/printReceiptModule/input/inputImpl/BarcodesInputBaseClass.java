package com.thoughtworks.printReceiptModule.input.inputImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.apache.log4j.Logger;

import com.thoughtworks.printReceiptModule.goodsAndCategoryManager.GoodsAndCategoryManager;
/**
 * 该类是输入类的基类，定义了一些检查正确行的方法
 * @author Administrator
 *
 */
public class BarcodesInputBaseClass {
	/*
	 * 正则表达式来确认输入字符的合法性
	 */
	Pattern pattern = Pattern.compile("^ITEM[0-9]{6}|^ITEM[0-9]{6}-[0-9]{1,}$");
	/*
	 * 商品和目录的管理类，单例，全局唯一，由配置文件加载
	 */
	GoodsAndCategoryManager goodsAndCategoryManager;
	static Logger logger = Logger.getLogger (BarcodesInputBaseClass.class.getName());
	
	
	public BarcodesInputBaseClass(GoodsAndCategoryManager goodsAndCategoryManager) {
		super();
		this.goodsAndCategoryManager = goodsAndCategoryManager;
	}

	/**
	 * 检查条形码格式正确
	 * @param inBarcode
	 * @return
	 */
	public Boolean checkBarcodeFormat(String inBarcode) {
		Matcher matcher = pattern.matcher(inBarcode);
		if(matcher.matches()){
			return true;
		}else{
			return false;
		}
	} 
	/**
	 * 检查条形码是否对应商品
	 * @param inBarcode
	 * @return
	 */
	public Boolean checkBarcodeValid(String inBarcode) {
		String[] spilt = inBarcode.split("-");
		if(goodsAndCategoryManager.getAllGoods().containsKey(spilt[0]))
			return true;
		else
			return false;
		
	} 
	/**
	 * 检查输入文件的正确行性
	 * @param file
	 * @return
	 */
	public JSONArray checkAndReturnFileContentCorrect(File file){
		BufferedReader reader = null;
		StringBuilder stringBuilder = null;
		JSONArray jsonArray = null;
        try {
        	stringBuilder = new StringBuilder();
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                stringBuilder.append(tempString);
            }
            jsonArray = new JSONArray(stringBuilder.toString());
            for (Object object : jsonArray) {
				if(!checkBarcodeValid((String)object)||!checkBarcodeValid((String)object)){
					return null;
				}
			}
            reader.close();
            
            if(jsonArray.length()==0){
    			logger.warn("user input empty!");
    			return jsonArray;
    		}else{
    			logger.info("user input finish!");
    			return jsonArray;
    		}
        }catch(Exception e){
        	logger.error("user input id wrong file date!file content is "+stringBuilder.toString());
        } finally {
            try {
                reader.close();
            } catch (IOException e1) {
            }
        }
        return null;
	}

}
