package Scripts.TestMap;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.*;


// script for talking to walrus npc
// checkout the documentation website for a detailed guide on how this script works
public class WalrusScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToWalrus", false));
                addRequirement(new FlagRequirement("testFlag", false));
                addScriptAction(new TextboxScriptAction() {{
                    addText("Hi Cat!");
                    addText("...oh, you lost your ball?");
                    addText("Hmmm...my walrus brain remembers seeing Dino with\nit last. Maybe you can check with him?");
                }});
                addScriptAction(new ChangeFlagScriptAction("hasTalkedToWalrus", true));
                //System.out.println("Talked");
            }});
            
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToWalrus", true));
                addScriptAction(new TextboxScriptAction("I sure love doing walrus things!"));
            }});
        }});
        scriptActions.add(new UnlockPlayerScriptAction());
        
        return scriptActions;
    }
//     isFlagRequirementMet("testFlag", true){
        
       
// }
}
