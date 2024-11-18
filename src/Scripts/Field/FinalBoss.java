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



//Correct Answers: B, A, B, A


public class FinalBoss extends Script {
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCLockScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new TextboxScriptAction() {
            {
                addText("Black Bear: Womp Womp!");
                addText("Kaegen: We’ve exposed thine evil deeds.\nGiveth up Ye Olde Black Beareth!");
                addText("Black Bear: Humanity gets to liveth in luxury of A.C\nwhile animals liveth with NOTHING to keepeth us cold!");
                addText("Black Bear: How is yond fair?");
                addText("Kaegen: Thee can speaketh English?!\nWhat other secrets art thee hiding?");
                addText("Kaegen: Distractions aside,\nlet’s receiveth backeth to fighting.");
                addText("Black Bear: Halt! This timeth however...\nwe aren’t fistfighting.");
                addText("Kaegen: ...huh?");
                addText("Black Bear: If it be true thee wanteth\nthy oh-so precious A.C backeth, I shalt quiz thee!");
                addText("Kaegen: Quiz?! On what?!");
                addText("Black Bear: Thy journey of course.");
                addText("Kaegen: I was expecting a square to the death.");
                addText("Black Bear: I hath lost yond square lasteth\ntimeth we hath met.");
                addText("Black Bear: I knoweth thine intelligence is... \nnot the most wondrous.");
                addText("Kaegen: I’m not thy average history major! Dare me!");
                addText("Black Bear: Thine first questioneth.\nHow hast thee been staying cold in this heateth?",
                        new String[] { "A.C", "Water and Fans" });
            }
        });

        scriptActions.add(new ConditionalScriptAction() {
            {

                // if A.C(fail)
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
                                addText("Black Bear: The A.C wast broken the entire timeth dimwit!");
                                addText("Kaegen: Right...");
                            }
                        });
                    }
                });

                // if Fans/Waterbottles(correct)
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
                                addText("Black Bear: I seeth. \nQuite a fine way to stayeth bitter cold.");
                                addText("Kaegen: It’s nothing did compare to how the\nA.C doth feel!");
                                addText("Black Bear: Anon for the second questioneth");
                                addText("Black Bear: What doest the house on the\nhath left side of Mountainview containeth?",
                                        new String[] { "Disco", "Dining Hall" });
                            }
                        });

                        addScriptAction(new ConditionalScriptAction() {
                            {

                                // if Disco(correct)
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
                                                addText("Black Bear: Darn! I wisheth I'd outsmarted thee there!");
                                                addText("Kaegen: I did solve the crisis in Dana yond\nthee did cause! I can solveth aught.");
                                                addText("Black Bear: Speaking of Dana, what clue leadeth you\nto apprehend Victor as the culprit?",
                                                        new String[] { "His Roommate", "Part Trail" });
                                            }
                                        });
                                        addScriptAction(new ConditionalScriptAction(){{
                                            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {
                                                {
                                                    //If Roommate
                                                    addRequirement(new CustomRequirement() {
                                                        @Override
                                                        public boolean isRequirementMet() {
                                                            int answer = outputManager
                                                                    .getFlagData("TEXTBOX_OPTION_SELECTION");
                                                            return answer == 0;
                                                        }
                                                    });
    
                                                    addScriptAction(new TextboxScriptAction() {
                                                        {
                                                            addText("Black Bear: Thee very much art cunninger than I\nbethought!");
                                                            addText("Kaegen: I’m the one who ist embarked on this journey.");
                                                            addText("Kaegen: Of course I’m going to remember!");
                                                            addText("Black Bear: Anon then, if it be true thee holdeth\nthyself to such a high standard, answer this questioneth.");
                                                            addText("Black Bear: What didst the jealous guy outside of Dana\nasketh thee to doth?",
                                                                    new String[] { "Retrieve Something", "Buy His Water" });
                                                        }
                                                    });
                                                    addScriptAction(new ConditionalScriptAction(){{
                                                        addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {
                                                            {
                                                                //If Retrieve Something(failed)
                                                                addRequirement(new CustomRequirement() {
                                                                    @Override
                                                                    public boolean isRequirementMet() {
                                                                        int answer = outputManager
                                                                                .getFlagData("TEXTBOX_OPTION_SELECTION");
                                                                        return answer == 0;
                                                                    }
                                                                });
                
                                                                addScriptAction(new TextboxScriptAction() {
                                                                    {
                                                                        addText("Black Bear: How shall thee fixeth the A.C\nwith yond leveleth of intellect?");
                                                                        addText("Black Bear: Didst thee coequal talketh to the guy?");
                                                                        addText("Kaegen: I supposeth not.");
                                                                    }
                                                                });
                
                                                            }
                                                        });
                                                        addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {
                                                            {
                
                                                                // if Buy Water
                                                                addRequirement(new CustomRequirement() {
                                                                    @Override
                                                                    public boolean isRequirementMet() {
                                                                        int answer = outputManager
                                                                                .getFlagData("TEXTBOX_OPTION_SELECTION");
                                                                        return answer == 1;
                                                                    }
                                                                });
                
                                                                addScriptAction(new TextboxScriptAction() {
                                                                    {
                                                                        addText("Kaegen: Valorous thing i didn’t followeth that gent!");
                                                                        addText("Black Bear: Drat! I’m running out of options!");
                                                                        addText("Kaegen: Running out of steam?");
                                                                        addText("Black Bear: Fine then. Here’s mine own final questioneth.");
                                                                        addText("Black Bear: What wast one way thee obtained A.C parts\nin thy journey? ",new String[]{"Confronting Preeda", "Pushing Crates", "Secret Room"});
                                                                    }
                                                                });
                                                                addScriptAction(new ConditionalScriptAction(){{
                                                                    addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {
                                                                        {
                                                                            //If Confront(failed)
                                                                            addRequirement(new CustomRequirement() {
                                                                                @Override
                                                                                public boolean isRequirementMet() {
                                                                                    int answer = outputManager
                                                                                            .getFlagData("TEXTBOX_OPTION_SELECTION");
                                                                                    return answer == 0;
                                                                                }
                                                                            });
                            
                                                                            addScriptAction(new TextboxScriptAction() {
                                                                                {
                                                                                    addText("Black Bear: Thee didst forsooth confronteth someone else in Dana.");
                                                                                    addText("Kaegen: But it wasn't Preeda.");
                                                                                }
                                                                            });
                            
                                                                        }
                                                                    });
                                                                    addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {
                                                                        {
                            
                                                                            // if Crates
                                                                            addRequirement(new CustomRequirement() {
                                                                                @Override
                                                                                public boolean isRequirementMet() {
                                                                                    int answer = outputManager
                                                                                            .getFlagData("TEXTBOX_OPTION_SELECTION");
                                                                                    return answer == 1;
                                                                                }
                                                                            });
                            
                                                                            addScriptAction(new TextboxScriptAction() {
                                                                                {
                                                                                    addText("Black Bear: ...");
                                                                                    addText("Black Bear: You’ve bested me.\nI shall backeth down anon.");
                                                                                    addText("Black Bear: I just did want to feeleth comfortable...");
                                                                                    addText("Black Bear: Wherefore can’t we animals has't\nwhat thee doth?!");
                                                                                    addText("Kaegen: It’s still wrong to wrecketh people’s stuffeth.");
                                                                                    addText("Black Bear: ...I supposeth so.");
                                                                                    addText("Kaegen: If 't be true thee promiseth to holp fixeth\nthe A.C’s in the dorms...");
                                                                                    addText("Kaegen: I'll fain shareth mine own A.C with thee.");
                                                                                    addText("Black Bear: Sure.");
                                                                                    addText("Black Bear: Waiteth. One lasteth trinket of wisdom\nto impart onto thee.");
                                                                                    addText("Kaegen: What is it?");
                                                                                    addText("Black Bear: Mine own real name is...");
                                                                                    addText("Sam...");
                                                                                    scriptActions.add(new ChangeFlagScriptAction("finalBossFought", true));
                                                                                }
                                                                            });
                                                                            
                                                                        }
                                                                    });
                                                                    addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {
                                                                        {
                            
                                                                            // if Secret(failed)
                                                                            addRequirement(new CustomRequirement() {
                                                                                @Override
                                                                                public boolean isRequirementMet() {
                                                                                    int answer = outputManager
                                                                                            .getFlagData("TEXTBOX_OPTION_SELECTION");
                                                                                    return answer == 2;
                                                                                }
                                                                            });
                            
                                                                            addScriptAction(new TextboxScriptAction() {
                                                                                {
                                                                                    addText("Black Bear: Th're's a secret cubiculo?");
                                                                                    addText("Black Bear: Coequal I didn't knoweth of this!");
                                                                                    addText("Black Bear: How didst thee findeth it?");
                                                                                    addText("Kaegen: Coequal I remember not...");
                                                                                }
                                                                            });
                                                                            
                                                                        }
                                                                    });
                                                                }});
                                                                
        
                                                            }
                                                        });
                                                    }});
                                                    
    
                                                }
                                            });
                                            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {
                                                {
    
                                                    // if Part Trail
                                                    addRequirement(new CustomRequirement() {
                                                        @Override
                                                        public boolean isRequirementMet() {
                                                            int answer = outputManager
                                                                    .getFlagData("TEXTBOX_OPTION_SELECTION");
                                                            return answer == 1;
                                                        }
                                                    });
    
                                                    addScriptAction(new TextboxScriptAction() {
                                                        {
                                                            addText("Black Bear: Wast the part trail the final clue yond\nleadeth thee to apprehend the culprit?");
                                                            addText("Kaegen: Right... there wast just one more clue.");
                                                        }
                                                    });
                                                }
                                            });
                                        }});
                
                                        
                                    }
                                });

                                addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {
                                    {

                                        // if Dining Hall(wrong)
                                        addRequirement(new CustomRequirement() {
                                            @Override
                                            public boolean isRequirementMet() {
                                                int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                                                return answer == 1;
                                            }
                                        });

                                        addScriptAction(new TextboxScriptAction() {
                                            {
                                                addText("Black Bear: Well the dining hall is one of the buildings.");
                                                addText("Black Bear: Just not the right one.");
                                            }
                                        });
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });

        scriptActions.add(new NPCUnlockScriptAction());
        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
