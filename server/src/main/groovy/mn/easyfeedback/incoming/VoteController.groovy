package mn.easyfeedback.incoming

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import mn.easyfeedback.core.model.Command
import mn.easyfeedback.core.usecases.CommandUseCase

import javax.inject.Inject

@Controller("/vote")
@Secured(SecurityRule.IS_ANONYMOUS)
class VoteController {

    @Inject
    CommandUseCase useCase

    @Post
    boolean vote(String id, String question){
        Command command = Command.builder().id(id).action("vote").extra(question).build()
        useCase.execute( command)
    }

    @Get("{id}")
    void sse(String id){
        println "TODO!!"
    }
}
