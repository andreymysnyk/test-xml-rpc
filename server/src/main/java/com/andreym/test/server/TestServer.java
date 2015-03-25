package com.andreym.test.server;

import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.webserver.WebServer;

/**
 * Created by amisnik on 24.03.2015.
 */
public class TestServer {

    public Integer sum(Integer a, Integer b) {
        return a + b;
    }

    public static void main(String[] args) {
        try {
            WebServer webServer = new WebServer(8080);

            PropertyHandlerMapping mapping = new PropertyHandlerMapping();
            mapping.addHandler("TestServer", com.andreym.test.server.TestServer.class);

            XmlRpcServer server = webServer.getXmlRpcServer();
            server.setHandlerMapping(mapping);

            webServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
