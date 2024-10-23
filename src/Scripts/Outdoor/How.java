package Scripts.Outdoor;

import Level.Script;
import ScriptActions.ChangeFlagScriptAction;
import ScriptActions.LockPlayerScriptAction;
import ScriptActions.NPCFacePlayerScriptAction;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;

import java.util.ArrayList;


public class How extends Script {
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());
        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new TextboxScriptAction() {{
            addText("Student: Excuse me!\nHow did you manage to fight off that bear?");
            addText("Kaegen: I combated a beareth? When did I do that? ");
            addText("Student: Just now! Look! It ran away! ");
            addText("Black Bear: *Growls*");
            addText("Kaegen: Guh... I really did that huh?");
            
        }});

        scriptActions.add(new ChangeFlagScriptAction("E", true));

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
