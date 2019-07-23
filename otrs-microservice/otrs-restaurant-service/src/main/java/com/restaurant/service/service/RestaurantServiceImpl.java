package com.restaurant.service.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.service.exception.DuplicateRestaurantException;
import com.restaurant.service.exception.InvalidRestaurantException;
import com.restaurant.service.model.Entity;
import com.restaurant.service.model.Restaurant;
import com.restaurant.service.repository.RestaurantRepository;

@Service("restaurantService")
public class RestaurantServiceImpl extends BaseService<Restaurant, String> implements RestaurantService {
	
	private RestaurantRepository<Restaurant, String> restaurantRepository;
	
	@Autowired
	public RestaurantServiceImpl(RestaurantRepository<Restaurant, String> restaurantRepository) {
		super(restaurantRepository);
		this.restaurantRepository = restaurantRepository;
	}

	@Override
	public void add(Restaurant restaurant) throws Exception {

		if (restaurantRepository.containsName(restaurant.getName())) {
			Object[] args = {restaurant.getName()};
			throw new DuplicateRestaurantException("Duplicate Restaurant", args);
		}
		
		if (restaurant.getName() == null || "".equals(restaurant.getName())) {
			Object[] args = {"Restaurant with null or empty name"};
			throw new InvalidRestaurantException("Invalid Restaurant", args);
		}
		
		super.add(restaurant);
	}

	@Override
	public void update(Restaurant restaurant) throws Exception {
		restaurantRepository.update(restaurant);
	}

	@Override
	public void delete(String id) throws Exception {
		restaurantRepository.remove(id);
	}

	@Override
	public Entity<?> findById(String restaurantId) throws Exception {
		return restaurantRepository.get(restaurantId);
	}

	@Override
	public Collection<Restaurant> findByName(String name) throws Exception {
		return restaurantRepository.findByName(name);
	}

	@Override
	public Collection<Restaurant> findByCriteria(Map<String, ArrayList<String>> name) throws Exception {
		// To change body of generated methods, choose Tools | Templates.
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
