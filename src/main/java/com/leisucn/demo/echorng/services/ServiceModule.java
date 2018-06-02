package com.leisucn.demo.echorng.services;

import com.google.inject.AbstractModule;

public class ServiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(EchoResource.class);
    }
}
