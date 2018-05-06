package com.tak.rest

import com.tak.rest.resources.UserResource
import com.tak.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletResponse
import javax.validation.Valid

@RestController
@RequestMapping(value = "/users")
class UserController(
    @Autowired
    val userService: UserService
){

    @PostMapping(value="/newuser")
    fun newUser(@Valid @RequestBody resource: UserResource, res: HttpServletResponse) {
        val success = userService.createUser(resource)
        if (success)
            res.addHeader(SecurityUtils.HEADER_STRING, SecurityUtils.TOKEN_PREFIX + SecurityUtils.generateToken(resource.username))
        else
            res.sendError(409)
    }

    @PostMapping(value="/login")
    fun login(@Valid @RequestBody resource: UserResource, res: HttpServletResponse){
        if (userService.checkLogin(resource))
            res.addHeader(SecurityUtils.HEADER_STRING, SecurityUtils.TOKEN_PREFIX + SecurityUtils.generateToken(resource.username))
        else
            res.sendError(401)
    }
}