package Scripts.DeliriousDana;

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

public class VictorFight extends Script {
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCLockScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new TextboxScriptAction() {
            {
                addText("Kaegen: Victor! 'Twere thou all along! You’ve been\neating the A.C parts all along to keep yourself cool!");
                addText("Kaegen: Selfish bastard.");
                addText("Victor: Thou hast no proof of that!\nI'm suffering through this heat like everyone else is!");
                addText("Kaegen: Victor, thou stand against a master detective.\nI hast not yet begun to fight!",
                        new String[] { "Ask about A.C parts", "Ask about trail." });
            }
        });

        scriptActions.add(new ConditionalScriptAction() {
            {

                // A.C parts
                addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {
                    {
                        addRequirement(new CustomRequirement() {
                            @Override
                            public boolean isRequirementMet() {
                                int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                                return answer == 0;
                            }
                        });

                        addScriptAction(new TextboxScriptAction() {
                            {
                                addText("Kaegen: Thou were eating A.C parts that fell from the\nunit when Ye Olde Black Bear surprised it!");
                                addText("Victor: There were no parts that fell out\nwhen Ye Olde Black Bear surprised the unit.");
                                addText("Kaegen: That's cause you ate them!");
                                addText("Victor: Tsk tsk. There was no\ntrail of metal coming from there was there?");
                                addText("Kaegen: Darn! There's no way we\nshall be able to prove him guilty now!");
                            }
                        });
                    }
                });

                // Trail
                addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {
                    {
                        addRequirement(new CustomRequirement() {
                            @Override
                            public boolean isRequirementMet() {
                                int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                                return answer == 1;
                            }
                        });
                        addScriptAction(new TextboxScriptAction() {
                            {
                                addText("Kaegen: There’s a trail of A.C parts leading to thy\ndorm Victor! What doth thou hast to say about that?!");
                                addText("Victor: I could’ve just let ANYONE in, you know?",
                                        new String[] { "Ask about new friends", "Inquire about roommate" });
                            }
                        });

                        addScriptAction(new ConditionalScriptAction() {
                            {

                                // new friends
                                addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {
                                    {
                                        addRequirement(new CustomRequirement() {
                                            @Override
                                            public boolean isRequirementMet() {
                                                int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                                                return answer == 0;
                                            }
                                        });

                                        addScriptAction(new TextboxScriptAction() {
                                            {
                                                addText("Kaegen: Didst thou compose new friends?");
                                                addText("Victor: Oh absolutely! They're so delightful!");
                                                addText("Preeda: Something about that smile tells me that\nVictor hath weasled his way out of this!");
                                                addText("Kaegen: Drat! How could I hast fallen for such lies?!");
                                            }
                                        });
                                    }
                                });

                                addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {
                                    {

                                        // roommate
                                        addRequirement(new CustomRequirement() {
                                            @Override
                                            public boolean isRequirementMet() {
                                                int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                                                return answer == 1;
                                            }
                                        });

                                        addScriptAction(new TextboxScriptAction() {
                                            {
                                                addText("Kaegen: Victor, we wot how little thou trust people.\nThe only person thou trust is thy roommate!");
                                                addText("Kaegen: And he was in class with me!");
                                                addText("Kaegen: The trails, the timing,\nit can only mean one thing...");
                                                addText("Kaegen: The only other person whom could’ve\nconsumed these A.C parts is THOU!!!!");
                                                addText("Victor: ...");
                                                addText("Victor: ...how?");
                                                addText("Victor: How could thou hast figured me out?!");
                                                addText("Kaegen: None shall forbear me from mine A.C!");
                                            }
                                        });

                            addScriptAction(new NPCStandScriptAction(Direction.RIGHT));

                            addScriptAction(new NPCWalkScriptAction(Direction.RIGHT, 0, 10));
                            //addScriptAction(new NPCChangeVisibilityScriptAction(Visibility.HIDDEN));
                                    }
                                    
                                });
                                
                            }
                        });
                    }
                });
            }
        });
        scriptActions.add(new ChangeFlagScriptAction("victorFought", true));
        scriptActions.add(new NPCUnlockScriptAction());
        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
