package mn.easyfeedback.incoming

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import io.micronaut.http.sse.Event
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.FlowableEmitter
import mn.easyfeedback.core.model.Command
import mn.easyfeedback.core.model.EasyFeedback
import mn.easyfeedback.core.usecases.CommandUseCase
import mn.easyfeedback.core.usecases.FindUseCase

import javax.inject.Inject
import java.util.concurrent.TimeUnit

@Controller("/api/vote")
@Secured(SecurityRule.IS_ANONYMOUS)
class VoteController {

    @Inject
    CommandUseCase useCase

    @Inject
    FindUseCase findUseCase

    @Post
    boolean vote(String id, String question){
        Command command = Command.builder().id(id).action("vote").extra(question).build()
        useCase.execute( command)
    }

    @Produces(MediaType.TEXT_EVENT_STREAM)
    @Get("{id}")
    Flowable<Event<EasyFeedback>> sse(String id){
        Flowable<Event<EasyFeedback>>.fromCallable({
            Optional<EasyFeedback> optional = findUseCase.execute(id)
            EasyFeedback ret = optional.orElse(new EasyFeedback(id:id))
        }).repeat().delay(1, TimeUnit.SECONDS)
    }

}
