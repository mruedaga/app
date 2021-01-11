package mn.easyfeedback.incoming

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.security.annotation.Secured
import io.micronaut.security.authentication.Authentication
import io.micronaut.security.rules.SecurityRule
import mn.easyfeedback.core.model.Command
import mn.easyfeedback.core.model.EasyFeedback
import mn.easyfeedback.core.usecases.CommandUseCase
import mn.easyfeedback.core.usecases.FindUseCase

import javax.inject.Inject

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/api/feedback")
class FeedbackController {

    @Inject
    CommandUseCase commandUseCase

    @Inject
    FindUseCase findUseCase

    @Secured(SecurityRule.IS_ANONYMOUS)
    @Get("{id}")
    Optional<EasyFeedback> find(String id){
        findUseCase.execute( id )
    }

    @Post("{id}/start")
    boolean start(Authentication authentication, String id){
        Command command = Command.builder().id(id).extra(authentication.name).action("start").build()
        commandUseCase.execute( command )
    }

    @Post("{id}/stop")
    boolean stop(Authentication authentication, String id){
        Command command = Command.builder().id(id).extra(authentication.name).action("stop").build()
        commandUseCase.execute( command )
    }

    @Post("{id}/reset")
    boolean reset(Authentication authentication, String id){
        Command command = Command.builder().id(id).extra(authentication.name).action("reset").build()
        commandUseCase.execute( command )
    }
}
