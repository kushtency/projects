package dev.spring.springdata.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dev.spring.springdata.hibernate.model.Tour;
import dev.spring.springdata.hibernate.service.TourService;
import jakarta.validation.Valid;

@Controller
public class TourController {
	
	private final TourService tourService;
	
	@Autowired
	public TourController(TourService tourService) {
		this.tourService = tourService;
	}
	
	@GetMapping("/addTour")
	public String showForm(Model model) {
		model.addAttribute("tour", new Tour());
		return "form";
	}
	
	@PostMapping("/process")
	public String showTourData(@Valid @ModelAttribute Tour tour, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "form";
		}
		Tour t = tourService.getTourByID(tour.getId());
		if(t != null) {
			tourService.updateTour(tour);
			return "redirect:show";
		}
		tourService.saveTour(tour);
		return "redirect:show";
	}
	
	@GetMapping("/show")
	public String getTours(Model model) {
		List<Tour> tours = tourService.getAll();
		model.addAttribute("tours", tours);
		return "tours";
	}
	
	@GetMapping("/deleteTour/{id}")
	public String deleteTour(@PathVariable(name = "id") int id) {
		Tour tour = tourService.getTourByID(id);
		if(tour != null) {
			tourService.deleteTour(id);
		}
		return "redirect:/show";
	}
	
	@GetMapping("/editTour/{id}")
	public String editTour(@PathVariable(name = "id") int id, Model model) {
		Tour tour = tourService.getTourByID(id);
		if(tour != null) {
			model.addAttribute("tour", tour);
			return "form";
		}
		return "redirect:/show";
	}
}
