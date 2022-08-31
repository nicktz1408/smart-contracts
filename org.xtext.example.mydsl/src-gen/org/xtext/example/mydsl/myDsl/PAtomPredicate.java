/**
 * generated by Xtext 2.27.0
 */
package org.xtext.example.mydsl.myDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PAtom Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.PAtomPredicate#getPredicateFunction <em>Predicate Function</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getPAtomPredicate()
 * @model
 * @generated
 */
public interface PAtomPredicate extends Proposition
{
  /**
   * Returns the value of the '<em><b>Predicate Function</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Predicate Function</em>' containment reference.
   * @see #setPredicateFunction(PredicateFunction)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getPAtomPredicate_PredicateFunction()
   * @model containment="true"
   * @generated
   */
  PredicateFunction getPredicateFunction();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.PAtomPredicate#getPredicateFunction <em>Predicate Function</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Predicate Function</em>' containment reference.
   * @see #getPredicateFunction()
   * @generated
   */
  void setPredicateFunction(PredicateFunction value);

} // PAtomPredicate