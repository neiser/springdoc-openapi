package test.org.springdoc.api.app20;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;

@RestController
public class HelloController {

	@GetMapping(value = "/persons")
	@Hidden
	public void persons(@Valid @NotBlank String name) {

	}
	
}
