package com.softtek.academia.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.softtek.academia.entity.City;
import com.softtek.academia.entity.State;
import com.softtek.academia.entity.User;
import com.softtek.academia.service.CityService;
import com.softtek.academia.service.StateService;

@Controller
public class CityController {
	//Constructor basado en inyeccion de dependencias.
	
	private CityService cityService;
	
	public CityController() {
		
	}
	
	@Autowired 
	public CityController(CityService cityService) {
		this.cityService = cityService;
	}
	
    @Autowired
    private StateService stateService;
	
	// Get All Users
	@PostMapping("/allCities")
	public ModelAndView displayAllCities() {
		System.out.println("Citi page Requested : All Cities ");
		ModelAndView mv = new ModelAndView();
		List<City> cityList = cityService.getAllCities();
		mv.addObject("cityList", cityList);
		mv.setViewName("allCities");
		return mv;	
	}
	
	@GetMapping("/addCity")
	public ModelAndView displayNewStateForm(){
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("headerMessage","Add City Details");
		List<State> states = stateService.getAllStates();
		mv.addObject("city", new City());
		mv.addObject("states", states);
		return mv;
	}
	
	@PostMapping("/addCity")
	public ModelAndView saveNewState(@ModelAttribute City city, BindingResult result) {
		
		ModelAndView mv = new ModelAndView("redirect:/home");
		
		if (result.hasErrors()) {
			return new ModelAndView("error");
		}
		boolean isAdded = cityService.saveCity(city);
		
		if(isAdded) {
			mv.addObject("message", "New City succesfully added");
		}else {
			return new ModelAndView("error");
		}
		
		return mv;
		}
	
		@GetMapping("/deleteCity/{city_id}")
		public ModelAndView deleteCityById(@PathVariable Long city_id) {
			boolean isDeleted = cityService.deleteCityById(city_id);
			System.out.println("City deletion response: " + isDeleted);
			ModelAndView mv = new ModelAndView("redirect:/home");
			return mv;
			
		}
		
		@RequestMapping(value = "/editCity/{city_id}", method = RequestMethod.GET)
		public ModelAndView displayEditUserForm(@PathVariable Long city_id) {
			ModelAndView mv = new ModelAndView("/editCity");
			City city = cityService.getCityById(city_id);
			List<State> states = stateService.getAllStates();
			mv.addObject("headerMessage", "Edit City Details");
			mv.addObject("city", city);
			mv.addObject("states", states);
			return mv;
		}

		@RequestMapping(value = "/editCity/{city_id}", method = RequestMethod.POST)
		public ModelAndView saveEditedUser(@ModelAttribute City city, BindingResult result) {
			ModelAndView mv = new ModelAndView("redirect:/home");

			if (result.hasErrors()) {
				System.out.println(result.toString());
				return new ModelAndView("error");
			}
			boolean isSaved = cityService.saveCity(city);
			if (!isSaved) {

				return new ModelAndView("error");
			}

			return mv;
		}
		
		@RequestMapping( value ="/city-state", method = RequestMethod.GET)
		public Map referenceData(HttpServletRequest request) throws Exception {
			State state = new State();
			List<State> stateList = stateService.getAllStates();
			Map referenceData = new HashMap();
			Map<Long,String> city = new LinkedHashMap<Long,String>();
			
            for(State state_id: stateList) {
            	
            	city.put(state.getState_id(), state.getDescription());
			}
            
            referenceData.put("cityList", city);
            
			return city;
		}
	}

