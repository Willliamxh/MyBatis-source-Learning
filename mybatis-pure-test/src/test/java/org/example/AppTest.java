package org.example;

import com.bjp.dao.AccountDao;
import com.bjp.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    public static void main(String[] args) throws IOException {
        ////1.定义mybatis主配置文件的名称, 从类路径的根开始（target/clasess）
        //String config="mybatis.xml";
        ////2.读取这个config表示文件
        //InputStream inputStream = Resources.getResourceAsStream(config);
        ////3.创建sqlSessionFactoryBuilder对象
        //SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        ////4.创建SqlSessionFactory对象
        //SqlSessionFactory factory=sqlSessionFactoryBuilder.build(inputStream);
        ////5.【重要】获取sqlSession对象，从SqlSessionFactory中获得sqlSession
        //SqlSession sqlSession = factory.openSession();
        ////6.【重要】指定要执行的sql语句的标识。sql映射文件中的namespace + '.' +标签的id值
        //String sqlId="com.bjp.dao.StudentDao"+"."+"selectStudents";
        ////7.执行sql语句，通过sqlId找到语句
        //List<Student> studentList = sqlSession.selectList(sqlId);
        ////8.输出结果
        //studentList.forEach(student -> System.out.println("查询的学生"+student));
        ////9.关闭sqlSession对象
        //sqlSession.close();


        // 第一步：读取mybatis-config.xml 配置文件
        String config="mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(config);
        // 第一步的核心代码就是：InputStream returnValue = cl.getResourceAsStream(resource);
        // 其实就是 ：
        // InputStream inputStream2 = Thread.currentThread().getContextClassLoader().getResourceAsStream(config);
        // 或者是
        // InputStream inputStream = AppTest.class.getClassLoader().getResourceAsStream(config);


        // 第二步：构建sqlSessionFactory（框架初始化） 这里是个建造者模式 == new DefaultSqlSessionFactory() 这个类持有一个Configuration类的引用
        /**
         * 1.MyBatis解析配置文件的本质就是为了获得Configuration对象；
         * 2.Configuration 对象可以理解是mybatis的XML配置文件在程序中的化身，是MyBatis非常重要的一个对象，里面封装了MyBatis的整个配置信息；
         */
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        // 第三步：打开sqlSession  其实这边的核心就是拿到private final Executor executor; 这个执行器对象。
        // 如果开启了缓存，就是cache执行器，如果有插件，那就是是个代理的cache执行器（proxy），如果都没有应该就是个simple执行器
        /**
         * 1、从 configuration 配置对象中获取环境 environment 信息；
         * 2,根据环境 environment 信息获取事务工厂 TransactionFactory;
         * 3、根据环境信息中创建一个事务对象 Transaction :
         * 4、根据 configuration 和 Transaction 创建一个执行器 Executor 对象；
         * 5、 根据 configuration 和 Executor创建一个默认的SqlSession 对象；
         */
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 第四步：获取mapper接口对象 底层是动态代理
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        // 第五步：操作数据库
        Account account = accountDao.selectById(2);
        // 第六步：业务处理
        System.out.println(account);

        // 9.提交并关闭sqlSession对象
        sqlSession.commit();
        sqlSession.close();


    }
}
