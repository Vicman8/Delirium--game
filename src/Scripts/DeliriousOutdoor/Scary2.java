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

        // Show textbox with initial dialogue
        scriptActions.add(new TextboxScriptAction() {{
            addText("Female Student?: Someone saveth me!");
            //addRequirement(new FlagRequirement("x", false));
        }});


        //scriptActions.add(new ScriptAction() {{
        //     addScriptAction(new NPCStandScriptAction(Direction.RIGHT));
        //     addScriptAction(new NPCWalkScriptAction(Direction.UP, 360, 100));
        //     addScriptAction(new NPCWalkScriptAction(Direction.RIGHT, 190, 10));
        // }} );


        //scriptActions.add(new NPCStandScriptAction(Direction.RIGHT));
        scriptActions.add(new NPCWalkScriptAction(Direction.UP, 36, 10));
        //scriptActions.add(new NPCWalkScriptAction(Direction.RIGHT, 19, 10));

        // // Add conditional actions
        // scriptActions.add(new ConditionalScriptAction() {{
        //     addConditionalScriptAction( addRequirement(new FlagRequirement("x", true));
        //     {{
        //         addRequirement(new FlagRequirement("x", true));

        //         addScriptAction(new WaitScriptAction(70)); // Wait for 70 units (time steps, frames, etc.)
        //         addScriptAction(new NPCFacePlayerScriptAction()); // NPC faces player

        //         // NPC's dialogue
        //         addScriptAction(new TextboxScriptAction() {{
        //             addText("Oh, you're still here...");
        //             addText("...You heard from Walrus that he saw me with your\nball?");
        //             addText("Well, I saw him playing with it and was worried it would\nroll into my garden.");
        //             addText("So I kicked it as far as I could into the forest to the left.");
        //             addText("Now, if you'll excuse me, I have to go.");
        //         }});

        //         // NPC stands facing right and walks
        //         addScriptAction(new NPCStandScriptAction(Direction.RIGHT)); // NPC stands facing right
        //         addScriptAction(new NPCWalkScriptAction(Direction.DOWN, 36, 2)); // NPC walks down
        //         addScriptAction(new NPCWalkScriptAction(Direction.RIGHT, 196, 2)); // NPC walks right
        //     }});
        // }});

        // // Set a flag after the NPC flees
        // scriptActions.add(new ChangeFlagScriptAction("Flee!", true));

        // Unlock the player
        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
