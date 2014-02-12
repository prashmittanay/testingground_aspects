package testing.ground.rest;

import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import testing.ground.beans.TempBean;
import testing.ground.dao.MiscDao;

@Component
@Path("/misc")
public class MiscRest {
	@Autowired MiscDao miscDao;
	
	
	@GET
	@Path("/autocompleteusers")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAutoUsers(@QueryParam("term") String user){
		List<String> autoUsers = miscDao.getAutoUsers(user);
		return Response.status(200).entity(autoUsers).build();
	}
	
	@POST
	@Path("/binddata")
	@Produces(MediaType.APPLICATION_JSON)
	public Response bindData(TempBean data){
		System.out.println(data);
		return Response.status(200).build();
	}
	
	@GET
	@Path("/halt-request-one")
	@Produces(MediaType.TEXT_HTML)
	public Response haltRequestOne(@QueryParam("duration") String duration){
		long d = 0l;
		try{
			d = Long.parseLong(duration);
		}catch(NumberFormatException e){
			System.out.println(">>>>>>>>>>>>>>>>parsing failed....assigning default value");
			d = 2000l;
		}
		
		try {
			Thread.sleep(d);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return Response.status(200).entity("hello world").build();
	}
}
