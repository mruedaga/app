package mn.easyfeedback.incoming

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.security.annotation.Secured
import io.micronaut.security.authentication.Authentication
import io.micronaut.security.rules.SecurityRule
import mn.easyfeedback.core.model.EasyFeedback
import mn.easyfeedback.core.usecases.EditUseCase

import javax.inject.Inject

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/edit")
class EditController {

    @Inject
    EditUseCase editUserCase

    @Post
    Optional<EasyFeedback> createOrUpdate(Authentication authentication, EasyFeedback easyfeedback){
        easyfeedback.author = authentication.name
        editUserCase.execute( easyfeedback )
    }

}
