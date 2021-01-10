package mn.easyfeedback.core.usecases

import mn.easyfeedback.core.UseCase
import mn.easyfeedback.core.model.EasyFeedback

interface FindUseCase extends UseCase<String, Optional<EasyFeedback> > {

}