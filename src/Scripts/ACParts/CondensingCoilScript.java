package Scripts.ACParts;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.ChangeFlagScriptAction;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;

public class CondensingCoilScript extends Script {
     @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();




        scriptActions.add(new TextboxScriptAction() {{
            addText("You picked up the Condensing Coil");
        }});

        scriptActions.add(new ChangeFlagScriptAction("Condensing", true));


        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
