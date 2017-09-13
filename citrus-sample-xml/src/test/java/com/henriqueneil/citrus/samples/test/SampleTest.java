package com.henriqueneil.citrus.samples.test;

import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.dsl.testng.TestNGCitrusTestDesigner;
import com.consol.citrus.testng.CitrusParameters;
import com.henriqueneil.citrus.samples.bean.TestBean;
import com.henriqueneil.citrus.samples.dataprovider.TestDataProvider;
import org.testng.annotations.Test;

import static org.springframework.http.HttpStatus.OK;

/**
 * @author Henrique Neil
 */
public class SampleTest extends TestNGCitrusTestDesigner {
    
    @Test(suiteName = "Citrus Samples",
            groups = {"Citrus Group", "Samples", "XML Tests"},
            dataProvider = "Test Data Provider",
            dataProviderClass = TestDataProvider.class)
    @CitrusTest
    @CitrusParameters({"bean"})
    public void givenBean_thenExecute_shouldProcess(TestBean bean) throws Exception {
        
        name(bean.getTestName());
        description(bean.getTestDescription());
        
        http().client("httpClient")
                .send().post().payload("Dummy payload request");
        
        http().server("httpServer")
                .receive().post().payload("Dummy payload request");
        
        http().server("httpServer")
                .respond(OK).contentType("Dummy payload response");
        
        http().client("httpClient")
                .receive().response(OK).contentType("Dummy payload response");
    }
}
