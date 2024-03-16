package workspace;


import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2023/10/15 14:29:43
 */
public class MyCodeGenerator {
    public static void main(String[] args) throws IOException {
        // 获取当前Java进程的工作目录;当前项目的绝对路径
        String projectPath = System.getProperty("user.dir");
        // 使用类加载器加载配置文件
        InputStream input = MyCodeGenerator.class.getClassLoader().getResourceAsStream("mybatisPlus.properties");
        // 创建Properties对象
        Properties prop = new Properties();
        // 加载配置文件
        prop.load(input);

        FastAutoGenerator.create(prop.getProperty("codeGenerator.url"), prop.getProperty("codeGenerator.username"), prop.getProperty("codeGenerator.password"))
                .globalConfig(builder -> {
                    builder.author("Lemon") // 设置作者
                            // .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .disableOpenDir()// 不要打开资源管理器
                            .outputDir(projectPath + "/src/main/java"); // 指定输出目录
                })
                // 策略配置
                .strategyConfig(builder -> {
                    builder.addInclude("t_train_courses") // 设置需要生成的表名
                            .addTablePrefix("t_train_")// 设置过滤表前缀
                            .serviceBuilder()
                            .formatServiceFileName("%sService")// 去掉service文件前面的i，%s会自动填充对象名
                            .entityBuilder()
                            // 使用Lombok注解并开启链式
                            .enableLombok()
                            .enableChainModel()
                            .enableRemoveIsPrefix()// 类型字段移除 is 前缀
                            .enableTableFieldAnnotation()// 开启生成实体时生成字段注解
                            .naming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
                            .columnNaming(NamingStrategy.underline_to_camel); // 数据库表字段映射到实体的命名策略

                })
                .packageConfig(builder -> {
                    builder.parent("com") // 设置父包名
                            // 这里是设置各个文件类型的包名
                            .xml("mapper")
                            .entity("domain")
                            .mapper("mapper")
                            .service("service")
                            .controller("controller")
                            .moduleName("codeGenerator"); // 设置父包模块名);
                })
                .injectionConfig(builder -> {
                    // 自定义配置Map
                    Map<String, Object> map = new HashMap<>();
                    // 修改typeConvert属性
                    map.put("typeConvert", new MySqlTypeConvert() {
                        @Override
                        public IColumnType processTypeConvert(GlobalConfig config, String fieldType) {
                            // 打印数据库字段类型，用于验证是否触发了自定义类型转换逻辑
                            System.out.println("Database Field Type: " + fieldType);

                            // 将数据库的datetime类型映射为Java的Date类型
                            if (fieldType.equalsIgnoreCase("datetime")) {
                                System.out.println("Mapping to Java Date Type");
                                return DbColumnType.DATE;
                            }
                            if (fieldType.equalsIgnoreCase("tinyint")) {
                                return DbColumnType.INTEGER;
                            }
                            return super.processTypeConvert(config, fieldType);
                        }
                    });
                    builder.customMap(map);
                })
                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
