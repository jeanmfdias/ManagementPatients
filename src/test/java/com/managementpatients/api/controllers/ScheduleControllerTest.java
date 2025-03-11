package com.managementpatients.api.controllers;

import com.managementpatients.api.domains.doctor.Specialty;
import com.managementpatients.api.domains.schedule.Schedule;
import com.managementpatients.api.domains.schedule.dto.CreateDataScheduleDto;
import com.managementpatients.api.domains.schedule.dto.ScheduleDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class ScheduleControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<CreateDataScheduleDto> createDataScheduleDtoJson;

    @Autowired
    private JacksonTester<ScheduleDto> scheduleDtoJson;

    @Test
    @DisplayName("Should 400 status code when information wrong")
    @WithMockUser
    void testShouldCreateResultError400() throws Exception {
        var response = mvc.perform(post("/schedule"))
                .andReturn()
                .getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Should 200 status code when information right")
    @WithMockUser
    void testShouldCreateResultSuccess200() throws Exception {
        var date = LocalDateTime.now().plusHours(1);

        var response = mvc.perform(
                    post("/schedule")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(createDataScheduleDtoJson.write(
                                    new CreateDataScheduleDto(21L, 51L, date, Specialty.CARDIOLOGY)
                            ).getJson())
                )
                .andReturn()
                .getResponse();

//        var expectJson = scheduleDtoJson.write(
//                new ScheduleDto(null, 21L, 51L, date)
//        ).getJson();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//        assertThat(response.getContentAsString()).isEqualTo(expectJson);
    }

}