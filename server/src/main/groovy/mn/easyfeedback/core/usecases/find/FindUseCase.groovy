package mn.easyfeedback.core.usecases.find

import mn.easyfeedback.core.model.EasyFeedback
import mn.easyfeedback.outgoing.EasyFeedbackStorage

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FindUseCase implements mn.easyfeedback.core.usecases.FindUseCase{

    @Inject
    EasyFeedbackStorage storage

    @Override
    Optional<EasyFeedback> execute(String id) {
        storage.get(id)
    }
}
