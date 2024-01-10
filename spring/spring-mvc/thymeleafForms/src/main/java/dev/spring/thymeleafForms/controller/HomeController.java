package dev.spring.thymeleafForms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.spring.thymeleafForms.model.Tour;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class HomeController {
	
	private List<Tour> tours = new ArrayList<>();

	@GetMapping("")
	public String getHome() {
		return "home";
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
		tours.add(tour);
		return "redirect:show";
	}
	
	@GetMapping("/show")
	public String getTours(Model model) {
		model.addAttribute("tours", tours);
		return "tours";
	}
	
}
