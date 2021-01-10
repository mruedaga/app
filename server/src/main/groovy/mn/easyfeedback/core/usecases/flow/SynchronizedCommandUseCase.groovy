package mn.easyfeedback.core.usecases.flow

import groovy.transform.Synchronized
import mn.easyfeedback.core.model.Command
import mn.easyfeedback.core.model.EasyFeedback
import mn.easyfeedback.core.usecases.CommandUseCase
import mn.easyfeedback.outgoing.EasyFeedbackStorage

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SynchronizedCommandUseCase implements CommandUseCase{

    @Inject
    EasyFeedbackStorage storage

    @Synchronized
    @Override
    Boolean execute(Command command) {
        Boolean ret = false;
        Optional<EasyFeedback> optional = storage.get(command.id)

        optional.ifPresent({ EasyFeedback easyfeedback ->
            switch (command.action) {
                case 'start':
                    ret = startFeedBack(easyfeedback, command.extra)
                    break
                case 'stop':
                    ret = stopFeedBack(easyfeedback, command.extra)
                    break
                case 'reset':
                    ret = resetFeedBack(easyfeedback, command.extra)
                    break
                case 'vote':
                    ret = voteFeedBack(easyfeedback, command.extra)
                    break
            }
            storage.save(easyfeedback)
        })

        ret
    }

    boolean startFeedBack(EasyFeedback easyfeedback, String user){
        if( easyfeedback.author == user ) {
            easyfeedback.state = "STARTED"
            return true
        }
        false
    }

    boolean stopFeedBack(EasyFeedback easyfeedback, String user){
        if( easyfeedback.author == user ) {
            if (easyfeedback.state && easyfeedback.state == 'STARTED') {
                easyfeedback.state = "CLOSED"
                return true
            }
        }
        false
    }


    boolean resetFeedBack(EasyFeedback easyfeedback, String user){
        if( easyfeedback.author == user ) {
            if (easyfeedback.state && easyfeedback.state == 'CLOSED') {
                easyfeedback.questions.each{
                    it.votes = 0
                }
                return true
            }
        }
        false
    }

    boolean voteFeedBack(EasyFeedback easyfeedback, String extra){
        if( easyfeedback.state && easyfeedback.state == 'STARTED' && extra.isNumber() ){
            easyfeedback.questions[extra as int].votes++
            return true
        }
        false
    }

}
