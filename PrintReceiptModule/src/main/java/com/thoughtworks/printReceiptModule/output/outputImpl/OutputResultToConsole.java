/**
 * 
 */
package com.thoughtworks.printReceiptModule.output.outputImpl;

import org.apache.log4j.Logger;

import com.thoughtworks.printReceiptModule.output.OutputResult;

/**
 * @author Peter King
 *
 */
public class OutputResultToConsole extends outputBaseClass implements OutputResult {

	static Logger logger = Logger.getLogger (OutputResultToConsole.class.getName());
	public OutputResultToConsole() {
	}

	/* 
	 * @see com.thoughtworks.printReceiptModule.output.OutputResult#outputMethod(java.lang.String)
	 */
	@Override
	public Boolean outputMethod(String result) {
		logger.info("output to console success!");
		System.out.println(result);
		return true;
	}

}
