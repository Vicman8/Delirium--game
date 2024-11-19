package Scripts.ACParts;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;

public class CondensingCoilScript extends Script {
     @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();




        scriptActions.add(new TextboxScriptAction() {{
            addText("You picked up the dog");
        }});


        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
