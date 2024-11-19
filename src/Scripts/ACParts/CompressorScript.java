package Scripts.ACParts;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.LockPlayerScriptAction;
import ScriptActions.NPCFacePlayerScriptAction;
import ScriptActions.NPCLockScriptAction;
import ScriptActions.NPCUnlockScriptAction;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;

public class CompressorScript extends Script{
     
    
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();




        scriptActions.add(new TextboxScriptAction() {{
            addText("You picked up the compressor");
        }});


        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
