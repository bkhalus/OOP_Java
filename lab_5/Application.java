public class Application {
    public static void main(String[] args){
        CommandController controller = new CommandController();
       
        if (args.length <= 0) {
            controller.setCommand(new UnknownCommand());
        } else if (args[0].equals("help")) {
            controller.setCommand(new HelpCommand());
        } else if (args[0].equals("exit")) {
            controller.setCommand(new ExitCommand());
        } else if (args.length > 1) {
            if (args[0].equals("echo") && args[1] != null) {
                controller.setCommand( new EchoCommand(args[1]));
            } else if (args[0].equals("date") && args[1].equals("now")) {
                controller.setCommand( new DateNowCommand());
            }
        } else {
            controller.setCommand( new UnknownCommand() );
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