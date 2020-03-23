package gtcloud.yqbjgh.controllers

import gtcloud.yqbjgh.services.UserLoginService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class UserLoginController {

    @Autowired
    UserLoginService service

    @GetMapping(value = "/UserLogin")
    String[] login(@RequestParam("id") String username, @RequestParam("pwd") String password) {
        return service.login(username, password)
    }
}
