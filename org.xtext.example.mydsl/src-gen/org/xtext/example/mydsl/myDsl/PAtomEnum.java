/**
 * generated by Xtext 2.27.0
 */
package org.xtext.example.mydsl.myDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PAtom Enum</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.PAtomEnum#getEnumeration <em>Enumeration</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.PAtomEnum#getEnumItem <em>Enum Item</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getPAtomEnum()
 * @model
 * @generated
 */
public interface PAtomEnum extends Proposition
{
  /**
   * Returns the value of the '<em><b>Enumeration</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enumeration</em>' attribute.
   * @see #setEnumeration(String)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getPAtomEnum_Enumeration()
   * @model
   * @generated
   */
  String getEnumeration();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.PAtomEnum#getEnumeration <em>Enumeration</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Enumeration</em>' attribute.
   * @see #getEnumeration()
   * @generated
   */
  void setEnumeration(String value);

  /**
   * Returns the value of the '<em><b>Enum Item</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enum Item</em>' attribute.
   * @see #setEnumItem(String)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getPAtomEnum_EnumItem()
   * @model
   * @generated
   */
  String getEnumItem();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.PAtomEnum#getEnumItem <em>Enum Item</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Enum Item</em>' attribute.
   * @see #getEnumItem()
   * @generated
   */
  void setEnumItem(String value);

} // PAtomEnum
