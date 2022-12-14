/**
 * generated by Xtext 2.27.0
 */
package org.xtext.example.mydsl.myDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Power State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.PowerState#getPowerVariable <em>Power Variable</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getPowerState()
 * @model
 * @generated
 */
public interface PowerState extends Situation
{
  /**
   * Returns the value of the '<em><b>Power Variable</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Power Variable</em>' reference.
   * @see #setPowerVariable(PowerWrapper)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getPowerState_PowerVariable()
   * @model
   * @generated
   */
  PowerWrapper getPowerVariable();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.PowerState#getPowerVariable <em>Power Variable</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Power Variable</em>' reference.
   * @see #getPowerVariable()
   * @generated
   */
  void setPowerVariable(PowerWrapper value);

} // PowerState
