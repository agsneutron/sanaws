/**
 * SAFIServiciosSoap11Skeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package safisrv.ws.schemas;

public class SAFIServiciosSoap11Skeleton implements safisrv.ws.schemas.SAFIServicios, org.apache.axis.wsdl.Skeleton {
    private safisrv.ws.schemas.SAFIServicios impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://safisrv/ws/schemas", "PagoCreditoRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://safisrv/ws/schemas", ">PagoCreditoRequest"), safisrv.ws.schemas.PagoCreditoRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("pagoCredito", _params, new javax.xml.namespace.QName("http://safisrv/ws/schemas", "PagoCreditoResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://safisrv/ws/schemas", ">PagoCreditoResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "PagoCredito"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("pagoCredito") == null) {
            _myOperations.put("pagoCredito", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("pagoCredito")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://safisrv/ws/schemas", "altaSolicitudCreditoRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://safisrv/ws/schemas", ">altaSolicitudCreditoRequest"), safisrv.ws.schemas.AltaSolicitudCreditoRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("altaSolicitudCredito", _params, new javax.xml.namespace.QName("http://safisrv/ws/schemas", "altaSolicitudCreditoResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://safisrv/ws/schemas", ">altaSolicitudCreditoResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "altaSolicitudCredito"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("altaSolicitudCredito") == null) {
            _myOperations.put("altaSolicitudCredito", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("altaSolicitudCredito")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://safisrv/ws/schemas", "SolAltaClienteRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://safisrv/ws/schemas", ">SolAltaClienteRequest"), safisrv.ws.schemas.SolAltaClienteRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("solAltaCliente", _params, new javax.xml.namespace.QName("http://safisrv/ws/schemas", "SolAltaClienteResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://safisrv/ws/schemas", ">SolAltaClienteResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "SolAltaCliente"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("solAltaCliente") == null) {
            _myOperations.put("solAltaCliente", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("solAltaCliente")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://safisrv/ws/schemas", "AltaGrupoWSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://safisrv/ws/schemas", ">AltaGrupoWSRequest"), safisrv.ws.schemas.AltaGrupoWSRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("altaGrupoWS", _params, new javax.xml.namespace.QName("http://safisrv/ws/schemas", "AltaGrupoWSResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://safisrv/ws/schemas", ">AltaGrupoWSResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "AltaGrupoWS"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("altaGrupoWS") == null) {
            _myOperations.put("altaGrupoWS", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("altaGrupoWS")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://safisrv/ws/schemas", "ConsultaSaldoCreditoRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://safisrv/ws/schemas", ">ConsultaSaldoCreditoRequest"), safisrv.ws.schemas.ConsultaSaldoCreditoRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("consultaSaldoCredito", _params, new javax.xml.namespace.QName("http://safisrv/ws/schemas", "ConsultaSaldoCreditoResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://safisrv/ws/schemas", ">ConsultaSaldoCreditoResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "ConsultaSaldoCredito"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("consultaSaldoCredito") == null) {
            _myOperations.put("consultaSaldoCredito", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("consultaSaldoCredito")).add(_oper);
    }

    public SAFIServiciosSoap11Skeleton() {
        this.impl = new safisrv.ws.schemas.SAFIServiciosSoap11Impl();
    }

    public SAFIServiciosSoap11Skeleton(safisrv.ws.schemas.SAFIServicios impl) {
        this.impl = impl;
    }
    public safisrv.ws.schemas.PagoCreditoResponse pagoCredito(safisrv.ws.schemas.PagoCreditoRequest pagoCreditoRequest) throws java.rmi.RemoteException
    {
        safisrv.ws.schemas.PagoCreditoResponse ret = impl.pagoCredito(pagoCreditoRequest);
        return ret;
    }

    public safisrv.ws.schemas.AltaSolicitudCreditoResponse altaSolicitudCredito(safisrv.ws.schemas.AltaSolicitudCreditoRequest altaSolicitudCreditoRequest) throws java.rmi.RemoteException
    {
        safisrv.ws.schemas.AltaSolicitudCreditoResponse ret = impl.altaSolicitudCredito(altaSolicitudCreditoRequest);
        return ret;
    }

    public safisrv.ws.schemas.SolAltaClienteResponse solAltaCliente(safisrv.ws.schemas.SolAltaClienteRequest solAltaClienteRequest) throws java.rmi.RemoteException
    {
        safisrv.ws.schemas.SolAltaClienteResponse ret = impl.solAltaCliente(solAltaClienteRequest);
        return ret;
    }

    public safisrv.ws.schemas.AltaGrupoWSResponse altaGrupoWS(safisrv.ws.schemas.AltaGrupoWSRequest altaGrupoWSRequest) throws java.rmi.RemoteException
    {
        safisrv.ws.schemas.AltaGrupoWSResponse ret = impl.altaGrupoWS(altaGrupoWSRequest);
        return ret;
    }

    public safisrv.ws.schemas.ConsultaSaldoCreditoResponse consultaSaldoCredito(safisrv.ws.schemas.ConsultaSaldoCreditoRequest consultaSaldoCreditoRequest) throws java.rmi.RemoteException
    {
        safisrv.ws.schemas.ConsultaSaldoCreditoResponse ret = impl.consultaSaldoCredito(consultaSaldoCreditoRequest);
        return ret;
    }

}
