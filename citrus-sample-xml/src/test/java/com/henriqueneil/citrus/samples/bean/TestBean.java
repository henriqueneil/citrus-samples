package com.henriqueneil.citrus.samples.bean;

import java.io.Serializable;

/**
 * @author Henrique Neil
 */
public class TestBean implements Serializable {
    
    private Long id;
    private String testName;
    private String testDescription;
    
    public TestBean(Long id, String testName, String testDescription) {
        this.id = id;
        this.testName = testName;
        this.testDescription = testDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestDescription() {
        return testDescription;
    }

    public void setTestDescription(String testDescription) {
        this.testDescription = testDescription;
    }
}
