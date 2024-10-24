package Scripts.DeliriousDana;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.ChangeFlagScriptAction;
import ScriptActions.LockPlayerScriptAction;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;

public class DDanaHallway extends Script {
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new TextboxScriptAction() {{
            addText("Kaegen: Are thou knowest the A.C in Nada is working?");
            addText("Preeda: It hath been perfectly brave since ere thou walked in.");
            addText("Kaegen: All I knoweth is yond QU’s Halloween party would’ve been on the quad.\nNot h're.");
            addText("Kaegen: There’s no way...'twere that black bear.\nHe doth lack revenge.");
            addText("Preeda: Thou mean the bear thou somehow beat up earlier?!");
            addText("Kaegen: I hast a hunch! Ye Olde Black Bear surprised the A.C unit hither as well!");
        }});

        scriptActions.add(new ChangeFlagScriptAction("introStarted", true));

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
