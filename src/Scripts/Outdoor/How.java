package Scripts.Outdoor;

import Level.Script;
import ScriptActions.ChangeFlagScriptAction;
import ScriptActions.LockPlayerScriptAction;
import ScriptActions.NPCFacePlayerScriptAction;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;

import java.util.ArrayList;


public class How extends Script {
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());
        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new TextboxScriptAction() {{
            addText("Student: Excuse me!\nDon't go any further, there's a bear!");
            addText("Kaegen: A bear?");
            
        }});

        scriptActions.add(new ChangeFlagScriptAction("E", true));

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
