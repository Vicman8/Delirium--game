package Scripts.DiningRoom;

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






public class TheThimQuiz extends Script {
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCLockScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new TextboxScriptAction() {
            {
                addText("Prof. Thimineur: Greetings! I am Professor Thimineur!");
                addText("Kaegen: Hello! Have you seen any AC parts around?");
                addText("Prof. Thimineur: I have! But if you want it you'll have \nto answer some questions!");
                addText("Kaegan: About what?");
                addText("Prof. Thimineur: Software engineering and \ncomputer science! What else?");
                addText("Kaegen: ...I'm a history major though?");
                addText("Prof. Thimineur: The people playing this game are likely\nComputer science/software engineering majors!");
                addText("Kaegen: ...huh? Ease up on the meta there\nAnyways, what's the first question?");
                addText("Prof. Thimineur: Quick sort, what is it's running time?",
                        new String[] { "O(n^2)", "O(nlogn)" });
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
                                addScriptAction(new NPCWalkScriptAction(Direction.RIGHT,0,1));
                                addText("Prof. Thimineur: Wrong! Geez some expert you are huh.");
                                addText("Kaegen: I just said I'm a history major!");
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
                                addScriptAction(new NPCWalkScriptAction(Direction.LEFT,0,1));
                                
                                
                                addText("Prof. Thimineur: Correct!");
                                addText("Kaegen: Easy! What else you got?");
                                
                                addText("Prof. Thimineur: Next, what is the name of a commonly\nused website by software engineers?",
                                        new String[] { "Github.com", "Fortnite.com" });
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
                                                addScriptAction(new NPCWalkScriptAction(Direction.LEFT,0,1));
                                                
                                                addText("Prof. Thimineur: Right! I even teach a class on it!");
                                                addText("Kaegen: Wow! Everyone should take it!");
                                                addText("Prof. Thimineur: Now, which of these follows a first in\nfirst out procedure?",
                                                        new String[] { "Queues", "Stacks" });
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
                                                            addScriptAction(new NPCWalkScriptAction(Direction.LEFT,0,1));
                                                            
                                                            addText("Prof. Thimineur: Impressive! As opposed to stacks which\n are last in first out.");
                                                            addText("Kaegen: Yes!");
                                                            addText("Prof. Thimineur: Better than I expected!\n...So far at least.");
                                                            addText("Kaegen: I got this! Give me another!");
                                                            addText("Prof. Thimineur: What is needed for a proper\nrecursive algorithm?",
                                                            
                                                                    new String[] { "Iteration", "A base case" });
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
                                                                        addScriptAction(new NPCWalkScriptAction(Direction.RIGHT,0,1));
                                                                        addText("Prof. Thimineur: Wrong! You always need a base case!");
                                                                        addText("Kaegen: Darn, I forgot.");
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
                                                                        addScriptAction(new NPCWalkScriptAction(Direction.LEFT,0,1));
                                                                        addScriptAction(new NPCStandScriptAction(Direction.RIGHT));
                                                                        addText("Prof. Thimineur: Right! Iteration is not needed\nbut a base case always is!");
                                                                        addText("Prof. Thimineur: Last one! You ready?");
                                                                        addText("Kaegen: Let's do it.");
                                                                        addText("Prof. Thimineur: In terms of NP-Completeness\n, does P = NP?",new String[]{"It's a Trick!", "Yes", "No"});
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
                                                                                    return answer == 1;
                                                                                }
                                                                            });
                            
                                                                            addScriptAction(new TextboxScriptAction() {
                                                                                {
                                                                                    addScriptAction(new NPCWalkScriptAction(Direction.RIGHT,0,1));
                                                                                    addText("Prof. Thimineur: Wrong! No one's ever proven that!");
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
                                                                                    return answer == 0;
                                                                                }
                                                                            });
                            
                                                                            addScriptAction(new TextboxScriptAction() {
                                                                                {
                                                                                    addText("Prof. Thimineur: ...");
                                                                                    addText("Prof. Thimineur: Yes! Very good!");
                                                                                    addText("Prof. Thimineur: No one knows! People have been\ntrying to prove it forever!");
                                                                                    addText("Kaegen: Yes!");
                                                                                    addText("Prof. Thimineur: Well, as promised, you earned this!");
                                                                                    addText("Kaegen: Thank you!");
                                                                                    addScriptAction(new NPCWalkScriptAction(Direction.LEFT,0,1));
                                                                                    addScriptAction(new NPCStandScriptAction(Direction.RIGHT));
                                                                                    
                                                                                }
                                                                                
                                                                            });
                                                                            addScriptAction(new NPCChangeVisibilityScriptAction(Visibility.HIDDEN));
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
                                                                                    addScriptAction(new NPCWalkScriptAction(Direction.RIGHT,0,1));
                                                                                    addText("Prof. Thimineur: Wrong! No one's ever proven that!");
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
                                                            addScriptAction(new NPCWalkScriptAction(Direction.RIGHT,0,1));
                                                            addText("Prof. Thimineur: Wrong! That's how stacks work!");
                                                            addText("Kaegen: Right...");
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
                                                addScriptAction(new NPCWalkScriptAction(Direction.RIGHT,0,1));
                                                addText("Prof. Thimineur: ...Did you just say\nFortnite.com...?");
                                                addText("Kaegan: I don't know what\nyou're talking about.");
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
