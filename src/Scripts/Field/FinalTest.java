package Scripts.Field;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.ChangeFlagScriptAction;
import ScriptActions.ConditionalScriptAction;
import ScriptActions.ConditionalScriptActionGroup;
import ScriptActions.CustomRequirement;
import ScriptActions.LockPlayerScriptAction;
import ScriptActions.NPCChangeVisibilityScriptAction;
import ScriptActions.NPCFacePlayerScriptAction;
import ScriptActions.NPCLockScriptAction;
import ScriptActions.NPCStandScriptAction;
import ScriptActions.NPCUnlockScriptAction;
import ScriptActions.NPCWalkScriptAction;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;
import Utils.Direction;
import Utils.Visibility;

public class FinalTest extends Script {
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCLockScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new TextboxScriptAction() {{
            addText("Hello!");
            addText("Do you like heat?", new String[] { "Yes", "No" });
        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new CustomRequirement() {
                    @Override
                    public boolean isRequirementMet() {
                        int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                        return answer == 0;
                    }
                });

                addScriptAction(new TextboxScriptAction() {{
                    
                }});
            }});

            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new CustomRequirement() {
                    @Override
                    public boolean isRequirementMet() {
                        int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                        return answer == 1;
                    }
                });
                
                addScriptAction(new TextboxScriptAction("Oh...uh...Disco..."));
            }});
            
        }});

        scriptActions.add(new NPCUnlockScriptAction());
        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }

}
