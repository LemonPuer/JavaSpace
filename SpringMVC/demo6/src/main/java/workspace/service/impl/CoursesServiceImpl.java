package workspace.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import workspace.domain.Courses;
import workspace.domain.CoursesVO;
import workspace.mapMapper.CoursesMapMapper;
import workspace.mapper.CoursesMapper;
import workspace.service.CoursesService;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 培训课程 服务实现类
 * </p>
 *
 * @author Lemon
 * @since 2023-10-15
 */
@Slf4j
@Service
@CacheConfig(cacheManager = "myCacheManager")
public class CoursesServiceImpl extends ServiceImpl<CoursesMapper, Courses> implements CoursesService {
    @Autowired
    private CoursesMapper mapper;
    @Autowired
    private CoursesMapMapper mapMapper;

    @Override
    @Cacheable(cacheNames = "filledList")
    public List<CoursesVO> filledList() {
        List<Courses> courses = mapper.selectList(null);
        List<CoursesVO> coursesVO = mapMapper.toVO(courses);
        // coursesVOS.forEach(temp -> {
        //     switch (temp.getType()) {
        //         case "1":
        //             temp.setType("面授");
        //             break;
        //         case "2":
        //             temp.setType("在线");
        //             break;
        //         case "3":
        //             temp.setType("混合");
        //         default:
        //     }
        // });
        log.info("执行时间：{}", LocalDateTime.now());
        return coursesVO;
    }

    @Override
    @Cacheable(cacheNames = "filledById", key = "#id", unless = "#result==null")
    public CoursesVO findById(Long id) {
        Courses courses = mapper.selectById(id);
        return mapMapper.toVO(courses);
    }

    @Override
    // @CachePut(cacheNames = {"filledById"})
    @Caching(
            evict = {
                    @CacheEvict(cacheNames = "filledById", key = "#coursesVO.id"),
                    @CacheEvict(cacheNames = "filledList", allEntries = true)
            }
    )
    public void update(CoursesVO coursesVO) {
        mapper.updateById(mapMapper.toEntity(coursesVO));
    }

    @Override
    public void changeName(Long id, String name) {
        mapper.changeName(id, name);
    }
}
