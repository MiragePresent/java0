package org.miragepresent.java0;

import java.net.InetSocketAddress;
import java.rmi.ServerException;

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
            String serverPort = System.getenv("HTTP_LISTENING_PORT");
            
            if (serverPort == null) {
                    System.out.println("HTTP_LISTENING_PORT is not define. Defaulting to 8080");
                serverPort = "8080";
            }

            Long portNumber = Long.valueOf(serverPort);
            System.out.println("Start listening on port " + serverPort + "...");
            HttpServer server = HttpServer.create(new InetSocketAddress(portNumber.intValue()),0);
            server.createContext("/", new HomePageHandler());
            server.setExecutor(null);
            server.start();
        } catch (NumberFormatException e) {
            System.out.println("Cannot start webserver. HTTP_LISTENING_PORT is invalid");
        } catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
