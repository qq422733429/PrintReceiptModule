package com.thoughtworks.printReceiptModule;

import javax.annotation.Resource;
import javax.naming.ConfigurationException;





import org.json.JSONArray;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thoughtworks.printReceiptModule.input.BarcodesInput;
import com.thoughtworks.printReceiptModule.input.InputFactory;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class InputTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired 
	private PrintReceiptModule 	printReceiptModule; 
	
	
	public InputTest() throws ConfigurationException {
	}
	
	@Test
	public void getInputFromFileClass() throws ConfigurationException {
		BarcodesInput barcodesInput = InputFactory.getBarcodesInput(1, printReceiptModule.getGoodsAndCategoryManager());
		Assert.assertTrue(barcodesInput!=null);
	}
	@Test
	public void getInputFromFile() throws ConfigurationException {
		BarcodesInput barcodesInput = InputFactory.getBarcodesInput(1, printReceiptModule.getGoodsAndCategoryManager());
		JSONArray jsonArray = barcodesInput.readBarcodes();
		Assert.assertTrue(jsonArray!=null);
	}
	@Test
	public void getInputFromConsoleClass() throws ConfigurationException {
		BarcodesInput barcodesInput = InputFactory.getBarcodesInput(2, printReceiptModule.getGoodsAndCategoryManager());
		Assert.assertTrue(barcodesInput!=null);
	}
	@Test
	public void getInputFromConsole() throws ConfigurationException {
		BarcodesInput barcodesInput = InputFactory.getBarcodesInput(2, printReceiptModule.getGoodsAndCategoryManager());
		JSONArray jsonArray = barcodesInput.readBarcodes();
		Assert.assertTrue(jsonArray!=null);
	}

}
