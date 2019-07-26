package com.restaurant.service.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import com.restaurant.service.model.Entity;
import com.restaurant.service.model.Restaurant;

public interface RestaurantService {
	void add(Restaurant restaurant) throws Exception;
	void update(Restaurant restaurant) throws Exception;
	void delete(String id) throws Exception;
	Entity<?> findById(String restaurantId) throws Exception;
	Collection<Restaurant> findByName(String name) throws Exception;
	Collection<Restaurant> findByCriteria(Map<String, ArrayList<String>> name) throws Exception;
}
