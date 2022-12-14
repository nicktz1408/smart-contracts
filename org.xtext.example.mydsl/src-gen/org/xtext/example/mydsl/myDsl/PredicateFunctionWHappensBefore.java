/**
 * generated by Xtext 2.27.0
 */
package org.xtext.example.mydsl.myDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Predicate Function WHappens Before</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.PredicateFunctionWHappensBefore#getEvent <em>Event</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.PredicateFunctionWHappensBefore#getPoint <em>Point</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getPredicateFunctionWHappensBefore()
 * @model
 * @generated
 */
public interface PredicateFunctionWHappensBefore extends PredicateFunction
{
  /**
   * Returns the value of the '<em><b>Event</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Event</em>' containment reference.
   * @see #setEvent(Event)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getPredicateFunctionWHappensBefore_Event()
   * @model containment="true"
   * @generated
   */
  Event getEvent();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.PredicateFunctionWHappensBefore#getEvent <em>Event</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Event</em>' containment reference.
   * @see #getEvent()
   * @generated
   */
  void setEvent(Event value);

  /**
   * Returns the value of the '<em><b>Point</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Point</em>' containment reference.
   * @see #setPoint(Point)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getPredicateFunctionWHappensBefore_Point()
   * @model containment="true"
   * @generated
   */
  Point getPoint();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.PredicateFunctionWHappensBefore#getPoint <em>Point</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Point</em>' containment reference.
   * @see #getPoint()
   * @generated
   */
  void setPoint(Point value);

} // PredicateFunctionWHappensBefore
