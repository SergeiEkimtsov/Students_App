package com.ekimtsovss.students_app;

import com.ekimtsovss.students_app.controller.StudentsController;
import com.ekimtsovss.students_app.entity.Student;
import com.ekimtsovss.students_app.service.ServiceStudent;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(MockitoExtension.class)
public class StudentDAOUnitTests {
    @Mock
    ServiceStudent serviceStudent;
    @Mock
    Model model;
    @InjectMocks
    StudentsController studentsController;
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    public void handleGetAllStudents_ReturnValidRespond(){
        //given
        var list = List.of(new Student(1, "A","B","111-22-33"));
        doReturn(list).when(this.serviceStudent).getAllStudents();

        var respond = this.studentsController.showAllStudents(model);
        assertEquals(respond,"testView");
    }
//    @Test
//    public void handleShowAllStudents_ReturnValidRespond(){
//        //given
//        assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/getAll",String.class))
//                .containsSubsequence("testView");
//
//    }



}
