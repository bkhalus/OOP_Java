import java.util.Arrays;

public class Application {
    public static void main(String[] args){
        

        CommandController controller = new CommandController();

        if (args == null || args.length ==  0){
            controller.setCommand(new UnknownCommand());
        }

        else if (Arrays.equals(args, new String[] {"help"})) {
            controller.setCommand(new HelpCommand());
        }

        else if (Arrays.equals(args, new String[] {"exit"})) {
            controller.setCommand(new ExitCommand());
        }

        else if (Arrays.equals(args, new String[] {"date", "now"})) {
            controller.setCommand(new DateNowCommand());
        }

        else if (args[0].equals("echo") && args.length == 2) {
            controller.setCommand(new EchoCommand(args[1]));
        }

        else {
            controller.setCommand(new UnknownCommand());
        }

        controller.pressButtun();

    }
}

class HelpCommand implements Command {
    public void execute(){
        System.out.println("Help executed");
    }
}

class EchoCommand implements Command {

    String msg;

    public EchoCommand(String msg){
        this.msg = msg;
    }

    public void execute() {
        System.out.println(msg);
    }

}

class DateNowCommand implements Command {
    public void execute() {
        System.out.println(System.currentTimeMillis());
    }
}

class ExitCommand implements Command {
    public void execute() {
        System.out.println("Goodbye!");
    }
}

class UnknownCommand implements Command {
    public void execute () {
        System.out.println("Error");
    }
}
    
class CommandController {
    private Command command;
    public void setCommand(Command command) {
        this.command = command;
    }
    public void pressButtun(){
        command.execute();
    }
}