package com.example.service;

import javax.xml.bind.JAXBException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.menu.OrderGeneratorApplication;
import com.menu.service.MenuParser;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=OrderGeneratorApplication.class)
public class MenuParserTest {

	@Mock
	public String filePath="menu.xml";
	
	@Autowired
	private MenuParser menuParser;
	
	@Test
	public void testFilePath() throws JAXBException{
		System.out.println(filePath);
		menuParser.updateMenu();
	}
}
