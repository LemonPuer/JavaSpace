package workspace.domain;

import lombok.Data;
import lombok.experimental.Accessors;


/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @String 2023/10/15 18:55:36
 */
@Data
@Accessors(chain = true)
public class CoursesVO {
    private Long id;

    private String name;

    private String code;

    private String type;

    private String open;

    private Long category;

    private String describe;

    private String excellent;

    private String expire;

    private String createDate;

    private String updateDate;

    private String createrId;

    private String createrName;

    private String managerId;

    private String managerName;

    private String deleteFlag;

    private Integer status;

    private String beProtect;

}
