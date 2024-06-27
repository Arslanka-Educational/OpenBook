package org.example.service

import org.example.domain.AuthorizationUserDetails
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.oauth2.jwt.JwtClaimsSet
import org.springframework.security.oauth2.jwt.JwtEncoder
import org.springframework.security.oauth2.jwt.JwtEncoderParameters
import org.springframework.stereotype.Service
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.stream.Collectors

@Service
class JwtService(
    private val jwtEncoder: JwtEncoder
) {
    fun generateToken(authorizationUserDetails: AuthorizationUserDetails): String {
        val now = Instant.now()

        val scope: String = authorizationUserDetails.authorities.stream()
            .map { obj: GrantedAuthority -> obj.authority }
            .collect(Collectors.joining(" "))

        val claimsSet: JwtClaimsSet = JwtClaimsSet.builder()
            .issuer("self")
            .issuedAt(now)
            .expiresAt(now.plus(1, ChronoUnit.DAYS))
            .subject(authorizationUserDetails.user.id.toString())
            .claim("scope", scope)
            .build()
        return jwtEncoder.encode(JwtEncoderParameters.from(claimsSet)).tokenValue
    }
}