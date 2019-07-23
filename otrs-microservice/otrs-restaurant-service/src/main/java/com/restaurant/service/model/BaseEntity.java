package com.restaurant.service.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public abstract class BaseEntity<T> extends Entity<T> {
	
	private boolean isModified;

	public BaseEntity(T id, String name) {
		super.id = id;
		super.name = name;
		isModified = false;
	}
	
}
