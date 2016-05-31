package com.thoughtworks.printReceiptModule;

import java.util.HashMap;

import javax.naming.ConfigurationException;

import org.apache.log4j.Logger;
import org.json.JSONArray;

import com.thoughtworks.printReceiptModule.entity.ComputedItem;
import com.thoughtworks.printReceiptModule.entity.GoodsItem;
import com.thoughtworks.printReceiptModule.entity.PromotionInfomation;
import com.thoughtworks.printReceiptModule.goodsAndCategoryManager.GoodsAndCategoryManager;
import com.thoughtworks.printReceiptModule.input.BarcodesInput;
import com.thoughtworks.printReceiptModule.input.InputFactory;
import com.thoughtworks.printReceiptModule.output.OutputFactory;
import com.thoughtworks.printReceiptModule.output.OutputResult;
import com.thoughtworks.printReceiptModule.output.outputImpl.OutputResultToFile;
import com.thoughtworks.printReceiptModule.receiptCompute.ReceiptCompute;
import com.thoughtworks.printReceiptModule.receiptCompute.ReceiptComputeFactory;
/**
 * 运行类，由spring创建对象，由main方法调用run运行
 * @author Peter King
 *
 */
public class PrintReceiptModule {
	static Logger logger = Logger.getLogger (PrintReceiptModule.class.getName());
	/*
	 * 促销信息类
	 */
	private PromotionInfomation promotionInfomation;
	/*
	 * 输入方式，配置文件配置
	 */
	private int inputMethod;
	/*
	 * 所有商品和目录对象，单例，全局唯一
	 */
	private GoodsAndCategoryManager goodsAndCategoryManager;
	/*
	 * 输出方式，配置文件配置
	 */
	private int outputMethod;
	
	
	/**
	 * 全参构造函数
	 * @param promotionInfomation
	 * @param inputMethod
	 * @param goodsAndCategoryManager
	 * @param outputMethod
	 */
	public PrintReceiptModule(PromotionInfomation promotionInfomation,
			int inputMethod, GoodsAndCategoryManager goodsAndCategoryManager,int outputMethod) {
		super();
		this.promotionInfomation = promotionInfomation;
		this.inputMethod = inputMethod;
		this.goodsAndCategoryManager = goodsAndCategoryManager;
		this.outputMethod = outputMethod;
	}
	

	public int getOutputMethod() {
		return outputMethod;
	}


	public void setOutputMethod(int outputMethod) {
		this.outputMethod = outputMethod;
	}


	public int getInputMethod() {
		return inputMethod;
	}

	public void setInputMethod(int inputMethod) {
		this.inputMethod = inputMethod;
	}

	public GoodsAndCategoryManager getGoodsAndCategoryManager() {
		return goodsAndCategoryManager;
	}

	public void setGoodsAndCategoryManager(
			GoodsAndCategoryManager goodsAndCategoryManager) {
		this.goodsAndCategoryManager = goodsAndCategoryManager;
	}

	public PromotionInfomation getPromotionInfomation() {
		return promotionInfomation;
	}

	public void setPromotionInfomation(PromotionInfomation promotionInfomation) {
		this.promotionInfomation = promotionInfomation;
	}


	/**
	 * 运行方法，整个运行分为三步，
	 * 1、输入，根据配置文件中的输入方式进行条形码获取。
	 * 2、处理，根据配置文件的优惠信息从工厂得到优惠处理类处理。
	 * 3、输出，根据配置文件输出方式得到相应输出类，输出
	 * @throws ConfigurationException
	 */
	public void run() throws ConfigurationException{
		
			//按照配置文件从工厂获取输入类
			BarcodesInput barcodesInput = InputFactory.getBarcodesInput(inputMethod, goodsAndCategoryManager);
			logger.debug("get input class success");
			System.out.println("欢迎光临没钱赚商店");
			JSONArray jsonArray = barcodesInput.readBarcodes();
			logger.debug("get barcode success");
			
			if (jsonArray.length() == 0) {
				System.out.println("您输入的条形码数量为空，本次小计结束！");
			} else {
				//按照配置文件从工厂获取处理类
				ReceiptCompute receiptCompute = ReceiptComputeFactory.getReceiptCompute(promotionInfomation.getPromotionName());
				logger.debug("get compute class success ");
				
				//对json进行处理
				HashMap<String,GoodsItem> dealedInput = receiptCompute.dealInput(jsonArray, goodsAndCategoryManager);
				logger.debug("deal input success");
				
				ComputedItem computedItem = receiptCompute.freeMethod(dealedInput, promotionInfomation);
				logger.debug("deal free goods success");
				
				//按照配置文件从工厂获取输出类
				OutputResult outputResult = OutputFactory.getOutputResult(outputMethod);
				logger.debug("get output class success ");
				outputResult.outputMethod(outputResult.getOutputString(computedItem));
				logger.debug("output success");
			}
			logger.info("print receipt finish!");
	}
	
	
}
