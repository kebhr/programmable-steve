package jp.kebihara.programmablesteve.server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class APIServer {
    public void start() {
        // TODO: research how to start the server with client only and rewrite this without try-catch
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(43001), 0);
            server.createContext("/", new CommandHandler());
            server.start();
        } catch (IOException e) {
            // TODO: error handling
        }
    }
}
