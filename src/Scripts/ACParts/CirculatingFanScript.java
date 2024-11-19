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
            addText("Pub Sec?: Headeth inside!\ni shall protecteth thee all from harmeth!");
            
        }});

        scriptActions.add(new ChangeFlagScriptAction("Bear!", true));

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
