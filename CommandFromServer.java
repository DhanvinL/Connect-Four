import java.io.Serializable;

public class CommandFromServer implements Serializable
{
    // The command being sent to the client
    private int command;
    // Text data for the command
    private String data ="";

    // Command list

    public static final int DISCONNECTED = 8;

    public CommandFromServer(int command, String data) {
        this.command = command;
        this.data = data;
    }

    public int getCommand() {
        return command;
    }

    public String getData() {
        return data;
    }
}
