package com.restaurant.service.model;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(callSuper=false)
public class Table extends BaseEntity<BigInteger>{
	
	private int capacity;

	public Table(@JsonProperty("name") String name, @JsonProperty("id") BigInteger id, @JsonProperty("capacity") int capacity) {
		super(id, name);
		this.capacity = capacity;
	}
	
}
