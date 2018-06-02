package com.leisucn.demo.echorng.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("echo")
public class EchoResource {

    @GET
    public String echo(){
        return String.valueOf(System.currentTimeMillis());
    }
}
