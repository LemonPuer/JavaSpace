import com.mapper.DeptMapper;
import com.mapper.EmpMapper;
import com.pojo.Dept;
import com.pojo.Emp;
import com.util.MapperUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lemon
 * @create 2022-11-21-11:57
 */
public class empTest {
    @Test
    public void test(){
        EmpMapper mapper = MapperUtil.getMapper(EmpMapper.class);
        System.out.println(mapper.selectOne(100));
    }
    @Test
    public void test1(){
        EmpMapper mapper = MapperUtil.getMapper(EmpMapper.class);
        System.out.println(mapper.stepOne(100));
    }
    @Test
    public void test2(){
        DeptMapper mapper = MapperUtil.getMapper(DeptMapper.class);
        System.out.println(mapper.selectOne(60));
    }
    @Test
    public void test3(){
        DeptMapper mapper = MapperUtil.getMapper(DeptMapper.class);
        System.out.println(mapper.stepOne(60).getDeptId());
        System.out.println(mapper.stepOne(60).getName());
    }
    @Test
    public void test4(){
        EmpMapper mapper = MapperUtil.getMapper(EmpMapper.class);
        System.out.println(mapper.selectMore(new Emp(0,"king","",24000,null)));
    }
    @Test
    public void test5(){
        EmpMapper mapper = MapperUtil.getMapper(EmpMapper.class);
        List<Emp> list =new ArrayList<>();
        list.add(new Emp(0,"john1","john1@qq.com",5000,new Dept(60)));
        list.add(new Emp(0,"john2","john2@qq.com",5000,new Dept(60)));
        list.add(new Emp(0,"john3","john3@qq.com",5000,new Dept(60)));
        System.out.println(mapper.insertMore(list));
    }
}

