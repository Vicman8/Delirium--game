package Scripts.ACParts;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.ChangeFlagScriptAction;
import ScriptActions.LockPlayerScriptAction;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;

public class CirculatingFanScript extends Script {
     @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new TextboxScriptAction() {{
            addText("You Picked up the Circulating Fan");
            
        }});

        scriptActions.add(new ChangeFlagScriptAction("CirculatingFan", true));

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
