package org.acme.security;

import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.time.Instant;
import java.util.Set;

@ApplicationScoped
public class JwtService {

    @ConfigProperty(name = "mp.jwt.verify.issuer")
    String issuer;

    @ConfigProperty(name = "quarkus.smallrye-jwt.token.expiration", defaultValue = "3600")
    long expirationSeconds;

    public String generateToken(String subject, String role) {
        return Jwt.issuer(issuer)
                .subject(subject)
                .groups(Set.of(role))
                .claim("role", role)
                .expiresAt(Instant.now().plusSeconds(expirationSeconds))
                .sign();
    }
}
