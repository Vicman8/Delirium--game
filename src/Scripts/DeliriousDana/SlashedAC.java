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
            addText("Kaegen: Gadzooks! Ye Olde Black Bear hath join\nthrough hither as well!");
            addText("Preeda: Gasp! Ye Olde Black Bear this did?\nHow didst it e'en get in?");
            addText("Kaegen: Hark! I hark rustling from the commons!\nHaply it’s Ye Olde Black Bear!");
        }});

        scriptActions.add(new ChangeFlagScriptAction("a.cSlashed", true));

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
