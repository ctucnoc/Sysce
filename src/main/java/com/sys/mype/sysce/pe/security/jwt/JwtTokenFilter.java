package com.sys.mype.sysce.pe.security.jwt;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sys.mype.sysce.pe.dto.UserPrincipalDTO;
import com.sys.mype.sysce.pe.security.provider.MyAuthenticationProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.ExpiredJwtException;

public class JwtTokenFilter extends OncePerRequestFilter {

	private static final Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);

	@Autowired
	private JwtProvider jwtProvider;

	@Autowired
	private MyAuthenticationProvider myAuthenticationProvider;
	

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		logger.debug("processing authentication for '{}'", request.getRequestURL());

		final String requestHeader = request.getHeader("Authorization");

		String username = null;
		String authToken = null;
		if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
			authToken = requestHeader.substring(7);
			try {
				username = jwtProvider.getUsernameFromToken(authToken);
			} catch (IllegalArgumentException e) {
				logger.error("an error occured during getting username from token", e);
			} catch (ExpiredJwtException e) {
				logger.warn("the token is expired and not valid anymore", e);
			}
		} else {
			logger.warn("couldn't find bearer string, will ignore the header");
		}

		logger.debug("checking authentication for user '{}'", username);
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			logger.debug("security context was null, so authorizating user");

			// It is not compelling necessary to load the use details from the database. You
			// could also store the information
			// in the token and read it from it. It's up to you ;)

			UserPrincipalDTO user = (UserPrincipalDTO) myAuthenticationProvider.loadUserByUsername(username);

			// For simple validation it is completely sufficient to just check the token
			// integrity. You don't have to call
			// the database compellingly. Again it's up to you ;)
			if (jwtProvider.validateToken(authToken, user)) {
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null,
						user.getAuthorities());
				// authentication.setDetails(new
				// WebAuthenticationDetailsSource().buildDetails(request));
				logger.info("authorizated user '{}', setting security context", username);
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}

		chain.doFilter(request, response);
	}
}
