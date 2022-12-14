/**
 * generated by Xtext 2.27.0
 */
package org.xtext.example.mydsl.myDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.FunctionCall#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.FunctionCall#getArg1 <em>Arg1</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getFunctionCall()
 * @model
 * @generated
 */
public interface FunctionCall extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getFunctionCall_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.FunctionCall#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Arg1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Arg1</em>' containment reference.
   * @see #setArg1(Expression)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getFunctionCall_Arg1()
   * @model containment="true"
   * @generated
   */
  Expression getArg1();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.FunctionCall#getArg1 <em>Arg1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Arg1</em>' containment reference.
   * @see #getArg1()
   * @generated
   */
  void setArg1(Expression value);

} // FunctionCall
