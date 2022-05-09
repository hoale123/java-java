package com.example.studentservice.controller;


import com.example.studentservice.Student;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentServiceController {

    private List<Student> studentList;

    public StudentServiceController(){
        studentList = new ArrayList<>();
        studentList.add(new Student("Andy", 20));
        studentList.add(new Student("Jose",8));
        studentList.add(new Student("Kevin", 21));
        studentList.add(new Student("Alonzo", 10));
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public List<Student> getStudent(){
    return studentList;
    }

//    @RequestMapping(value = "/students/{theIndexOfTheStudent}", method = RequestMethod.GET)
//    public Student getStudentByIndexInList(@PathVariable int theIndexOfTheStudent){
//        return studentList.get(theIndexOfTheStudent);
//    }

    @RequestMapping(value = "/students/{studentName}", method = RequestMethod.GET)
    public Student getStudentByName(@PathVariable String studentName) {
//        return studentList.get(studentList.indexOf(studentName));
//        int indexOfKevin = studentList.indexOf(new Student("Kevin", 21));

//        List<Student> matchingStudentList = studentList.stream()
//                .filter(st -> st.getName().equals(studentName))
//                .collect(Collectors.toList());
//
//        return matchingStudentList.get(0);
        //        List<Student> matchingStudentList = studentList.stream()
//                .filter(st -> st.getName().equals(studentName))
//                .collect(Collectors.toList());
//        return matchingStudentList.get(0);

        // get name  by going into the studentList
        // pull with getName() equal to studentName
        // return thisStudent.
        for (Student thisStudent : studentList) {
            if (thisStudent.getName().equals(studentName)) {
                return thisStudent;
            }
        }
        return null;
    }


}
