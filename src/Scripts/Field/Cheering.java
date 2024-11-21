package Scripts.Field;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.ChangeFlagScriptAction;
import ScriptActions.LockPlayerScriptAction;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;

public class Cheering extends Script {
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new TextboxScriptAction() {{
            addText("Preeda: Kaegen! Thee can doth it!");
            addText("Kaegen: Grant thee mercy for\nbelieving in me!");
        }});

        scriptActions.add(new ChangeFlagScriptAction("danaIntroed", true));

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
