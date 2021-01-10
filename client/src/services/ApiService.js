export default class APIService {

    constructor(axios) {
        this.axios = axios
    }

    loadUser(){
        return this.axios.get(`user`)
    }

    generateCode(json) {
        return this.axios.post(`edit`, json)
    }

    startEasyFeedback(uuid) {
        return this.axios.post(`feedback/${uuid}/start`)
    }

    stopEasyFeedback(uuid) {
        return this.axios.post(`feedback/${uuid}/stop`)
    }

    resetEasyFeedback(uuid) {
        return this.axios.post(`feedback/${uuid}/reset`)
    }

    getEasyFeedback(uuid) {
        return this.axios.get(`feedback/${uuid}`)
    }

    voteEasyFeedback(uuid, question) {
        return this.axios.post(`vote`, {
            id:uuid,
            question:question
        })
    }

}