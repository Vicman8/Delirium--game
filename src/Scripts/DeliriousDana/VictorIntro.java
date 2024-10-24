package Scripts.DeliriousDana;

import java.util.ArrayList;

import Level.Script;
import NPCs.THEVICMANM;
import ScriptActions.ChangeFlagScriptAction;
import ScriptActions.ConditionalScriptAction;
import ScriptActions.ConditionalScriptActionGroup;
import ScriptActions.FlagRequirement;
import ScriptActions.LockPlayerScriptAction;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;

public class VictorIntro extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new ConditionalScriptAction() {
            {

                addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {
                    {
                        addRequirement(new FlagRequirement("a.cSlashed", false));
                        addScriptAction(new TextboxScriptAction() {
                            {
                                addText("Student: Leaveth me alone!");
                            }
                        });

                    }
                });

                addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {
                    {
                        addRequirement(new FlagRequirement("victorIntroed", false));
                        addRequirement(new FlagRequirement("a.cSlashed", true));
                        addScriptAction(new TextboxScriptAction() {
                            {
                                addText("Kaegen: Ah! It is not Ye Olde Black Bear!\nIt’s hold, but for a student!");
                                addText("Student: It’s so hot out!! I NEEDETH this cold strawberry\nmilk man!!");
                                addText("Preeda: You’re Victor, correct? Aren’t thou the person\nin the back coign of mine Calculus class?");
                                addText("Victor: Preeda, right? Aren’t thou the one whom loves\nhelping others all the time?");
                                addText("Kaegen: Enough about that! Why art thou dressed\nlike a vampire?");
                                addText("Victor: Me? Huh? How about thyself?");
                                addText("Preeda: I don’t understand why I’m trimmed thus yet.\nThere’s a problem, Nada’s A.C hath been sabotaged.");
                                addText("Victor: Interesting. Doth thou wot what may\nhast caused it?");
                                addText("Kaegen: Of course. There's slash marks.Ye Olde Black\nBear hath broke both Nada and Mantle’s A.C units!");
                                addText("Preeda: Victor, doth thou wot where thy dorm may\nbear spare A.C parts?");
                                addText("Preeda: We need 'em to fix both dorms and end this crisis!");
                                addText("Victor: I...");
                                addText("Victor: I wot nought! leave me alone!");
                                addText("Victor: I might not but consume this cold delight\n'I decree to not succumb to the heat.");
                                addText("Kaegen: Something about him seems off.");
                                addText("Kaegen: Let’s look for more clues as to where the A.C parts may be occulted.");
                                addText("Preeda: I am in agreement.");
                            }
                        });
                        addScriptAction(new ChangeFlagScriptAction("victorIntroed", true));
                    }
                });

                addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {
                    {
                        addRequirement(new FlagRequirement("victorIntroed", true));
                        addScriptAction(new TextboxScriptAction("Victor: I told you man! I did nothing wrong!"));
                    }
                });
            }
        });
        scriptActions.add(new ChangeFlagScriptAction("victorIntroed", true));

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
