package Scripts.DeliriousDana;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.ChangeFlagScriptAction;
import ScriptActions.LockPlayerScriptAction;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;

public class TrailScript extends Script {
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new TextboxScriptAction() {{
            addText("Kaegen: Look here! A.C parts leading into Victor's dorm!");
            addText("Preeda: That's quite peculiar!");
            addText("Kaegen: This should confirm it was either him\nor his roommate.");
        }});

        scriptActions.add(new ChangeFlagScriptAction("trailFollowed", true));

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
