package Scripts.DeliriousDorm;

import Level.Script;
import ScriptActions.ChangeFlagScriptAction;
import ScriptActions.LockPlayerScriptAction;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;

import java.util.ArrayList;

public class FirstBearFight extends Script {
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new TextboxScriptAction() {{
            addText("Kaegen: Great gadzooks! Looketh here!\nThis beast must be removed posthaste!");
            addText("Kaegen: Upon furth'r inspection, thee behold familiar.");
            addText("Kaegen: Thee. Thou art the one who is't hast did destroy our A.C unit!");
            addText("Black Bear: Womp Womp.");
            addText("Kaegen: Thy sland'r knoweth nay bounds. I shalt slayeth thee!");
        }});

        scriptActions.add(new ChangeFlagScriptAction("bearFought", true));

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
