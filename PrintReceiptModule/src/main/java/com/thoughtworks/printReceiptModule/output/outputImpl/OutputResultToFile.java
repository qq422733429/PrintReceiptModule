/**
 * 
 */
package com.thoughtworks.printReceiptModule.output.outputImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.thoughtworks.printReceiptModule.output.OutputResult;

/**
 * @author Peter King
 *
 */
public class OutputResultToFile extends outputBaseClass implements OutputResult {
	static Logger logger = Logger.getLogger (OutputResultToFile.class.getName());
	public OutputResultToFile() {
	}

	/* 
	 * @see com.thoughtworks.printReceiptModule.output.OutputResult#outputMethod(java.lang.String)
	 */
	@Override
	public Boolean outputMethod(String result) {
		System.out.println("请输入输出文件位置：（格式：D://output.txt，若不是绝对路径，会输入到程序目录下）");
		Scanner scanner = new Scanner(System.in);
		String outputPath = "";
		boolean flag = true;
		do {
			outputPath = scanner.nextLine();
			logger.info("user import output path is "+outputPath);
			File file = new File(outputPath);
			try {
				if (file.exists()) {
					logger.warn("file output fail,file is existed!");
					System.out.println("文件已经存在请重新输入");
				}else{
					if(file.createNewFile()){
						FileOutputStream output = new FileOutputStream(file);
						output.write(result.getBytes());
						output.close();
						logger.info("file output success,file path is "+file.getAbsolutePath());
						System.out.println("收银小票输出成功，文件位置："+file.getAbsolutePath());
						flag=false;
					}else{
						throw new IOException("create file fail");
					}
				}
			} catch (IOException e) {
				logger.warn("file output fail,"+e.getMessage());
				System.out.println("文件创建失败，请输入可行的文件地址");
			}
		} while (flag);
		return true;
	}

}
