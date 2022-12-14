/**
 * generated by Xtext 2.27.0
 */
package org.xtext.example.mydsl.myDsl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.xtext.example.mydsl.myDsl.Interval;
import org.xtext.example.mydsl.myDsl.IntervalExpression;
import org.xtext.example.mydsl.myDsl.MyDslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interval</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.IntervalImpl#getIntervalExpression <em>Interval Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntervalImpl extends MinimalEObjectImpl.Container implements Interval
{
  /**
   * The cached value of the '{@link #getIntervalExpression() <em>Interval Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIntervalExpression()
   * @generated
   * @ordered
   */
  protected IntervalExpression intervalExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IntervalImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return MyDslPackage.Literals.INTERVAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public IntervalExpression getIntervalExpression()
  {
    return intervalExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIntervalExpression(IntervalExpression newIntervalExpression, NotificationChain msgs)
  {
    IntervalExpression oldIntervalExpression = intervalExpression;
    intervalExpression = newIntervalExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MyDslPackage.INTERVAL__INTERVAL_EXPRESSION, oldIntervalExpression, newIntervalExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setIntervalExpression(IntervalExpression newIntervalExpression)
  {
    if (newIntervalExpression != intervalExpression)
    {
      NotificationChain msgs = null;
      if (intervalExpression != null)
        msgs = ((InternalEObject)intervalExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.INTERVAL__INTERVAL_EXPRESSION, null, msgs);
      if (newIntervalExpression != null)
        msgs = ((InternalEObject)newIntervalExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.INTERVAL__INTERVAL_EXPRESSION, null, msgs);
      msgs = basicSetIntervalExpression(newIntervalExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.INTERVAL__INTERVAL_EXPRESSION, newIntervalExpression, newIntervalExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case MyDslPackage.INTERVAL__INTERVAL_EXPRESSION:
        return basicSetIntervalExpression(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case MyDslPackage.INTERVAL__INTERVAL_EXPRESSION:
        return getIntervalExpression();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MyDslPackage.INTERVAL__INTERVAL_EXPRESSION:
        setIntervalExpression((IntervalExpression)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case MyDslPackage.INTERVAL__INTERVAL_EXPRESSION:
        setIntervalExpression((IntervalExpression)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case MyDslPackage.INTERVAL__INTERVAL_EXPRESSION:
        return intervalExpression != null;
    }
    return super.eIsSet(featureID);
  }

} //IntervalImpl
