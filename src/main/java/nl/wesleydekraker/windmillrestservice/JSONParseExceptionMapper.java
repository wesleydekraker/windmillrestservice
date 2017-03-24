package nl.wesleydekraker.windmillrestservice;

import com.fasterxml.jackson.core.JsonParseException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class JSONParseExceptionMapper implements ExceptionMapper<JsonParseException> {
    @Override
    public Response toResponse(final JsonParseException jpe) {
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
