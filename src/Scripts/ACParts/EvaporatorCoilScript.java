package Scripts.ACParts;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;

public class EvaporatorCoilScript extends Script {
     @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();




        scriptActions.add(new TextboxScriptAction() {{
            addText("Meow");
        }});


        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
