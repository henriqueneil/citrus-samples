package com.henriqueneil.citrus.samples.dataprovider;

import com.henriqueneil.citrus.samples.bean.TestBean;
import org.testng.annotations.DataProvider;

/**
 * @author Henrique Neil
 */
public class TestDataProvider {
    
    @DataProvider(name = "Test Data Provider")
    public static Object[][] dataProvider() {
        return new Object[][] {
            new Object[] { new TestBean(1L, "Test Name 1", "Test Description 1")},
            new Object[] { new TestBean(2L, "Test Name 2", "Test Description 2")},
            new Object[] { new TestBean(3L, "Test Name 3", "Test Description 3")},
            new Object[] { new TestBean(4L, "Test Name 4", "Test Description 4")},
            new Object[] { new TestBean(5L, "Test Name 5", "Test Description 5")},
        };
    }
}
