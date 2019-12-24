package com.softtek.academia.repository;

import org.springframework.stereotype.Repository;

import com.softtek.academia.entity.State;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface StateRepository extends CrudRepository<State, Long>{
	
}