package com.restaurant.service.model;

import lombok.Data;

@Data
public abstract class Entity<T> {
	T id;
	String name;
}
