package com.menu.schedulers;

import java.util.Date;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.menu.service.MenuParser;

@Component
public class MenuChecker {

	@Autowired
	private MenuParser menuParser;
	
	private static final Logger log = LoggerFactory.getLogger(MenuChecker.class);
	
	@Scheduled(fixedRate=60000)
	public void updateMenu() throws JAXBException{
		log.info("Menu updated at " + new Date());
		menuParser.updateMenu();
	}
}
