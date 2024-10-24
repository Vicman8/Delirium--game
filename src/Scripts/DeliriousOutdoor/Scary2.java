package Scripts.DeliriousOutdoor;

import Level.Script;

import ScriptActions.ChangeFlagScriptAction;
import ScriptActions.ConditionalScriptAction;
import ScriptActions.FlagRequirement;
import ScriptActions.LockPlayerScriptAction;
import ScriptActions.NPCStandScriptAction;
import ScriptActions.NPCWalkScriptAction;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;
import Utils.Direction;

import java.util.ArrayList;

public class Scary2 extends Script {
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();

        // Lock the player at the start of the script
        scriptActions.add(new LockPlayerScriptAction());
        scriptActions.add(new TextboxScriptAction("poo"));
        
        scriptActions.add(new ScriptAction() {
            addScriptAction(new NPCStandScriptAction(Direction.RIGHT));
            
        });
        // Show textbox with initial dialogue
        scriptActions.add(new TextboxScriptAction() {{
            addText("Female Student?: Someone saveth me!");
            //addRequirement(new FlagRequirement("x", false));
            addScriptAction(new NPCStandScriptAction(Direction.RIGHT));
        }});


        scriptActions.add(new ScriptAction() {{
            addScriptAction(new NPCWalkScriptAction(Direction.UP, 360, 100));
            addScriptAction(new NPCWalkScriptAction(Direction.RIGHT, 190, 10));
        }} );

        //scriptActions.add(new ChangeFlagScriptAction("Flee!", false));
        
      
        
        // // Set a flag after the NPC flees
        scriptActions.add(new ChangeFlagScriptAction("Flee!", true));
        // Unlock the player
        scriptActions.add(new UnlockPlayerScriptAction());
        
        return scriptActions;
    }
}
