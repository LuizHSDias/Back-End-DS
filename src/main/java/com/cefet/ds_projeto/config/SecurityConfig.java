package com.cefet.ds_projeto.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cefet.ds_projeto.security.JwtAuthenticationFilter;
import com.cefet.ds_projeto.services.UsuarioDetailsService;

@Configuration
public class SecurityConfig {

    @Autowired
    private UsuarioDetailsService usuarioDetailsService;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors().and()
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/h2-console/**").permitAll() // Acessa ao H2 Console
                .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll() // Acessa ao Swagger UI
                
               .requestMatchers(HttpMethod.POST,"/auth").permitAll() // Permitir login de usuário

                // acesso as imagens salvas
                .requestMatchers(HttpMethod.GET, "/imagens/**").permitAll()

                 //Regras de Autorização para ARQUIVOS
                .requestMatchers(HttpMethod.POST, "/imagens/upload").hasAnyRole("NIVEL1", "NIVEL2")


                // Regras de Autorização para CATEGORIAS
                .requestMatchers(HttpMethod.GET, "/categorias").hasAnyRole("NIVEL1", "NIVEL2", "NIVEL3")
                .requestMatchers(HttpMethod.GET, "/categorias/{id}").hasAnyRole("NIVEL1", "NIVEL2", "NIVEL3")
                .requestMatchers(HttpMethod.POST, "/categorias").hasAnyRole("NIVEL1", "NIVEL2", "NIVEL3")
                .requestMatchers(HttpMethod.PUT, "/categorias/**").hasAnyRole("NIVEL1", "NIVEL2", "NIVEL3")
                .requestMatchers(HttpMethod.DELETE, "/categorias/**").hasAnyRole("NIVEL1", "NIVEL2", "NIVEL3")

                // Regras de Autorização para DESPESAS
                .requestMatchers(HttpMethod.GET, "/despesas").hasAnyRole("NIVEL1", "NIVEL2")
                .requestMatchers(HttpMethod.GET, "/despesas/{id}").hasAnyRole("NIVEL1", "NIVEL2")
                .requestMatchers(HttpMethod.POST, "/despesas").hasAnyRole("NIVEL1", "NIVEL2")
                .requestMatchers(HttpMethod.PUT, "/despesas/**").hasAnyRole("NIVEL1", "NIVEL2")
                .requestMatchers(HttpMethod.DELETE, "/despesas/**").hasAnyRole("NIVEL1", "NIVEL2")

                // Regras de Autorização para RECEITAS
                .requestMatchers(HttpMethod.GET,"/receitas").hasAnyRole("NIVEL1", "NIVEL2")
                .requestMatchers(HttpMethod.GET, "/receitas/{id}").hasAnyRole("NIVEL1", "NIVEL2")
                .requestMatchers(HttpMethod.POST, "/receitas").hasAnyRole("NIVEL1", "NIVEL2")
                .requestMatchers(HttpMethod.PUT, "/receitas/**").hasAnyRole("NIVEL1", "NIVEL2")
                .requestMatchers(HttpMethod.DELETE, "/receitas/**").hasAnyRole("NIVEL1", "NIVEL2")


                 // Regras de Autorização para USUÁRIO
                .requestMatchers(HttpMethod.GET, "/usuarios").hasAnyRole("NIVEL1", "NIVEL2", "NIVEL3")
                .requestMatchers(HttpMethod.GET, "/usuarios/{id}").hasAnyRole("NIVEL1")
                 .requestMatchers(HttpMethod.POST, "/usuarios").hasAnyRole("NIVEL1")
                 .requestMatchers(HttpMethod.PUT, "/usuarios/**").hasAnyRole("NIVEL1")
                 .requestMatchers(HttpMethod.DELETE, "/usuarios/**").hasAnyRole("NIVEL1")

                //Todos os outros endpoints exigem autenticação
                .anyRequest().authenticated()
            )
            .headers(headers -> headers.frameOptions().disable()) // Necessário para H2 Console
            .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(usuarioDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

     @Bean
	  public WebMvcConfigurer corsConfigurer() {
	    return new WebMvcConfigurer() {
	      @Override
	      public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
	          .allowedOrigins("http://localhost:4200", "https://ds-projeto.netlify.app")
	          .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
	          .allowedHeaders("*")
	          .allowCredentials(true);
	      }
	    };
	  }  
}