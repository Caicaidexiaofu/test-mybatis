import com.ydl.entity.Admin;
import com.ydl.mapper.AdminMapper;
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
public class TestAnnotation {

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
    public void testSelect() {

        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            // statement是sql的声明，并不是sql本身
            AdminMapper mapper = session.getMapper(AdminMapper.class);
            List<Admin> admins = mapper.selectAll();
            log.debug("admin are [{}]:",admins);

        }
    }

    @Test
    public void testInsert() {

        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            // statement是sql的声明，并不是sql本身
            AdminMapper mapper = session.getMapper(AdminMapper.class);
            int i = mapper.saveAdmin(new Admin(6, "tom", "23"));
            log.debug("affected is [{}]:",i);

        }
    }




}
