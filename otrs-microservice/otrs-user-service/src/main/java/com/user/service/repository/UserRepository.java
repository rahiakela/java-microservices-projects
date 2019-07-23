package com.user.service.repository;

import java.util.Collection;

@SuppressWarnings("hiding")
public interface UserRepository<Booking, String> extends Repository<Booking, String> {

  /**
   * @param name
   */
  boolean containsName(String name);

  /**
   * @param name
   */
  public Collection<Booking> findByName(String name) throws Exception;
}
