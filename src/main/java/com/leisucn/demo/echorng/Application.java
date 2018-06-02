package com.leisucn.demo.echorng;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.leisucn.demo.echorng.server.EmbeddedServer;
import com.leisucn.demo.echorng.server.ServerModule;
import com.leisucn.demo.echorng.services.ServiceModule;
import org.jboss.resteasy.plugins.guice.ModuleProcessor;

public class Application {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ServerModule()
                , new ServiceModule());

        EmbeddedServer server = injector.getInstance(EmbeddedServer.class);

        server.start(9480);

        if (server.getStatus() == EmbeddedServer.STATUS.UP) {
            System.out.println("Start Server Success.");

            ModuleProcessor processor = new ModuleProcessor(server.getDeployment().getRegistry()
                    , server.getDeployment().getProviderFactory());

            processor.processInjector(injector);

        } else {
            System.out.println("Start Server Fatal!!!");
        }
    }
}
