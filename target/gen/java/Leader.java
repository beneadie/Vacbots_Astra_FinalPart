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


public class Leader extends ASTRAClass {
	public Leader() {
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
						return ((astra.lang.EIS) visitor.agent().getModule("Leader","ei")).auto_formula((Predicate) predicate.accept(visitor));
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
						return ((astra.lang.EIS) visitor.agent().getModule("Leader","ei")).auto_formula((Predicate) predicate.accept(visitor));
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
			"Leader", new int[] {45,10,45,55},
			new ModuleEvent("ei",
				"$eis",
				new Predicate("event", new Term[] {
					new Funct("task", new Term[] {
						Primitive.newPrimitive("none")
					})
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.lang.EIS) agent.getModule("Leader","ei")).event(
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
				"Leader", new int[] {45,54,68,6},
				new Statement[] {
					new Query(
						"Leader", new int[] {46,10,46,34},
						new Predicate("dustlist", new Term[] {
							new Variable(Type.LIST, "L1",false)
						})
					),
					new ForAll(
						"Leader", new int[] {48,10,48,30},
						new Variable(Type.LIST, "X1",false),
						new Variable(Type.LIST, "L1"),
						new Block(
							"Leader", new int[] {48,31,68,6},
							new Statement[] {
								new Query(
									"Leader", new int[] {49,15,49,39},
									new Predicate("todolist", new Term[] {
										new Variable(Type.LIST, "L2",false)
									})
								),
								new Declaration(
									new Variable(Type.BOOLEAN, "checker"),
									"Leader", new int[] {50,15,66,11},
									Primitive.newPrimitive(false)
								),
								new ForAll(
									"Leader", new int[] {51,15,51,36},
									new Variable(Type.LIST, "X2",false),
									new Variable(Type.LIST, "L2"),
									new Block(
										"Leader", new int[] {51,36,66,11},
										new Statement[] {
											new If(
												"Leader", new int[] {52,20,56,16},
												new Comparison("==",
													new Variable(Type.LIST, "X1"),
													new Variable(Type.LIST, "X2")
												),
												new Block(
													"Leader", new int[] {52,33,54,21},
													new Statement[] {
														new Assignment(
															new Variable(Type.BOOLEAN, "checker"),
															"Leader", new int[] {53,25,54,21},
															Primitive.newPrimitive(true)
														)
													}
												),
												new Block(
													"Leader", new int[] {55,25,56,16},
													new Statement[] {
													}
												)
											)
										}
									)
								),
								new If(
									"Leader", new int[] {57,15,66,11},
									new Comparison("==",
										new Variable(Type.BOOLEAN, "checker"),
										Primitive.newPrimitive(false)
									),
									new Block(
										"Leader", new int[] {57,36,64,16},
										new Statement[] {
											new Declaration(
												new Variable(Type.LIST, "NewL"),
												"Leader", new int[] {59,20,64,16},
												Operator.newOperator('+',
													new Variable(Type.LIST, "L2"),
													new ListTerm(new Term[] {
														new Variable(Type.LIST, "X1")
													})
												)
											),
											new BeliefUpdate('-',
												"Leader", new int[] {60,20,64,16},
												new Predicate("todolist", new Term[] {
													new Variable(Type.LIST, "L2")
												})
											),
											new BeliefUpdate('+',
												"Leader", new int[] {61,20,64,16},
												new Predicate("todolist", new Term[] {
													new Variable(Type.LIST, "NewL")
												})
											),
											new ModuleCall("C",
												"Leader", new int[] {62,20,62,52},
												new Predicate("println", new Term[] {
													Operator.newOperator('+',
														Primitive.newPrimitive("to do list: "),
														new Variable(Type.LIST, "NewL")
													)
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Leader","C")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											),
											new Subgoal(
												"Leader", new int[] {63,20,64,16},
												new Goal(
													new Predicate("messfail", new Term[] {})
												)
											)
										}
									),
									new Block(
										"Leader", new int[] {65,19,66,11},
										new Statement[] {
										}
									)
								)
							}
						)
					),
					new Subgoal(
						"Leader", new int[] {67,10,68,6},
						new Goal(
							new Predicate("task", new Term[] {
								new Variable(Type.STRING, "action",false)
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Leader", new int[] {95,10,95,23},
			new GoalEvent('+',
				new Goal(
					new Predicate("messfail", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Leader", new int[] {95,22,137,6},
				new Statement[] {
					new Query(
						"Leader", new int[] {96,10,96,34},
						new Predicate("todolist", new Term[] {
							new Variable(Type.LIST, "L1",false)
						})
					),
					new Query(
						"Leader", new int[] {97,10,97,34},
						new Predicate("donelist", new Term[] {
							new Variable(Type.LIST, "L2",false)
						})
					),
					new ModuleCall("C",
						"Leader", new int[] {98,10,98,41},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("to do list 2: "),
								new Variable(Type.LIST, "L1")
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Leader","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Declaration(
						new Variable(Type.LIST, "blank"),
						"Leader", new int[] {99,10,137,6},
						new ListTerm(new Term[] {

						})
					),
					new If(
						"Leader", new int[] {100,10,137,6},
						new Comparison("==",
							new Variable(Type.LIST, "L1"),
							new Variable(Type.LIST, "blank")
						),
						new Block(
							"Leader", new int[] {100,26,104,11},
							new Statement[] {
								new Subgoal(
									"Leader", new int[] {102,15,104,11},
									new Goal(
										new Predicate("task", new Term[] {
											new Variable(Type.STRING, "action",false)
										})
									)
								),
								new ModuleCall("C",
									"Leader", new int[] {103,15,103,42},
									new Predicate("println", new Term[] {
										Primitive.newPrimitive("list was blank")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Leader","C")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								)
							}
						),
						new Block(
							"Leader", new int[] {105,14,137,6},
							new Statement[] {
								new ForEach(
									"Leader", new int[] {107,15,135,11},
									new Predicate("holdreceiver", new Term[] {
										new Variable(Type.STRING, "sender",false)
									}),
									new Block(
										"Leader", new int[] {107,51,134,16},
										new Statement[] {
											new ModuleCall("C",
												"Leader", new int[] {110,20,110,70},
												new Predicate("println", new Term[] {
													Operator.newOperator('+',
														Primitive.newPrimitive("doing check to find job for "),
														new Variable(Type.STRING, "sender")
													)
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Leader","C")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											),
											new ForAll(
												"Leader", new int[] {111,20,111,40},
												new Variable(Type.LIST, "X1",false),
												new Variable(Type.LIST, "L1"),
												new Block(
													"Leader", new int[] {111,41,134,16},
													new Statement[] {
														new Declaration(
															new Variable(Type.BOOLEAN, "checker"),
															"Leader", new int[] {112,25,133,16},
															Primitive.newPrimitive(false)
														),
														new ForAll(
															"Leader", new int[] {113,25,113,46},
															new Variable(Type.LIST, "X2",false),
															new Variable(Type.LIST, "L2"),
															new Block(
																"Leader", new int[] {113,46,133,16},
																new Statement[] {
																	new If(
																		"Leader", new int[] {114,30,121,26},
																		new Comparison("==",
																			new Variable(Type.LIST, "X1"),
																			new Variable(Type.LIST, "X2")
																		),
																		new Block(
																			"Leader", new int[] {114,43,119,31},
																			new Statement[] {
																				new ModuleCall("C",
																					"Leader", new int[] {115,35,115,62},
																					new Predicate("println", new Term[] {
																						Operator.newOperator('+',
																							Primitive.newPrimitive("LIST 1:  "),
																							new Variable(Type.LIST, "L1")
																						)
																					}),
																					new DefaultModuleCallAdaptor() {
																						public boolean inline() {
																							return true;
																						}

																						public boolean invoke(Intention intention, Predicate predicate) {
																							return ((astra.lang.Console) intention.getModule("Leader","C")).println(
																								(java.lang.String) intention.evaluate(predicate.getTerm(0))
																							);
																						}
																					}
																				),
																				new ModuleCall("C",
																					"Leader", new int[] {116,35,116,62},
																					new Predicate("println", new Term[] {
																						Operator.newOperator('+',
																							Primitive.newPrimitive("LIST 2:  "),
																							new Variable(Type.LIST, "L2")
																						)
																					}),
																					new DefaultModuleCallAdaptor() {
																						public boolean inline() {
																							return true;
																						}

																						public boolean invoke(Intention intention, Predicate predicate) {
																							return ((astra.lang.Console) intention.getModule("Leader","C")).println(
																								(java.lang.String) intention.evaluate(predicate.getTerm(0))
																							);
																						}
																					}
																				),
																				new ModuleCall("C",
																					"Leader", new int[] {117,35,117,72},
																					new Predicate("println", new Term[] {
																						Operator.newOperator('+',
																							new Variable(Type.LIST, "X1"),
																							Primitive.newPrimitive("was already in list")
																						)
																					}),
																					new DefaultModuleCallAdaptor() {
																						public boolean inline() {
																							return true;
																						}

																						public boolean invoke(Intention intention, Predicate predicate) {
																							return ((astra.lang.Console) intention.getModule("Leader","C")).println(
																								(java.lang.String) intention.evaluate(predicate.getTerm(0))
																							);
																						}
																					}
																				),
																				new Assignment(
																					new Variable(Type.BOOLEAN, "checker"),
																					"Leader", new int[] {118,35,119,31},
																					Primitive.newPrimitive(true)
																				)
																			}
																		),
																		new Block(
																			"Leader", new int[] {120,35,121,26},
																			new Statement[] {
																			}
																		)
																	)
																}
															)
														),
														new If(
															"Leader", new int[] {122,25,133,16},
															new Comparison("==",
																new Variable(Type.BOOLEAN, "checker"),
																Primitive.newPrimitive(false)
															),
															new Block(
																"Leader", new int[] {122,46,131,26},
																new Statement[] {
																	new ModuleCall("C",
																		"Leader", new int[] {123,30,123,62},
																		new Predicate("println", new Term[] {
																			Primitive.newPrimitive("adding to done list")
																		}),
																		new DefaultModuleCallAdaptor() {
																			public boolean inline() {
																				return true;
																			}

																			public boolean invoke(Intention intention, Predicate predicate) {
																				return ((astra.lang.Console) intention.getModule("Leader","C")).println(
																					(java.lang.String) intention.evaluate(predicate.getTerm(0))
																				);
																			}
																		}
																	),
																	new Send("Leader", new int[] {124,30,124,67},
																		new Performative("inform"),
																		new Variable(Type.STRING, "sender"),
																		new Predicate("coordinates", new Term[] {
																			new Variable(Type.LIST, "X1")
																		})
																	),
																	new BeliefUpdate('-',
																		"Leader", new int[] {125,30,131,26},
																		new Predicate("donelist", new Term[] {
																			new Variable(Type.LIST, "L2")
																		})
																	),
																	new Declaration(
																		new Variable(Type.LIST, "NewL"),
																		"Leader", new int[] {126,30,131,26},
																		Operator.newOperator('+',
																			new Variable(Type.LIST, "L2"),
																			new ListTerm(new Term[] {
																				new Variable(Type.LIST, "X1")
																			})
																		)
																	),
																	new BeliefUpdate('+',
																		"Leader", new int[] {127,30,131,26},
																		new Predicate("donelist", new Term[] {
																			new Variable(Type.LIST, "NewL")
																		})
																	),
																	new BeliefUpdate('+',
																		"Leader", new int[] {128,30,131,26},
																		new Predicate("coordinates", new Term[] {
																			new Variable(Type.LIST, "X1")
																		})
																	),
																	new ModuleCall("C",
																		"Leader", new int[] {129,30,129,78},
																		new Predicate("println", new Term[] {
																			Operator.newOperator('+',
																				Primitive.newPrimitive("sending "),
																				Operator.newOperator('+',
																					new Variable(Type.STRING, "sender"),
																					Operator.newOperator('+',
																						Primitive.newPrimitive(" to "),
																						Operator.newOperator('+',
																							new Variable(Type.LIST, "X1"),
																							Primitive.newPrimitive("!")
																						)
																					)
																				)
																			)
																		}),
																		new DefaultModuleCallAdaptor() {
																			public boolean inline() {
																				return true;
																			}

																			public boolean invoke(Intention intention, Predicate predicate) {
																				return ((astra.lang.Console) intention.getModule("Leader","C")).println(
																					(java.lang.String) intention.evaluate(predicate.getTerm(0))
																				);
																			}
																		}
																	),
																	new Assignment(
																		new Variable(Type.BOOLEAN, "checker"),
																		"Leader", new int[] {130,30,131,26},
																		Primitive.newPrimitive(true)
																	)
																}
															),
															new Block(
																"Leader", new int[] {132,29,133,16},
																new Statement[] {
																}
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
					)
				}
			)
		));
		addRule(new Rule(
			"Leader", new int[] {139,10,139,67},
			new MessageEvent(
				new Performative("inform"),
				new Variable(Type.STRING, "sender",false),
				new Predicate("coordinates", new Term[] {
					new Variable(Type.LIST, "Slist",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"Leader", new int[] {139,66,171,6},
				new Statement[] {
					new BeliefUpdate('+',
						"Leader", new int[] {146,10,171,6},
						new Predicate("holdreceiver", new Term[] {
							new Variable(Type.STRING, "sender")
						})
					),
					new Subgoal(
						"Leader", new int[] {147,10,171,6},
						new Goal(
							new Predicate("task", new Term[] {
								new Variable(Type.STRING, "action",false)
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Leader", new int[] {177,10,177,50},
			new GoalEvent('+',
				new Goal(
					new Predicate("check1", new Term[] {})
				)
			),
			new ModuleFormula("ei",
				new Predicate("square", new Term[] {
					Primitive.newPrimitive("here"),
					Primitive.newPrimitive("dust")
				}),
				new ModuleFormulaAdaptor() {
					public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
						return ((astra.lang.EIS) visitor.agent().getModule("Leader","ei")).auto_formula((Predicate) predicate.accept(visitor));
					}
				}
			),
			new Block(
				"Leader", new int[] {177,49,192,6},
				new Statement[] {
					new Declaration(
						new Variable(Type.BOOLEAN, "check"),
						"Leader", new int[] {179,10,192,6},
						Primitive.newPrimitive(false)
					),
					new While(
						"Leader", new int[] {180,10,192,6},
						new Comparison("==",
							new Variable(Type.BOOLEAN, "check"),
							Primitive.newPrimitive(false)
						),
						new Block(
							"Leader", new int[] {180,32,191,11},
							new Statement[] {
								new Query(
									"Leader", new int[] {181,15,181,51},
									new ModuleFormula("ei",
										new Predicate("location", new Term[] {
											new Variable(Type.LONG, "sx",false),
											new Variable(Type.LONG, "sy",false)
										}),
										new ModuleFormulaAdaptor() {
											public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((astra.lang.EIS) visitor.agent().getModule("Leader","ei")).auto_formula((Predicate) predicate.accept(visitor));
											}
										}
									)
								),
								new If(
									"Leader", new int[] {182,15,191,11},
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
										"Leader", new int[] {182,35,189,16},
										new Statement[] {
											new Query(
												"Leader", new int[] {183,20,183,43},
												new Predicate("dustlist", new Term[] {
													new Variable(Type.LIST, "L",false)
												})
											),
											new BeliefUpdate('-',
												"Leader", new int[] {184,20,189,16},
												new Predicate("dustlist", new Term[] {
													new Variable(Type.LIST, "L")
												})
											),
											new Assignment(
												new Variable(Type.LIST, "L"),
												"Leader", new int[] {186,20,189,16},
												Operator.newOperator('+',
													new Variable(Type.LIST, "L"),
													new ListTerm(new Term[] {
														new ListTerm(new Term[] {
															new Variable(Type.LONG, "sx"),
															new Variable(Type.LONG, "sy")
														})
													})
												)
											),
											new Assignment(
												new Variable(Type.BOOLEAN, "check"),
												"Leader", new int[] {187,20,189,16},
												Primitive.newPrimitive(true)
											),
											new BeliefUpdate('+',
												"Leader", new int[] {188,20,189,16},
												new Predicate("dustlist", new Term[] {
													new Variable(Type.LIST, "L")
												})
											)
										}
									),
									new Block(
										"Leader", new int[] {190,19,191,11},
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
			"Leader", new int[] {194,10,194,22},
			new GoalEvent('+',
				new Goal(
					new Predicate("check1", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Leader", new int[] {194,21,194,23},
				new Statement[] {
				}
			)
		));
		addRule(new Rule(
			"Leader", new int[] {195,10,195,77},
			new GoalEvent('+',
				new Goal(
					new Predicate("check2", new Term[] {})
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
							return ((astra.lang.EIS) visitor.agent().getModule("Leader","ei")).auto_formula((Predicate) predicate.accept(visitor));
						}
					}
				),
				new ModuleFormula("ei",
					new Predicate("direction", new Term[] {
						Primitive.newPrimitive("north")
					}),
					new ModuleFormulaAdaptor() {
						public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
							return ((astra.lang.EIS) visitor.agent().getModule("Leader","ei")).auto_formula((Predicate) predicate.accept(visitor));
						}
					}
				)
			),
			new Block(
				"Leader", new int[] {195,76,212,6},
				new Statement[] {
					new Declaration(
						new Variable(Type.BOOLEAN, "check"),
						"Leader", new int[] {197,10,212,6},
						Primitive.newPrimitive(false)
					),
					new While(
						"Leader", new int[] {198,10,212,6},
						new Comparison("==",
							new Variable(Type.BOOLEAN, "check"),
							Primitive.newPrimitive(false)
						),
						new Block(
							"Leader", new int[] {198,32,211,11},
							new Statement[] {
								new Query(
									"Leader", new int[] {199,15,199,51},
									new ModuleFormula("ei",
										new Predicate("location", new Term[] {
											new Variable(Type.LONG, "sx",false),
											new Variable(Type.LONG, "sy",false)
										}),
										new ModuleFormulaAdaptor() {
											public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((astra.lang.EIS) visitor.agent().getModule("Leader","ei")).auto_formula((Predicate) predicate.accept(visitor));
											}
										}
									)
								),
								new If(
									"Leader", new int[] {200,15,211,11},
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
										"Leader", new int[] {200,35,209,16},
										new Statement[] {
											new Assignment(
												new Variable(Type.LONG, "sx"),
												"Leader", new int[] {202,20,209,16},
												Operator.newOperator('-',
													new Variable(Type.LONG, "sx"),
													Primitive.newPrimitive(1)
												)
											),
											new Query(
												"Leader", new int[] {203,20,203,43},
												new Predicate("dustlist", new Term[] {
													new Variable(Type.LIST, "L",false)
												})
											),
											new BeliefUpdate('-',
												"Leader", new int[] {204,20,209,16},
												new Predicate("dustlist", new Term[] {
													new Variable(Type.LIST, "L")
												})
											),
											new Assignment(
												new Variable(Type.LIST, "L"),
												"Leader", new int[] {206,20,209,16},
												Operator.newOperator('+',
													new Variable(Type.LIST, "L"),
													new ListTerm(new Term[] {
														new ListTerm(new Term[] {
															new Variable(Type.LONG, "sx"),
															new Variable(Type.LONG, "sy")
														})
													})
												)
											),
											new Assignment(
												new Variable(Type.BOOLEAN, "check"),
												"Leader", new int[] {207,20,209,16},
												Primitive.newPrimitive(true)
											),
											new BeliefUpdate('+',
												"Leader", new int[] {208,20,209,16},
												new Predicate("dustlist", new Term[] {
													new Variable(Type.LIST, "L")
												})
											)
										}
									),
									new Block(
										"Leader", new int[] {210,19,211,11},
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
			"Leader", new int[] {213,10,213,22},
			new GoalEvent('+',
				new Goal(
					new Predicate("check2", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Leader", new int[] {213,21,213,23},
				new Statement[] {
				}
			)
		));
		addRule(new Rule(
			"Leader", new int[] {215,10,215,53},
			new GoalEvent('+',
				new Goal(
					new Predicate("check3", new Term[] {})
				)
			),
			new ModuleFormula("ei",
				new Predicate("square", new Term[] {
					Primitive.newPrimitive("forward"),
					Primitive.newPrimitive("dust")
				}),
				new ModuleFormulaAdaptor() {
					public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
						return ((astra.lang.EIS) visitor.agent().getModule("Leader","ei")).auto_formula((Predicate) predicate.accept(visitor));
					}
				}
			),
			new Block(
				"Leader", new int[] {215,52,266,6},
				new Statement[] {
					new Declaration(
						new Variable(Type.BOOLEAN, "check"),
						"Leader", new int[] {217,10,266,6},
						Primitive.newPrimitive(false)
					),
					new While(
						"Leader", new int[] {218,10,266,6},
						new Comparison("==",
							new Variable(Type.BOOLEAN, "check"),
							Primitive.newPrimitive(false)
						),
						new Block(
							"Leader", new int[] {218,32,265,11},
							new Statement[] {
								new Query(
									"Leader", new int[] {219,15,219,51},
									new ModuleFormula("ei",
										new Predicate("location", new Term[] {
											new Variable(Type.LONG, "sx",false),
											new Variable(Type.LONG, "sy",false)
										}),
										new ModuleFormulaAdaptor() {
											public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((astra.lang.EIS) visitor.agent().getModule("Leader","ei")).auto_formula((Predicate) predicate.accept(visitor));
											}
										}
									)
								),
								new If(
									"Leader", new int[] {220,15,265,11},
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
										"Leader", new int[] {220,35,263,16},
										new Statement[] {
											new Query(
												"Leader", new int[] {222,20,222,49},
												new ModuleFormula("ei",
													new Predicate("direction", new Term[] {
														new Variable(Type.STRING, "D",false)
													}),
													new ModuleFormulaAdaptor() {
														public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
															return ((astra.lang.EIS) visitor.agent().getModule("Leader","ei")).auto_formula((Predicate) predicate.accept(visitor));
														}
													}
												)
											),
											new If(
												"Leader", new int[] {223,20,263,16},
												new Comparison("==",
													new Variable(Type.STRING, "D"),
													Primitive.newPrimitive("north")
												),
												new Block(
													"Leader", new int[] {223,37,232,21},
													new Statement[] {
														new Assignment(
															new Variable(Type.LONG, "sy"),
															"Leader", new int[] {225,25,232,21},
															Operator.newOperator('-',
																new Variable(Type.LONG, "sy"),
																Primitive.newPrimitive(1)
															)
														),
														new Query(
															"Leader", new int[] {226,25,226,48},
															new Predicate("dustlist", new Term[] {
																new Variable(Type.LIST, "L",false)
															})
														),
														new BeliefUpdate('-',
															"Leader", new int[] {227,25,232,21},
															new Predicate("dustlist", new Term[] {
																new Variable(Type.LIST, "L")
															})
														),
														new Assignment(
															new Variable(Type.LIST, "L"),
															"Leader", new int[] {229,25,232,21},
															Operator.newOperator('+',
																new Variable(Type.LIST, "L"),
																new ListTerm(new Term[] {
																	new ListTerm(new Term[] {
																		new Variable(Type.LONG, "sx"),
																		new Variable(Type.LONG, "sy")
																	})
																})
															)
														),
														new Assignment(
															new Variable(Type.BOOLEAN, "check"),
															"Leader", new int[] {230,25,232,21},
															Primitive.newPrimitive(true)
														),
														new BeliefUpdate('+',
															"Leader", new int[] {231,25,232,21},
															new Predicate("dustlist", new Term[] {
																new Variable(Type.LIST, "L")
															})
														)
													}
												),
												new If(
													"Leader", new int[] {233,25,263,16},
													new Comparison("==",
														new Variable(Type.STRING, "D"),
														Primitive.newPrimitive("south")
													),
													new Block(
														"Leader", new int[] {233,41,242,21},
														new Statement[] {
															new Assignment(
																new Variable(Type.LONG, "sy"),
																"Leader", new int[] {235,25,242,21},
																Operator.newOperator('+',
																	new Variable(Type.LONG, "sy"),
																	Primitive.newPrimitive(1)
																)
															),
															new Query(
																"Leader", new int[] {236,25,236,48},
																new Predicate("dustlist", new Term[] {
																	new Variable(Type.LIST, "L",false)
																})
															),
															new BeliefUpdate('-',
																"Leader", new int[] {237,25,242,21},
																new Predicate("dustlist", new Term[] {
																	new Variable(Type.LIST, "L")
																})
															),
															new Assignment(
																new Variable(Type.LIST, "L"),
																"Leader", new int[] {239,25,242,21},
																Operator.newOperator('+',
																	new Variable(Type.LIST, "L"),
																	new ListTerm(new Term[] {
																		new ListTerm(new Term[] {
																			new Variable(Type.LONG, "sx"),
																			new Variable(Type.LONG, "sy")
																		})
																	})
																)
															),
															new Assignment(
																new Variable(Type.BOOLEAN, "check"),
																"Leader", new int[] {240,25,242,21},
																Primitive.newPrimitive(true)
															),
															new BeliefUpdate('+',
																"Leader", new int[] {241,25,242,21},
																new Predicate("dustlist", new Term[] {
																	new Variable(Type.LIST, "L")
																})
															)
														}
													),
													new If(
														"Leader", new int[] {243,25,263,16},
														new Comparison("==",
															new Variable(Type.STRING, "D"),
															Primitive.newPrimitive("east")
														),
														new Block(
															"Leader", new int[] {243,40,252,21},
															new Statement[] {
																new Assignment(
																	new Variable(Type.LONG, "sx"),
																	"Leader", new int[] {245,25,252,21},
																	Operator.newOperator('+',
																		new Variable(Type.LONG, "sx"),
																		Primitive.newPrimitive(1)
																	)
																),
																new Query(
																	"Leader", new int[] {246,25,246,48},
																	new Predicate("dustlist", new Term[] {
																		new Variable(Type.LIST, "L",false)
																	})
																),
																new BeliefUpdate('-',
																	"Leader", new int[] {247,25,252,21},
																	new Predicate("dustlist", new Term[] {
																		new Variable(Type.LIST, "L")
																	})
																),
																new Assignment(
																	new Variable(Type.LIST, "L"),
																	"Leader", new int[] {249,25,252,21},
																	Operator.newOperator('+',
																		new Variable(Type.LIST, "L"),
																		new ListTerm(new Term[] {
																			new ListTerm(new Term[] {
																				new Variable(Type.LONG, "sx"),
																				new Variable(Type.LONG, "sy")
																			})
																		})
																	)
																),
																new Assignment(
																	new Variable(Type.BOOLEAN, "check"),
																	"Leader", new int[] {250,25,252,21},
																	Primitive.newPrimitive(true)
																),
																new BeliefUpdate('+',
																	"Leader", new int[] {251,25,252,21},
																	new Predicate("dustlist", new Term[] {
																		new Variable(Type.LIST, "L")
																	})
																)
															}
														),
														new If(
															"Leader", new int[] {253,25,263,16},
															new Comparison("==",
																new Variable(Type.STRING, "D"),
																Primitive.newPrimitive("west")
															),
															new Block(
																"Leader", new int[] {253,40,262,21},
																new Statement[] {
																	new Assignment(
																		new Variable(Type.LONG, "sx"),
																		"Leader", new int[] {255,25,262,21},
																		Operator.newOperator('-',
																			new Variable(Type.LONG, "sx"),
																			Primitive.newPrimitive(1)
																		)
																	),
																	new Query(
																		"Leader", new int[] {256,25,256,48},
																		new Predicate("dustlist", new Term[] {
																			new Variable(Type.LIST, "L",false)
																		})
																	),
																	new BeliefUpdate('-',
																		"Leader", new int[] {257,25,262,21},
																		new Predicate("dustlist", new Term[] {
																			new Variable(Type.LIST, "L")
																		})
																	),
																	new Assignment(
																		new Variable(Type.LIST, "L"),
																		"Leader", new int[] {259,25,262,21},
																		Operator.newOperator('+',
																			new Variable(Type.LIST, "L"),
																			new ListTerm(new Term[] {
																				new ListTerm(new Term[] {
																					new Variable(Type.LONG, "sx"),
																					new Variable(Type.LONG, "sy")
																				})
																			})
																		)
																	),
																	new Assignment(
																		new Variable(Type.BOOLEAN, "check"),
																		"Leader", new int[] {260,25,262,21},
																		Primitive.newPrimitive(true)
																	),
																	new BeliefUpdate('+',
																		"Leader", new int[] {261,25,262,21},
																		new Predicate("dustlist", new Term[] {
																			new Variable(Type.LIST, "L")
																		})
																	)
																}
															)
														)
													)
												)
											)
										}
									),
									new Block(
										"Leader", new int[] {264,19,265,11},
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
			"Leader", new int[] {267,10,267,22},
			new GoalEvent('+',
				new Goal(
					new Predicate("check3", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Leader", new int[] {267,21,267,23},
				new Statement[] {
				}
			)
		));
		addRule(new Rule(
			"Leader", new int[] {269,10,269,50},
			new GoalEvent('+',
				new Goal(
					new Predicate("check4", new Term[] {})
				)
			),
			new ModuleFormula("ei",
				new Predicate("square", new Term[] {
					Primitive.newPrimitive("left"),
					Primitive.newPrimitive("dust")
				}),
				new ModuleFormulaAdaptor() {
					public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
						return ((astra.lang.EIS) visitor.agent().getModule("Leader","ei")).auto_formula((Predicate) predicate.accept(visitor));
					}
				}
			),
			new Block(
				"Leader", new int[] {269,49,320,6},
				new Statement[] {
					new Declaration(
						new Variable(Type.BOOLEAN, "check"),
						"Leader", new int[] {271,10,320,6},
						Primitive.newPrimitive(false)
					),
					new While(
						"Leader", new int[] {272,10,320,6},
						new Comparison("==",
							new Variable(Type.BOOLEAN, "check"),
							Primitive.newPrimitive(false)
						),
						new Block(
							"Leader", new int[] {272,32,319,11},
							new Statement[] {
								new Query(
									"Leader", new int[] {273,15,273,51},
									new ModuleFormula("ei",
										new Predicate("location", new Term[] {
											new Variable(Type.LONG, "sx",false),
											new Variable(Type.LONG, "sy",false)
										}),
										new ModuleFormulaAdaptor() {
											public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((astra.lang.EIS) visitor.agent().getModule("Leader","ei")).auto_formula((Predicate) predicate.accept(visitor));
											}
										}
									)
								),
								new If(
									"Leader", new int[] {274,15,319,11},
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
										"Leader", new int[] {274,35,317,16},
										new Statement[] {
											new Query(
												"Leader", new int[] {276,20,276,49},
												new ModuleFormula("ei",
													new Predicate("direction", new Term[] {
														new Variable(Type.STRING, "D",false)
													}),
													new ModuleFormulaAdaptor() {
														public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
															return ((astra.lang.EIS) visitor.agent().getModule("Leader","ei")).auto_formula((Predicate) predicate.accept(visitor));
														}
													}
												)
											),
											new If(
												"Leader", new int[] {277,20,317,16},
												new Comparison("==",
													new Variable(Type.STRING, "D"),
													Primitive.newPrimitive("north")
												),
												new Block(
													"Leader", new int[] {277,37,286,21},
													new Statement[] {
														new Assignment(
															new Variable(Type.LONG, "sx"),
															"Leader", new int[] {279,25,286,21},
															Operator.newOperator('-',
																new Variable(Type.LONG, "sx"),
																Primitive.newPrimitive(1)
															)
														),
														new Query(
															"Leader", new int[] {280,25,280,48},
															new Predicate("dustlist", new Term[] {
																new Variable(Type.LIST, "L",false)
															})
														),
														new BeliefUpdate('-',
															"Leader", new int[] {281,25,286,21},
															new Predicate("dustlist", new Term[] {
																new Variable(Type.LIST, "L")
															})
														),
														new Assignment(
															new Variable(Type.LIST, "L"),
															"Leader", new int[] {283,25,286,21},
															Operator.newOperator('+',
																new Variable(Type.LIST, "L"),
																new ListTerm(new Term[] {
																	new ListTerm(new Term[] {
																		new Variable(Type.LONG, "sx"),
																		new Variable(Type.LONG, "sy")
																	})
																})
															)
														),
														new Assignment(
															new Variable(Type.BOOLEAN, "check"),
															"Leader", new int[] {284,25,286,21},
															Primitive.newPrimitive(true)
														),
														new BeliefUpdate('+',
															"Leader", new int[] {285,25,286,21},
															new Predicate("dustlist", new Term[] {
																new Variable(Type.LIST, "L")
															})
														)
													}
												),
												new If(
													"Leader", new int[] {287,25,317,16},
													new Comparison("==",
														new Variable(Type.STRING, "D"),
														Primitive.newPrimitive("south")
													),
													new Block(
														"Leader", new int[] {287,41,296,21},
														new Statement[] {
															new Assignment(
																new Variable(Type.LONG, "sx"),
																"Leader", new int[] {289,25,296,21},
																Operator.newOperator('+',
																	new Variable(Type.LONG, "sx"),
																	Primitive.newPrimitive(1)
																)
															),
															new Query(
																"Leader", new int[] {290,25,290,48},
																new Predicate("dustlist", new Term[] {
																	new Variable(Type.LIST, "L",false)
																})
															),
															new BeliefUpdate('-',
																"Leader", new int[] {291,25,296,21},
																new Predicate("dustlist", new Term[] {
																	new Variable(Type.LIST, "L")
																})
															),
															new Assignment(
																new Variable(Type.LIST, "L"),
																"Leader", new int[] {293,25,296,21},
																Operator.newOperator('+',
																	new Variable(Type.LIST, "L"),
																	new ListTerm(new Term[] {
																		new ListTerm(new Term[] {
																			new Variable(Type.LONG, "sx"),
																			new Variable(Type.LONG, "sy")
																		})
																	})
																)
															),
															new Assignment(
																new Variable(Type.BOOLEAN, "check"),
																"Leader", new int[] {294,25,296,21},
																Primitive.newPrimitive(true)
															),
															new BeliefUpdate('+',
																"Leader", new int[] {295,25,296,21},
																new Predicate("dustlist", new Term[] {
																	new Variable(Type.LIST, "L")
																})
															)
														}
													),
													new If(
														"Leader", new int[] {297,25,317,16},
														new Comparison("==",
															new Variable(Type.STRING, "D"),
															Primitive.newPrimitive("east")
														),
														new Block(
															"Leader", new int[] {297,40,306,21},
															new Statement[] {
																new Assignment(
																	new Variable(Type.LONG, "sy"),
																	"Leader", new int[] {299,25,306,21},
																	Operator.newOperator('-',
																		new Variable(Type.LONG, "sy"),
																		Primitive.newPrimitive(1)
																	)
																),
																new Query(
																	"Leader", new int[] {300,25,300,48},
																	new Predicate("dustlist", new Term[] {
																		new Variable(Type.LIST, "L",false)
																	})
																),
																new BeliefUpdate('-',
																	"Leader", new int[] {301,25,306,21},
																	new Predicate("dustlist", new Term[] {
																		new Variable(Type.LIST, "L")
																	})
																),
																new Assignment(
																	new Variable(Type.LIST, "L"),
																	"Leader", new int[] {303,25,306,21},
																	Operator.newOperator('+',
																		new Variable(Type.LIST, "L"),
																		new ListTerm(new Term[] {
																			new ListTerm(new Term[] {
																				new Variable(Type.LONG, "sx"),
																				new Variable(Type.LONG, "sy")
																			})
																		})
																	)
																),
																new Assignment(
																	new Variable(Type.BOOLEAN, "check"),
																	"Leader", new int[] {304,25,306,21},
																	Primitive.newPrimitive(true)
																),
																new BeliefUpdate('+',
																	"Leader", new int[] {305,25,306,21},
																	new Predicate("dustlist", new Term[] {
																		new Variable(Type.LIST, "L")
																	})
																)
															}
														),
														new If(
															"Leader", new int[] {307,25,317,16},
															new Comparison("==",
																new Variable(Type.STRING, "D"),
																Primitive.newPrimitive("west")
															),
															new Block(
																"Leader", new int[] {307,40,316,21},
																new Statement[] {
																	new Assignment(
																		new Variable(Type.LONG, "sy"),
																		"Leader", new int[] {309,25,316,21},
																		Operator.newOperator('+',
																			new Variable(Type.LONG, "sy"),
																			Primitive.newPrimitive(1)
																		)
																	),
																	new Query(
																		"Leader", new int[] {310,25,310,48},
																		new Predicate("dustlist", new Term[] {
																			new Variable(Type.LIST, "L",false)
																		})
																	),
																	new BeliefUpdate('-',
																		"Leader", new int[] {311,25,316,21},
																		new Predicate("dustlist", new Term[] {
																			new Variable(Type.LIST, "L")
																		})
																	),
																	new Assignment(
																		new Variable(Type.LIST, "L"),
																		"Leader", new int[] {313,25,316,21},
																		Operator.newOperator('+',
																			new Variable(Type.LIST, "L"),
																			new ListTerm(new Term[] {
																				new ListTerm(new Term[] {
																					new Variable(Type.LONG, "sx"),
																					new Variable(Type.LONG, "sy")
																				})
																			})
																		)
																	),
																	new Assignment(
																		new Variable(Type.BOOLEAN, "check"),
																		"Leader", new int[] {314,25,316,21},
																		Primitive.newPrimitive(true)
																	),
																	new BeliefUpdate('+',
																		"Leader", new int[] {315,25,316,21},
																		new Predicate("dustlist", new Term[] {
																			new Variable(Type.LIST, "L")
																		})
																	)
																}
															)
														)
													)
												)
											)
										}
									),
									new Block(
										"Leader", new int[] {318,19,319,11},
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
			"Leader", new int[] {321,10,321,22},
			new GoalEvent('+',
				new Goal(
					new Predicate("check4", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Leader", new int[] {321,21,321,23},
				new Statement[] {
				}
			)
		));
		addRule(new Rule(
			"Leader", new int[] {323,10,323,51},
			new GoalEvent('+',
				new Goal(
					new Predicate("check5", new Term[] {})
				)
			),
			new ModuleFormula("ei",
				new Predicate("square", new Term[] {
					Primitive.newPrimitive("right"),
					Primitive.newPrimitive("dust")
				}),
				new ModuleFormulaAdaptor() {
					public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
						return ((astra.lang.EIS) visitor.agent().getModule("Leader","ei")).auto_formula((Predicate) predicate.accept(visitor));
					}
				}
			),
			new Block(
				"Leader", new int[] {323,50,374,6},
				new Statement[] {
					new Declaration(
						new Variable(Type.BOOLEAN, "check"),
						"Leader", new int[] {325,10,374,6},
						Primitive.newPrimitive(false)
					),
					new While(
						"Leader", new int[] {326,10,374,6},
						new Comparison("==",
							new Variable(Type.BOOLEAN, "check"),
							Primitive.newPrimitive(false)
						),
						new Block(
							"Leader", new int[] {326,32,373,11},
							new Statement[] {
								new Query(
									"Leader", new int[] {327,15,327,51},
									new ModuleFormula("ei",
										new Predicate("location", new Term[] {
											new Variable(Type.LONG, "sx",false),
											new Variable(Type.LONG, "sy",false)
										}),
										new ModuleFormulaAdaptor() {
											public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((astra.lang.EIS) visitor.agent().getModule("Leader","ei")).auto_formula((Predicate) predicate.accept(visitor));
											}
										}
									)
								),
								new If(
									"Leader", new int[] {328,15,373,11},
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
										"Leader", new int[] {328,35,371,16},
										new Statement[] {
											new Query(
												"Leader", new int[] {330,20,330,49},
												new ModuleFormula("ei",
													new Predicate("direction", new Term[] {
														new Variable(Type.STRING, "D",false)
													}),
													new ModuleFormulaAdaptor() {
														public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
															return ((astra.lang.EIS) visitor.agent().getModule("Leader","ei")).auto_formula((Predicate) predicate.accept(visitor));
														}
													}
												)
											),
											new If(
												"Leader", new int[] {331,20,371,16},
												new Comparison("==",
													new Variable(Type.STRING, "D"),
													Primitive.newPrimitive("north")
												),
												new Block(
													"Leader", new int[] {331,37,340,21},
													new Statement[] {
														new Assignment(
															new Variable(Type.LONG, "sx"),
															"Leader", new int[] {333,25,340,21},
															Operator.newOperator('+',
																new Variable(Type.LONG, "sx"),
																Primitive.newPrimitive(1)
															)
														),
														new Query(
															"Leader", new int[] {334,25,334,48},
															new Predicate("dustlist", new Term[] {
																new Variable(Type.LIST, "L",false)
															})
														),
														new BeliefUpdate('-',
															"Leader", new int[] {335,25,340,21},
															new Predicate("dustlist", new Term[] {
																new Variable(Type.LIST, "L")
															})
														),
														new Assignment(
															new Variable(Type.LIST, "L"),
															"Leader", new int[] {337,25,340,21},
															Operator.newOperator('+',
																new Variable(Type.LIST, "L"),
																new ListTerm(new Term[] {
																	new ListTerm(new Term[] {
																		new Variable(Type.LONG, "sx"),
																		new Variable(Type.LONG, "sy")
																	})
																})
															)
														),
														new Assignment(
															new Variable(Type.BOOLEAN, "check"),
															"Leader", new int[] {338,25,340,21},
															Primitive.newPrimitive(true)
														),
														new BeliefUpdate('+',
															"Leader", new int[] {339,25,340,21},
															new Predicate("dustlist", new Term[] {
																new Variable(Type.LIST, "L")
															})
														)
													}
												),
												new If(
													"Leader", new int[] {341,25,371,16},
													new Comparison("==",
														new Variable(Type.STRING, "D"),
														Primitive.newPrimitive("south")
													),
													new Block(
														"Leader", new int[] {341,41,350,21},
														new Statement[] {
															new Assignment(
																new Variable(Type.LONG, "sx"),
																"Leader", new int[] {343,25,350,21},
																Operator.newOperator('-',
																	new Variable(Type.LONG, "sx"),
																	Primitive.newPrimitive(1)
																)
															),
															new Query(
																"Leader", new int[] {344,25,344,48},
																new Predicate("dustlist", new Term[] {
																	new Variable(Type.LIST, "L",false)
																})
															),
															new BeliefUpdate('-',
																"Leader", new int[] {345,25,350,21},
																new Predicate("dustlist", new Term[] {
																	new Variable(Type.LIST, "L")
																})
															),
															new Assignment(
																new Variable(Type.LIST, "L"),
																"Leader", new int[] {347,25,350,21},
																Operator.newOperator('+',
																	new Variable(Type.LIST, "L"),
																	new ListTerm(new Term[] {
																		new ListTerm(new Term[] {
																			new Variable(Type.LONG, "sx"),
																			new Variable(Type.LONG, "sy")
																		})
																	})
																)
															),
															new Assignment(
																new Variable(Type.BOOLEAN, "check"),
																"Leader", new int[] {348,25,350,21},
																Primitive.newPrimitive(true)
															),
															new BeliefUpdate('+',
																"Leader", new int[] {349,25,350,21},
																new Predicate("dustlist", new Term[] {
																	new Variable(Type.LIST, "L")
																})
															)
														}
													),
													new If(
														"Leader", new int[] {351,25,371,16},
														new Comparison("==",
															new Variable(Type.STRING, "D"),
															Primitive.newPrimitive("east")
														),
														new Block(
															"Leader", new int[] {351,40,360,21},
															new Statement[] {
																new Assignment(
																	new Variable(Type.LONG, "sy"),
																	"Leader", new int[] {353,25,360,21},
																	Operator.newOperator('+',
																		new Variable(Type.LONG, "sy"),
																		Primitive.newPrimitive(1)
																	)
																),
																new Query(
																	"Leader", new int[] {354,25,354,48},
																	new Predicate("dustlist", new Term[] {
																		new Variable(Type.LIST, "L",false)
																	})
																),
																new BeliefUpdate('-',
																	"Leader", new int[] {355,25,360,21},
																	new Predicate("dustlist", new Term[] {
																		new Variable(Type.LIST, "L")
																	})
																),
																new Assignment(
																	new Variable(Type.LIST, "L"),
																	"Leader", new int[] {357,25,360,21},
																	Operator.newOperator('+',
																		new Variable(Type.LIST, "L"),
																		new ListTerm(new Term[] {
																			new ListTerm(new Term[] {
																				new Variable(Type.LONG, "sx"),
																				new Variable(Type.LONG, "sy")
																			})
																		})
																	)
																),
																new Assignment(
																	new Variable(Type.BOOLEAN, "check"),
																	"Leader", new int[] {358,25,360,21},
																	Primitive.newPrimitive(true)
																),
																new BeliefUpdate('+',
																	"Leader", new int[] {359,25,360,21},
																	new Predicate("dustlist", new Term[] {
																		new Variable(Type.LIST, "L")
																	})
																)
															}
														),
														new If(
															"Leader", new int[] {361,25,371,16},
															new Comparison("==",
																new Variable(Type.STRING, "D"),
																Primitive.newPrimitive("west")
															),
															new Block(
																"Leader", new int[] {361,40,370,21},
																new Statement[] {
																	new Assignment(
																		new Variable(Type.LONG, "sy"),
																		"Leader", new int[] {363,25,370,21},
																		Operator.newOperator('-',
																			new Variable(Type.LONG, "sy"),
																			Primitive.newPrimitive(1)
																		)
																	),
																	new Query(
																		"Leader", new int[] {364,25,364,48},
																		new Predicate("dustlist", new Term[] {
																			new Variable(Type.LIST, "L",false)
																		})
																	),
																	new BeliefUpdate('-',
																		"Leader", new int[] {365,25,370,21},
																		new Predicate("dustlist", new Term[] {
																			new Variable(Type.LIST, "L")
																		})
																	),
																	new Assignment(
																		new Variable(Type.LIST, "L"),
																		"Leader", new int[] {367,25,370,21},
																		Operator.newOperator('+',
																			new Variable(Type.LIST, "L"),
																			new ListTerm(new Term[] {
																				new ListTerm(new Term[] {
																					new Variable(Type.LONG, "sx"),
																					new Variable(Type.LONG, "sy")
																				})
																			})
																		)
																	),
																	new Assignment(
																		new Variable(Type.BOOLEAN, "check"),
																		"Leader", new int[] {368,25,370,21},
																		Primitive.newPrimitive(true)
																	),
																	new BeliefUpdate('+',
																		"Leader", new int[] {369,25,370,21},
																		new Predicate("dustlist", new Term[] {
																			new Variable(Type.LIST, "L")
																		})
																	)
																}
															)
														)
													)
												)
											)
										}
									),
									new Block(
										"Leader", new int[] {372,19,373,11},
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
			"Leader", new int[] {375,10,375,22},
			new GoalEvent('+',
				new Goal(
					new Predicate("check5", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Leader", new int[] {375,21,375,23},
				new Statement[] {
				}
			)
		));
		addRule(new Rule(
			"Leader", new int[] {376,10,376,57},
			new GoalEvent('+',
				new Goal(
					new Predicate("check6", new Term[] {})
				)
			),
			new ModuleFormula("ei",
				new Predicate("square", new Term[] {
					Primitive.newPrimitive("forwardLeft"),
					Primitive.newPrimitive("dust")
				}),
				new ModuleFormulaAdaptor() {
					public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
						return ((astra.lang.EIS) visitor.agent().getModule("Leader","ei")).auto_formula((Predicate) predicate.accept(visitor));
					}
				}
			),
			new Block(
				"Leader", new int[] {376,56,431,6},
				new Statement[] {
					new Declaration(
						new Variable(Type.BOOLEAN, "check"),
						"Leader", new int[] {378,10,431,6},
						Primitive.newPrimitive(false)
					),
					new While(
						"Leader", new int[] {379,10,431,6},
						new Comparison("==",
							new Variable(Type.BOOLEAN, "check"),
							Primitive.newPrimitive(false)
						),
						new Block(
							"Leader", new int[] {379,32,430,11},
							new Statement[] {
								new Query(
									"Leader", new int[] {380,15,380,51},
									new ModuleFormula("ei",
										new Predicate("location", new Term[] {
											new Variable(Type.LONG, "sx",false),
											new Variable(Type.LONG, "sy",false)
										}),
										new ModuleFormulaAdaptor() {
											public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((astra.lang.EIS) visitor.agent().getModule("Leader","ei")).auto_formula((Predicate) predicate.accept(visitor));
											}
										}
									)
								),
								new If(
									"Leader", new int[] {381,15,430,11},
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
										"Leader", new int[] {381,35,428,16},
										new Statement[] {
											new Query(
												"Leader", new int[] {383,20,383,49},
												new ModuleFormula("ei",
													new Predicate("direction", new Term[] {
														new Variable(Type.STRING, "D",false)
													}),
													new ModuleFormulaAdaptor() {
														public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
															return ((astra.lang.EIS) visitor.agent().getModule("Leader","ei")).auto_formula((Predicate) predicate.accept(visitor));
														}
													}
												)
											),
											new If(
												"Leader", new int[] {384,20,428,16},
												new Comparison("==",
													new Variable(Type.STRING, "D"),
													Primitive.newPrimitive("north")
												),
												new Block(
													"Leader", new int[] {384,37,394,21},
													new Statement[] {
														new Assignment(
															new Variable(Type.LONG, "sy"),
															"Leader", new int[] {386,25,394,21},
															Operator.newOperator('-',
																new Variable(Type.LONG, "sy"),
																Primitive.newPrimitive(1)
															)
														),
														new Assignment(
															new Variable(Type.LONG, "sx"),
															"Leader", new int[] {387,25,394,21},
															Operator.newOperator('-',
																new Variable(Type.LONG, "sx"),
																Primitive.newPrimitive(1)
															)
														),
														new Query(
															"Leader", new int[] {388,25,388,48},
															new Predicate("dustlist", new Term[] {
																new Variable(Type.LIST, "L",false)
															})
														),
														new BeliefUpdate('-',
															"Leader", new int[] {389,25,394,21},
															new Predicate("dustlist", new Term[] {
																new Variable(Type.LIST, "L")
															})
														),
														new Assignment(
															new Variable(Type.LIST, "L"),
															"Leader", new int[] {391,25,394,21},
															Operator.newOperator('+',
																new Variable(Type.LIST, "L"),
																new ListTerm(new Term[] {
																	new ListTerm(new Term[] {
																		new Variable(Type.LONG, "sx"),
																		new Variable(Type.LONG, "sy")
																	})
																})
															)
														),
														new Assignment(
															new Variable(Type.BOOLEAN, "check"),
															"Leader", new int[] {392,25,394,21},
															Primitive.newPrimitive(true)
														),
														new BeliefUpdate('+',
															"Leader", new int[] {393,25,394,21},
															new Predicate("dustlist", new Term[] {
																new Variable(Type.LIST, "L")
															})
														)
													}
												),
												new If(
													"Leader", new int[] {395,25,428,16},
													new Comparison("==",
														new Variable(Type.STRING, "D"),
														Primitive.newPrimitive("south")
													),
													new Block(
														"Leader", new int[] {395,41,405,21},
														new Statement[] {
															new Assignment(
																new Variable(Type.LONG, "sy"),
																"Leader", new int[] {397,25,405,21},
																Operator.newOperator('+',
																	new Variable(Type.LONG, "sy"),
																	Primitive.newPrimitive(1)
																)
															),
															new Assignment(
																new Variable(Type.LONG, "sx"),
																"Leader", new int[] {398,25,405,21},
																Operator.newOperator('+',
																	new Variable(Type.LONG, "sx"),
																	Primitive.newPrimitive(1)
																)
															),
															new Query(
																"Leader", new int[] {399,25,399,48},
																new Predicate("dustlist", new Term[] {
																	new Variable(Type.LIST, "L",false)
																})
															),
															new BeliefUpdate('-',
																"Leader", new int[] {400,25,405,21},
																new Predicate("dustlist", new Term[] {
																	new Variable(Type.LIST, "L")
																})
															),
															new Assignment(
																new Variable(Type.LIST, "L"),
																"Leader", new int[] {402,25,405,21},
																Operator.newOperator('+',
																	new Variable(Type.LIST, "L"),
																	new ListTerm(new Term[] {
																		new ListTerm(new Term[] {
																			new Variable(Type.LONG, "sx"),
																			new Variable(Type.LONG, "sy")
																		})
																	})
																)
															),
															new Assignment(
																new Variable(Type.BOOLEAN, "check"),
																"Leader", new int[] {403,25,405,21},
																Primitive.newPrimitive(true)
															),
															new BeliefUpdate('+',
																"Leader", new int[] {404,25,405,21},
																new Predicate("dustlist", new Term[] {
																	new Variable(Type.LIST, "L")
																})
															)
														}
													),
													new If(
														"Leader", new int[] {406,25,428,16},
														new Comparison("==",
															new Variable(Type.STRING, "D"),
															Primitive.newPrimitive("east")
														),
														new Block(
															"Leader", new int[] {406,40,416,21},
															new Statement[] {
																new Assignment(
																	new Variable(Type.LONG, "sx"),
																	"Leader", new int[] {408,25,416,21},
																	Operator.newOperator('+',
																		new Variable(Type.LONG, "sx"),
																		Primitive.newPrimitive(1)
																	)
																),
																new Assignment(
																	new Variable(Type.LONG, "sy"),
																	"Leader", new int[] {409,25,416,21},
																	Operator.newOperator('-',
																		new Variable(Type.LONG, "sy"),
																		Primitive.newPrimitive(1)
																	)
																),
																new Query(
																	"Leader", new int[] {410,25,410,48},
																	new Predicate("dustlist", new Term[] {
																		new Variable(Type.LIST, "L",false)
																	})
																),
																new BeliefUpdate('-',
																	"Leader", new int[] {411,25,416,21},
																	new Predicate("dustlist", new Term[] {
																		new Variable(Type.LIST, "L")
																	})
																),
																new Assignment(
																	new Variable(Type.LIST, "L"),
																	"Leader", new int[] {413,25,416,21},
																	Operator.newOperator('+',
																		new Variable(Type.LIST, "L"),
																		new ListTerm(new Term[] {
																			new ListTerm(new Term[] {
																				new Variable(Type.LONG, "sx"),
																				new Variable(Type.LONG, "sy")
																			})
																		})
																	)
																),
																new Assignment(
																	new Variable(Type.BOOLEAN, "check"),
																	"Leader", new int[] {414,25,416,21},
																	Primitive.newPrimitive(true)
																),
																new BeliefUpdate('+',
																	"Leader", new int[] {415,25,416,21},
																	new Predicate("dustlist", new Term[] {
																		new Variable(Type.LIST, "L")
																	})
																)
															}
														),
														new If(
															"Leader", new int[] {417,25,428,16},
															new Comparison("==",
																new Variable(Type.STRING, "D"),
																Primitive.newPrimitive("west")
															),
															new Block(
																"Leader", new int[] {417,40,427,21},
																new Statement[] {
																	new Assignment(
																		new Variable(Type.LONG, "sx"),
																		"Leader", new int[] {419,25,427,21},
																		Operator.newOperator('-',
																			new Variable(Type.LONG, "sx"),
																			Primitive.newPrimitive(1)
																		)
																	),
																	new Assignment(
																		new Variable(Type.LONG, "sy"),
																		"Leader", new int[] {420,25,427,21},
																		Operator.newOperator('+',
																			new Variable(Type.LONG, "sy"),
																			Primitive.newPrimitive(1)
																		)
																	),
																	new Query(
																		"Leader", new int[] {421,25,421,48},
																		new Predicate("dustlist", new Term[] {
																			new Variable(Type.LIST, "L",false)
																		})
																	),
																	new BeliefUpdate('-',
																		"Leader", new int[] {422,25,427,21},
																		new Predicate("dustlist", new Term[] {
																			new Variable(Type.LIST, "L")
																		})
																	),
																	new Assignment(
																		new Variable(Type.LIST, "L"),
																		"Leader", new int[] {424,25,427,21},
																		Operator.newOperator('+',
																			new Variable(Type.LIST, "L"),
																			new ListTerm(new Term[] {
																				new ListTerm(new Term[] {
																					new Variable(Type.LONG, "sx"),
																					new Variable(Type.LONG, "sy")
																				})
																			})
																		)
																	),
																	new Assignment(
																		new Variable(Type.BOOLEAN, "check"),
																		"Leader", new int[] {425,25,427,21},
																		Primitive.newPrimitive(true)
																	),
																	new BeliefUpdate('+',
																		"Leader", new int[] {426,25,427,21},
																		new Predicate("dustlist", new Term[] {
																			new Variable(Type.LIST, "L")
																		})
																	)
																}
															)
														)
													)
												)
											)
										}
									),
									new Block(
										"Leader", new int[] {429,19,430,11},
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
			"Leader", new int[] {432,10,432,22},
			new GoalEvent('+',
				new Goal(
					new Predicate("check6", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Leader", new int[] {432,21,432,23},
				new Statement[] {
				}
			)
		));
		addRule(new Rule(
			"Leader", new int[] {434,10,434,58},
			new GoalEvent('+',
				new Goal(
					new Predicate("check7", new Term[] {})
				)
			),
			new ModuleFormula("ei",
				new Predicate("square", new Term[] {
					Primitive.newPrimitive("forwardRight"),
					Primitive.newPrimitive("dust")
				}),
				new ModuleFormulaAdaptor() {
					public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
						return ((astra.lang.EIS) visitor.agent().getModule("Leader","ei")).auto_formula((Predicate) predicate.accept(visitor));
					}
				}
			),
			new Block(
				"Leader", new int[] {434,57,491,6},
				new Statement[] {
					new Declaration(
						new Variable(Type.BOOLEAN, "check"),
						"Leader", new int[] {436,10,491,6},
						Primitive.newPrimitive(false)
					),
					new While(
						"Leader", new int[] {437,10,491,6},
						new Comparison("==",
							new Variable(Type.BOOLEAN, "check"),
							Primitive.newPrimitive(false)
						),
						new Block(
							"Leader", new int[] {437,32,490,11},
							new Statement[] {
								new Query(
									"Leader", new int[] {438,15,438,51},
									new ModuleFormula("ei",
										new Predicate("location", new Term[] {
											new Variable(Type.LONG, "sx",false),
											new Variable(Type.LONG, "sy",false)
										}),
										new ModuleFormulaAdaptor() {
											public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((astra.lang.EIS) visitor.agent().getModule("Leader","ei")).auto_formula((Predicate) predicate.accept(visitor));
											}
										}
									)
								),
								new If(
									"Leader", new int[] {439,15,490,11},
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
										"Leader", new int[] {439,35,488,16},
										new Statement[] {
											new Query(
												"Leader", new int[] {441,20,441,49},
												new ModuleFormula("ei",
													new Predicate("direction", new Term[] {
														new Variable(Type.STRING, "D",false)
													}),
													new ModuleFormulaAdaptor() {
														public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
															return ((astra.lang.EIS) visitor.agent().getModule("Leader","ei")).auto_formula((Predicate) predicate.accept(visitor));
														}
													}
												)
											),
											new If(
												"Leader", new int[] {442,20,488,16},
												new Comparison("==",
													new Variable(Type.STRING, "D"),
													Primitive.newPrimitive("north")
												),
												new Block(
													"Leader", new int[] {442,37,452,21},
													new Statement[] {
														new Assignment(
															new Variable(Type.LONG, "sy"),
															"Leader", new int[] {444,25,452,21},
															Operator.newOperator('-',
																new Variable(Type.LONG, "sy"),
																Primitive.newPrimitive(1)
															)
														),
														new Assignment(
															new Variable(Type.LONG, "sx"),
															"Leader", new int[] {445,25,452,21},
															Operator.newOperator('+',
																new Variable(Type.LONG, "sx"),
																Primitive.newPrimitive(1)
															)
														),
														new Query(
															"Leader", new int[] {446,25,446,48},
															new Predicate("dustlist", new Term[] {
																new Variable(Type.LIST, "L",false)
															})
														),
														new BeliefUpdate('-',
															"Leader", new int[] {447,25,452,21},
															new Predicate("dustlist", new Term[] {
																new Variable(Type.LIST, "L")
															})
														),
														new Assignment(
															new Variable(Type.LIST, "L"),
															"Leader", new int[] {449,25,452,21},
															Operator.newOperator('+',
																new Variable(Type.LIST, "L"),
																new ListTerm(new Term[] {
																	new ListTerm(new Term[] {
																		new Variable(Type.LONG, "sx"),
																		new Variable(Type.LONG, "sy")
																	})
																})
															)
														),
														new Assignment(
															new Variable(Type.BOOLEAN, "check"),
															"Leader", new int[] {450,25,452,21},
															Primitive.newPrimitive(true)
														),
														new BeliefUpdate('+',
															"Leader", new int[] {451,25,452,21},
															new Predicate("dustlist", new Term[] {
																new Variable(Type.LIST, "L")
															})
														)
													}
												),
												new If(
													"Leader", new int[] {453,25,488,16},
													new Comparison("==",
														new Variable(Type.STRING, "D"),
														Primitive.newPrimitive("south")
													),
													new Block(
														"Leader", new int[] {453,41,463,21},
														new Statement[] {
															new Assignment(
																new Variable(Type.LONG, "sy"),
																"Leader", new int[] {455,25,463,21},
																Operator.newOperator('+',
																	new Variable(Type.LONG, "sy"),
																	Primitive.newPrimitive(1)
																)
															),
															new Assignment(
																new Variable(Type.LONG, "sx"),
																"Leader", new int[] {456,25,463,21},
																Operator.newOperator('-',
																	new Variable(Type.LONG, "sx"),
																	Primitive.newPrimitive(1)
																)
															),
															new Query(
																"Leader", new int[] {457,25,457,48},
																new Predicate("dustlist", new Term[] {
																	new Variable(Type.LIST, "L",false)
																})
															),
															new BeliefUpdate('-',
																"Leader", new int[] {458,25,463,21},
																new Predicate("dustlist", new Term[] {
																	new Variable(Type.LIST, "L")
																})
															),
															new Assignment(
																new Variable(Type.LIST, "L"),
																"Leader", new int[] {460,25,463,21},
																Operator.newOperator('+',
																	new Variable(Type.LIST, "L"),
																	new ListTerm(new Term[] {
																		new ListTerm(new Term[] {
																			new Variable(Type.LONG, "sx"),
																			new Variable(Type.LONG, "sy")
																		})
																	})
																)
															),
															new Assignment(
																new Variable(Type.BOOLEAN, "check"),
																"Leader", new int[] {461,25,463,21},
																Primitive.newPrimitive(true)
															),
															new BeliefUpdate('+',
																"Leader", new int[] {462,25,463,21},
																new Predicate("dustlist", new Term[] {
																	new Variable(Type.LIST, "L")
																})
															)
														}
													),
													new If(
														"Leader", new int[] {464,25,488,16},
														new Comparison("==",
															new Variable(Type.STRING, "D"),
															Primitive.newPrimitive("east")
														),
														new Block(
															"Leader", new int[] {464,40,474,21},
															new Statement[] {
																new Assignment(
																	new Variable(Type.LONG, "sx"),
																	"Leader", new int[] {466,25,474,21},
																	Operator.newOperator('+',
																		new Variable(Type.LONG, "sx"),
																		Primitive.newPrimitive(1)
																	)
																),
																new Assignment(
																	new Variable(Type.LONG, "sy"),
																	"Leader", new int[] {467,25,474,21},
																	Operator.newOperator('+',
																		new Variable(Type.LONG, "sy"),
																		Primitive.newPrimitive(1)
																	)
																),
																new Query(
																	"Leader", new int[] {468,25,468,48},
																	new Predicate("dustlist", new Term[] {
																		new Variable(Type.LIST, "L",false)
																	})
																),
																new BeliefUpdate('-',
																	"Leader", new int[] {469,25,474,21},
																	new Predicate("dustlist", new Term[] {
																		new Variable(Type.LIST, "L")
																	})
																),
																new Assignment(
																	new Variable(Type.LIST, "L"),
																	"Leader", new int[] {471,25,474,21},
																	Operator.newOperator('+',
																		new Variable(Type.LIST, "L"),
																		new ListTerm(new Term[] {
																			new ListTerm(new Term[] {
																				new Variable(Type.LONG, "sx"),
																				new Variable(Type.LONG, "sy")
																			})
																		})
																	)
																),
																new Assignment(
																	new Variable(Type.BOOLEAN, "check"),
																	"Leader", new int[] {472,25,474,21},
																	Primitive.newPrimitive(true)
																),
																new BeliefUpdate('+',
																	"Leader", new int[] {473,25,474,21},
																	new Predicate("dustlist", new Term[] {
																		new Variable(Type.LIST, "L")
																	})
																)
															}
														),
														new If(
															"Leader", new int[] {475,25,488,16},
															new Comparison("==",
																new Variable(Type.STRING, "D"),
																Primitive.newPrimitive("west")
															),
															new Block(
																"Leader", new int[] {475,40,485,21},
																new Statement[] {
																	new Assignment(
																		new Variable(Type.LONG, "sx"),
																		"Leader", new int[] {477,25,485,21},
																		Operator.newOperator('-',
																			new Variable(Type.LONG, "sx"),
																			Primitive.newPrimitive(1)
																		)
																	),
																	new Assignment(
																		new Variable(Type.LONG, "sy"),
																		"Leader", new int[] {478,25,485,21},
																		Operator.newOperator('-',
																			new Variable(Type.LONG, "sy"),
																			Primitive.newPrimitive(1)
																		)
																	),
																	new Query(
																		"Leader", new int[] {479,25,479,48},
																		new Predicate("dustlist", new Term[] {
																			new Variable(Type.LIST, "L",false)
																		})
																	),
																	new BeliefUpdate('-',
																		"Leader", new int[] {480,25,485,21},
																		new Predicate("dustlist", new Term[] {
																			new Variable(Type.LIST, "L")
																		})
																	),
																	new Assignment(
																		new Variable(Type.LIST, "L"),
																		"Leader", new int[] {482,25,485,21},
																		Operator.newOperator('+',
																			new Variable(Type.LIST, "L"),
																			new ListTerm(new Term[] {
																				new ListTerm(new Term[] {
																					new Variable(Type.LONG, "sx"),
																					new Variable(Type.LONG, "sy")
																				})
																			})
																		)
																	),
																	new Assignment(
																		new Variable(Type.BOOLEAN, "check"),
																		"Leader", new int[] {483,25,485,21},
																		Primitive.newPrimitive(true)
																	),
																	new BeliefUpdate('+',
																		"Leader", new int[] {484,25,485,21},
																		new Predicate("dustlist", new Term[] {
																			new Variable(Type.LIST, "L")
																		})
																	)
																}
															),
															new Block(
																"Leader", new int[] {487,24,488,16},
																new Statement[] {
																}
															)
														)
													)
												)
											)
										}
									),
									new Block(
										"Leader", new int[] {489,19,490,11},
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
			"Leader", new int[] {492,10,492,22},
			new GoalEvent('+',
				new Goal(
					new Predicate("check7", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Leader", new int[] {492,21,492,23},
				new Statement[] {
				}
			)
		));
		addRule(new Rule(
			"Leader", new int[] {495,10,495,19},
			new GoalEvent('+',
				new Goal(
					new Predicate("scan", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Leader", new int[] {495,18,503,6},
				new Statement[] {
					new Subgoal(
						"Leader", new int[] {496,10,503,6},
						new Goal(
							new Predicate("check1", new Term[] {})
						)
					),
					new Subgoal(
						"Leader", new int[] {497,10,503,6},
						new Goal(
							new Predicate("check2", new Term[] {})
						)
					),
					new Subgoal(
						"Leader", new int[] {498,10,503,6},
						new Goal(
							new Predicate("check3", new Term[] {})
						)
					),
					new Subgoal(
						"Leader", new int[] {499,10,503,6},
						new Goal(
							new Predicate("check4", new Term[] {})
						)
					),
					new Subgoal(
						"Leader", new int[] {500,10,503,6},
						new Goal(
							new Predicate("check5", new Term[] {})
						)
					),
					new Subgoal(
						"Leader", new int[] {501,10,503,6},
						new Goal(
							new Predicate("check6", new Term[] {})
						)
					),
					new Subgoal(
						"Leader", new int[] {502,10,503,6},
						new Goal(
							new Predicate("check7", new Term[] {})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Leader", new int[] {507,10,507,49},
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
				"Leader", new int[] {507,48,512,6},
				new Statement[] {
					new Subgoal(
						"Leader", new int[] {509,10,512,6},
						new Goal(
							new Predicate("scan", new Term[] {})
						)
					),
					new ModuleCall("ei",
						"Leader", new int[] {510,10,510,28},
						new Predicate("move", new Term[] {
							Primitive.newPrimitive("forward")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("Leader","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Assignment(
						new Variable(Type.STRING, "action"),
						"Leader", new int[] {511,10,512,6},
						Primitive.newPrimitive("move")
					)
				}
			)
		));
		addRule(new Rule(
			"Leader", new int[] {513,10,513,62},
			new GoalEvent('+',
				new Goal(
					new Predicate("task", new Term[] {
						new Variable(Type.STRING, "action",false)
					})
				)
			),
			new AND(
				new Predicate("free", new Term[] {
					Primitive.newPrimitive("left")
				}),
				new Predicate("free", new Term[] {
					Primitive.newPrimitive("right")
				})
			),
			new Block(
				"Leader", new int[] {513,61,525,6},
				new Statement[] {
					new Subgoal(
						"Leader", new int[] {514,10,525,6},
						new Goal(
							new Predicate("scan", new Term[] {})
						)
					),
					new Declaration(
						new Variable(Type.INTEGER, "ran"),
						"Leader", new int[] {516,10,525,6},
						Operator.newOperator('+',
							Primitive.newPrimitive(0),
							new Brackets(
								Operator.newOperator('%',
									new ModuleTerm("math", Type.INTEGER,
										new Predicate("randomInt", new Term[] {}),
										new ModuleTermAdaptor() {
											public Object invoke(Intention intention, Predicate predicate) {
												return ((astra.lang.Math) intention.getModule("Leader","math")).randomInt(
												);
											}
											public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((astra.lang.Math) visitor.agent().getModule("Leader","math")).randomInt(
												);
											}
										}
									),
									Primitive.newPrimitive(2)
								)
							)
						)
					),
					new If(
						"Leader", new int[] {517,10,525,6},
						new Comparison("==",
							new Variable(Type.INTEGER, "ran"),
							Primitive.newPrimitive(0)
						),
						new Block(
							"Leader", new int[] {517,22,519,11},
							new Statement[] {
								new ModuleCall("ei",
									"Leader", new int[] {518,15,518,30},
									new Predicate("move", new Term[] {
										Primitive.newPrimitive("left")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return false;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.EIS) intention.getModule("Leader","ei")).auto_action(intention,evaluate(intention,predicate));
										}
									}
								)
							}
						),
						new Block(
							"Leader", new int[] {520,14,525,6},
							new Statement[] {
								new ModuleCall("ei",
									"Leader", new int[] {521,15,521,31},
									new Predicate("move", new Term[] {
										Primitive.newPrimitive("right")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return false;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.EIS) intention.getModule("Leader","ei")).auto_action(intention,evaluate(intention,predicate));
										}
									}
								)
							}
						)
					),
					new Assignment(
						new Variable(Type.STRING, "action"),
						"Leader", new int[] {524,10,525,6},
						Primitive.newPrimitive("move")
					)
				}
			)
		));
		addRule(new Rule(
			"Leader", new int[] {526,10,526,46},
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
				"Leader", new int[] {526,45,530,6},
				new Statement[] {
					new Subgoal(
						"Leader", new int[] {527,10,530,6},
						new Goal(
							new Predicate("scan", new Term[] {})
						)
					),
					new ModuleCall("ei",
						"Leader", new int[] {528,10,528,25},
						new Predicate("move", new Term[] {
							Primitive.newPrimitive("left")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("Leader","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Assignment(
						new Variable(Type.STRING, "action"),
						"Leader", new int[] {529,10,530,6},
						Primitive.newPrimitive("move")
					)
				}
			)
		));
		addRule(new Rule(
			"Leader", new int[] {531,10,531,47},
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
				"Leader", new int[] {531,46,535,6},
				new Statement[] {
					new Subgoal(
						"Leader", new int[] {532,10,535,6},
						new Goal(
							new Predicate("scan", new Term[] {})
						)
					),
					new ModuleCall("ei",
						"Leader", new int[] {533,10,533,26},
						new Predicate("move", new Term[] {
							Primitive.newPrimitive("right")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("Leader","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Assignment(
						new Variable(Type.STRING, "action"),
						"Leader", new int[] {534,10,535,6},
						Primitive.newPrimitive("move")
					)
				}
			)
		));
		addRule(new Rule(
			"Leader", new int[] {537,10,537,32},
			new GoalEvent('+',
				new Goal(
					new Predicate("task", new Term[] {
						new Variable(Type.STRING, "action",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Leader", new int[] {537,31,541,6},
				new Statement[] {
					new Subgoal(
						"Leader", new int[] {538,10,541,6},
						new Goal(
							new Predicate("scan", new Term[] {})
						)
					),
					new ModuleCall("ei",
						"Leader", new int[] {539,10,539,27},
						new Predicate("move", new Term[] {
							Primitive.newPrimitive("left"),
							Primitive.newPrimitive(0)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("Leader","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Assignment(
						new Variable(Type.STRING, "action"),
						"Leader", new int[] {540,10,541,6},
						Primitive.newPrimitive("move")
					)
				}
			)
		));
		addRule(new Rule(
			"Leader", new int[] {552,10,552,35},
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
				"Leader", new int[] {552,34,557,5},
				new Statement[] {
					new ModuleCall("ei",
						"Leader", new int[] {553,10,553,23},
						new Predicate("join", new Term[] {
							Primitive.newPrimitive("hw")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("Leader","ei")).join(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("ei",
						"Leader", new int[] {554,10,554,25},
						new Predicate("link", new Term[] {
							new Variable(Type.STRING, "vacbot")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("Leader","ei")).link(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Declaration(
						new Variable(Type.INTEGER, "ran"),
						"Leader", new int[] {555,10,557,5},
						Operator.newOperator('+',
							Primitive.newPrimitive(0),
							new Brackets(
								Operator.newOperator('%',
									new ModuleTerm("math", Type.INTEGER,
										new Predicate("randomInt", new Term[] {}),
										new ModuleTermAdaptor() {
											public Object invoke(Intention intention, Predicate predicate) {
												return ((astra.lang.Math) intention.getModule("Leader","math")).randomInt(
												);
											}
											public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((astra.lang.Math) visitor.agent().getModule("Leader","math")).randomInt(
												);
											}
										}
									),
									Primitive.newPrimitive(2)
								)
							)
						)
					),
					new ModuleCall("C",
						"Leader", new int[] {556,10,556,39},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("Leader activated")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Leader","C")).println(
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
				((astra.lang.EIS) agent.getModule("Leader","ei")).sense();
			}
		});

		agent.initialize(
			new Predicate("counter", new Term[] {
				Primitive.newPrimitive(0)
			})
		);
		agent.initialize(
			new Predicate("dustlist", new Term[] {
				new ListTerm(new Term[] {

				})
			})
		);
		agent.initialize(
			new Predicate("donelist", new Term[] {
				new ListTerm(new Term[] {

				})
			})
		);
		agent.initialize(
			new Predicate("todolist", new Term[] {
				new ListTerm(new Term[] {

				})
			})
		);
	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("ei",astra.lang.EIS.class,agent);
		fragment.addModule("C",astra.lang.Console.class,agent);
		fragment.addModule("R",Routing.class,agent);
		fragment.addModule("math",astra.lang.Math.class,agent);
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
			astra.core.Agent agent = new Leader().newInstance(name);
			agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};
	}
}
