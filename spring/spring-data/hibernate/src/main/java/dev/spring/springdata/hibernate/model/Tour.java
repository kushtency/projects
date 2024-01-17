package dev.spring.springdata.hibernate.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tour")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Tour {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
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
	@Builder.Default
	private boolean allInclusive = false;
}
