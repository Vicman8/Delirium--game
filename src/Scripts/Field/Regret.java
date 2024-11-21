package Scripts.Field;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.ChangeFlagScriptAction;
import ScriptActions.LockPlayerScriptAction;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;

public class Regret extends Script {
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new TextboxScriptAction() {{
            addText("Victor: I... regreteth nothing...");
            addText("Victor: At least I wast cold for a dram while.");
            addText("Victor: Urgh... my stomach...");
        }});

        scriptActions.add(new ChangeFlagScriptAction("danaIntroed", true));

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
