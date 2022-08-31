/*******************************************************************************
 * Copyright (c) 2011, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.example.fowlerdsl.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.example.fowlerdsl.ide.contentassist.antlr.internal.InternalStatemachineParser;
import org.eclipse.xtext.example.fowlerdsl.services.StatemachineGrammarAccess;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class StatemachineParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(StatemachineGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, StatemachineGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getStatemachineAccess().getGroup(), "rule__Statemachine__Group__0");
			builder.put(grammarAccess.getStatemachineAccess().getGroup_1(), "rule__Statemachine__Group_1__0");
			builder.put(grammarAccess.getStatemachineAccess().getGroup_2(), "rule__Statemachine__Group_2__0");
			builder.put(grammarAccess.getStatemachineAccess().getGroup_3(), "rule__Statemachine__Group_3__0");
			builder.put(grammarAccess.getEventAccess().getGroup(), "rule__Event__Group__0");
			builder.put(grammarAccess.getCommandAccess().getGroup(), "rule__Command__Group__0");
			builder.put(grammarAccess.getStateAccess().getGroup(), "rule__State__Group__0");
			builder.put(grammarAccess.getStateAccess().getGroup_2(), "rule__State__Group_2__0");
			builder.put(grammarAccess.getTransitionAccess().getGroup(), "rule__Transition__Group__0");
			builder.put(grammarAccess.getStatemachineAccess().getEventsAssignment_1_1(), "rule__Statemachine__EventsAssignment_1_1");
			builder.put(grammarAccess.getStatemachineAccess().getResetEventsAssignment_2_1(), "rule__Statemachine__ResetEventsAssignment_2_1");
			builder.put(grammarAccess.getStatemachineAccess().getCommandsAssignment_3_1(), "rule__Statemachine__CommandsAssignment_3_1");
			builder.put(grammarAccess.getStatemachineAccess().getStatesAssignment_4(), "rule__Statemachine__StatesAssignment_4");
			builder.put(grammarAccess.getEventAccess().getNameAssignment_0(), "rule__Event__NameAssignment_0");
			builder.put(grammarAccess.getEventAccess().getCodeAssignment_1(), "rule__Event__CodeAssignment_1");
			builder.put(grammarAccess.getCommandAccess().getNameAssignment_0(), "rule__Command__NameAssignment_0");
			builder.put(grammarAccess.getCommandAccess().getCodeAssignment_1(), "rule__Command__CodeAssignment_1");
			builder.put(grammarAccess.getStateAccess().getNameAssignment_1(), "rule__State__NameAssignment_1");
			builder.put(grammarAccess.getStateAccess().getActionsAssignment_2_2(), "rule__State__ActionsAssignment_2_2");
			builder.put(grammarAccess.getStateAccess().getTransitionsAssignment_3(), "rule__State__TransitionsAssignment_3");
			builder.put(grammarAccess.getTransitionAccess().getEventAssignment_0(), "rule__Transition__EventAssignment_0");
			builder.put(grammarAccess.getTransitionAccess().getStateAssignment_2(), "rule__Transition__StateAssignment_2");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private StatemachineGrammarAccess grammarAccess;

	@Override
	protected InternalStatemachineParser createParser() {
		InternalStatemachineParser result = new InternalStatemachineParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public StatemachineGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(StatemachineGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
