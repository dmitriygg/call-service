package com.grigoryevdev.testprojects.callsservice;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;


public class Starter {

    public static void main( final String[] args ) throws Exception {
        Server server = new Server( 8080 );

        WebAppContext context = new WebAppContext();
        context.setDescriptor("WEB-INF/web.xml");
        context.setContextPath("/");

        server.setHandler(context);
        server.start();
        server.join();
    }

}
