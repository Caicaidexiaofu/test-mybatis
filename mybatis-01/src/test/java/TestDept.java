import com.ydl.entity.Dept;
import com.ydl.entity.Employee;
import com.ydl.mapper.DeptMapper;
import com.ydl.mapper.EmployeeMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Slf4j
public class TestDept {

    SqlSessionFactory sqlSessionFactory = null;


    @Before
    public void before() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        // 这个对象是核心，一个工程的数据库相关的操作都是围绕 SqlSessionFactory
        sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);

    }



    @Test
    public void testSelectAll() {

        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            // statement是sql的声明，并不是sql本身
            DeptMapper mapper = session.getMapper(DeptMapper.class);
            List<Dept> depts = mapper.selectAll(null);
            log.debug("employees are [{}]:",depts);

        }
    }

    @Test
    public void testSelect2() {

        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            // statement是sql的声明，并不是sql本身
            DeptMapper mapper = session.getMapper(DeptMapper.class);
            List<Dept> depts = mapper.select2(null);
            log.debug("employees are [{}]:",depts);

        }
    }









}
