package com.foodorder.bo;

import java.util.ArrayList;
import java.util.List;

import com.foodorder.models.Menu;

public class FilterMenu {
	
	public static List<Menu> getFilteredMenuItems(List<Menu> allItems, String searchItem){
		List<Menu> filteredItems = new ArrayList<>();
		
		for(Menu item : allItems) {
			if(item.getItemName().contains(searchItem)) {
				filteredItems.add(item);
			}
		}
		
		return filteredItems;
	}

}
