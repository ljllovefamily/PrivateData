package cn.itcast.dao;

import cn.itcast.domain.Student;

import java.util.List;

public interface Studentdao {
    List<Student> selectStudentInformation();
}
