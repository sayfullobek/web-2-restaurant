package it.ul.restaranserverbackend2.security;

import io.jsonwebtoken.*;
import it.ul.restaranserverbackend2.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class JwtTokenFilter extends OncePerRequestFilter {
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);
    @Autowired
    AuthService authService;
    @Value("${app.jwtSecretKey}")
    private String key;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        try {
            String token = request.getHeader("Authorization");
            if (token != null) {
                String tokenType = token.substring(0, 6);
                if (tokenType.equals("Bearer")) {
                    token = token.substring(7);
                    if (tokenValidmi(token)) {
                        String userId = getUserIdTokenningIchidan(token);
                        UserDetails userDetails = authService.getUserById(UUID.fromString(userId));
                        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                                userDetails, null, userDetails.getAuthorities()
                        );
                        usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                    }
                }
            }
        } catch (Exception e) {
            logger.error("kirish mumkin emas", e);
        }
        filterChain.doFilter(request, response);
    }

    public boolean tokenValidmi(String tokenjon) {
        try {
            Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(tokenjon);
            return true;
        } catch (SignatureException ex) {
            logger.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty.");
        }
        return false;
    }

    public String getUserIdTokenningIchidan(String token) {
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
