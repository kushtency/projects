package dev.spring.thymeleafForms.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Tour {
	public enum Continent {
		ASIA, AUSTRALIA, US, EUROPE, AFRICA
	}
	@NotBlank(message="{tour.name.NotBlank}")
	@Size(min = 5, message="{tour.name.Min}")
	private String name;
	@Pattern(regexp="^[a-zA-Z]{2}-[0-9]{2}[a-zA-z]{1}$", message = "{tour.code.Pattern}")
	private String code;
	private Continent continent;
	@NotNull(message = "{tour.date.NotNull}")
	@Future(message = "{tour.date.Future}")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	@Min(value = 7, message="{tour.duration.Min}")
	@Max(value = 21, message="{tour.duration.Max}")
	private int duration;
	private boolean allInclusive = false;
	
	public Tour() {}
	
	public Tour(String name, String code, Continent continent, Date date, int duration, boolean allInclusive) {
		this.name = name;
		this.code = code;
		this.continent = continent;
		this.date = date;
		this.duration = duration;
		this.allInclusive = allInclusive;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public boolean isAllInclusive() {
		return allInclusive;
	}

	public void setAllInclusive(boolean allInclusive) {
		this.allInclusive = allInclusive;
	}
	
	@Override
	public String toString() {
		return "Tour [name=" + name + ", code=" + code + ", continent=" + continent + ", date=" + date + ", duration="
				+ duration + ", allInclusive=" + allInclusive + "]";
	}
	
}
