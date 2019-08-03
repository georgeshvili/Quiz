package Loggers;

import java.util.logging.*;

public class Test {

    private static void configureLogging() {

        Logger LOGGER_A = Logger.getLogger("ClassA");
        LOGGER_A.setLevel(Level.ALL);
        Logger LOGGER_B = Logger.getLogger("ClassB");
        LOGGER_B.setLevel(Level.WARNING);
        Logger LOGGER = Logger.getLogger("Quiz/src/Loggers");
        LOGGER.setUseParentHandlers(false);

        Handler CH = new ConsoleHandler();
        Formatter XML = new XMLFormatter();
        CH.setLevel(Level.ALL);
        LOGGER.addHandler(CH);
        CH.setFormatter(XML);
    }

    public static void main(String[] args){

        configureLogging();

    }

}
