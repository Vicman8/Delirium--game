package Scripts.DeliriousDana;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.ChangeFlagScriptAction;
import ScriptActions.LockPlayerScriptAction;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;

public class VictorIntro extends Script {
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new TextboxScriptAction() {{
            addText("Kaegen: Ah! It is not Ye Olde Black Bear!\nIt’s hold, but for a student!");
            addText("Student: It’s so hot out!! I NEEDETH this cold strawberry milk man!!");
            addText("Preeda: You’re Victor, correct? Aren’t thou the person in the back coign of mine Calculus class?");
            addText("Victor: Preeda, right? Aren’t thou the one whom loves helping others all the time?");
            addText("Kaegen: Enough about that! Why art thou dressed like a vampire?");
            addText("Victor: Me? Huh? How about thyself?");
            addText("Preeda: I don’t understand why I’m trimmed thus yet. There’s a problem, Nada’s A.C hath been sabotaged.");
            addText("Victor: Interesting. Doth thou wot what may hast caused it?");
            addText("Kaegen: Of course. There are slash marks. Ye Olde Black Bear hath damaged both Nada and Mantle’s A.C units!");
            addText("Preeda: Victor, doth thou wot where thy dorm may bear spare A.C parts? We need 'em to fix both dorms and end this crisis!");
            addText("Victor: I...");
            addText("Victor: I wot nought! leave me alone. I might not but consume this cold delight 'i decree to not succumb to the heat.");
            addText("Kaegen: Something about him seems off. Let’s look for moe clues as to where the A.C parts may be occulted.");
            addText("Preeda: I am in agreement.");
        }});

        scriptActions.add(new ChangeFlagScriptAction("introStarted", true));

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
