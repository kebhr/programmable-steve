package jp.kebihara.programmablesteve.server;

import jp.kebihara.programmablesteve.server.exceptions.InvalidArgumentException;
import jp.kebihara.programmablesteve.server.exceptions.UnknownCommandException;

public class CommandProcessor {
    public static void process(String cmd) throws UnknownCommandException, InvalidArgumentException {
        String[] cmds = cmd.split(" ");
        switch (cmds[0]) {
            case "key" -> {
                if (cmds.length != 3) {
                    throw new InvalidArgumentException();
                }
                switch (cmds[2]) {
                    case "down" -> Commander.keydown(cmds[1]);
                    case "up" -> Commander.keyup(cmds[1]);
                    default -> throw new InvalidArgumentException();
                }
            }
            case "yaw" -> {
                if (cmds.length != 2) {
                    throw new InvalidArgumentException();
                }
                Commander.yaw(Float.parseFloat(cmds[1]));
            }
            case "pitch" -> {
                if (cmds.length != 2) {
                    throw new InvalidArgumentException();
                }
                Commander.pitch(Float.parseFloat(cmds[1]));
            }
            default -> throw new UnknownCommandException();
        }
    }
}
