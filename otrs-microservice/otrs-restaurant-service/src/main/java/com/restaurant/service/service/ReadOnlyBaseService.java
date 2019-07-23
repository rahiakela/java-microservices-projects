package com.restaurant.service.service;

import com.restaurant.service.repository.ReadOnlyRepository;

public abstract class ReadOnlyBaseService<TE, T> {
	
	private ReadOnlyRepository<TE, T> repository;

	public ReadOnlyBaseService(ReadOnlyRepository<TE, T> repository) {
		this.repository = repository;
	}
	
}
