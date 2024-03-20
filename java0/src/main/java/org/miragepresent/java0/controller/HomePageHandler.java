package org.miragepresent.java0.controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;

public class HomePageHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange t) throws IOException {
        String hello = "Hello world!";
        t.sendResponseHeaders(200, hello.length());
        OutputStream os = t.getResponseBody();
        os.write(hello.getBytes());
        os.close();
    }
}
