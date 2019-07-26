package com.user.service.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {

  private String name;
  private String id;
  private String address;
  private String city;
  private String phoneNo;

}
