package com.booking.service.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class InvalidBookingException extends Exception {

  private static final long serialVersionUID = -8890080495441147845L;

  private String message;
  private Object[] args;

  public InvalidBookingException(String arg) {
    this.message = String.format("%s is an invalid booking.", arg);
  }

  public InvalidBookingException(Object[] args) {
    this.args = args;
  }

  public InvalidBookingException(String message, Object[] args) {
    this.message = message;
    this.args = args;
  }
  
}
