package Scripts.Outdoor;

import Level.Script;
import ScriptActions.ChangeFlagScriptAction;
import ScriptActions.LockPlayerScriptAction;
import ScriptActions.NPCFacePlayerScriptAction;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;

import java.util.ArrayList;

public class CheckUp extends Script {
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());
        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new TextboxScriptAction() {{
            addText("Pub Sec: Hey Kid! You ok?!");
            addText("Kaegen: I'm fine.");
            addText("Pub Sec: Watch out for that bear down there!");
            addText("Kaegen: Ok sir.");
        }});

        scriptActions.add(new ChangeFlagScriptAction("checkDone", true));

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
