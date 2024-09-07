package totreviews.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authorizeRequests -> authorizeRequests.requestMatchers("/public/**").permitAll() // 공용																									// URL
																													
				.requestMatchers("/admin/**").hasRole("ADMIN") 
				.anyRequest().authenticated() 
		).formLogin(formLogin -> formLogin.loginPage("/login") 
				.permitAll() 
		).logout(logout -> logout.permitAll()
		);
		return http.build();
	}

	/* TODO 임의의 사용자 지정 */
	@Bean
	public UserDetailsService userDetailsService() {
		return username -> {
			if ("memeber".equals(username)) {
				return User.withUsername("memeber")
						.roles("USER").build();
			} else {
				throw new UsernameNotFoundException("User not found");
			}
		};
	}
}
