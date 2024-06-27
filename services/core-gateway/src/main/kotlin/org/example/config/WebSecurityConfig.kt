package org.example.config

import com.nimbusds.jose.jwk.JWKSet
import com.nimbusds.jose.jwk.RSAKey
import com.nimbusds.jose.jwk.source.ImmutableJWKSet
import com.nimbusds.jose.proc.SecurityContext
import org.example.service.AuthorizationUserDetailsService
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.ProviderManager
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.oauth2.jwt.JwtDecoder
import org.springframework.security.oauth2.jwt.JwtEncoder
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder
import org.springframework.security.web.SecurityFilterChain
import java.security.interfaces.RSAPrivateKey
import java.security.interfaces.RSAPublicKey

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(jsr250Enabled = true)
class WebSecurityConfig(
    @Value("\${rsa.public-key}") private val rsaPublicKey: RSAPublicKey,
    @Value("\${rsa.private-key}") private val rsaPrivateKey: RSAPrivateKey,
) {
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeRequests { auth ->
                auth
                    .requestMatchers("/v1/client/register").permitAll()
                    .requestMatchers("/v1/client/login").permitAll()
                    .anyRequest().authenticated()
            }
            .headers { header -> header.frameOptions { it.sameOrigin() } }
            .httpBasic { }
            .oauth2ResourceServer { it.jwt { } }
            .cors {
            }
            .csrf { it.disable() }
        return http.build()
    }

    @Bean
    fun authenticationManager(authorizationUserDetailsService: AuthorizationUserDetailsService): AuthenticationManager =
        ProviderManager(DaoAuthenticationProvider().also {
            it.setUserDetailsService(authorizationUserDetailsService)
            it.setPasswordEncoder(passwordEncoder())
        })

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    @Bean
    fun jwtDecoder(): JwtDecoder = NimbusJwtDecoder.withPublicKey(rsaPublicKey).build()

    @Bean
    fun jwtEncoder(): JwtEncoder {
        val jwk = RSAKey.Builder(rsaPublicKey).privateKey(rsaPrivateKey).build()
        val jwks = ImmutableJWKSet<SecurityContext>(JWKSet(jwk))
        return NimbusJwtEncoder(jwks)
    }
}