package com.kant.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.kant.rest.model.Person;

/**
 * http://howtodoinjava.com/jersey/jersey-2-hello-world-application-tutorial/
 * https
 * ://github.com/swagger-api/swagger-core/wiki/Swagger-Core-Jersey-2.X-Project
 * -Setup-1.5
 * 
 * @author shaskant
 *
 */
@Api(value = "hello", description = "Endpoint for user management")
@Path("/hello")
public class HelloWorldService {

	@GET
	@Path("/{param}")
	@Produces(MediaType.TEXT_PLAIN)
	@ApiOperation(value = "Returns welcome message.", notes = "Returns a  welcome message for the param name passed.", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successful retrieval of response", response = String.class),
			@ApiResponse(code = 404, message = "Param passed is not good"),
			@ApiResponse(code = 500, message = "Internal server error") })
	public Response getMsg(@PathParam("param") String msg) {
		if ("bad".equalsIgnoreCase(msg)) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		String output = "Jersey say : " + msg;
		return Response.status(200).entity(output).build();
	}

	@GET
	@Path("/person/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Returns Person.", notes = "Returns a person details for value passed.", response = Person.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successful retrieval of response", response = Person.class),
			@ApiResponse(code = 404, message = "Param passed is not good"),
			@ApiResponse(code = 500, message = "Internal server error") })
	public Response getPerson(@PathParam("id") String id) {
		Person person = new Person();
		if ("1".equals(id)) {
			person.setAge(27);
			person.setEmailId("itsmeshashi@outlook.com");
			person.setFirstName("shashi");
			person.setLastName("kant");
			person.setPhone("532600021");

		} else if (Integer.parseInt(id) < 5) {
			person.setAge(22);
			person.setEmailId("dummayMail@fake.com");
			person.setFirstName("foo");
			person.setLastName("bar");
			person.setPhone("2343-243-234");
		} else
			return Response.status(Status.BAD_REQUEST).build();
		return Response.status(200).entity(person).build();
	}

}