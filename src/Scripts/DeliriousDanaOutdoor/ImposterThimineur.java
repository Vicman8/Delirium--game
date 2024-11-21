package Scripts.DeliriousDanaOutdoor;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.ChangeFlagScriptAction;
import ScriptActions.LockPlayerScriptAction;
import ScriptActions.NPCFacePlayerScriptAction;
import ScriptActions.NPCLockScriptAction;
import ScriptActions.NPCStandScriptAction;
import ScriptActions.NPCUnlockScriptAction;
import ScriptActions.NPCWalkScriptAction;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;
import Utils.Direction;

public class ImposterThimineur extends Script {
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();

        scriptActions.add(new NPCLockScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new TextboxScriptAction() {{
            addText("???: HEY KID!!!!");
            addText("???: WNAT SOME WATER?????");
            addText("Kaegen: Why art not thou talking strange?");
            addText("???: GOTTA LOCK IN!!!!!");
            addText("Kaegen: What?");
            addText("???: LOOK KID I'M A BUSY GUY,\nWANT WATER OR NOT?????",  new String[] {"Yes", "No"});
            addText("???: OK HAHA!! FOLLOW ME!!!");
        }});
        scriptActions.add(new NPCStandScriptAction(Direction.RIGHT));

        scriptActions.add(new NPCWalkScriptAction(Direction.DOWN, 1000, 2));

        


        scriptActions.add(new UnlockPlayerScriptAction());
        scriptActions.add(new NPCUnlockScriptAction());

        return scriptActions;
    }
}