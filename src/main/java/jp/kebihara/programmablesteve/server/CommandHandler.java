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
    public void handle(HttpExchange t) throws IOException {
        // process request
        InputStream is = t.getRequestBody();
        byte[] b = is.readAllBytes();
        is.close();
        String cmd = new String(b);

        // process command
        String resp = "ok";
        try {
            CommandProcessor.process(cmd);
        } catch (UnknownCommandException | InvalidArgumentException e) {
            resp = "ng";
            e.printStackTrace();
        }

        // make response
        t.sendResponseHeaders(200, resp.getBytes(StandardCharsets.UTF_8).length);

        // return response
        OutputStream os = t.getResponseBody();
        os.write(resp.getBytes());
        os.close();
    }
}
