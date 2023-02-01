package com.fake.bank.backend.rest.controller;

import com.fake.bank.backend.common.type.CurrencyType;
import com.fake.bank.backend.rest.controller.version.RestApiVersion;
import com.fake.bank.backend.rest.model.account.ExchangeDTO;
import com.fake.bank.backend.rest.service.AccountRestService;
import com.fake.bank.backend.rest.utility.BaseUnitTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest()
@ContextConfiguration(classes = AccountController.class)
class AccountControllerTest extends BaseUnitTest {
    @MockBean
    private AccountRestService accountService;

    @Test
    public void shouldReturnNoContentStatus() throws Exception {
        //given
        doNothing().when(accountService).exchange(any(), any());
        MockHttpServletRequestBuilder mockHttp = post(RestApiVersion.version + "/account/exchange/12345678910")
                .content(jsonToString(getExchangeDTO()))
                .contentType(MediaType.APPLICATION_JSON);
        //when-then
        callApi(mockHttp, HttpStatus.NO_CONTENT);
    }

    public static ExchangeDTO getExchangeDTO() {
        return ExchangeDTO.builder()
                .amount(BigDecimal.valueOf(123))
                .fromCurrency(CurrencyType.PLN)
                .toCurrency(CurrencyType.USD)
                .build();
    }
}