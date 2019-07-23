package com.booking.service.repository;

import java.util.Collection;

@SuppressWarnings("hiding")
public interface BookingRepository<Booking, String> extends Repository<Booking, String> {

  /**
   * @param name
   */
  boolean containsName(String name);

  /**
   * @param name
   */
  public Collection<Booking> findByName(String name) throws Exception;
}
