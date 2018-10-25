package com.zbank.model;

public class opensystem {
    private String openModuleId;

    private String openEnvironmentId;

    private String openModuleName;

    private String openModuleUrl;

    private String openModuleServer;

    private String openModuleAcct;

    private String openModuleUpdatetime;

    public String getOpenModuleId() {
        return openModuleId;
    }

    public void setOpenModuleId(String openModuleId) {
        this.openModuleId = openModuleId == null ? null : openModuleId.trim();
    }

    public String getOpenEnvironmentId() {
        return openEnvironmentId;
    }

    public void setOpenEnvironmentId(String openEnvironmentId) {
        this.openEnvironmentId = openEnvironmentId == null ? null : openEnvironmentId.trim();
    }

    public String getOpenModuleName() {
        return openModuleName;
    }

    public void setOpenModuleName(String openModuleName) {
        this.openModuleName = openModuleName == null ? null : openModuleName.trim();
    }

    public String getOpenModuleUrl() {
        return openModuleUrl;
    }

    public void setOpenModuleUrl(String openModuleUrl) {
        this.openModuleUrl = openModuleUrl == null ? null : openModuleUrl.trim();
    }

    public String getOpenModuleServer() {
        return openModuleServer;
    }

    public void setOpenModuleServer(String openModuleServer) {
        this.openModuleServer = openModuleServer == null ? null : openModuleServer.trim();
    }

    public String getOpenModuleAcct() {
        return openModuleAcct;
    }

    public void setOpenModuleAcct(String openModuleAcct) {
        this.openModuleAcct = openModuleAcct == null ? null : openModuleAcct.trim();
    }

    public String getOpenModuleUpdatetime() {
        return openModuleUpdatetime;
    }

    public void setOpenModuleUpdatetime(String openModuleUpdatetime) {
        this.openModuleUpdatetime = openModuleUpdatetime == null ? null : openModuleUpdatetime.trim();
    }
}