package org.mcallydevelops;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Application {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        Connector connector = new ServerConnector(server);
        server.addConnector(connector);
        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/api/v1");
        ServletHolder servletHolder = context.addServlet(HelloWorldServlet.class, "/hello/*");
        servletHolder.setInitParameter("maxItems", "128");
        server.setHandler(context);
        server.start();
    }
}
