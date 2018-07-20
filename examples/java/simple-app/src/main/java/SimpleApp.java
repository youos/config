import com.typesafe.config.*;
import simplelib.*;

import java.io.File;

class SimpleApp {
    public static void main(String[] args) {

        Config conf = ConfigFactory.parseFile(new File("C:\\Users\\Growthteam\\Documents\\IdeaProjects\\lightbend-config\\examples\\java\\simple-app\\src\\main\\resources\\application.conf"));


        System.out.println(conf.resolve().getValue("app.simple").origin().substitutionPath());

    }
}
