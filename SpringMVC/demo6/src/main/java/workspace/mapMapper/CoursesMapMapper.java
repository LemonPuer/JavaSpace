package workspace.mapMapper;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.mapstruct.*;
import workspace.domain.Courses;
import workspace.domain.CoursesVO;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2023/10/15 18:58:50
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CoursesMapMapper {
    default String booleanToString(Boolean value) {
        return value ? "是" : "否";
    }

    default Boolean stringToboolean(String value) {
        if ("是".equals(value)) {
            return true;
        } else if ("否".equals(value)) {
            return false;
        }
        return null;
    }

    // LocalDateTime 转换为 String
    default String localDateTimeToString(LocalDateTime dateTime) {
        Date date = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
        return DateFormatUtils.format(date, "yyyy.MM.dd HH.mm.ss");
    }

    @Mappings({
            @Mapping(target = "beProtect", expression = "java(courses.getBeProtect().equals(Boolean.TRUE) ? \"是\" : \"否\")"),
            @Mapping(target = "type", expression = "java(courses.getType() == 1 ? \"面授\" : (courses.getType() == 2 ? \"在线\" : \"混合\"))")
    })
    CoursesVO toVO(Courses courses);

    List<CoursesVO> toVO(List<Courses> courses);

    /**
     * 将toVO方法的转换规则反转
     */
    @InheritInverseConfiguration(name = "toVO")
    Courses toEntity(CoursesVO coursesVO);

    List<Courses> toEntity(List<CoursesVO> coursesVO);

}
