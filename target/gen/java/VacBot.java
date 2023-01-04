/**
 * GENERATED CODE - DO NOT CHANGE
 */

import astra.core.*;
import astra.execution.*;
import astra.event.*;
import astra.messaging.*;
import astra.formula.*;
import astra.lang.*;
import astra.statement.*;
import astra.term.*;
import astra.type.*;
import astra.tr.*;
import astra.reasoner.util.*;


public class VacBot extends ASTRAClass {
	public VacBot() {
		setParents(new Class[] {astra.lang.Agent.class});
		addInference(new Inference(
			new Predicate("free", new Term[] {
				new Variable(Type.STRING, "Sq",false)
			}),
			new ModuleFormula("ei",
				new Predicate("square", new Term[] {
					new Variable(Type.STRING, "Sq"),
					Primitive.newPrimitive("dust")
				}),
				new ModuleFormulaAdaptor() {
					public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
						return ((astra.lang.EIS) visitor.agent().getModule("VacBot","ei")).auto_formula((Predicate) predicate.accept(visitor));
					}
				}
			)
		));
		addInference(new Inference(
			new Predicate("free", new Term[] {
				new Variable(Type.STRING, "Sq",false)
			}),
			new ModuleFormula("ei",
				new Predicate("square", new Term[] {
					new Variable(Type.STRING, "Sq"),
					Primitive.newPrimitive("empty")
				}),
				new ModuleFormulaAdaptor() {
					public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
						return ((astra.lang.EIS) visitor.agent().getModule("VacBot","ei")).auto_formula((Predicate) predicate.accept(visitor));
					}
				}
			)
		));
		addInference(new Inference(
			new Predicate("route", new Term[] {
				new Variable(Type.LIST, "L",false)
			}),
			new Predicate("routelist", new Term[] {
				new Variable(Type.LIST, "L")
			})
		));
		addRule(new Rule(
			"VacBot", new int[] {33,10,33,55},
			new ModuleEvent("ei",
				"$eis",
				new Predicate("event", new Term[] {
					new Funct("task", new Term[] {
						Primitive.newPrimitive("none")
					})
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.lang.EIS) agent.getModule("VacBot","ei")).event(
							"+",
							predicate.getTerm(0)
						);
					}
				}
			),
			new Predicate("counter", new Term[] {
				new Variable(Type.INTEGER, "count",false)
			}),
			new Block(
				"VacBot", new int[] {33,54,43,6},
				new Statement[] {
					new Subgoal(
						"VacBot", new int[] {34,10,43,6},
						new Goal(
							new Predicate("update", new Term[] {})
						)
					),
					new BeliefUpdate('-',
						"VacBot", new int[] {35,10,43,6},
						new Predicate("counter", new Term[] {
							new Variable(Type.INTEGER, "count")
						})
					),
					new BeliefUpdate('+',
						"VacBot", new int[] {36,10,43,6},
						new Predicate("counter", new Term[] {
							Operator.newOperator('+',
								new Variable(Type.INTEGER, "count"),
								Primitive.newPrimitive(1)
							)
						})
					),
					new If(
						"VacBot", new int[] {37,10,43,6},
						new Comparison("==",
							new Variable(Type.INTEGER, "count"),
							Primitive.newPrimitive(20)
						),
						new Block(
							"VacBot", new int[] {37,26,39,11},
							new Statement[] {
								new Subgoal(
									"VacBot", new int[] {38,15,39,11},
									new Goal(
										new Predicate("route", new Term[] {
											new Variable(Type.STRING, "action",false)
										})
									)
								)
							}
						),
						new Block(
							"VacBot", new int[] {40,14,43,6},
							new Statement[] {
								new Subgoal(
									"VacBot", new int[] {41,15,42,11},
									new Goal(
										new Predicate("task", new Term[] {
											new Variable(Type.STRING, "action",false)
										})
									)
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {47,10,47,67},
			new ModuleEvent("ei",
				"$eis",
				new Predicate("event", new Term[] {
					new Funct("location", new Term[] {
						new Variable(Type.LONG, "X",false),
						new Variable(Type.LONG, "Y",false)
					})
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.lang.EIS) agent.getModule("VacBot","ei")).event(
							"+",
							predicate.getTerm(0)
						);
					}
				}
			),
			new Predicate("counter", new Term[] {
				new Variable(Type.INTEGER, "count",false)
			}),
			new Block(
				"VacBot", new int[] {47,66,57,6},
				new Statement[] {
					new Subgoal(
						"VacBot", new int[] {48,10,57,6},
						new Goal(
							new Predicate("update", new Term[] {})
						)
					),
					new BeliefUpdate('-',
						"VacBot", new int[] {49,10,57,6},
						new Predicate("counter", new Term[] {
							new Variable(Type.INTEGER, "count")
						})
					),
					new BeliefUpdate('+',
						"VacBot", new int[] {50,10,57,6},
						new Predicate("counter", new Term[] {
							Operator.newOperator('+',
								new Variable(Type.INTEGER, "count"),
								Primitive.newPrimitive(1)
							)
						})
					),
					new If(
						"VacBot", new int[] {51,10,57,6},
						new Comparison("==",
							new Variable(Type.INTEGER, "count"),
							Primitive.newPrimitive(20)
						),
						new Block(
							"VacBot", new int[] {51,26,53,11},
							new Statement[] {
								new Subgoal(
									"VacBot", new int[] {52,15,53,11},
									new Goal(
										new Predicate("route", new Term[] {
											new Variable(Type.STRING, "action",false)
										})
									)
								)
							}
						),
						new Block(
							"VacBot", new int[] {54,14,57,6},
							new Statement[] {
								new Subgoal(
									"VacBot", new int[] {55,15,56,11},
									new Goal(
										new Predicate("task", new Term[] {
											new Variable(Type.STRING, "action",false)
										})
									)
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {60,10,60,55},
			new GoalEvent('+',
				new Goal(
					new Predicate("go", new Term[] {
						new Funct("move", new Term[] {
							new Variable(Type.STRING, "direction",false)
						}),
						new Variable(Type.STRING, "action",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"VacBot", new int[] {60,54,68,6},
				new Statement[] {
					new ModuleCall("C",
						"VacBot", new int[] {61,10,61,48},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("direction 2: "),
								new Variable(Type.STRING, "direction")
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("VacBot","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("ei",
						"VacBot", new int[] {63,10,63,28},
						new Predicate("move", new Term[] {
							new Variable(Type.STRING, "direction")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("VacBot","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Assignment(
						new Variable(Type.STRING, "action"),
						"VacBot", new int[] {64,10,68,6},
						new Variable(Type.STRING, "direction")
					),
					new Subgoal(
						"VacBot", new int[] {66,10,68,6},
						new Goal(
							new Predicate("update", new Term[] {})
						)
					),
					new Subgoal(
						"VacBot", new int[] {67,10,68,6},
						new Goal(
							new Predicate("task", new Term[] {
								new Variable(Type.STRING, "action")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {72,10,72,55},
			new GoalEvent('+',
				new Goal(
					new Predicate("task", new Term[] {
						new Variable(Type.STRING, "action",false)
					})
				)
			),
			new Predicate("route", new Term[] {
				new ListTerm(new Term[] {
					new Variable(Type.FUNCTION, "move",false)
				})
			}),
			new Block(
				"VacBot", new int[] {72,54,80,6},
				new Statement[] {
					new ModuleCall("C",
						"VacBot", new int[] {73,10,73,43},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("direction 1: "),
								new Variable(Type.FUNCTION, "move")
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("VacBot","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("C",
						"VacBot", new int[] {75,10,75,35},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("ITS TASKING!")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("VacBot","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("sys",
						"VacBot", new int[] {76,10,76,24},
						new Predicate("sleep", new Term[] {
							Primitive.newPrimitive(5000)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("VacBot","sys")).sleep(
									(java.lang.Integer) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new BeliefUpdate('-',
						"VacBot", new int[] {77,10,80,6},
						new Predicate("route", new Term[] {
							new ListTerm(new Term[] {
								new Variable(Type.FUNCTION, "move")
							})
						})
					),
					new Subgoal(
						"VacBot", new int[] {78,10,80,6},
						new Goal(
							new Predicate("go", new Term[] {
								new Variable(Type.FUNCTION, "move"),
								new Variable(Type.STRING, "action")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {81,10,81,63},
			new GoalEvent('+',
				new Goal(
					new Predicate("task", new Term[] {
						new Variable(Type.STRING, "action",false)
					})
				)
			),
			new Predicate("route", new Term[] {
				new ListSplitter(
					new Variable(Type.FUNCTION, "move",false),
					new Variable(Type.LIST, "L",false)
				)
			}),
			new Block(
				"VacBot", new int[] {81,62,88,6},
				new Statement[] {
					new ModuleCall("C",
						"VacBot", new int[] {82,10,82,44},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("direction 1a: "),
								new Variable(Type.FUNCTION, "move")
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("VacBot","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("C",
						"VacBot", new int[] {83,10,83,35},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("action: "),
								new Variable(Type.LIST, "L")
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("VacBot","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("C",
						"VacBot", new int[] {84,10,84,35},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("ITS TASKING!")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("VacBot","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("sys",
						"VacBot", new int[] {85,10,85,24},
						new Predicate("sleep", new Term[] {
							Primitive.newPrimitive(5000)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("VacBot","sys")).sleep(
									(java.lang.Integer) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new SpecialBeliefUpdate(
						"VacBot", new int[] {86,10,88,6},
						new Predicate("route", new Term[] {
							new Variable(Type.LIST, "L")
						})
					),
					new Subgoal(
						"VacBot", new int[] {87,10,88,6},
						new Goal(
							new Predicate("go", new Term[] {
								new Variable(Type.FUNCTION, "move"),
								new Variable(Type.STRING, "action")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {90,10,90,61},
			new GoalEvent('+',
				new Goal(
					new Predicate("task", new Term[] {
						new Variable(Type.STRING, "action",false)
					})
				)
			),
			new ModuleFormula("ei",
				new Predicate("square", new Term[] {
					Primitive.newPrimitive("here"),
					Primitive.newPrimitive("dust")
				}),
				new ModuleFormulaAdaptor() {
					public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
						return ((astra.lang.EIS) visitor.agent().getModule("VacBot","ei")).auto_formula((Predicate) predicate.accept(visitor));
					}
				}
			),
			new Block(
				"VacBot", new int[] {90,60,96,6},
				new Statement[] {
					new ModuleCall("ei",
						"VacBot", new int[] {91,10,91,20},
						new Predicate("clean", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("VacBot","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Subgoal(
						"VacBot", new int[] {94,10,96,6},
						new Goal(
							new Predicate("task", new Term[] {
								new Variable(Type.STRING, "action")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {98,10,98,82},
			new GoalEvent('+',
				new Goal(
					new Predicate("task", new Term[] {
						new Variable(Type.STRING, "action",false)
					})
				)
			),
			new AND(
				new ModuleFormula("ei",
					new Predicate("square", new Term[] {
						Primitive.newPrimitive("forward"),
						Primitive.newPrimitive("dust")
					}),
					new ModuleFormulaAdaptor() {
						public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
							return ((astra.lang.EIS) visitor.agent().getModule("VacBot","ei")).auto_formula((Predicate) predicate.accept(visitor));
						}
					}
				),
				new Predicate("free", new Term[] {
					Primitive.newPrimitive("forward")
				})
			),
			new Block(
				"VacBot", new int[] {98,81,101,6},
				new Statement[] {
					new ModuleCall("ei",
						"VacBot", new int[] {99,10,99,28},
						new Predicate("move", new Term[] {
							Primitive.newPrimitive("forward")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("VacBot","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Assignment(
						new Variable(Type.STRING, "action"),
						"VacBot", new int[] {100,10,101,6},
						Primitive.newPrimitive("move")
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {102,10,102,75},
			new GoalEvent('+',
				new Goal(
					new Predicate("task", new Term[] {
						new Variable(Type.STRING, "action",false)
					})
				)
			),
			new AND(
				new ModuleFormula("ei",
					new Predicate("square", new Term[] {
						Primitive.newPrimitive("left"),
						Primitive.newPrimitive("dust")
					}),
					new ModuleFormulaAdaptor() {
						public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
							return ((astra.lang.EIS) visitor.agent().getModule("VacBot","ei")).auto_formula((Predicate) predicate.accept(visitor));
						}
					}
				),
				new Predicate("free", new Term[] {
					Primitive.newPrimitive("left")
				})
			),
			new Block(
				"VacBot", new int[] {102,74,105,6},
				new Statement[] {
					new ModuleCall("ei",
						"VacBot", new int[] {103,10,103,25},
						new Predicate("move", new Term[] {
							Primitive.newPrimitive("left")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("VacBot","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Assignment(
						new Variable(Type.STRING, "action"),
						"VacBot", new int[] {104,10,105,6},
						Primitive.newPrimitive("move")
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {106,10,106,77},
			new GoalEvent('+',
				new Goal(
					new Predicate("task", new Term[] {
						new Variable(Type.STRING, "action",false)
					})
				)
			),
			new AND(
				new ModuleFormula("ei",
					new Predicate("square", new Term[] {
						Primitive.newPrimitive("right"),
						Primitive.newPrimitive("dust")
					}),
					new ModuleFormulaAdaptor() {
						public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
							return ((astra.lang.EIS) visitor.agent().getModule("VacBot","ei")).auto_formula((Predicate) predicate.accept(visitor));
						}
					}
				),
				new Predicate("free", new Term[] {
					Primitive.newPrimitive("right")
				})
			),
			new Block(
				"VacBot", new int[] {106,76,109,6},
				new Statement[] {
					new ModuleCall("ei",
						"VacBot", new int[] {107,10,107,26},
						new Predicate("move", new Term[] {
							Primitive.newPrimitive("right")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("VacBot","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Assignment(
						new Variable(Type.STRING, "action"),
						"VacBot", new int[] {108,10,109,6},
						Primitive.newPrimitive("move")
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {110,10,110,83},
			new GoalEvent('+',
				new Goal(
					new Predicate("task", new Term[] {
						new Variable(Type.STRING, "action",false)
					})
				)
			),
			new AND(
				new ModuleFormula("ei",
					new Predicate("square", new Term[] {
						Primitive.newPrimitive("forwardLeft"),
						Primitive.newPrimitive("dust")
					}),
					new ModuleFormulaAdaptor() {
						public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
							return ((astra.lang.EIS) visitor.agent().getModule("VacBot","ei")).auto_formula((Predicate) predicate.accept(visitor));
						}
					}
				),
				new Predicate("free", new Term[] {
					Primitive.newPrimitive("forward")
				})
			),
			new Block(
				"VacBot", new int[] {110,82,113,6},
				new Statement[] {
					new ModuleCall("ei",
						"VacBot", new int[] {111,10,111,28},
						new Predicate("move", new Term[] {
							Primitive.newPrimitive("forward")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("VacBot","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Assignment(
						new Variable(Type.STRING, "action"),
						"VacBot", new int[] {112,10,113,6},
						Primitive.newPrimitive("move")
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {114,10,114,84},
			new GoalEvent('+',
				new Goal(
					new Predicate("task", new Term[] {
						new Variable(Type.STRING, "action",false)
					})
				)
			),
			new AND(
				new ModuleFormula("ei",
					new Predicate("square", new Term[] {
						Primitive.newPrimitive("forwardRight"),
						Primitive.newPrimitive("dust")
					}),
					new ModuleFormulaAdaptor() {
						public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
							return ((astra.lang.EIS) visitor.agent().getModule("VacBot","ei")).auto_formula((Predicate) predicate.accept(visitor));
						}
					}
				),
				new Predicate("free", new Term[] {
					Primitive.newPrimitive("forward")
				})
			),
			new Block(
				"VacBot", new int[] {114,83,117,6},
				new Statement[] {
					new ModuleCall("ei",
						"VacBot", new int[] {115,10,115,28},
						new Predicate("move", new Term[] {
							Primitive.newPrimitive("forward")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("VacBot","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Assignment(
						new Variable(Type.STRING, "action"),
						"VacBot", new int[] {116,10,117,6},
						Primitive.newPrimitive("move")
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {118,10,118,49},
			new GoalEvent('+',
				new Goal(
					new Predicate("task", new Term[] {
						new Variable(Type.STRING, "action",false)
					})
				)
			),
			new Predicate("free", new Term[] {
				Primitive.newPrimitive("forward")
			}),
			new Block(
				"VacBot", new int[] {118,48,121,6},
				new Statement[] {
					new ModuleCall("ei",
						"VacBot", new int[] {119,10,119,28},
						new Predicate("move", new Term[] {
							Primitive.newPrimitive("forward")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("VacBot","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Assignment(
						new Variable(Type.STRING, "action"),
						"VacBot", new int[] {120,10,121,6},
						Primitive.newPrimitive("move")
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {122,10,122,46},
			new GoalEvent('+',
				new Goal(
					new Predicate("task", new Term[] {
						new Variable(Type.STRING, "action",false)
					})
				)
			),
			new Predicate("free", new Term[] {
				Primitive.newPrimitive("left")
			}),
			new Block(
				"VacBot", new int[] {122,45,125,6},
				new Statement[] {
					new ModuleCall("ei",
						"VacBot", new int[] {123,10,123,25},
						new Predicate("move", new Term[] {
							Primitive.newPrimitive("left")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("VacBot","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Assignment(
						new Variable(Type.STRING, "action"),
						"VacBot", new int[] {124,10,125,6},
						Primitive.newPrimitive("move")
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {126,10,126,47},
			new GoalEvent('+',
				new Goal(
					new Predicate("task", new Term[] {
						new Variable(Type.STRING, "action",false)
					})
				)
			),
			new Predicate("free", new Term[] {
				Primitive.newPrimitive("right")
			}),
			new Block(
				"VacBot", new int[] {126,46,129,6},
				new Statement[] {
					new ModuleCall("ei",
						"VacBot", new int[] {127,10,127,26},
						new Predicate("move", new Term[] {
							Primitive.newPrimitive("right")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("VacBot","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Assignment(
						new Variable(Type.STRING, "action"),
						"VacBot", new int[] {128,10,129,6},
						Primitive.newPrimitive("move")
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {131,10,131,32},
			new GoalEvent('+',
				new Goal(
					new Predicate("task", new Term[] {
						new Variable(Type.STRING, "action",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"VacBot", new int[] {131,31,134,6},
				new Statement[] {
					new ModuleCall("ei",
						"VacBot", new int[] {132,10,132,27},
						new Predicate("move", new Term[] {
							Primitive.newPrimitive("left"),
							Primitive.newPrimitive(0)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("VacBot","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Assignment(
						new Variable(Type.STRING, "action"),
						"VacBot", new int[] {133,10,134,6},
						Primitive.newPrimitive("move")
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {136,10,136,33},
			new GoalEvent('+',
				new Goal(
					new Predicate("route", new Term[] {
						new Variable(Type.STRING, "action",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"VacBot", new int[] {136,32,154,6},
				new Statement[] {
					new Declaration(
						new Variable(Type.BOOLEAN, "check"),
						"VacBot", new int[] {138,10,154,6},
						Primitive.newPrimitive(false)
					),
					new While(
						"VacBot", new int[] {139,10,154,6},
						new Comparison("==",
							new Variable(Type.BOOLEAN, "check"),
							Primitive.newPrimitive(false)
						),
						new Block(
							"VacBot", new int[] {139,32,153,11},
							new Statement[] {
								new Query(
									"VacBot", new int[] {140,15,140,51},
									new ModuleFormula("ei",
										new Predicate("location", new Term[] {
											new Variable(Type.LONG, "sx",false),
											new Variable(Type.LONG, "sy",false)
										}),
										new ModuleFormulaAdaptor() {
											public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((astra.lang.EIS) visitor.agent().getModule("VacBot","ei")).auto_formula((Predicate) predicate.accept(visitor));
											}
										}
									)
								),
								new If(
									"VacBot", new int[] {141,15,153,11},
									new AND(
										new Comparison(">",
											new Variable(Type.LONG, "sx"),
											Primitive.newPrimitive(-5)
										),
										new Comparison(">",
											new Variable(Type.LONG, "sy"),
											Primitive.newPrimitive(-5)
										)
									),
									new Block(
										"VacBot", new int[] {141,35,151,16},
										new Statement[] {
											new Declaration(
												new Variable(Type.LONG, "tx"),
												"VacBot", new int[] {142,20,151,16},
												Primitive.newPrimitive(1l)
											),
											new Declaration(
												new Variable(Type.LONG, "ty"),
												"VacBot", new int[] {143,20,151,16},
												Primitive.newPrimitive(1l)
											),
											new Declaration(
												new Variable(Type.LIST, "L"),
												"VacBot", new int[] {144,20,151,16},
												new ModuleTerm("R", Type.LIST,
													new Predicate("routeTo", new Term[] {
														new Variable(Type.LONG, "sx"),
														new Variable(Type.LONG, "sy"),
														new Variable(Type.LONG, "tx"),
														new Variable(Type.LONG, "ty")
													}),
													new ModuleTermAdaptor() {
														public Object invoke(Intention intention, Predicate predicate) {
															return ((Routing) intention.getModule("VacBot","R")).routeTo(
																(long) intention.evaluate(predicate.getTerm(0)),
																(long) intention.evaluate(predicate.getTerm(1)),
																(long) intention.evaluate(predicate.getTerm(2)),
																(long) intention.evaluate(predicate.getTerm(3))
															);
														}
														public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
															return ((Routing) visitor.agent().getModule("VacBot","R")).routeTo(
																(long) visitor.evaluate(predicate.getTerm(0)),
																(long) visitor.evaluate(predicate.getTerm(1)),
																(long) visitor.evaluate(predicate.getTerm(2)),
																(long) visitor.evaluate(predicate.getTerm(3))
															);
														}
													}
												)
											),
											new BeliefUpdate('+',
												"VacBot", new int[] {148,20,151,16},
												new Predicate("routelist", new Term[] {
													new Variable(Type.LIST, "L")
												})
											),
											new Subgoal(
												"VacBot", new int[] {149,20,151,16},
												new Goal(
													new Predicate("task", new Term[] {
														new Variable(Type.STRING, "action")
													})
												)
											),
											new Assignment(
												new Variable(Type.BOOLEAN, "check"),
												"VacBot", new int[] {150,20,151,16},
												Primitive.newPrimitive(true)
											)
										}
									),
									new Block(
										"VacBot", new int[] {152,19,153,11},
										new Statement[] {
										}
									)
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {159,10,159,21},
			new GoalEvent('+',
				new Goal(
					new Predicate("update", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"VacBot", new int[] {159,20,186,6},
				new Statement[] {
					new Query(
						"VacBot", new int[] {165,10,165,44},
						new ModuleFormula("ei",
							new Predicate("location", new Term[] {
								new Variable(Type.LONG, "X",false),
								new Variable(Type.LONG, "Y",false)
							}),
							new ModuleFormulaAdaptor() {
								public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.EIS) visitor.agent().getModule("VacBot","ei")).auto_formula((Predicate) predicate.accept(visitor));
								}
							}
						)
					),
					new Query(
						"VacBot", new int[] {166,10,166,39},
						new ModuleFormula("ei",
							new Predicate("direction", new Term[] {
								new Variable(Type.STRING, "D",false)
							}),
							new ModuleFormulaAdaptor() {
								public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.EIS) visitor.agent().getModule("VacBot","ei")).auto_formula((Predicate) predicate.accept(visitor));
								}
							}
						)
					),
					new ForEach(
						"VacBot", new int[] {171,10,186,6},
						new AND(
							new ModuleFormula("ei",
								new Predicate("square", new Term[] {
									new Variable(Type.STRING, "location",false),
									Primitive.newPrimitive("obstacle")
								}),
								new ModuleFormulaAdaptor() {
									public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.EIS) visitor.agent().getModule("VacBot","ei")).auto_formula((Predicate) predicate.accept(visitor));
									}
								}
							),
							new NOT(
								new ModuleFormula("R",
									new Predicate("obstacle", new Term[] {
										new Variable(Type.LONG, "X"),
										new Variable(Type.LONG, "Y"),
										new Variable(Type.STRING, "D"),
										new Variable(Type.STRING, "location")
									}),
								new ModuleFormulaAdaptor() {
										public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
											return ((Routing) visitor.agent().getModule("VacBot","R")).obstacle(
												(long) visitor.evaluate(predicate.getTerm(0)),
												(long) visitor.evaluate(predicate.getTerm(1)),
												(java.lang.String) visitor.evaluate(predicate.getTerm(2)),
												(java.lang.String) visitor.evaluate(predicate.getTerm(3))
											);
									}
								}
									)
							)
						),
						new Block(
							"VacBot", new int[] {171,91,173,11},
							new Statement[] {
								new ModuleCall("R",
									"VacBot", new int[] {172,15,172,50},
									new Predicate("recordObstacle", new Term[] {
										new Variable(Type.LONG, "X"),
										new Variable(Type.LONG, "Y"),
										new Variable(Type.STRING, "D"),
										new Variable(Type.STRING, "location")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((Routing) intention.getModule("VacBot","R")).recordObstacle(
												(java.lang.Long) intention.evaluate(predicate.getTerm(0)),
												(java.lang.Long) intention.evaluate(predicate.getTerm(1)),
												(java.lang.String) intention.evaluate(predicate.getTerm(2)),
												(java.lang.String) intention.evaluate(predicate.getTerm(3))
											);
										}
									}
								)
							}
						)
					),
					new Declaration(
						new Variable(Type.LONG, "gX"),
						"VacBot", new int[] {175,10,186,6},
						Operator.newOperator('+',
							new Variable(Type.LONG, "X"),
							Primitive.newPrimitive(1)
						)
					),
					new Declaration(
						new Variable(Type.LONG, "gY"),
						"VacBot", new int[] {176,10,186,6},
						Operator.newOperator('+',
							new Variable(Type.LONG, "Y"),
							Primitive.newPrimitive(1)
						)
					),
					new Declaration(
						new Variable(Type.LONG, "cX"),
						"VacBot", new int[] {177,10,186,6},
						new ModuleTerm("R", Type.LONG,
							new Predicate("maxX", new Term[] {}),
							new ModuleTermAdaptor() {
								public Object invoke(Intention intention, Predicate predicate) {
									return ((Routing) intention.getModule("VacBot","R")).maxX(
									);
								}
								public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((Routing) visitor.agent().getModule("VacBot","R")).maxX(
									);
								}
							}
						)
					),
					new Declaration(
						new Variable(Type.LONG, "cY"),
						"VacBot", new int[] {178,10,186,6},
						new ModuleTerm("R", Type.LONG,
							new Predicate("maxY", new Term[] {}),
							new ModuleTermAdaptor() {
								public Object invoke(Intention intention, Predicate predicate) {
									return ((Routing) intention.getModule("VacBot","R")).maxY(
									);
								}
								public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((Routing) visitor.agent().getModule("VacBot","R")).maxY(
									);
								}
							}
						)
					),
					new If(
						"VacBot", new int[] {179,10,186,6},
						new Comparison(">",
							new Variable(Type.LONG, "gX"),
							new Variable(Type.LONG, "cX")
						),
						new Block(
							"VacBot", new int[] {179,22,181,16},
							new Statement[] {
								new Assignment(
									new Variable(Type.LONG, "cX"),
									"VacBot", new int[] {180,15,181,16},
									new Variable(Type.LONG, "gX")
								)
							}
						)
					),
					new If(
						"VacBot", new int[] {182,10,186,6},
						new Comparison(">",
							new Variable(Type.LONG, "gY"),
							new Variable(Type.LONG, "cY")
						),
						new Block(
							"VacBot", new int[] {182,22,184,11},
							new Statement[] {
								new Assignment(
									new Variable(Type.LONG, "cY"),
									"VacBot", new int[] {183,15,184,11},
									new Variable(Type.LONG, "gY")
								)
							}
						)
					),
					new ModuleCall("R",
						"VacBot", new int[] {185,10,185,34},
						new Predicate("updateBoundary", new Term[] {
							new Variable(Type.LONG, "cX"),
							new Variable(Type.LONG, "cY")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((Routing) intention.getModule("VacBot","R")).updateBoundary(
									(java.lang.Long) intention.evaluate(predicate.getTerm(0)),
									(java.lang.Long) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"VacBot", new int[] {207,10,207,35},
			new GoalEvent('+',
				new Goal(
					new Predicate("main", new Term[] {
						new ListTerm(new Term[] {
							new Variable(Type.STRING, "vacbot",false)
						})
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"VacBot", new int[] {207,34,212,6},
				new Statement[] {
					new ModuleCall("ei",
						"VacBot", new int[] {208,10,208,23},
						new Predicate("join", new Term[] {
							Primitive.newPrimitive("hw")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("VacBot","ei")).join(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("ei",
						"VacBot", new int[] {209,10,209,25},
						new Predicate("link", new Term[] {
							new Variable(Type.STRING, "vacbot")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("VacBot","ei")).link(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("C",
						"VacBot", new int[] {210,10,210,39},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("VacBot activated")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("VacBot","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
	}

	public void initialize(astra.core.Agent agent) {
		agent.addSensorAdaptor(new SensorAdaptor() {
			public void sense(astra.core.Agent agent) {
				((astra.lang.EIS) agent.getModule("VacBot","ei")).sense();
			}
		});

		agent.initialize(
			new Predicate("counter", new Term[] {
				Primitive.newPrimitive(0)
			})
		);
	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("ei",astra.lang.EIS.class,agent);
		fragment.addModule("C",astra.lang.Console.class,agent);
		fragment.addModule("R",Routing.class,agent);
		fragment.addModule("sys",astra.lang.System.class,agent);
		return fragment;
	}

	public static void main(String[] args) {
		Scheduler.setStrategy(new TestSchedulerStrategy());
		ListTerm argList = new ListTerm();
		for (String arg: args) {
			argList.add(Primitive.newPrimitive(arg));
		}

		String name = java.lang.System.getProperty("astra.name", "main");
		try {
			astra.core.Agent agent = new VacBot().newInstance(name);
			agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};
	}
}
