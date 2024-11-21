package Scripts.Field;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.ChangeFlagScriptAction;
import ScriptActions.LockPlayerScriptAction;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;

public class CheerUp extends Script {
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new TextboxScriptAction() {{
            addText("Frank Lynn: I'm sorry I busted thee.");
            addText("Frank Lynn: I'm surprised thee couldst coequal\nconsume an A.C parteth!");
            addText("Frank Lynn: We may beest in troubleth\nwith administration but...");
            addText("Frank Lynn: At least we're facing it together.");
        }});

        scriptActions.add(new ChangeFlagScriptAction("danaIntroed", true));

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
