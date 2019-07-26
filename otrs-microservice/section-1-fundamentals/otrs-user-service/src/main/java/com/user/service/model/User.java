package com.user.service.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(callSuper=false)
public class User extends BaseEntity<String> {

  private String address;
  private String city;
  private String phoneNo;

  /**
   * @param name
   * @param id
   * @param address
   * @param city
   * @param phoneNo
   */
  public User(String id, String name, String address, String city, String phoneNo) {
    super(id, name);
    this.address = address;
    this.city = city;
    this.phoneNo = phoneNo;
  }

  private User(String id, String name) {
    super(id, name);
  }

  public static User getDummyUser() {
    return new User(null, null);
  }

}
