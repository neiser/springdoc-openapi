package test.org.springdoc.api.app39;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class HelloController {

	@Operation(summary = "test Request")
	@RequestBody(description = "test value", required = true, content = @Content(schema = @Schema(implementation = String.class)))
	@PostMapping("/test")
	public Mono<Void> searchEmployee(String test) {
	  return Mono.empty();
	}
	
    @GetMapping("/hello")
    public Mono<String> hello() {
      return Mono.just("hello");
    }
}
