package com.booking.service.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import com.booking.service.model.Booking;
import com.booking.service.model.Entity;

public interface BookingService {

  /**
   * @param booking
   */
  public void add(Booking booking) throws Exception;

  /**
   * @param booking
   */
  public void update(Booking booking) throws Exception;

  /**
   * @param id
   */
  public void delete(String id) throws Exception;

  /**
   * @param id
   */
  public Entity<?> findById(String id) throws Exception;

  /**
   * @param name
   */
  public Collection<Booking> findByName(String name) throws Exception;

  /**
   * @param name
   */
  public Collection<Booking> findByCriteria(Map<String, ArrayList<String>> name) throws Exception;
}
