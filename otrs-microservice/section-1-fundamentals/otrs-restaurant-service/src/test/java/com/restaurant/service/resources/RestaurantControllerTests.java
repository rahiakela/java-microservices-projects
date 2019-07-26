package com.restaurant.service.resources;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;

import com.restaurant.service.model.Restaurant;
import com.restaurant.service.repository.RestaurantRepository;
import com.restaurant.service.service.RestaurantService;
import com.restaurant.service.service.RestaurantServiceImpl;

public class RestaurantControllerTests extends AbstractRestaurantControllerTests {
	/**
	 * Test Restaurant Instance
	 */
	protected static final Restaurant restaurantStaticInstance = new Restaurant(RESTAURANT,
      RESTAURANT_NAME, RESTAURANT_ADDRESS, null);
	/**
	 * Initialized Restaurant Repository
	 */
	protected TestRestaurantRepository testRestaurantRepository = new TestRestaurantRepository();
	/**
	 * Initialized Restaurant Service
	 */
	protected RestaurantService restaurantService = new RestaurantServiceImpl(testRestaurantRepository);
	
	@Before
	public void setup() {
		restaurantController = new RestaurantController(restaurantService);
	}
	
	protected static class TestRestaurantRepository implements RestaurantRepository<Restaurant, String> {
		private Map<String, Restaurant> entities;
		
		
		public TestRestaurantRepository() {
			entities = new HashMap<>();
			Restaurant restaurant = new Restaurant(RESTAURANT_NAME, RESTAURANT, RESTAURANT_ADDRESS, null);
			entities.put("1", restaurant);
			restaurant = new Restaurant("O Restaurant", "2", "Address of O Restaurant", null);
			entities.put("2", restaurant);
		}

		@Override
		public void add(Restaurant entity) {
			entities.put(entity.getId(), entity);
		}

		@Override
		public void remove(String id) {
			if (entities.containsKey(id)) {
		      entities.remove(id);
		    }
		}

		@Override
		public void update(Restaurant entity) {
			if (entities.containsKey(entity.getId())) {
		      entities.put(entity.getId(), entity);
		    }
		}

		@Override
		public boolean contains(String id) {
			throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		}

		@Override
		public Restaurant get(String id) {
			return entities.get(id);
		}

		@Override
		public Collection<Restaurant> getAll() {
			return entities.values();
		}

		@Override
		public boolean containsName(String name) {
			try {
		        return this.findByName(name).size() > 0;
		     } catch (Exception ex) {
		        //Exception Handler
		    }
			return false;
		}

		@Override
		public Collection<Restaurant> findByName(String name) throws Exception {
			Collection<Restaurant> restaurants = new ArrayList<>();
		    int noOfChars = name.length();
		    entities.forEach((k, v) -> {
		      if (v.getName().toLowerCase().contains(name.subSequence(0, noOfChars))) {
		        restaurants.add(v);
		      }
		    });
			return restaurants;
		}
		
	}
}
