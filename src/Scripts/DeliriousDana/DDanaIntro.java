package Scripts.DeliriousDana;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.ChangeFlagScriptAction;
import ScriptActions.LockPlayerScriptAction;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;

public class DDanaIntro extends Script {
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new TextboxScriptAction() {{
            addText("Kaegen: Not again... everything looks weird.");
            addText("Preeda: Kaegen, wh’re art we? Ev'rything looks spooky.");
            addText("Kaegen: All I knoweth is yond QU’s Halloween party would’ve been on the quad.  Not h're.");
            addText("Preeda: Followeth me! I knoweth wh're the coldest parteth of the d'rm is!");
            addText("Kaegen: Guesseth I shouldst beholdeth 'round again while following her.");
        }});

        scriptActions.add(new ChangeFlagScriptAction("introStarted", true));

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
