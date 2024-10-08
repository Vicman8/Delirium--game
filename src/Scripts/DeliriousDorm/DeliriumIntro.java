package Scripts.DeliriousDorm;

import Level.Script;
import ScriptActions.ChangeFlagScriptAction;
import ScriptActions.LockPlayerScriptAction;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;

import java.util.ArrayList;

public class DeliriumIntro extends Script {
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new TextboxScriptAction() {{
            addText("Kaegen: Where am I? Mine own room looks different.");
            addText("Kaegen: I hath passed out, correct?");
            addText("Kaegen: Guesseth I shouldst behold 'round.");
        }});

        scriptActions.add(new ChangeFlagScriptAction("mcUnfainted", true));

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}

