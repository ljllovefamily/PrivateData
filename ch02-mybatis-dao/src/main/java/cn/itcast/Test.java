package cn.itcast;

import cn.itcast.Utils.FactoryUtils;
import cn.itcast.domain.Student;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Test {

public static void main(String[] args){
        SqlSession sqlsession= FactoryUtils.getSqLSession();
        String qld="cn.itcast.dao.Studentdao.selectStudentInformation";
        List<Student> studentlist =sqlsession.selectList(qld);
        studentlist.forEach(stu->System.out.println(stu));
        sqlsession.close();
}
}
