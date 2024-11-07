package Scripts.DeliriousDanaOutdoor;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.ChangeFlagScriptAction;
import ScriptActions.LockPlayerScriptAction;
import ScriptActions.NPCFacePlayerScriptAction;
import ScriptActions.NPCLockScriptAction;
import ScriptActions.NPCUnlockScriptAction;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;

public class ImposterThimineur extends Script {
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();

        scriptActions.add(new NPCLockScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new TextboxScriptAction() {{
            addText("HEY KID!!!!");
            addText("WNAT SOME WATER?????");
            addText("Why art not thou talking strange?");
            addText("GOTTA LOCK IN!!!!!");
            addText("What?");
            addText("LOOK KID I'M A BUSY GUY, WANT WATER OR NOT?????",  new String[] {"Yes", "No"});
        }});


        scriptActions.add(new UnlockPlayerScriptAction());
        scriptActions.add(new NPCUnlockScriptAction());

        return scriptActions;
    }
}