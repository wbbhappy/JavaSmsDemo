/**
 * ISMWebService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */
package com.jsmsxx.demo.ws;

public interface ISMWebService extends java.rmi.Remote {
    public java.lang.String getAmount(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String queryMo(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String queryReport(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String sendMsg(java.lang.String arg0) throws java.rmi.RemoteException;
    public boolean toSyncInfos(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
}
