/**
 * 
 */
package com.thoughtworks.printReceiptModule.receiptCompute;

import javax.naming.ConfigurationException;

import org.apache.log4j.Logger;

import com.thoughtworks.printReceiptModule.PrintReceiptModule;
import com.thoughtworks.printReceiptModule.receiptCompute.receiptComputeIpml.ReceiptComputeBuyThreeFreeOne;

/**
 * 该类是优惠类的创建工厂，只需添加相应的优惠方式，修改配置文件，即可实现相关优惠
 * @author Peter King
 *
 */
public class ReceiptComputeFactory {
	static Logger logger = Logger.getLogger (ReceiptComputeFactory.class.getName());
	
	/**
	 * 该方法用于获取具体优惠处理类，通过配置文件配置具体优惠处理方式，BUY_THREE_GET_ONE_FREE为买三减一，可添加更多优惠处理方式，只需继承优惠处理类接口并实现相关接口，并在配置文件配置相关信息即可
	 * @param freeName
	 * @return
	 * @throws ConfigurationException
	 */
	public static ReceiptCompute getReceiptCompute(String freeName) throws ConfigurationException{
		switch (freeName) {
		case "BUY_THREE_GET_ONE_FREE":
			logger.info("user use the buy three free one method");
			return getReceiptComputeBuyThreeFreeOne();
		default:
			System.out.println("未知优惠方式，请检查配置文件！");
			logger.error("unknown free method,please check the conf file!");
			throw new ConfigurationException("unknown free method,please check the conf file!");
		}
		
	}
	
	/**
	 * 返回买三减一实现类
	 * @return
	 * @throws ConfigurationException 
	 */
	private static ReceiptCompute getReceiptComputeBuyThreeFreeOne(){
		return new ReceiptComputeBuyThreeFreeOne();
	}

}
