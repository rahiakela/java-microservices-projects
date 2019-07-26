package com.user.service.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class InvalidUserException extends Exception {

  private static final long serialVersionUID = -8890080495441147845L;

  private String message;
  private Object[] args;

  public InvalidUserException(String arg) {
    this.message = String.format("%s is an invalid user.", arg);
  }

  public InvalidUserException(Object[] args) {
    this.args = args;
  }

  public InvalidUserException(String message, Object[] args) {
    this.message = message;
    this.args = args;
  }

}
