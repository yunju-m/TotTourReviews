package totreviews.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// "/resources/**" 경로에 대해 정적 리소스를 제공하도록 설정
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
}
