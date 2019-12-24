package com.softtek.academia.service;

import java.util.List;

import com.softtek.academia.entity.State;

public interface StateService {

	public List<State> getAllStates();
	public State getStateById (Long state_id);
	public boolean saveState (State state);
	public boolean deleteStateById(Long state_id);
	
}
