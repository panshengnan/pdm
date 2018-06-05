package com.cgwx.data.entity;

public class UrmPriorityInfo {
    private Integer priority;

    private String priorityDescription;

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getPriorityDescription() {
        return priorityDescription;
    }

    public void setPriorityDescription(String priorityDescription) {
        this.priorityDescription = priorityDescription == null ? null : priorityDescription.trim();
    }
}