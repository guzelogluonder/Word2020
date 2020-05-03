import java.util.ArrayList;
import java.util.List;

public class Writer {
    private List<Command> commandList = new ArrayList<Command>();

    public void takeCommand(Command command){
        commandList.add(command);
    }

    public void executeCommand(){

        for (Command command : commandList) {
            command.execute();
        }
        commandList.clear();
    }}
