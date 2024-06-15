package org.example.api.config

import org.example.domain.UserAuthority
import org.example.domain.UserType
import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("spring.security")
data class UserAuthorities (
    val authorities: Map<UserType, UserAuthority>
)