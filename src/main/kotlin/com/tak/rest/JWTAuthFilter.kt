package com.tak.rest

import com.fasterxml.jackson.databind.ObjectMapper
import com.tak.rest.resources.UserResource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.core.userdetails.User
import java.util.*

import com.tak.rest.SecurityUtils.HEADER_STRING
import com.tak.rest.SecurityUtils.SECRET
import com.tak.rest.SecurityUtils.TOKEN_PREFIX
import com.tak.rest.SecurityUtils.EXPIRATION_TIME


class JWTAuthFilter(
        @Autowired
        authenticationManager: AuthenticationManager
) : UsernamePasswordAuthenticationFilter() {

    override fun attemptAuthentication(request: HttpServletRequest?, response: HttpServletResponse?): Authentication {
        try {
            val creds: UserResource = ObjectMapper().readValue(request?.inputStream, UserResource::class.java)
            return authenticationManager.authenticate(
                    UsernamePasswordAuthenticationToken(
                        creds.username,
                        creds.password,
                        ArrayList())
            )
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }

    override fun successfulAuthentication(request: HttpServletRequest?, response: HttpServletResponse?, chain: FilterChain?, authResult: Authentication?) {

        val token = SecurityUtils.generateToken((authResult?.principal as User).username)
        response?.addHeader(HEADER_STRING, TOKEN_PREFIX + token)
    }
}