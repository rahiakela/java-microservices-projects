package com.restaurant.service.vo;

import java.util.List;
import java.util.Optional;

import com.restaurant.service.model.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class RestaurantVO {
	private Optional<List<Table>> tables = Optional.empty();
	private String name;
	private String id;
	private String address;
}
