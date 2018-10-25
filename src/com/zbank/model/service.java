package com.zbank.model;

public class service {
    private String serviceId;

    private String serviceEnname;

    private String serviceCnname;

    private String serviceSystem;

    private String serviceDesc;

    private String serviceStatus;

    private String remake;

    private String serviceUpdatetime;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId == null ? null : serviceId.trim();
    }

    public String getServiceEnname() {
        return serviceEnname;
    }

    public void setServiceEnname(String serviceEnname) {
        this.serviceEnname = serviceEnname == null ? null : serviceEnname.trim();
    }

    public String getServiceCnname() {
        return serviceCnname;
    }

    public void setServiceCnname(String serviceCnname) {
        this.serviceCnname = serviceCnname == null ? null : serviceCnname.trim();
    }

    public String getServiceSystem() {
        return serviceSystem;
    }

    public void setServiceSystem(String serviceSystem) {
        this.serviceSystem = serviceSystem == null ? null : serviceSystem.trim();
    }

    public String getServiceDesc() {
        return serviceDesc;
    }

    public void setServiceDesc(String serviceDesc) {
        this.serviceDesc = serviceDesc == null ? null : serviceDesc.trim();
    }

    public String getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus == null ? null : serviceStatus.trim();
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake == null ? null : remake.trim();
    }

    public String getServiceUpdatetime() {
        return serviceUpdatetime;
    }

    public void setServiceUpdatetime(String serviceUpdatetime) {
        this.serviceUpdatetime = serviceUpdatetime == null ? null : serviceUpdatetime.trim();
    }
}