import com.typesafe.config.*;
import simplelib.*;

import java.io.File;

class SimpleApp {
    public static void main(String[] args) {

        Config conf = ConfigFactory.parseFile(new File("examples/java/simple-app/src/main/resources/application.conf"));
        Config resolved = conf.resolve();

        System.out.println(resolved.getValue("app.simple").origin());
        System.out.println(resolved.getValue("app.simple").origin().substitutionPath());
        System.out.println(resolved.getValue("app.simple"));

        System.out.println();
        System.out.println(resolved.getValue("app.envtest").origin());
        System.out.println(resolved.getValue("app.envtest").origin().substitutionPath() + "  __ SHOULD BE ENVTEST");
        System.out.println(resolved.getValue("app.envtest"));

    }
}
