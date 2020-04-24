import com.demo.po.Thing;
import com.demo.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;


public class ThingTest {

    @Test
    public void findThingByIdTest() {
        // 获取SqlSession
        try {
            SqlSession sqlSession = MybatisUtils.getSession();
            // SqlSession执行映射文件中定义的SQL，并返回映射结果
            Thing thing = sqlSession.selectOne("com.demo.mappers"
                    + ".ThingMapper.findThingById", 1);
            // 打印输出结果
            System.out.println(thing.toString());
            // 关闭SqlSession
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findThingByNameTest() {
        // 获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSession();
        // SqlSession执行映射文件中定义的SQL，并返回映射结果
        List<Thing> things = sqlSession.selectList("com.demo.mappers"
                + ".ThingMapper.findThingByName", "j");
        for (Thing thing : things) {
            //打印输出结果集
            System.out.println(thing);
        }
        // 关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void addThingTest() {
        // 获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSession();
        Thing thing = new Thing();
        thing.setId(9);
        thing.setThingname("aaa");
        thing.setType("aabb");
        // 使用主键自助增长的添加方法
//		int rows = sqlSession.insert("com.itheima.mappers."
//				+ "CustomerMapper.addCustomer", customer);
        // 使用自定义主键值的添加方法
        int rows = sqlSession.insert("com.demo.mappers."
                + "ThingMapper.addThing", thing);
        // 输出插入数据的主键id值
        System.out.println(thing.getId());
        if (rows > 0) {
            System.out.println("您成功插入了" + rows + "条数据！");
        } else {
            System.out.println("执行插入操作失败！！！");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateThingTest() throws Exception {
        // 获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSession();
        // SqlSession执行更新操作
        // 创建Customer对象，并向对象中添加数据
        Thing thing = new Thing();
        thing.setId(5);
        thing.setThingname("rose");
        thing.setType("programmer");

        // 执行sqlSession的更新方法，返回的是SQL语句影响的行数
        int rows = sqlSession.update("com.demo.mappers"
                + ".ThingMapper.updateThing", thing);
        // 通过返回结果判断更新操作是否执行成功
        if (rows > 0) {
            System.out.println("您成功修改了" + rows + "条数据！");
        } else {
            System.out.println("执行修改操作失败！！！");
        }
        // 提交事务
        sqlSession.commit();
        // 关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void deleteThingTest() {
        // 获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSession();
        // SqlSession执行删除操作
        // 执行SqlSession的删除方法，返回的是SQL语句影响的行数
        int rows = sqlSession.delete("com.demo.mappers"
                + ".ThingMapper.deleteThing", 4);
        // 通过返回结果判断删除操作是否执行成功
        if (rows > 0) {
            System.out.println("您成功删除了" + rows + "条数据！");
        } else {
            System.out.println("执行删除操作失败！！！");
        }
        // 提交事务
        sqlSession.commit();
        // 关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void findAllUserTest() {
        // 获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSession();

        // SqlSession执行映射文件中定义的SQL，并返回映射结果
        List<Thing> things = sqlSession.selectList("com.demo.mappers.ThingMapper.findAllThing");
        for (Thing thing : things) {
            System.out.println(thing);
        }
        // 关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void findCustomerByNameAndJobTest() {
        // 获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSession();
        Thing thing = new Thing();
        thing.setThingname("a");
        thing.setType("aabb");
        // SqlSession执行映射文件中定义的SQL，并返回映射结果
        List<Thing> things = sqlSession.selectList("com.demo.mappers"
                + ".ThingMapper.findCustomerByNameAndJobs", thing);
        for (Thing thingg : things) {
            //打印输出结果集
            System.out.println(thingg);
        }
        // 关闭SqlSession
        sqlSession.close();
    }
}