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


public class Main extends ASTRAClass {
	public Main() {
		setParents(new Class[] {astra.lang.Agent.class});
		addRule(new Rule(
			"Main", new int[] {8,10,8,29},
			new GoalEvent('+',
				new Goal(
					new Predicate("main", new Term[] {
						new Variable(Type.LIST, "args",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Main", new int[] {8,28,25,6},
				new Statement[] {
					new ModuleCall("ei",
						"Main", new int[] {9,10,9,60},
						new Predicate("launch", new Term[] {
							Primitive.newPrimitive("hw"),
							Primitive.newPrimitive("dependency/vacuumworld-1.2.0.jar")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("Main","ei")).launch(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(java.lang.String) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					),
					new ModuleCall("ei",
						"Main", new int[] {10,10,10,49},
						new Predicate("init", new Term[] {
							new ListTerm(new Term[] {
								new Funct("generation", new Term[] {
									Primitive.newPrimitive("no")
								}),
								new Funct("level", new Term[] {
									Primitive.newPrimitive("5")
								})
							})
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("Main","ei")).init(
									(astra.term.ListTerm) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("ei",
						"Main", new int[] {11,9,11,19},
						new Predicate("start", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("Main","ei")).start(
								);
							}
						}
					),
					new Declaration(
						new Variable(Type.LIST, "entities"),
						"Main", new int[] {12,10,25,6},
						new ModuleTerm("ei", Type.LIST,
							new Predicate("freeEntities", new Term[] {}),
							new ModuleTermAdaptor() {
								public Object invoke(Intention intention, Predicate predicate) {
									return ((astra.lang.EIS) intention.getModule("Main","ei")).freeEntities(
									);
								}
								public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.EIS) visitor.agent().getModule("Main","ei")).freeEntities(
									);
								}
							}
						)
					),
					new Declaration(
						new Variable(Type.INTEGER, "count"),
						"Main", new int[] {13,10,25,6},
						Primitive.newPrimitive(1)
					),
					new ForAll(
						"Main", new int[] {14,10,14,42},
						new Variable(Type.STRING, "entity",false),
						new Variable(Type.LIST, "entities"),
						new Block(
							"Main", new int[] {14,43,25,6},
							new Statement[] {
								new If(
									"Main", new int[] {15,15,24,11},
									new Comparison("==",
										new Variable(Type.INTEGER, "count"),
										Primitive.newPrimitive(1)
									),
									new Block(
										"Main", new int[] {15,29,19,16},
										new Statement[] {
											new ModuleCall("sys",
												"Main", new int[] {16,20,16,53},
												new Predicate("createAgent", new Term[] {
													new Variable(Type.STRING, "entity"),
													Primitive.newPrimitive("Leader")
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.System) intention.getModule("Main","sys")).createAgent(
															(java.lang.String) intention.evaluate(predicate.getTerm(0)),
															(java.lang.String) intention.evaluate(predicate.getTerm(1))
														);
													}
												}
											),
											new ModuleCall("sys",
												"Main", new int[] {17,20,17,53},
												new Predicate("setMainGoal", new Term[] {
													new Variable(Type.STRING, "entity"),
													new ListTerm(new Term[] {
														new Variable(Type.STRING, "entity")
													})
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.System) intention.getModule("Main","sys")).setMainGoal(
															(java.lang.String) intention.evaluate(predicate.getTerm(0)),
															(astra.term.ListTerm) intention.evaluate(predicate.getTerm(1))
														);
													}
												}
											),
											new Assignment(
												new Variable(Type.INTEGER, "count"),
												"Main", new int[] {18,20,19,16},
												Operator.newOperator('+',
													new Variable(Type.INTEGER, "count"),
													Primitive.newPrimitive(1)
												)
											)
										}
									),
									new Block(
										"Main", new int[] {20,20,24,11},
										new Statement[] {
											new ModuleCall("sys",
												"Main", new int[] {21,20,21,55},
												new Predicate("createAgent", new Term[] {
													new Variable(Type.STRING, "entity"),
													Primitive.newPrimitive("Follower")
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.System) intention.getModule("Main","sys")).createAgent(
															(java.lang.String) intention.evaluate(predicate.getTerm(0)),
															(java.lang.String) intention.evaluate(predicate.getTerm(1))
														);
													}
												}
											),
											new ModuleCall("sys",
												"Main", new int[] {22,20,22,53},
												new Predicate("setMainGoal", new Term[] {
													new Variable(Type.STRING, "entity"),
													new ListTerm(new Term[] {
														new Variable(Type.STRING, "entity")
													})
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.System) intention.getModule("Main","sys")).setMainGoal(
															(java.lang.String) intention.evaluate(predicate.getTerm(0)),
															(astra.term.ListTerm) intention.evaluate(predicate.getTerm(1))
														);
													}
												}
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
	}

	public void initialize(astra.core.Agent agent) {
		agent.addSensorAdaptor(new SensorAdaptor() {
			public void sense(astra.core.Agent agent) {
				((astra.lang.EIS) agent.getModule("Main","ei")).sense();
			}
		});

	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("ei",astra.lang.EIS.class,agent);
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
			astra.core.Agent agent = new Main().newInstance(name);
			agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};
	}
}
