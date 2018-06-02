package com.leisucn.demo.echorng.server;

import com.google.inject.AbstractModule;

public class ServerModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(EmbeddedServer.class).toInstance(new EmbeddedServer());
    }

}
