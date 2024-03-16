package workspace.service;


import com.baomidou.mybatisplus.extension.service.IService;
import workspace.domain.Courses;
import workspace.domain.CoursesVO;

import java.util.List;

/**
 * <p>
 * 培训课程 服务类
 * </p>
 *
 * @author Lemon
 * @since 2023-10-15
 */
public interface CoursesService extends IService<Courses> {

    List<CoursesVO> filledList();

    CoursesVO findById(Long id);

    void update(CoursesVO coursesVO);

    void changeName(Long id, String name);
}
