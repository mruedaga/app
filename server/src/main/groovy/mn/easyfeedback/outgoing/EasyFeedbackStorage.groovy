package mn.easyfeedback.outgoing

import mn.easyfeedback.core.model.EasyFeedback

interface EasyFeedbackStorage {

    Optional<EasyFeedback> get(String id)

    Optional<EasyFeedback> save(EasyFeedback easyfeedback)

}