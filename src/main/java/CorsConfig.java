import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
	   @Bean
	    public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurer() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/**") // Apply CORS to all endpoints
	                        .allowedOrigins("http://localhost:3000") // Allow requests from your React app's origin
	                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow common HTTP methods
	                        .allowedHeaders("*") // Allow all headers
	                        .allowCredentials(true); // Allow sending cookies/auth headers if needed
	            }
	        };
	    }

}
