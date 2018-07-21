package club.throwable.sample;

import club.throwable.sample.aspect.MethodMetric;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/7/21 9:13
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class SampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

	@MethodMetric
	@GetMapping(value = "/hello")
	public String hello(@RequestParam(name = "name", required = false, defaultValue = "doge") String name) {
		return String.format("%s say hello!", name);
	}
}
