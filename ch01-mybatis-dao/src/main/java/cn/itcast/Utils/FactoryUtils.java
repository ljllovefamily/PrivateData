package cn.itcast.Utils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;

public class FactoryUtils {
    //定义SqlSessionFactory为空，
   private static SqlSessionFactory factory=null;
    //编写静态代码块，因为SqlSession工厂太大，所以加载一次就行
    static{
        //设置配置文件的路径
        String config="mybatis01.xml";
        //定义IO流对象读取配置文件
        InputStream in= null;
        try {
            in = Resources.getResourceAsStream(config);
            //由 SqlSessionFactoryBuilder 对象开启 SqlSessionFactory
            SqlSessionFactoryBuilder sfb=new SqlSessionFactoryBuilder();
            factory=sfb.build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    //编写静态方法获取SqlSession对象
    public static SqlSession getSqLSession(){
        //初始化Sqlsession
        SqlSession sqlsession=null;
        //判断SqlsessionFactory是否为空
        if(factory!=null){
            //不为空则开启Session
            sqlsession= factory.openSession();

        }
        //返回session
        return sqlsession;
    }
}
