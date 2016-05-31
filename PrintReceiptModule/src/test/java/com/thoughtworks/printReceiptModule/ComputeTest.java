package com.thoughtworks.printReceiptModule;

import java.util.HashMap;

import javax.naming.ConfigurationException;

import org.json.JSONArray;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thoughtworks.printReceiptModule.entity.GoodsItem;
import com.thoughtworks.printReceiptModule.receiptCompute.ReceiptCompute;
import com.thoughtworks.printReceiptModule.receiptCompute.ReceiptComputeFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ComputeTest extends AbstractJUnit4SpringContextTests {
	@Autowired 
	private PrintReceiptModule 	printReceiptModule; 

	public ComputeTest() {
	}
	
	String string = "[ 'ITEM000001', 'ITEM000001', 'ITEM000001', 'ITEM000001', 'ITEM000001', 'ITEM000000-2' ]";
	
	@Test
	public void getComputeBuyThreeFreeOneClass() throws ConfigurationException{
		ReceiptCompute compute = ReceiptComputeFactory.getReceiptCompute(printReceiptModule.getPromotionInfomation().getPromotionName());
		Assert.assertTrue(compute!=null);
	}
	
	@Test
	public void dealInput() throws ConfigurationException{
		ReceiptCompute compute = ReceiptComputeFactory.getReceiptCompute(printReceiptModule.getPromotionInfomation().getPromotionName());
		compute.dealInput(new JSONArray(string), printReceiptModule.getGoodsAndCategoryManager());
		Assert.assertTrue(compute!=null);
	}
	
	@Test
	public void freeMethod() throws ConfigurationException{
		ReceiptCompute compute = ReceiptComputeFactory.getReceiptCompute(printReceiptModule.getPromotionInfomation().getPromotionName());
		HashMap<String, GoodsItem> goodsItems =  compute.dealInput(new JSONArray(string), printReceiptModule.getGoodsAndCategoryManager());
		compute.freeMethod(goodsItems, printReceiptModule.getPromotionInfomation());
		Assert.assertTrue(compute!=null);
	}
	

}
