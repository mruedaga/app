package mn.easyfeedback.core.model

import groovy.transform.builder.Builder

@Builder
class Command {

    String id

    String action

    String extra

}
