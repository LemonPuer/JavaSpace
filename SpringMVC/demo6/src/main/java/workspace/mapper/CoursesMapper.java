package workspace.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import workspace.domain.Courses;

/**
 * <p>
 * 培训课程 Mapper 接口
 * </p>
 *
 * @author Lemon
 * @since 2023-10-15
 */
// @Mapper
public interface CoursesMapper extends BaseMapper<Courses> {

    void changeName(Long id, String name);
}
