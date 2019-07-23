package com.restaurant.service.repository;

import java.util.Collection;

@SuppressWarnings("hiding")
public interface RestaurantRepository<Restaurant, String> extends Repository<Restaurant, String>{
	boolean containsName(String name);
	public Collection<Restaurant> findByName(String name) throws Exception;
}
