package implementation;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
@Bean
@Override
public <a href="#UserDetailsService">UserDetailsService</a> userDetailsService() {
	
	UserDetails user = User.builder().username("user")
			.password(passwordEncoder().encode("secret"))
			.roles("USER").build();
	UserDetails userAdmin = User.builder().username("admin")
			.password(passwordEncoder().encode("secret"))
			.roles("ADMIN").build();
	return new InMemoryUserDetailsManager(user, userAdmin);
}

@Bean
public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
}

@Override
protected void configure(HttpSecurity http) throws Exception {
	http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers(",", "/index",  "/webpublico").permitAll()
			.antMatchers("/webprivado").authenticated()
			.antMatchers("/webadmin").hasRole("ADMIN").and()
			.formLogin()
			.loginPage("/login")
			.permitAll()
			.and()
			.logout() //método get por estar desabilitado CSRF
			.permitAll();
	
}
	

}
