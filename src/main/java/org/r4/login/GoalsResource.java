package org.r4.login;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.jboss.logging.Logger;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.r4.login.*;


import org.jboss.resteasy.annotations.jaxrs.PathParam;
//import jdk.nashorn.internal.objects.annotations.Getter;

@Path("/financial-kids-api-goals")
@Produces(APPLICATION_JSON)
@Consumes("application/json")
public class GoalsResource {

    private static final Logger LOGGER = Logger.getLogger(GoalsResource.class);

    @Inject
    GoalsService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/goals/hello")
    public String hello() {
        return "login service is up";
    }
    
    @Operation(summary = "obtiene todas las goals")
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema (implementation = Goals.class  )))
    @GET
    @Path("/goals")
    public Response goals() {
        List<Goals> goals = service.goals();
        return Response.ok(goals).build();
    }
}