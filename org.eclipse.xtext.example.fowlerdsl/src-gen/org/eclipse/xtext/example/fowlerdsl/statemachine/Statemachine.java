/**
 * Copyright (c) 2011, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.fowlerdsl.statemachine;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Statemachine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.example.fowlerdsl.statemachine.Statemachine#getEvents <em>Events</em>}</li>
 *   <li>{@link org.eclipse.xtext.example.fowlerdsl.statemachine.Statemachine#getResetEvents <em>Reset Events</em>}</li>
 *   <li>{@link org.eclipse.xtext.example.fowlerdsl.statemachine.Statemachine#getCommands <em>Commands</em>}</li>
 *   <li>{@link org.eclipse.xtext.example.fowlerdsl.statemachine.Statemachine#getStates <em>States</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.example.fowlerdsl.statemachine.StatemachinePackage#getStatemachine()
 * @model
 * @generated
 */
public interface Statemachine extends EObject
{
  /**
   * Returns the value of the '<em><b>Events</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.example.fowlerdsl.statemachine.Event}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Events</em>' containment reference list.
   * @see org.eclipse.xtext.example.fowlerdsl.statemachine.StatemachinePackage#getStatemachine_Events()
   * @model containment="true"
   * @generated
   */
  EList<Event> getEvents();

  /**
   * Returns the value of the '<em><b>Reset Events</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.xtext.example.fowlerdsl.statemachine.Event}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reset Events</em>' reference list.
   * @see org.eclipse.xtext.example.fowlerdsl.statemachine.StatemachinePackage#getStatemachine_ResetEvents()
   * @model
   * @generated
   */
  EList<Event> getResetEvents();

  /**
   * Returns the value of the '<em><b>Commands</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.example.fowlerdsl.statemachine.Command}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Commands</em>' containment reference list.
   * @see org.eclipse.xtext.example.fowlerdsl.statemachine.StatemachinePackage#getStatemachine_Commands()
   * @model containment="true"
   * @generated
   */
  EList<Command> getCommands();

  /**
   * Returns the value of the '<em><b>States</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.example.fowlerdsl.statemachine.State}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>States</em>' containment reference list.
   * @see org.eclipse.xtext.example.fowlerdsl.statemachine.StatemachinePackage#getStatemachine_States()
   * @model containment="true"
   * @generated
   */
  EList<State> getStates();

} // Statemachine
