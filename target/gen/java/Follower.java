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


public class Follower extends ASTRAClass {
	public Follower() {
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
						return ((astra.lang.EIS) visitor.agent().getModule("Follower","ei")).auto_formula((Predicate) predicate.accept(visitor));
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
						return ((astra.lang.EIS) visitor.agent().getModule("Follower","ei")).auto_formula((Predicate) predicate.accept(visitor));
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
			"Follower", new int[] {39,10,39,55},
			new ModuleEvent("ei",
				"$eis",
				new Predicate("event", new Term[] {
					new Funct("task", new Term[] {
						Primitive.newPrimitive("none")
					})
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.lang.EIS) agent.getModule("Follower","ei")).event(
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
				"Follower", new int[] {39,54,56,6},
				new Statement[] {
					new Subgoal(
						"Follower", new int[] {40,10,56,6},
						new Goal(
							new Predicate("update", new Term[] {})
						)
					),
					new Query(
						"Follower", new int[] {41,10,41,36},
						new Predicate("start", new Term[] {
							new Variable(Type.BOOLEAN, "Eval",false)
						})
					),
					new If(
						"Follower", new int[] {43,10,56,6},
						new Comparison("==",
							new Variable(Type.BOOLEAN, "Eval"),
							Primitive.newPrimitive(false)
						),
						new Block(
							"Follower", new int[] {43,28,51,11},
							new Statement[] {
								new Query(
									"Follower", new int[] {44,15,44,49},
									new ModuleFormula("ei",
										new Predicate("location", new Term[] {
											new Variable(Type.LONG, "X",false),
											new Variable(Type.LONG, "Y",false)
										}),
										new ModuleFormulaAdaptor() {
											public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((astra.lang.EIS) visitor.agent().getModule("Follower","ei")).auto_formula((Predicate) predicate.accept(visitor));
											}
										}
									)
								),
								new Declaration(
									new Variable(Type.LIST, "L"),
									"Follower", new int[] {45,15,51,11},
									new ListTerm(new Term[] {
										new Variable(Type.LONG, "X"),
										new Variable(Type.LONG, "Y")
									})
								),
								new Send("Follower", new int[] {46,15,46,52},
									new Performative("inform"),
									Primitive.newPrimitive("Henry"),
									new Predicate("coordinates", new Term[] {
										new Variable(Type.LIST, "L")
									})
								),
								new BeliefUpdate('-',
									"Follower", new int[] {48,15,51,11},
									new Predicate("start", new Term[] {
										Primitive.newPrimitive(false)
									})
								),
								new BeliefUpdate('+',
									"Follower", new int[] {49,15,51,11},
									new Predicate("start", new Term[] {
										Primitive.newPrimitive(true)
									})
								),
								new Subgoal(
									"Follower", new int[] {50,15,51,11},
									new Goal(
										new Predicate("task", new Term[] {
											new Variable(Type.STRING, "action",false)
										})
									)
								)
							}
						),
						new Block(
							"Follower", new int[] {52,14,56,6},
							new Statement[] {
								new Subgoal(
									"Follower", new int[] {53,15,54,11},
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
			"Follower", new int[] {76,10,76,63},
			new MessageEvent(
				new Performative("inform"),
				new Variable(Type.STRING, "sender",false),
				new Predicate("coordinates", new Term[] {
					new Variable(Type.LIST, "L",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"Follower", new int[] {76,62,99,6},
				new Statement[] {
					new ModuleCall("C",
						"Follower", new int[] {78,10,78,39},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("got a message :)")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Follower","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Declaration(
						new Variable(Type.INTEGER, "n"),
						"Follower", new int[] {79,10,99,6},
						Primitive.newPrimitive(0)
					),
					new ForAll(
						"Follower", new int[] {82,15,82,34},
						new Variable(Type.LONG, "i",false),
						new Variable(Type.LIST, "L"),
						new Block(
							"Follower", new int[] {82,34,99,6},
							new Statement[] {
								new If(
									"Follower", new int[] {83,20,90,16},
									new Comparison("==",
										new Variable(Type.INTEGER, "n"),
										Primitive.newPrimitive(0)
									),
									new Block(
										"Follower", new int[] {83,30,86,21},
										new Statement[] {
											new Declaration(
												new Variable(Type.LONG, "tx"),
												"Follower", new int[] {84,25,86,21},
												new Variable(Type.LONG, "i")
											),
											new Assignment(
												new Variable(Type.INTEGER, "n"),
												"Follower", new int[] {85,25,86,21},
												Operator.newOperator('+',
													new Variable(Type.INTEGER, "n"),
													Primitive.newPrimitive(1)
												)
											)
										}
									),
									new If(
										"Follower", new int[] {87,25,90,16},
										new Comparison("==",
											new Variable(Type.INTEGER, "n"),
											Primitive.newPrimitive(1)
										),
										new Block(
											"Follower", new int[] {87,34,89,21},
											new Statement[] {
												new Declaration(
													new Variable(Type.LONG, "ty"),
													"Follower", new int[] {88,25,89,21},
													new Variable(Type.LONG, "i")
												)
											}
										)
									)
								)
							}
						)
					),
					new BeliefUpdate('-',
						"Follower", new int[] {91,15,99,6},
						new Predicate("job", new Term[] {
							Primitive.newPrimitive(false)
						})
					),
					new BeliefUpdate('+',
						"Follower", new int[] {92,15,99,6},
						new Predicate("job", new Term[] {
							Primitive.newPrimitive(true)
						})
					),
					new Subgoal(
						"Follower", new int[] {93,15,99,6},
						new Goal(
							new Predicate("route", new Term[] {
								new Variable(Type.LONG, "tx",false),
								new Variable(Type.LONG, "ty",false)
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Follower", new int[] {104,10,104,55},
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
				"Follower", new int[] {104,54,112,6},
				new Statement[] {
					new ModuleCall("C",
						"Follower", new int[] {105,10,105,48},
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
								return ((astra.lang.Console) intention.getModule("Follower","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("ei",
						"Follower", new int[] {107,10,107,28},
						new Predicate("move", new Term[] {
							new Variable(Type.STRING, "direction")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("Follower","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Subgoal(
						"Follower", new int[] {110,10,112,6},
						new Goal(
							new Predicate("update", new Term[] {})
						)
					),
					new Subgoal(
						"Follower", new int[] {111,10,112,6},
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
			"Follower", new int[] {123,10,123,55},
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
				"Follower", new int[] {123,54,135,6},
				new Statement[] {
					new Query(
						"Follower", new int[] {125,10,125,44},
						new ModuleFormula("ei",
							new Predicate("square", new Term[] {
								Primitive.newPrimitive("here"),
								new Variable(Type.STRING, "X",false)
							}),
							new ModuleFormulaAdaptor() {
								public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.EIS) visitor.agent().getModule("Follower","ei")).auto_formula((Predicate) predicate.accept(visitor));
								}
							}
						)
					),
					new If(
						"Follower", new int[] {126,10,135,6},
						new Comparison("==",
							new Variable(Type.STRING, "X"),
							Primitive.newPrimitive("dust")
						),
						new Block(
							"Follower", new int[] {126,25,128,11},
							new Statement[] {
								new ModuleCall("ei",
									"Follower", new int[] {127,15,127,25},
									new Predicate("clean", new Term[] {}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return false;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.EIS) intention.getModule("Follower","ei")).auto_action(intention,evaluate(intention,predicate));
										}
									}
								)
							}
						),
						new Block(
							"Follower", new int[] {129,14,135,6},
							new Statement[] {
							}
						)
					),
					new ModuleCall("C",
						"Follower", new int[] {130,10,130,43},
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
								return ((astra.lang.Console) intention.getModule("Follower","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new BeliefUpdate('-',
						"Follower", new int[] {132,10,135,6},
						new Predicate("route", new Term[] {
							new ListTerm(new Term[] {
								new Variable(Type.FUNCTION, "move")
							})
						})
					),
					new Subgoal(
						"Follower", new int[] {133,10,135,6},
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
			"Follower", new int[] {136,10,136,63},
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
				"Follower", new int[] {136,62,147,6},
				new Statement[] {
					new Query(
						"Follower", new int[] {138,10,138,44},
						new ModuleFormula("ei",
							new Predicate("square", new Term[] {
								Primitive.newPrimitive("here"),
								new Variable(Type.STRING, "X",false)
							}),
							new ModuleFormulaAdaptor() {
								public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.EIS) visitor.agent().getModule("Follower","ei")).auto_formula((Predicate) predicate.accept(visitor));
								}
							}
						)
					),
					new If(
						"Follower", new int[] {139,10,147,6},
						new Comparison("==",
							new Variable(Type.STRING, "X"),
							Primitive.newPrimitive("dust")
						),
						new Block(
							"Follower", new int[] {139,25,141,11},
							new Statement[] {
								new ModuleCall("ei",
									"Follower", new int[] {140,15,140,25},
									new Predicate("clean", new Term[] {}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return false;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.EIS) intention.getModule("Follower","ei")).auto_action(intention,evaluate(intention,predicate));
										}
									}
								)
							}
						),
						new Block(
							"Follower", new int[] {142,14,147,6},
							new Statement[] {
							}
						)
					),
					new ModuleCall("C",
						"Follower", new int[] {143,10,143,44},
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
								return ((astra.lang.Console) intention.getModule("Follower","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("C",
						"Follower", new int[] {144,10,144,35},
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
								return ((astra.lang.Console) intention.getModule("Follower","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new SpecialBeliefUpdate(
						"Follower", new int[] {145,10,147,6},
						new Predicate("route", new Term[] {
							new Variable(Type.LIST, "L")
						})
					),
					new Subgoal(
						"Follower", new int[] {146,10,147,6},
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
			"Follower", new int[] {148,10,148,61},
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
						return ((astra.lang.EIS) visitor.agent().getModule("Follower","ei")).auto_formula((Predicate) predicate.accept(visitor));
					}
				}
			),
			new Block(
				"Follower", new int[] {148,60,152,6},
				new Statement[] {
					new ModuleCall("ei",
						"Follower", new int[] {149,10,149,20},
						new Predicate("clean", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("Follower","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Assignment(
						new Variable(Type.STRING, "action"),
						"Follower", new int[] {150,10,152,6},
						Primitive.newPrimitive("clean")
					)
				}
			)
		));
		addRule(new Rule(
			"Follower", new int[] {154,10,154,33},
			new GoalEvent('+',
				new Goal(
					new Predicate("task", new Term[] {
						new Variable(Type.STRING, "action",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Follower", new int[] {154,32,158,6},
				new Statement[] {
					new ModuleCall("ei",
						"Follower", new int[] {155,10,155,28},
						new Predicate("move", new Term[] {
							Primitive.newPrimitive("right"),
							Primitive.newPrimitive(0)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("Follower","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Assignment(
						new Variable(Type.STRING, "action"),
						"Follower", new int[] {156,10,158,6},
						Primitive.newPrimitive("move")
					)
				}
			)
		));
		addRule(new Rule(
			"Follower", new int[] {220,10,220,36},
			new GoalEvent('+',
				new Goal(
					new Predicate("route", new Term[] {
						new Variable(Type.LONG, "tx",false),
						new Variable(Type.LONG, "ty",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Follower", new int[] {220,35,254,6},
				new Statement[] {
					new Declaration(
						new Variable(Type.BOOLEAN, "check"),
						"Follower", new int[] {222,10,254,6},
						Primitive.newPrimitive(false)
					),
					new ModuleCall("C",
						"Follower", new int[] {223,10,223,39},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("doing a route :)")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Follower","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new While(
						"Follower", new int[] {226,10,254,6},
						new Comparison("==",
							new Variable(Type.BOOLEAN, "check"),
							Primitive.newPrimitive(false)
						),
						new Block(
							"Follower", new int[] {226,32,253,11},
							new Statement[] {
								new Query(
									"Follower", new int[] {227,15,227,51},
									new ModuleFormula("ei",
										new Predicate("location", new Term[] {
											new Variable(Type.LONG, "sx",false),
											new Variable(Type.LONG, "sy",false)
										}),
										new ModuleFormulaAdaptor() {
											public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((astra.lang.EIS) visitor.agent().getModule("Follower","ei")).auto_formula((Predicate) predicate.accept(visitor));
											}
										}
									)
								),
								new If(
									"Follower", new int[] {230,20,253,11},
									new AND(
										new Comparison("==",
											new Variable(Type.LONG, "sx"),
											new Variable(Type.LONG, "ty")
										),
										new Comparison("==",
											new Variable(Type.LONG, "sy"),
											new Variable(Type.LONG, "ty")
										)
									),
									new Block(
										"Follower", new int[] {230,44,240,21},
										new Statement[] {
											new Assignment(
												new Variable(Type.BOOLEAN, "check"),
												"Follower", new int[] {231,25,240,21},
												Primitive.newPrimitive(true)
											),
											new BeliefUpdate('-',
												"Follower", new int[] {232,25,240,21},
												new Predicate("job", new Term[] {
													Primitive.newPrimitive(true)
												})
											),
											new BeliefUpdate('+',
												"Follower", new int[] {233,25,240,21},
												new Predicate("job", new Term[] {
													Primitive.newPrimitive(false)
												})
											),
											new BeliefUpdate('-',
												"Follower", new int[] {235,25,240,21},
												new Predicate("routelist", new Term[] {
													new ListTerm(new Term[] {
														new Variable(Type.LONG, "tx"),
														new Variable(Type.LONG, "ty")
													})
												})
											),
											new ModuleCall("C",
												"Follower", new int[] {237,25,237,60},
												new Predicate("println", new Term[] {
													Primitive.newPrimitive("MADE IT TO DESTINATION")
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Follower","C")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											),
											new Send("Follower", new int[] {238,25,238,69},
												new Performative("inform"),
												Primitive.newPrimitive("Henry"),
												new Predicate("coordinates", new Term[] {
													new ListTerm(new Term[] {
														new Variable(Type.LONG, "sx"),
														new Variable(Type.LONG, "sy")
													})
												})
											),
											new Subgoal(
												"Follower", new int[] {239,25,240,21},
												new Goal(
													new Predicate("task", new Term[] {
														new Variable(Type.STRING, "action",false)
													})
												)
											)
										}
									),
									new Block(
										"Follower", new int[] {241,24,253,11},
										new Statement[] {
											new Declaration(
												new Variable(Type.LIST, "L"),
												"Follower", new int[] {245,25,250,21},
												new ModuleTerm("R", Type.LIST,
													new Predicate("routeTo", new Term[] {
														new Variable(Type.LONG, "sx"),
														new Variable(Type.LONG, "sy"),
														new Variable(Type.LONG, "tx"),
														new Variable(Type.LONG, "ty")
													}),
													new ModuleTermAdaptor() {
														public Object invoke(Intention intention, Predicate predicate) {
															return ((Routing) intention.getModule("Follower","R")).routeTo(
																(long) intention.evaluate(predicate.getTerm(0)),
																(long) intention.evaluate(predicate.getTerm(1)),
																(long) intention.evaluate(predicate.getTerm(2)),
																(long) intention.evaluate(predicate.getTerm(3))
															);
														}
														public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
															return ((Routing) visitor.agent().getModule("Follower","R")).routeTo(
																(long) visitor.evaluate(predicate.getTerm(0)),
																(long) visitor.evaluate(predicate.getTerm(1)),
																(long) visitor.evaluate(predicate.getTerm(2)),
																(long) visitor.evaluate(predicate.getTerm(3))
															);
														}
													}
												)
											),
											new ModuleCall("C",
												"Follower", new int[] {246,25,246,51},
												new Predicate("println", new Term[] {
													Primitive.newPrimitive("ROUTE CREATED")
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Follower","C")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											),
											new Assignment(
												new Variable(Type.BOOLEAN, "check"),
												"Follower", new int[] {247,25,250,21},
												Primitive.newPrimitive(true)
											),
											new BeliefUpdate('+',
												"Follower", new int[] {248,25,250,21},
												new Predicate("routelist", new Term[] {
													new Variable(Type.LIST, "L")
												})
											),
											new Subgoal(
												"Follower", new int[] {249,25,250,21},
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
					)
				}
			)
		));
		addRule(new Rule(
			"Follower", new int[] {258,10,258,21},
			new GoalEvent('+',
				new Goal(
					new Predicate("update", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Follower", new int[] {258,20,276,6},
				new Statement[] {
					new Query(
						"Follower", new int[] {259,10,259,44},
						new ModuleFormula("ei",
							new Predicate("location", new Term[] {
								new Variable(Type.LONG, "X",false),
								new Variable(Type.LONG, "Y",false)
							}),
							new ModuleFormulaAdaptor() {
								public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.EIS) visitor.agent().getModule("Follower","ei")).auto_formula((Predicate) predicate.accept(visitor));
								}
							}
						)
					),
					new Query(
						"Follower", new int[] {260,10,260,39},
						new ModuleFormula("ei",
							new Predicate("direction", new Term[] {
								new Variable(Type.STRING, "D",false)
							}),
							new ModuleFormulaAdaptor() {
								public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.EIS) visitor.agent().getModule("Follower","ei")).auto_formula((Predicate) predicate.accept(visitor));
								}
							}
						)
					),
					new ForEach(
						"Follower", new int[] {261,10,276,6},
						new AND(
							new ModuleFormula("ei",
								new Predicate("square", new Term[] {
									new Variable(Type.STRING, "location",false),
									Primitive.newPrimitive("obstacle")
								}),
								new ModuleFormulaAdaptor() {
									public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.EIS) visitor.agent().getModule("Follower","ei")).auto_formula((Predicate) predicate.accept(visitor));
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
											return ((Routing) visitor.agent().getModule("Follower","R")).obstacle(
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
							"Follower", new int[] {261,91,263,11},
							new Statement[] {
								new ModuleCall("R",
									"Follower", new int[] {262,15,262,50},
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
											return ((Routing) intention.getModule("Follower","R")).recordObstacle(
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
						"Follower", new int[] {265,10,276,6},
						Operator.newOperator('+',
							new Variable(Type.LONG, "X"),
							Primitive.newPrimitive(1)
						)
					),
					new Declaration(
						new Variable(Type.LONG, "gY"),
						"Follower", new int[] {266,10,276,6},
						Operator.newOperator('+',
							new Variable(Type.LONG, "Y"),
							Primitive.newPrimitive(1)
						)
					),
					new Declaration(
						new Variable(Type.LONG, "cX"),
						"Follower", new int[] {267,10,276,6},
						new ModuleTerm("R", Type.LONG,
							new Predicate("maxX", new Term[] {}),
							new ModuleTermAdaptor() {
								public Object invoke(Intention intention, Predicate predicate) {
									return ((Routing) intention.getModule("Follower","R")).maxX(
									);
								}
								public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((Routing) visitor.agent().getModule("Follower","R")).maxX(
									);
								}
							}
						)
					),
					new Declaration(
						new Variable(Type.LONG, "cY"),
						"Follower", new int[] {268,10,276,6},
						new ModuleTerm("R", Type.LONG,
							new Predicate("maxY", new Term[] {}),
							new ModuleTermAdaptor() {
								public Object invoke(Intention intention, Predicate predicate) {
									return ((Routing) intention.getModule("Follower","R")).maxY(
									);
								}
								public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((Routing) visitor.agent().getModule("Follower","R")).maxY(
									);
								}
							}
						)
					),
					new If(
						"Follower", new int[] {269,10,276,6},
						new Comparison(">",
							new Variable(Type.LONG, "gX"),
							new Variable(Type.LONG, "cX")
						),
						new Block(
							"Follower", new int[] {269,22,271,16},
							new Statement[] {
								new Assignment(
									new Variable(Type.LONG, "cX"),
									"Follower", new int[] {270,15,271,16},
									new Variable(Type.LONG, "gX")
								)
							}
						)
					),
					new If(
						"Follower", new int[] {272,10,276,6},
						new Comparison(">",
							new Variable(Type.LONG, "gY"),
							new Variable(Type.LONG, "cY")
						),
						new Block(
							"Follower", new int[] {272,22,274,11},
							new Statement[] {
								new Assignment(
									new Variable(Type.LONG, "cY"),
									"Follower", new int[] {273,15,274,11},
									new Variable(Type.LONG, "gY")
								)
							}
						)
					),
					new ModuleCall("R",
						"Follower", new int[] {275,10,275,34},
						new Predicate("updateBoundary", new Term[] {
							new Variable(Type.LONG, "cX"),
							new Variable(Type.LONG, "cY")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((Routing) intention.getModule("Follower","R")).updateBoundary(
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
			"Follower", new int[] {284,10,284,35},
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
				"Follower", new int[] {284,34,290,6},
				new Statement[] {
					new ModuleCall("ei",
						"Follower", new int[] {286,10,286,23},
						new Predicate("join", new Term[] {
							Primitive.newPrimitive("hw")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("Follower","ei")).join(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("ei",
						"Follower", new int[] {287,10,287,25},
						new Predicate("link", new Term[] {
							new Variable(Type.STRING, "vacbot")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("Follower","ei")).link(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("C",
						"Follower", new int[] {288,10,288,45},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("Follower bot activated")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Follower","C")).println(
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
				((astra.lang.EIS) agent.getModule("Follower","ei")).sense();
			}
		});

		agent.initialize(
			new Predicate("counter", new Term[] {
				Primitive.newPrimitive(0)
			})
		);
		agent.initialize(
			new Predicate("job", new Term[] {
				Primitive.newPrimitive(false)
			})
		);
		agent.initialize(
			new Predicate("start", new Term[] {
				Primitive.newPrimitive(false)
			})
		);
	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("ei",astra.lang.EIS.class,agent);
		fragment.addModule("C",astra.lang.Console.class,agent);
		fragment.addModule("R",Routing.class,agent);
		fragment.addModule("math",astra.lang.Math.class,agent);
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
			astra.core.Agent agent = new Follower().newInstance(name);
			agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};
	}
}
