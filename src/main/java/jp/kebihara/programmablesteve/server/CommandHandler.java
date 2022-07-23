package jp.kebihara.programmablesteve.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import jp.kebihara.programmablesteve.server.exceptions.InvalidArgumentException;
import jp.kebihara.programmablesteve.server.exceptions.UnknownCommandException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class CommandHandler implements HttpHandler {
    public void handle(HttpExchange httpExchange) throws IOException {
        // process request
        InputStream is = httpExchange.getRequestBody();
        byte[] b = is.readAllBytes();
        is.close();
        String cmd = new String(b);

        // CORS
        httpExchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");

        String resp = "";

        String method = httpExchange.getRequestMethod();
        switch (method.toUpperCase()) {
            case "POST" -> {
                // process command
                resp = "ok";
                try {
                    CommandProcessor.process(cmd);
                } catch (UnknownCommandException | InvalidArgumentException e) {
                    resp = "ng";
                    e.printStackTrace();
                }
            }
            case "OPTIONS" -> {
                // CORS
                httpExchange.getResponseHeaders().add("Access-Control-Allow-Methods", "*");
                httpExchange.sendResponseHeaders(204, 0);
                return;
            }
        }

        // make response
        httpExchange.sendResponseHeaders(200, resp.getBytes(StandardCharsets.UTF_8).length);

        // return response
        OutputStream os = httpExchange.getResponseBody();
        os.write(resp.getBytes());
        os.close();
    }
}
