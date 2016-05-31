/**
 * 
 */
package com.thoughtworks.printReceiptModule.output;

import javax.naming.ConfigurationException;

import org.apache.log4j.Logger;

import com.thoughtworks.printReceiptModule.input.InputFactory;
import com.thoughtworks.printReceiptModule.output.outputImpl.OutputResultToConsole;
import com.thoughtworks.printReceiptModule.output.outputImpl.OutputResultToFile;

/**
 * 该类是输出具体实现类的生成工厂
 * @author Peter King
 *
 */
public class OutputFactory {
	static Logger logger = Logger.getLogger (OutputFactory.class.getName());
	/**
	 * 该方法用于获取输入方式
	 * @param freeName
	 * @return
	 * @throws ConfigurationException
	 */
	public static OutputResult getOutputResult(int outputMethod) throws ConfigurationException{
		switch (outputMethod) {
		case 1:
			logger.info("user use console output");
			return getOutputResultToConsole();
		case 2:
			logger.info("user use file output");
			return getOutputResultToFile();
		default:
			System.out.println("未知优惠方式，请检查配置文件！");
			logger.error("unknown output method,please check the conf file!");
			throw new ConfigurationException("unknown output method,please check the conf file!");
		}
	}
	/**
	 * 输出到控制台
	 * @return
	 */
	private static  OutputResult getOutputResultToConsole(){
		return new OutputResultToConsole();
	}
	/**
	 * 输出到文件
	 * @return
	 */
	private static  OutputResult getOutputResultToFile(){
		return new OutputResultToFile();
	}

}
