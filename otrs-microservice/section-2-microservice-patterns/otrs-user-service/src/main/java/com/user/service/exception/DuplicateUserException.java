package com.user.service.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class DuplicateUserException extends Exception {

  private static final long serialVersionUID = -8890080495441147845L;

  private String message;
  private Object[] args;

  public DuplicateUserException(String name) {
    this.message = String.format("There is already an user with the name - %s", name);
  }

  public DuplicateUserException(Object[] args) {
    this.args = args;
  }

  public DuplicateUserException(String message, Object[] args) {
    this.message = message;
    this.args = args;
  }

}
