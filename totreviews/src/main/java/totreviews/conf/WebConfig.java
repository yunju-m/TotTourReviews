package totreviews.conf;

import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Value("${file.upload-dir}")
	private String uploadDir;

	// "/resources/**" 경로에 대해 정적 리소스를 제공하도록 설정
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
		registry.addResourceHandler("/upload/**")
				.addResourceLocations("file:" + Paths.get(uploadDir).toAbsolutePath().toString() + "/");
	}

	// 이미지 업로드 파일 용량 제한 설정
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(10 * 1024 * 1024); // 10MB
		multipartResolver.setMaxUploadSizePerFile(5 * 1024 * 1024); // 5MB
		multipartResolver.setMaxInMemorySize(10 * 1024 * 1024); // 10MB
		return multipartResolver;
	}

}
