package Scripts.DeliriousOutdoor;

import Level.Script;
import ScriptActions.ChangeFlagScriptAction;
import ScriptActions.LockPlayerScriptAction;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;

import java.util.ArrayList;

public class Scary2 extends Script {
     @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new TextboxScriptAction() {{
            addText("Female Student?: Someone saveth me!");
            
        }});

        scriptActions.add(new ChangeFlagScriptAction("Flee!", true));

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
