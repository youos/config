import com.typesafe.config.*;
import simplelib.*;

import java.io.File;

public class SimpleApp {
    public static void main(String[] args) {

        Config conf = ConfigFactory.parseFile(new File("examples/java/simple-app/src/main/resources/application.conf"));
        Config resolved = conf.resolve();

        // TODO @benjo withChangedDefaultValue -> DONE
        // ConfigDelayedMerge wird kopiert und der Stack verändert
        // conf = conf.withChangedDefaultValue("app.envtest", ConfigValue)
        // --> this.root().get("app").withChangedDefaultValue("envtest", ConfigValue)
        // --> [...] this.root().get("app").replaceChild(...)
        // conf = conf.withChangedReference("app.envtest", "ENVTEST2") ...

        //System.out.println(resolved.getValue("app.simple").origin());
        //System.out.println(resolved.getValue("app.simple").origin().substitutionPath());
        //System.out.println(resolved.getValue("app.simple"));

        Config withChangedReference = conf.withChangedReference("app.envtest", "OTHERENV");
        System.out.println(withChangedReference);

        Config withChangedValue = conf.withChangedDefaultValue("app.envtest", ConfigValueFactory.fromAnyRef(true));
        System.out.println(withChangedValue);

        System.out.println();
        System.out.println(resolved.getValue("app.envtest").origin());
        System.out.println(resolved.getValue("app.envtest").origin().substitutionPath() + "  __ SHOULD BE ENVTEST");
        // TODO substituted value ausgeben -> DONE
        System.out.println(resolved.getValue("app.envtest").origin().substitutedValue());

    }
}
