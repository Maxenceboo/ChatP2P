package chatSystem.utils;

import chatSystem.model.Message;
import chatSystem.model.Personne;
import chatSystem.view.GuiChatSystem;

public class utils {
    private static int value = 0;

    public static Message parseMessage(String str) {
        // parse message (ip name message)
        String[] parts = str.split("/(\\b\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\b) (\\S+) (.+)/");
        if (parts.length == 3) {
            Personne sender = new Personne(parts[0], parts[1]);
            return new Message(parts[2], sender);
        }
        return null;
    }

    public static Personne parseHello(String str , GuiChatSystem guiChatSystem) {
        // parse hello (ip) (name)
        String[] parts = str.split("/hello (\\b\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\b) (\\S+) ([01])$/");
        if (parts.length == 3) {
            if (parts[2].equals("1")) {
                return new Personne(parts[0], parts[1]);
            }
            if (parts[2].equals("0")) {
                // TODO: send hello to user (ip name 1)
                Personne personne = new Personne(parts[0], parts[1]);
                guiChatSystem.getController().sendMessage(new Message(parts[0], personne));
                return personne;
            }
        }
        return null;
    }

    public static String createHello(Personne me) {
        String message = "hello " + me.getIp() + " " + me.getPseudo() + " " + utils.value;
        utils.value = 1;
        return message;
    }

}
