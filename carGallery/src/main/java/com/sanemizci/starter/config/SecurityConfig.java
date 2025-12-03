package com.sanemizci.starter.config;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    public static final String REGISTER="/register";
    public static final String AUTHENTICATE="/authenticate";
    public static final String REFRESH_TOKEN="/refresh_token";

    @Autowired
    private JWTAuthenticationFilter jwtAuthenticationFilter;
    @Autowired
    private AuthenticationProvider authenticationProvider;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())//csrf korumasını devre dışı bırakır
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(REGISTER, AUTHENTICATE, REFRESH_TOKEN).permitAll()
                .anyRequest().authenticated())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
        
    }


}
