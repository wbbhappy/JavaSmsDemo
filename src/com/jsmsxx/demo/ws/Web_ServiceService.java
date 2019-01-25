/**
 * Web_ServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */
package com.jsmsxx.demo.ws;

public interface Web_ServiceService extends javax.xml.rpc.Service {
    public java.lang.String getWeb_ServicePortAddress();
    public com.jsmsxx.demo.ws.ISMWebService getWeb_ServicePort() throws javax.xml.rpc.ServiceException;
    public com.jsmsxx.demo.ws.ISMWebService getWeb_ServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
