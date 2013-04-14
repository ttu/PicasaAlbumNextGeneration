package com.ttu.picasaalbumnextgeneration.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ttu.picasaalbumnextgeneration.R;

public class MenuItems {

	public static List<MenuItem> ITEMS = new ArrayList<MenuItem>();

	public static Map<String, MenuItem> MENU_MAP = new HashMap<String, MenuItem>();

	static {
		// Add default menu items
		addItem(new MenuItem("1", "SkyDrive Authentication" ));
		addItem(new MenuItem("2", "Camera"));
		addItem(new MenuItem("3", "Gallery"));
	}

	private static void addItem(MenuItem item) {
		ITEMS.add(item);
		MENU_MAP.put(item.id, item);
	}
	
	public static class MenuItem {
		public String id;
		public String content;

		public MenuItem(String id, String content) {
			this.id = id;
			this.content = content;
		}

		@Override
		public String toString() {
			return content;
		}
	}
}
