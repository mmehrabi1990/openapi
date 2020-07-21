package com.mehrabi.openapi;

import com.mehrabi.openapi.data.TodoInput;
import com.mehrabi.openapi.entities.Todo;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/")
@Server(url = "/openapi-1.0-SNAPSHOT")
@Stateless
@OpenAPIDefinition(tags={@Tag(name = "todo")})
public class TodoService {

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(summary="Fetches all to dos")
	@ApiResponse(responseCode="200", description="Success")
	public List<Todo> getAll(@Parameter(required = true) @PathParam("id") Long id) {
		return new ArrayList<>();
	}

	@POST
	@Path("/create/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Operation(summary="Creates a new todo")
	@ApiResponse(responseCode="204", description="Success")
	public void create(@Parameter(required = true) TodoInput incoming) {
		Todo todo = new Todo();
		todo.setDescription(incoming.getDescription());
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Operation(summary="Updates a new todo")
	@ApiResponse(responseCode="204", description="Success")
	@ApiResponse(responseCode="404", description="Not Found")
	public void update(
		@Parameter(required = true) @PathParam("id") Long id,
		@Parameter(required = true) TodoInput incoming) {
		Todo todo = new Todo();
		todo.setDescription(incoming.getDescription());

	}

	@DELETE
	@Path("{id}")
	@Operation(summary="Removes a new todo")
	@ApiResponse(responseCode="204", description="Success")
	@ApiResponse(responseCode="404", description="Not Found")
	public void remove(@Parameter(required = true) @PathParam("id") Long id) {

	}
}
