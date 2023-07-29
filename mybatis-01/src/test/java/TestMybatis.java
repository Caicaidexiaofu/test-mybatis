import com.ydl.entity.User;
import com.ydl.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
public class TestMybatis {

//    public static final Logger LOGGER = LoggerFactory.getLogger(TestMybatis.class);\

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
    public void testSqlSession() {

        try (SqlSession session = sqlSessionFactory.openSession();) {
            // statement是sql的声明，并不是sql本身
            List<Object> objects = session.selectList("user.select");
            log.debug("user is [{}]",objects);
        }
    }


    @Test
    public void testMapper(){
        try (SqlSession session = sqlSessionFactory.openSession()) {

            // 动态代理
            // 获得一个代理对象，使用的是jdk的proxy类，代理对象实现了UserMapper的接口
            UserMapper mapper = session.getMapper(UserMapper.class);
            List<User> users1 = mapper.selectAll();
            log.debug("users1[{}]",users1);
            System.out.println("-------------");
            List<User> users2 = mapper.selectAll();
            log.debug("users2[{}]",users2);
        }
    }

    @Test
    public void testSelectById(){
        try (SqlSession session = sqlSessionFactory.openSession()) {
            // 动态代理
            // 获得一个代理对象，使用的是jdk的proxy类，代理对象实现了UserMapper的接口
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.selectById(5);
            log.debug("user is [{}]",user);
        }
    }

    @Test
    public void testSelectParams(){
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            // 动态代理
            // 获得一个代理对象，使用的是jdk的proxy类，代理对象实现了UserMapper的接口
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.selects("fqz", "123");
            log.debug("this user is [{}]",user);
        }
    }


    @Test
    public void testSelectByUser(){
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            // 动态代理
            // 获得一个代理对象，使用的是jdk的proxy类，代理对象实现了UserMapper的接口
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User param = new User(4,"fqz","123");
            List<User> users = mapper.selectByUser(param);
            log.debug("this user is [{}]",users);
        }

    }

    @Test
    public void testSelectByMap(){
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            // 动态代理
            // 获得一个代理对象，使用的是jdk的proxy类，代理对象实现了UserMapper的接口
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            Map<String,Object> param = new HashMap<>(2);
            param.put("username","fqz");
            param.put("password","123");
            User user = mapper.selectByMap(param);
            log.debug("this user is [{}]",user);
        }
    }

    @Test
    public void testSelectObscure(){
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            // 动态代理
            // 获得一个代理对象，使用的是jdk的proxy类，代理对象实现了UserMapper的接口
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            List<User> users = mapper.selectObscure("l");
            log.debug("this user is [{}]",users);
        }

    }

    @Test
    public void testInsert(){
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            // 动态代理
            // 获得一个代理对象，使用的是jdk的proxy类，代理对象实现了UserMapper的接口
            try {
                UserMapper mapper = sqlSession.getMapper(UserMapper.class);
                int row = mapper.insert(new User(111,"zahngsan","234"));
                log.debug("受影响行数[{}]",row);
                // 必须手动提交事务
                int i =  1 / 0;
                sqlSession.commit();
            }catch (Exception e){
                log.error("发生了异常：",e);
                sqlSession.rollback();
            }
        }
    }


    @Test
    public void testUpdate(){
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)){
            // 动态代理
            // 获得一个代理对象，使用的是jdk的proxy类，代理对象实现了UserMapper的接口
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int row = mapper.update(new User(12, "lisi", "123"));
            log.debug("受影响行数[{}]", row);
        }
    }

    @Test
    public void testDelete(){
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)){
            // 动态代理
            // 获得一个代理对象，使用的是jdk的proxy类，代理对象实现了UserMapper的接口
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int row = mapper.delete(11);
            log.debug("受影响行数[{}]", row);
        }



    }

    @Test
    public void testDeleteById(){
        try(SqlSession sqlSession = sqlSessionFactory.openSession(true)){
            // 动态代理
            // 获得一个代理对象，使用的是jdk的proxy类，代理对象实现了UserMapper的接口
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int row = mapper.deleteByIds(List.of(8,9,12));
            log.debug("受影响行数[{}]", row);
        }
    }

    @Test
    public void testBatchInsert(){
        try(SqlSession sqlSession = sqlSessionFactory.openSession(true)){
            // 动态代理
            // 获得一个代理对象，使用的是jdk的proxy类，代理对象实现了UserMapper的接口
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            List<User> users = List.of(new User(1, "tom", "123"),
                    new User(2, "jerry", "123"),
                    new User(3, "lucy", "123")
            );
            int row = mapper.batchInsert(users);
            log.debug("受影响行数[{}]", row);
        }



    }




}
