package mn.easyfeedback.outgoing.file

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import io.micronaut.context.annotation.Value
import mn.easyfeedback.core.model.EasyFeedback
import mn.easyfeedback.outgoing.EasyFeedbackStorage

import javax.annotation.PostConstruct
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Named("easyFeedbackStorage")
class EasyFeedbackFileStorage implements EasyFeedbackStorage {

    @Value('${easyfeedback.path:build}')
    String PATH

    @PostConstruct
    void init(){
        new File(PATH).mkdirs()
    }

    @Override
    Optional<EasyFeedback> get(String id) {
        try {
            File f = new File(PATH, "${id}.json")
            Optional.of(new JsonSlurper().parse(f) as EasyFeedback)
        }catch(e){
            println e.message
            Optional.empty()
        }
    }

    @Override
    Optional<EasyFeedback> save(EasyFeedback easyfeedback) {
        try{
            File f = new File(PATH,"${easyfeedback.id}.json")
            f.text = new JsonBuilder(easyfeedback).toPrettyString()
            Optional.of easyfeedback
        }catch(e){
            println e.message
            Optional.empty()
        }
    }
}
