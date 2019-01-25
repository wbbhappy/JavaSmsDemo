/**
 * Web_ServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */
package com.jsmsxx.demo.ws;

public class Web_ServiceServiceLocator extends org.apache.axis.client.Service implements com.jsmsxx.demo.ws.Web_ServiceService {

    public Web_ServiceServiceLocator() {
    }
    public Web_ServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Web_ServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }
    // Use to get a proxy class for Web_ServicePort
    private java.lang.String Web_ServicePort_address = "http://202.102.89.226:8030/service/webService/Web_Service";

    public java.lang.String getWeb_ServicePortAddress() {
        return Web_ServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String Web_ServicePortWSDDServiceName = "Web_ServicePort";

    public java.lang.String getWeb_ServicePortWSDDServiceName() {
        return Web_ServicePortWSDDServiceName;
    }

    public void setWeb_ServicePortWSDDServiceName(java.lang.String name) {
        Web_ServicePortWSDDServiceName = name;
    }

    public com.jsmsxx.demo.ws.ISMWebService getWeb_ServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Web_ServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWeb_ServicePort(endpoint);
    }

    public com.jsmsxx.demo.ws.ISMWebService getWeb_ServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.jsmsxx.demo.ws.Web_ServiceServiceSoapBindingStub _stub = new com.jsmsxx.demo.ws.Web_ServiceServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getWeb_ServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWeb_ServicePortEndpointAddress(java.lang.String address) {
        Web_ServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.jsmsxx.demo.ws.ISMWebService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.jsmsxx.demo.ws.Web_ServiceServiceSoapBindingStub _stub = new com.jsmsxx.demo.ws.Web_ServiceServiceSoapBindingStub(new java.net.URL(Web_ServicePort_address), this);
                _stub.setPortName(getWeb_ServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Web_ServicePort".equals(inputPortName)) {
            return getWeb_ServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://impl.web.service.com/", "Web_ServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://impl.web.service.com/", "Web_ServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        if ("Web_ServicePort".equals(portName)) {
            setWeb_ServicePortEndpointAddress(address);
        }
        else { // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }
}
