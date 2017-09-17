package integration;

import integration.config.ApplicationConfigTest;
import integration.helper.TestHelper;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.json.simple.JSONObject;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static javax.servlet.http.HttpServletResponse.SC_OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfigTest.class)
@WebAppConfiguration
public class AddressControllerIT {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;
    @Autowired
    private TestHelper testHelper;

    @Before
    public final void initialize() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void createAddress() throws Exception {
        JSONObject jsonObject = testHelper.getJsonObjectFromFile("json/address.json");

//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("country", "UA");
//        jsonObject.put("city", "Odessa");

        given().
                contentType(APPLICATION_JSON_VALUE).
                body(jsonObject.toString()).
        when().
                post("/addresses").
        then().
                statusCode(SC_OK).
                body("country", Matchers.is("UA"));
    }
}
