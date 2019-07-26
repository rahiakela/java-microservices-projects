package com.booking.service.vo;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BookingVO {

  private String name;
  private String id;
  private String restaurantId;
  private String userId;
  private LocalDate date;

  private LocalTime time;
  private String tableId;

}
