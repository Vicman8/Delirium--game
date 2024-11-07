package Scripts.DeliriousDana;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.ChangeFlagScriptAction;
import ScriptActions.LockPlayerScriptAction;
import ScriptActions.NPCFacePlayerScriptAction;
import ScriptActions.NPCLockScriptAction;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;

public class RoommateClue extends Script {
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCLockScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new TextboxScriptAction() {{
            addText("Kaegen: Thou are Victor's roommate correct?");
            addText("Roommate: Yes? Why do you ask?");
            addText("Kaegen: I wanted to inquire about the A.C part\ntrail coming out of your room.");
            addText("Roommate: It wasn't me! I didn't destroy the A.C!");
            addText("Kaegen: This basically confirms that Victor was behind it.");
        }});

        scriptActions.add(new ChangeFlagScriptAction("roommateTalked", true));

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
