package com.thoughtworks.printReceiptModule;

import java.util.ArrayList;

import javax.naming.ConfigurationException;

import org.json.JSONArray;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thoughtworks.printReceiptModule.entity.ComputedGoods;
import com.thoughtworks.printReceiptModule.entity.ComputedItem;
import com.thoughtworks.printReceiptModule.input.BarcodesInput;
import com.thoughtworks.printReceiptModule.input.InputFactory;
import com.thoughtworks.printReceiptModule.output.OutputFactory;
import com.thoughtworks.printReceiptModule.output.OutputResult;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OutputTest extends AbstractJUnit4SpringContextTests {
 
	
	public OutputTest() {
	}
	public ComputedItem getComputedItemTest(){
		ArrayList<ComputedGoods> allPayGoods = new ArrayList<ComputedGoods>();
		ArrayList<ComputedGoods> freegoods = new ArrayList<ComputedGoods>();
		ComputedGoods computedGoods = new ComputedGoods("哈利波特", 4, 13, 52, "本");
		ComputedGoods freeComputedGoods = new ComputedGoods("哈利波特", 1, 13, 13, "本");
		ComputedGoods computedGoods2 = new ComputedGoods("可乐", 2, 3, 6, "瓶");
		allPayGoods.add(computedGoods);
		allPayGoods.add(computedGoods2);
		freegoods.add(freeComputedGoods);
		
		double totalPrice =58;
		double freeTotalPrice =13;
		
		return new ComputedItem(allPayGoods, freegoods, totalPrice, freeTotalPrice);
	}
	
	@Test
	public void outputToFileClass() throws ConfigurationException {
		OutputResult outputResult = OutputFactory.getOutputResult(2);
		Assert.assertTrue(outputResult!=null);
	}
	
	@Test
	public void OutputStringFromFile() throws ConfigurationException {
		OutputResult outputResult = OutputFactory.getOutputResult(2);
		String string = outputResult.getOutputString(getComputedItemTest());
		System.out.println(string);
		Assert.assertTrue(string.length()!=0);
	}
	
	@Test
	public void OutputToConsoleClass() throws ConfigurationException {
		OutputResult outputResult = OutputFactory.getOutputResult(1);
		Assert.assertTrue(outputResult!=null);
	}
	
	@Test
	public void OutputStringFromConsole() throws ConfigurationException {
		OutputResult outputResult = OutputFactory.getOutputResult(1);
		String string = outputResult.getOutputString(getComputedItemTest());
		System.out.println(string);
		Assert.assertTrue(string.length()!=0);
	}

}
