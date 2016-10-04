package com.menu.schedulers;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.menu.beans.FoodItem;
import com.menu.service.MenuParser;
import com.menu.utility.Utility;

@Component
public class OrderGenerator {

	@Autowired
	private MenuParser menuParser;

	@Autowired
	private Utility utility;

	private static final Logger log = LoggerFactory.getLogger(OrderGenerator.class);

	private String generateOrder() {
		List<FoodItem> menu = menuParser.getMenu();
		if (menu != null) {
			List<String> tables = utility.getTables();
			String table = tables.get(utility.generateRandom(tables.size()));
			FoodItem item = menu.get(utility.generateRandom(menu.size()));
			int orderNum = 0;
			while (orderNum == 0) {
				orderNum = utility.generateRandom(6);
			}
			String numOfOrders = String.valueOf(utility.generateRandom(orderNum));
			StringBuffer order = new StringBuffer();
			order.append(item).append(":").append(numOfOrders).append(":").append(table);
			return order.toString();
		}
		return null;
	}

	@Scheduled(fixedDelay = 60000)
	public void sendOrder() throws IOException {
		String order = generateOrder();
		if (order != null) {
			DatagramSocket clientSocket = new DatagramSocket();
			InetAddress IPAddress = InetAddress.getByName("localhost");
			byte[] sendData = order.getBytes();
			log.info("Order sent at " + new Date() + " " + order);
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
			clientSocket.send(sendPacket);
			clientSocket.close();
		}

	}
}
