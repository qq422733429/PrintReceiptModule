package com.thoughtworks.printReceiptModule;


import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;




/**
 * 打印小票模块
 * @author Peter King
 */
public class App 
{
	static Logger logger = Logger.getLogger (App.class.getName());
	
    public static void main( String[] args )
    {
		PrintReceiptModule printReceiptModule = null;
    	try {
    		//从配置文件中读取信息
    		BeanFactory bf = new ClassPathXmlApplicationContext("applicationContext.xml");
			printReceiptModule = (PrintReceiptModule) bf.getBean("printReceiptModule");
			//若对象为空，则加载失败，程序退出
			if(printReceiptModule==null){
				logger.error("get printReceiptModule fail! the conf file is wrong!");
				throw new NullPointerException("get printReceiptModule fail! the conf file is wrong!");
			}
			logger.debug("app initialization success!");
			//程序开始运行
			logger.debug("app begin run");
			printReceiptModule.run();
			
		} catch (BeansException e) {
			logger.error("app initialization error,the conf file is wrong please check");
			System.out.println("程序初始化失败，请检查各项配置文件是非正确！");
		}catch (Exception e2){
			logger.error("app run error,please check log file!");
			System.out.println("程序运行出错");
			System.exit(1);
		}
    	
    }
}
