package com.booking.service.model;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(callSuper=false)
public class Booking extends BaseEntity<String> {

  private String restaurantId;
  private String userId;
  private LocalDate date;
  private LocalTime time;
  private String tableId;


  /**
   * @param name
   * @param id
   * @param restaurantId
   * @param userId
   * @param time
   * @param date
   */
  public Booking(String id, String name, String restaurantId, String tableId, String userId,
      LocalDate date, LocalTime time) {
    super(id, name);
    this.restaurantId = restaurantId;
    this.tableId = tableId;
    this.userId = userId;
    this.date = date;
    this.time = time;
  }

  private Booking(String id, String name) {
    super(id, name);
  }

  public static Booking getDummyBooking() {
    return new Booking(null, null);
  }

}
