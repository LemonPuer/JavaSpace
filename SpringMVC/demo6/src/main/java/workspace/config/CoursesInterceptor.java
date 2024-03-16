package workspace.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import workspace.domain.Courses;
import workspace.domain.CoursesVO;
import workspace.mapMapper.CoursesMapMapper;
import workspace.mapper.CoursesMapper;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2023/11/05 10:23:18
 */
@Slf4j
@Component
public class CoursesInterceptor implements HandlerInterceptor {
    @Autowired
    private CoursesMapper mapper;
    @Autowired
    private CoursesMapMapper mapMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // ServletContext context = request.getServletContext();
        HttpSession session = request.getSession();
        Object course = session.getAttribute("_course_");
        if (ObjectUtils.isEmpty(course)) {
            CoursesVO vo = mapMapper.toVO(mapper.selectById(100));
            log.info("vo:{},存入Session", vo);
            session.setAttribute("_course_", vo);
        } else {
            if (!(course instanceof CoursesVO)) {
                throw new Exception("课程类型不对应！");
            }
            CoursesVO vo = (CoursesVO) course;
            log.info("从session中获取到的vo:{}", vo);

        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
