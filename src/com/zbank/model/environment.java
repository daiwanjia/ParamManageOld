package com.zbank.model;

public class environment {
    private String environmentId;

    private String environmentName;

    private String environmentUrl;

    public String getEnvironmentId() {
        return environmentId;
    }

    public void setEnvironmentId(String environmentId) {
        this.environmentId = environmentId == null ? null : environmentId.trim();
    }

    public String getEnvironmentName() {
        return environmentName;
    }

    public void setEnvironmentName(String environmentName) {
        this.environmentName = environmentName == null ? null : environmentName.trim();
    }

    public String getEnvironmentUrl() {
        return environmentUrl;
    }

    public void setEnvironmentUrl(String environmentUrl) {
        this.environmentUrl = environmentUrl == null ? null : environmentUrl.trim();
    }
}