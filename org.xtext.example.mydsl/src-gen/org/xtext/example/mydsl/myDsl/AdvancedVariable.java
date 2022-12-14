/**
 * generated by Xtext 2.27.0
 */
package org.xtext.example.mydsl.myDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Advanced Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.AdvancedVariable#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getAdvancedVariable()
 * @model
 * @generated
 */
public interface AdvancedVariable extends Variable
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(BaseEntity)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getAdvancedVariable_Type()
   * @model
   * @generated
   */
  BaseEntity getType();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.AdvancedVariable#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(BaseEntity value);

} // AdvancedVariable
