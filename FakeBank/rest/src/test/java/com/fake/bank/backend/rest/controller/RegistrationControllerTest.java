package com.fake.bank.backend.rest.controller;

import com.fake.bank.backend.rest.model.user.RegistrationDTO;
import com.fake.bank.backend.rest.service.RegistrationRestService;
import com.fake.bank.backend.rest.utility.BaseUnitTest;
import org.junit.jupiter.api.Disabled;
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

@WebMvcTest
@ContextConfiguration(classes = RegistrationController.class)
class RegistrationControllerTest extends BaseUnitTest {

    @MockBean
    private RegistrationRestService registrationService;

    @Test
    public void shouldReturnCreatedStatus() throws Exception {
        //given
        doNothing().when(registrationService).registration(any());
        MockHttpServletRequestBuilder mockHttp = post("/registration")
                .content(jsonToString(getRegistrationDTO()))
                .contentType(MediaType.APPLICATION_JSON);
        //when-then
        callApi(mockHttp, HttpStatus.CREATED);
    }

    @Test
    public void shouldReturnBadRequestWhenInvalidPersonalNumber() throws Exception {
        //given
        RegistrationDTO invalidPersonalNumber = getRegistrationDTO();
        invalidPersonalNumber.setPersonalNumber("1234567890");
        MockHttpServletRequestBuilder mockHttp = post("/registration")
                .content(jsonToString(invalidPersonalNumber))
                .contentType(MediaType.APPLICATION_JSON);
        //when-then
        callApi(mockHttp, HttpStatus.BAD_REQUEST);
    }

    public static RegistrationDTO getRegistrationDTO() {
        return RegistrationDTO.builder()
                .firstName("jACEK")
                .lastName("Golota")
                .personalNumber("99061877218")
                .amount(BigDecimal.valueOf(522.22))
                .build();
    }
}