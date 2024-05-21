package at.htl.post.model;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/albums")
@Consumes(MediaType.APPLICATION_JSON)
public interface AlbumClient {
    @GET
    Album[] all();
}
