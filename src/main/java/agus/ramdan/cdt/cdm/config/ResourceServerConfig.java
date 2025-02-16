package agus.ramdan.cdt.cdm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Profile("oauth2")
public class ResourceServerConfig {

    // @formatter:off
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(auth -> auth
//                        .antMatchers(
//                                "/v3/api-docs/**",   // OpenAPI JSON
//                                "/swagger-ui/**",     // Swagger UI HTML
//                                "/swagger-ui.html"    // Swagger UI utama
//                        ).permitAll() // Tidak perlu autentikasi
//                        .and()
//                        .requestMatchers()
//                        .antMatchers(HttpMethod.GET, "/api/cdt/cdm/**").hasAuthority("SCOPE_cdm.read")
//                        .antMatchers(HttpMethod.POST, "/api/cdt/cdm/**").hasAuthority("SCOPE_cdm.write")
//                        .anyRequest().authenticated()
//                )
//                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
//
//        return http.build();
        http
                .authorizeRequests()
                // Swagger UI bebas diakses
                .antMatchers(
                        "/v3/api-docs/**",
                        "/swagger-ui/**",
                        "/swagger-ui.html"
                ).permitAll()

                // GET butuh scope "read"
                .antMatchers(HttpMethod.GET, "/api/**").hasAuthority("SCOPE_cdm.read")

                // POST, PUT, DELETE butuh scope "write"
                .antMatchers(HttpMethod.POST, "/api/**").hasAuthority("SCOPE_cdm.write")
                .antMatchers(HttpMethod.PUT, "/api/**").hasAuthority("SCOPE_cdm.write")
                .antMatchers(HttpMethod.DELETE, "/api/**").hasAuthority("SCOPE_cdm.write")

                // Semua request lain harus autentikasi
                .anyRequest().authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt(); // Menggunakan JWT
        return http.build();
    }
    // @formatter:on

}