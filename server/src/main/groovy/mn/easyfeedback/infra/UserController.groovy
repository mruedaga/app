package mn.easyfeedback.infra

import io.micronaut.context.annotation.Value
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.CookieValue
import io.micronaut.http.annotation.Get
import io.micronaut.http.cookie.Cookie
import io.micronaut.http.cookie.CookieFactory
import io.micronaut.http.cookie.SameSite
import io.micronaut.security.annotation.Secured
import io.micronaut.security.authentication.Authentication
import io.micronaut.security.rules.SecurityRule

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/user")
class UserController {

    @Get
    String userDetails(Authentication authentication){
        authentication.attributes['name']
    }

    @Value('${micronaut.security.redirect.after-login-success}')
    String afterLogin = ""


    @Get("afterlogin")
    MutableHttpResponse<String> fromLogin(@CookieValue("JWT") String jwt){
        Cookie cookie = CookieFactory.INSTANCE.create("JWT",jwt)
        cookie.sameSite(SameSite.None)
        cookie.secure(true)
        cookie.maxAge(60*5)
        cookie.path('/')
        HttpResponse.temporaryRedirect( afterLogin.toURI()).cookie(cookie)
    }

}
