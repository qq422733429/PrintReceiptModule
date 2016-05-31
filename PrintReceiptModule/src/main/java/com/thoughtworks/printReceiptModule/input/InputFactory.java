package com.thoughtworks.printReceiptModule.input;

import javax.naming.ConfigurationException;

import org.apache.log4j.Logger;

import com.thoughtworks.printReceiptModule.goodsAndCategoryManager.GoodsAndCategoryManager;
import com.thoughtworks.printReceiptModule.input.inputImpl.BarcodesInputFromConsole;
import com.thoughtworks.printReceiptModule.input.inputImpl.BarcodesInputFromFile;
import com.thoughtworks.printReceiptModule.receiptCompute.ReceiptComputeFactory;
/**
 * 该接口是输入方式的工厂类，用于根据配置文件生成不同的输入方式
 * @author Peter King
 *
 */
public class InputFactory {
	static Logger logger = Logger.getLogger (InputFactory.class.getName());
	/**
	 * 该方法用于获取具体输入类，通过配置文件配置具体输入方式，1为文件输入，2为控制台输入，可添加更多输入方式，只需继承输入类接口并实现相关接口，并在配置文件配置相关信息即可
	 * @return
	 * @throws ConfigurationException
	 */
	public static BarcodesInput getBarcodesInput(int inputMethod, GoodsAndCategoryManager goodsAndCategoryManager) throws ConfigurationException{
		switch (inputMethod) {
		case 1:
			logger.info("user use the file input");
			return getBarcodesInputFromFile(goodsAndCategoryManager);
		case 2:
			logger.info("user use the console input");
			return getBarcodesInputFromConsole(goodsAndCategoryManager);
		default:
			System.out.println("未知条形码输入方式，请检查配置文件！");
			logger.error("unknown input method,please check the conf file!");
			throw new ConfigurationException("unknown input method,please check the conf file!");
		}
	}
	
	/**
	 * 返回控制台输入类
	 * @param goodsAndCategoryManager
	 * @return
	 */
	private static BarcodesInput getBarcodesInputFromConsole(GoodsAndCategoryManager goodsAndCategoryManager){
		return new BarcodesInputFromConsole(goodsAndCategoryManager);
	}
	/**
	 * 返回文件输入类
	 * @param goodsAndCategoryManager
	 * @return
	 */
	private static BarcodesInput getBarcodesInputFromFile(GoodsAndCategoryManager goodsAndCategoryManager){
		return new BarcodesInputFromFile(goodsAndCategoryManager);
	}

}
