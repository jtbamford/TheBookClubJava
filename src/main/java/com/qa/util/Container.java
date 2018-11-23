package com.qa.util;

import javax.ws.rs.container.*;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@PreMatching
public class Container implements ContainerResponseFilter { 
	

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        MultivaluedMap<String,Object> headers = containerResponseContext.getHeaders();
        //Required for GET
        headers.add("Access-Control-Allow-Origin", "*");
        //Required for POST
        headers.add("Access-Control-Allow-Headers", "Authorization, Origin, X-Requested-With, Content-Type");


//        headers.add("Access-Control-Expose-Headers", "Location, Content-Disposition");
        headers.add("Access-Control-Allow-Methods", "POST, PUT, GET, DELETE, HEAD, OPTIONS");
//        containerRequestContext.getHeaders().add("Access-Control-Allow-Origin", "*");
    }
}

