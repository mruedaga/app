package mn.easyfeedback.core.usecases.edit

import mn.easyfeedback.core.model.EasyFeedback
import mn.easyfeedback.core.usecases.EditUseCase
import mn.easyfeedback.outgoing.EasyFeedbackStorage

import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Named("editEasyFeedbackUseCase")
class EditEasyFeedbackUseCase implements EditUseCase {

    @Named("easyFeedbackStorage")
    @Inject
    EasyFeedbackStorage easyFeedbackStorage

    @Override
    Optional<EasyFeedback> execute(EasyFeedback easyfeedback) {
        easyfeedback.id = UUID.randomUUID().toString()
        easyFeedbackStorage.save(easyfeedback)
    }

}
