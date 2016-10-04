package com.example.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.menu.OrderGeneratorApplication;
import com.menu.beans.FoodItem;
import com.menu.service.MenuParser;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = OrderGeneratorApplication.class)
@TestPropertySource(locations = "classpath:test/testMenu.properties")
public class MenuParserTest {

	@Value("${menu.path}")
	public String filePath;

	@Autowired
	private MenuParser menuParser;

	@Before
	public void createMenu() throws IOException {
		File menu = new File("testMenu.xml");
		BufferedWriter bw = null;
		FileWriter fw = null;
		menu.createNewFile();
		try {
			fw = new FileWriter(menu.getAbsoluteFile());
			bw = new BufferedWriter(fw);
			bw.write(
					"<menu><item>	<name>VEG_SANDWICH</name>	<type>FOOD</type>	<timeToPrepare>2</timeToPrepare></item><item>	<name>NON_VEG_SANDWICH</name>	<type>FOOD</type>	<timeToPrepare>2</timeToPrepare></item></menu>");
		} finally {
			bw.close();
			fw.close();
		}
	}

	@After
	public void deleteFile() {
		File menu = new File("testMenu.xml");
		menu.delete();
		File backup = new File("testMenu.xml.bkp");
		if(backup.exists()){
			backup.delete();
		}
	}

	@Test
	public void testFilePath() throws JAXBException {
		assertNull("Menu is not yet created", menuParser.getMenu());
		menuParser.updateMenu();
		List<FoodItem> menu = menuParser.getMenu();
		assertNotNull("Menu has been created", menu);
		assertEquals("Menu should contain 2 items", menu.size(), 2);
		assertNotNull("Menu food item name is not null", menu.get(0).getItemName());
		assertNotNull("Food type is not null", menu.get(0).getItemType());
	}
}
