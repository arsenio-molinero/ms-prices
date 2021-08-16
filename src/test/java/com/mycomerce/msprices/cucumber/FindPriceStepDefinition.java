package com.mycomerce.msprices.cucumber;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class FindPriceStepDefinition {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private ResultActions result;

    @When("the client call price with {string}, {string}, {string}")
    public void the_client_call_price_with_brand_product_datetime(String brand, String product, String datetime) throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        result = mockMvc.perform(
                get(String.format("/price?brand=%s&product=%s&date=%s", brand, product,datetime ))
                        .contentType(MediaType.APPLICATION_JSON)
        );
    }

    @Then("will return the price {double} from the list {int}")
    public void will_return_the_price_price_from_the_list_price_list(double price, int priceList) throws Exception {
        result.andExpect(status().isOk());
        result.andExpect(jsonPath("$.priceList").value(priceList));
        result.andExpect(jsonPath("$.price").value(price));
    }
}
