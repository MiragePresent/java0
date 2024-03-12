package org.miragepresent.java0;

import java.net.InetSocketAddress;

import org.miragepresent.java0.controller.HomePageHandler;

import com.sun.net.httpserver.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try { 
            Long serverPort = 8080L;
            System.out.println("Start listening on port " + serverPort + "...");
            HttpServer server = HttpServer.create(new InetSocketAddress(serverPort.intValue()),0);
            server.createContext("/", new HomePageHandler());
            server.setExecutor(null);
            server.start();
        } catch (Exception e) {
            System.out.print("Server error: " + e.getMessage());
        }
    }
}
