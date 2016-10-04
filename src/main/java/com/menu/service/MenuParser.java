package com.menu.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.menu.beans.FoodItem;
import com.menu.generated.Menu;

@Component
public class MenuParser {

	private List<FoodItem> menu = null;

	@Value("${menu.path}")
	private String filePath;

	@Autowired
	private FileUtils fileUtils;

	private Menu menuParser(String filePath) throws JAXBException {
		File file = new File(filePath);
		JAXBContext jaxbContext = JAXBContext.newInstance(Menu.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Menu menu = (Menu) jaxbUnmarshaller.unmarshal(file);
		return menu;
	}

	private List<FoodItem> parseMenuItems(Menu menu) {
		List<FoodItem> foodItems = new ArrayList<>();
		if (menu != null && menu.getItem().size() > 0) {
			FoodItem foodItem = null;
			List<Menu.Item> items = menu.getItem();
			for (Menu.Item item : items) {
				foodItem = new FoodItem(item.getName(), item.getType());
				foodItems.add(foodItem);
			}
		}
		return foodItems;
	}

	public void updateMenu() throws JAXBException {
		if (menu == null && fileUtils.checkExists(filePath)) {
			Menu itemMenu = menuParser(filePath);
			menu = parseMenuItems(itemMenu);
			fileUtils.renameFile(filePath);
		}
	}

	public List<FoodItem> getMenu() {
		return menu;
	}

}
