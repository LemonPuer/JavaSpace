package workspace.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 培训课程
 * </p>
 *
 * @author Lemon
 * @since 2023-10-15
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("t_train_courses")
public class Courses implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 名称
     */
    @TableField("name")
    private String name;

    /**
     * 编码
     */
    @TableField("code")
    private String code;

    /**
     * 类型： 1 面授， 2 在线， 3 混合
     */
    @TableField("type")
    private Integer type;

    /**
     * 是否公开： 0  否 ， 1 是
     */
    @TableField("is_open")
    private Boolean open;

    /**
     * 分类ID
     */
    @TableField("category")
    private Long category;

    /**
     * 课程简介
     */
    @TableField("`describe`")
    private String describe;

    /**
     * 是否精品课  0:否   1:是
     */
    @TableField("is_excellent")
    private Boolean excellent;

    /**
     * 是否过期  0:否   1:是
     */
    @TableField("is_expire")
    private Boolean expire;

    /**
     * 创建时间
     */
    @TableField("create_date")
    private LocalDateTime createDate;

    /**
     * 更新时间
     */
    @TableField("update_date")
    private LocalDateTime updateDate;

    /**
     * 创建人工号
     */
    @TableField("creater_id")
    private String createrId;

    /**
     * 创建人姓名
     */
    @TableField("creater_name")
    private String createrName;

    /**
     * 管理人工号
     */
    @TableField("manager_id")
    private String managerId;

    /**
     * 管理人姓名
     */
    @TableField("manager_name")
    private String managerName;

    /**
     * 删除标识， 0 否， 1 是
     */
    @TableField("delete_flag")
    private Boolean deleteFlag;

    /**
     * 1.草稿 2.发布 3.取消发布
     */
    @TableField("status")
    private Integer status;

    /**
     * 是否保护
     */
    @TableField("is_protected")
    private Boolean beProtect;
}
