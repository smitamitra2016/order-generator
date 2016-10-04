package com.menu.service;

import java.io.File;

import org.springframework.stereotype.Component;

@Component
public class FileUtils {

	public boolean checkExists(String fileName) {
		File file = new File(fileName);
		if (file.exists()) {
			return true;
		}
		return false;
	}
	
	public void renameFile(String fileName){
		File file = new File(fileName);
		File newFile = new File(fileName+".bkp");
		file.renameTo(newFile);
	}
}
