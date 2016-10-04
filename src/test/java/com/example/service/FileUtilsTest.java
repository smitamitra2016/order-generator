package com.example.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.menu.OrderGeneratorApplication;
import com.menu.service.FileUtils;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=OrderGeneratorApplication.class)
public class FileUtilsTest {

	private File menu = null;
	
	@Autowired
	private FileUtils fileUtils;
	
	@Before
	public void createMenu() throws IOException{
		menu = new File("testMenu.xml");
		menu.createNewFile();
	}
	
	@After
	public void deleteMenu(){
		if(menu!=null && menu.exists()){
			menu.delete();
		}
		File backup = new File("testMenu.xml.bkp");
		if(backup.exists()){
			backup.delete();
		}
	}
	
	@Test
	public void checkExistsTest(){
		assertTrue("Menu file exists", fileUtils.checkExists("testMenu.xml"));
	}
	
	@Test
	public void renameFileTest(){
		assertTrue("Menu file exists", fileUtils.checkExists("testMenu.xml"));
		fileUtils.renameFile("testMenu.xml");
		assertFalse("Menu file does not exist", fileUtils.checkExists("testMenu.xml"));
		assertTrue("Menu file backup exists", fileUtils.checkExists("testMenu.xml.bkp"));
	}
}
