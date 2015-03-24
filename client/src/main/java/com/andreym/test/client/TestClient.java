package com.andreym.test.client;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by amisnik on 24.03.2015.
 */
public class TestClient {

    public static void main(String[] args) {
        try {
            XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
            config.setServerURL(new URL("http://localhost:8080/xmlrpc"));

            List<Integer> params = new ArrayList<Integer>();
            params.add(12);
            params.add(14);

            XmlRpcClient client = new XmlRpcClient();
            client.setConfig(config);
            Object result = client.execute("TestServer.sum", params);

            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
