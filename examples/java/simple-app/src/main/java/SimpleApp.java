import com.typesafe.config.*;
import simplelib.*;

import java.io.File;

class SimpleApp {
    public static void main(String[] args) {

        Config conf = ConfigFactory.parseFile(new File("C:\\Users\\Growthteam\\Documents\\IdeaProjects\\lightbend-config\\examples\\java\\simple-app\\src\\main\\resources\\application.conf"));

        Config resolved = conf.resolve();
        System.out.println(resolved.getValue("app.envtest"));

    }
}
