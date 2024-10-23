package Scripts.DeliriousOutdoor;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.ConditionalScriptAction;
import ScriptActions.ConditionalScriptActionGroup;
import ScriptActions.CustomRequirement;
import ScriptActions.LockPlayerScriptAction;
import ScriptActions.NPCFacePlayerScriptAction;
import ScriptActions.NPCLockScriptAction;
import ScriptActions.NPCUnlockScriptAction;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;

public class Diabear extends Script {
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCLockScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new TextboxScriptAction() {{
            addText("Kaegen: Great gadzooks! Looketh here!\nThis beast must be removed posthaste!");
            addText("Kaegen: Upon furth'r inspection, thee behold familiar.");
            addText("Kaegen: Thee.\nThou art the one who is't hast did destroy our A.C unit!");
            addText("Black Bear: Womp Womp.");
            addText("Kaegen: Thy sland'r knoweth nay bounds.I shall slayeth thee!", new String[] { "Punch Bear", "Kick Bear" });
        }});

        scriptActions.add(new ConditionalScriptAction() {{

            //if punched bear
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new CustomRequirement() {
                    @Override
                    public boolean isRequirementMet() {
                        int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                        return answer == 0;
                    }
                });

                addScriptAction(new TextboxScriptAction() {{
                    addText("Kaegen: Oy beast! Take this knuckle sandwich of justice!!");
                    addText("Black Bear: *yelps in pain*");
                    addText("Kaegen: Ye Olde Black Bear is trying\nto fight back is he?", new String[]{"Parry him", "Counterattack"});
                }});
                
                addScriptAction(new ConditionalScriptAction() {{

                        //if parried blow
                        addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                            addRequirement(new CustomRequirement() {
                                @Override
                                public boolean isRequirementMet() {
                                    int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                                    return answer == 0;
                                }
                            });
            
                            addScriptAction(new TextboxScriptAction() {{
                                addText("Kaegen: I shall parry thee peasant!!");
                                addText("Black Bear: grrr");
                                addText("Kaegen: Finally backing off?\nI see you've learned thine place!");
                                addText("Black Bear: *whimpers*");
                            }});
                        }});
            
                        addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
            
                            //if counterrattacked
                            addRequirement(new CustomRequirement() {
                                @Override
                                public boolean isRequirementMet() {
                                    int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                                    return answer == 1;
                                }
                            });
                            
                            addScriptAction(new TextboxScriptAction() {{
                                addText("Kaegen: Thine swipes mean nothing\nto mine quick jabs!");
                                addText("Black Bear: grrr...");
                                addText("Kaegen: Finally backing off?\nI see you've learned thine place!");
                                addText("Black Bear: *whimpers*");
                            }});
                        }});
                    }});
                }});

                //if kicked bear
                addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                    addRequirement(new CustomRequirement() {
                        @Override
                        public boolean isRequirementMet() {
                            int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                            return answer == 1;
                        }
                    });
                    addScriptAction(new TextboxScriptAction() {{
                        addText("Kaegen: Oy beast!\nTake this roundhouse kick!!");
                        addText("Black Bear: *yelps in pain*");
                        addText("Kaegen: Ye Olde Black Bear is trying to\nfight back is he?", new String[]{"Parry him", "Counterattack"});
                    }});
                    
                    addScriptAction(new ConditionalScriptAction() {{
    
                            //if parried blow
                            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                                addRequirement(new CustomRequirement() {
                                    @Override
                                    public boolean isRequirementMet() {
                                        int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                                        return answer == 0;
                                    }
                                });
                
                                addScriptAction(new TextboxScriptAction() {{
                                    addText("Kaegen: I shall parry thee peasant!!");
                                    addText("Black Bear: grrr");
                                    addText("Kaegen: Finally backing off? I see you've learned thine place!");
                                    addText("Black Bear: *whimpers*");
                                }});
                            }});
                
                            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                
                                //if counterrattacked
                                addRequirement(new CustomRequirement() {
                                    @Override
                                    public boolean isRequirementMet() {
                                        int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                                        return answer == 1;
                                    }
                                });
                                
                                addScriptAction(new TextboxScriptAction() {{
                                    addText("Kaegen: Thine swipes mean nothing to mine quick jabs!");
                                    addText("Black Bear: grrr...");
                                    addText("Kaegen: Finally backing off?\nI see you've learned thine place!");
                                    addText("Black Bear: *whimpers*");
                                }});
                            }});
                        }});
                    }});
            }});

        scriptActions.add(new NPCUnlockScriptAction());
        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
