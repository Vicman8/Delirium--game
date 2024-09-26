package Scripts.MyMap;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.*;

public class StartIntro extends Script {
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new TextboxScriptAction() {{
            addText("Damn its hot today! I feel gross.");
            addText("Time to shower I suppose.");
            addText("Yep. Just another day in Mantle.");
        }});

        scriptActions.add(new ChangeFlagScriptAction("introStarted", true));

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
