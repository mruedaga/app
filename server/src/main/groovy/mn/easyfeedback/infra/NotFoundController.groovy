package mn.easyfeedback.infra

import io.micronaut.core.io.ResourceLoader
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Error
import io.micronaut.http.hateoas.JsonError
import io.micronaut.http.hateoas.Link
import java.util.Collections

@Controller("/notfound")
class NotFoundController {

    final ResourceLoader loader
    NotFoundController(ResourceLoader loader){
        this.loader = loader
    }

    @Error(status = HttpStatus.NOT_FOUND, global = true)
    public HttpResponse notFound(HttpRequest request) {
        if (request.getHeaders()
                .accept()
                .stream()
                .anyMatch(mediaType -> mediaType.getName().contains(MediaType.TEXT_HTML))) {
            return HttpResponse.ok(
                    new String(loader.getResourceAsStream("public/index.html").get().readAllBytes())
            ).contentType(MediaType.TEXT_HTML)
        }

        JsonError error = new JsonError("Page Not Found")
                .link(Link.SELF, Link.of(request.getUri()));

        return HttpResponse.<JsonError>notFound()
                .body(error);
    }
}
