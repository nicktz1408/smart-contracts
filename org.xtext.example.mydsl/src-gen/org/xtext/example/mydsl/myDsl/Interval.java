/**
 * generated by Xtext 2.27.0
 */
package org.xtext.example.mydsl.myDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interval</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.Interval#getIntervalExpression <em>Interval Expression</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getInterval()
 * @model
 * @generated
 */
public interface Interval extends EObject
{
  /**
   * Returns the value of the '<em><b>Interval Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Interval Expression</em>' containment reference.
   * @see #setIntervalExpression(IntervalExpression)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getInterval_IntervalExpression()
   * @model containment="true"
   * @generated
   */
  IntervalExpression getIntervalExpression();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.Interval#getIntervalExpression <em>Interval Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Interval Expression</em>' containment reference.
   * @see #getIntervalExpression()
   * @generated
   */
  void setIntervalExpression(IntervalExpression value);

} // Interval