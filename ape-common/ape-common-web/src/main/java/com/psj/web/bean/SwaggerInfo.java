package com.psj.web.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author pengshj
 * @version 1.0
 * @date 2023/10/10-16:27
 * @description TODO
 */
@Component
@ConfigurationProperties(prefix = "swagger")
public class SwaggerInfo {
    private String basePackage;
    private String title;
    private String description;
    private String contactEmail;
    private String contactName;
    private String contactUrl;
    private String version;
    private String groupName;

    public String getBasePackage() {
        return basePackage;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactUrl() {
        return contactUrl;
    }

    public String getVersion() {
        return version;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setContactUrl(String contactUrl) {
        this.contactUrl = contactUrl;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
