package Scripts.DeliriousOutdoor;

import Level.Script;
import ScriptActions.ChangeFlagScriptAction;
import ScriptActions.LockPlayerScriptAction;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;

import java.util.ArrayList;

public class Scary3 extends Script {
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
