package Scripts.DeliriousDana;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.ChangeFlagScriptAction;
import ScriptActions.LockPlayerScriptAction;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;

public class SlashedAC extends Script {
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new TextboxScriptAction() {{
            addText("Kaegen: Gadzooks! Ye Olde Black Bear hath join through hither as well!");
            addText("Preeda: Gasp! Ye Olde Black Bear this did? How didst it e'en get in?");
            addText("Kaegen: Hark! I hark rustling from the commons! Haply it’s Ye Olde Black Bear!");
        }});

        scriptActions.add(new ChangeFlagScriptAction("introStarted", true));

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
