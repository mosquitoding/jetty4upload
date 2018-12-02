package com.mos.service.impl;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.mos.service.StudentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;

import com.mos.dataset.StudentDateSet;
import com.mos.service.StudentService;
import com.mos.vo.StudentListVo;
import com.mos.vo.StudentVo;



@Path("/studentService")
@Produces("application/xml")
//@Component("studentService")
public class StudentServiceImpl implements StudentService {

//    private StudentDateSet studentDateSet;

    /**
     * url:http://<host>:<port>/<appcontext>/services/studentService/status
     */
    //@Override
    @GET
    @Path("/status")
    public String getStatus() {
        return "getStatus";
    }

    /**
     * url:http://<host>:<port>/<appcontext>/services/studentService/students/{
     * index}
     */
    //@Override
    @GET
    @Path("/students/{index}")
    public StudentVo getStudentById(@PathParam("index") Integer id) {
        List<StudentVo> studentList = StudentDateSet.getList();
        StudentVo vo = null;
        if (studentList.size() > id) {
            vo = studentList.get(id - 1);
        }
        return vo;
    }

    /**
     * url:http://<host>:<port>/<appcontext>/services/studentService/students
     */
    //@Override
    @GET
    @Path("/students")
    public StudentListVo getStudentList() {
        List<StudentVo> studentList = StudentDateSet.getList();
        StudentListVo listVo = new StudentListVo(studentList);
        return listVo;
    }

}
