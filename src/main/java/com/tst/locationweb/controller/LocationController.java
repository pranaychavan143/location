package com.tst.locationweb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tst.locationweb.model.Location;
import com.tst.locationweb.service.LocationService;
import com.tst.locationweb.util.EmailUtil;

@Controller
public class LocationController {

	@Autowired
	LocationService locationService;
	
	@Autowired
	EmailUtil email;

	@RequestMapping("/showCreate")
	public String showCreate() {

		return "createLocation";

	}

	@PostMapping("/savelocation")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		Location locationSaved = locationService.saveLocation(location);
		String msg = "Location saved with id:" + locationSaved.getId();
		modelMap.addAttribute("msg", msg);
		email.sendEmail("pranaychavan81@gmail.com", "Location saved ", "location saved succefully and about to returmn response");
		return "createLocation";

	}

	@RequestMapping("/displayLocation")
	public String displayLocation(ModelMap modelMap) {
		List<Location> location = locationService.getAllLocations();
		modelMap.addAttribute("locations", location);
		return "displayLocation";
	}

	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap) {
		/*
		 * Optional<Location> location = locationService.getLocationById(id); Location
		 * location2= location.get();
		 */
		Location location = new Location();
		location.setId(id);
		locationService.deleteLocation(location);
	List<Location>location1	= locationService.getAllLocations();
		modelMap.addAttribute("locations", location1);
		return "displayLocation";

	}

	@RequestMapping("/showUpdate")
	public String showLocation(@RequestParam("id") int id, ModelMap modelMap) {
		Optional<Location> location = locationService.getLocationById(id);
		Location location2 = location.get();
		modelMap.addAttribute("location", location2);
		return "updateLocation";
	}

	@RequestMapping("/updateLocation")
	public String updateLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		locationService.updateLocation(location);
		List<Location> locations1= locationService.getAllLocations();
		modelMap.addAttribute("locations", locations1);
		return "displayLocation";

	}

}
