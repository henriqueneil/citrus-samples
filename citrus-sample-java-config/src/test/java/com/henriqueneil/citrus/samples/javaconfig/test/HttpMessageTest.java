package com.henriqueneil.citrus.samples.javaconfig.test;

import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.dsl.testng.TestNGCitrusTestDesigner;
import com.henriqueneil.citrus.samples.javaconfig.config.Config;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.consol.citrus.message.MessageType.JSON;
import static com.consol.citrus.util.FileUtils.readToString;
import static org.springframework.http.HttpStatus.OK;

/**
 * @author Henrique Neil
 */
@ContextConfiguration(classes = {Config.class})
public class HttpMessageTest extends TestNGCitrusTestDesigner {
    
    private Resource request;
    private Resource response;
    
    @BeforeMethod
    public void doBefore() {
        request = new ClassPathResource("/messages/requests/simple-request.json");
        response = new ClassPathResource("/messages/responses/simple-response.json");
    }
    
    @Test
    @CitrusTest
    public void givenBean_whenTestingHttp_shouldValidateJson() throws Exception {
        
        http().client("httpClient")
                .send().post()
                .messageType(JSON)
                .payload(readToString(request));
        
        http().server("httpServer")
                .receive().post()
                .messageType(JSON)
                .jsonPath("$.Request_1", "Value 1")
                .jsonPath("$.Request_2", "Value 2")
                .jsonPath("$.Request_3", "Value 3")
                .jsonPath("$.Request_4", "Oops!")
                .timeout(5000);
        
        http().server("httpServer")
                .respond(OK)
                .payload(readToString(response));
        
        http().client("httpClient")
                .receive().response(OK)
                .jsonPath("$.Response_1", "Yay!")
                .jsonPath("$.Response_2", "Woohoo!")
                .jsonPath("$.Response_3", "Weeee!")
                .jsonPath("$.Response_4", "Oops!")
                .timeout(5000);
    }
}
