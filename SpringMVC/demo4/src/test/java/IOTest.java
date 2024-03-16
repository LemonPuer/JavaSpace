import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2023/09/30 11:37:47
 */
@Slf4j
public class IOTest {
    @Test
    public void test1() {
        try {
            File input = new File("D:\\Files\\CDN\\file\\1. Java\\1. JavaSE\\1. Java概述.md");
            File output = new File("D:\\Files\\CDN\\file\\1. Java\\1. JavaSE\\3. 数组(1).md");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(input));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(output, false));
            String s = null;
            while (true) {
                s = bufferedReader.readLine();
                if (s == null) {
                    break;
                }
                if (s.startsWith("<img") || s.startsWith("![")) {
                    log.info("修改前：{}", s);
                    s = s.replace("../../_resources", "https://gitcode.net/weixin_56750535/figure/-/raw/master/cnblogs");
                    log.info("修改后：{}", s);
                }
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test2() {
        try {
            Path path = Paths.get("D:\\Files\\CDN\\file\\1. Java\\1. JavaSE\\3. 数组 - 副本.md");
            List<String> lines = Files.lines(path)
                    .map(line -> line.startsWith("<img") || line.startsWith("![") ?
                            line.replace("../../_resources", "https://gitcode.net/weixin_56750535/figure/-/raw/master/cnblogs") :
                            line)
                    .collect(Collectors.toList());
            Iterator<String> iterator = lines.iterator();
            while (iterator.hasNext()) {
                String temp = iterator.next();
                if (temp.equalsIgnoreCase("[TOC]")) {
                    iterator.remove(); // 使用迭代器的remove方法安全地删除元素
                }
            }
            Files.write(path, lines, StandardCharsets.UTF_8);
            log.info("文件更新完成！");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test3() {
        //获取当前文件夹下的所有子文件夹
        try {
            Path path = Paths.get("D:\\Files\\CDN\\file");
            Stream<Path> walk = Files.walk(path, 1);
            List<Path> collect = walk.filter(temp -> !temp.getFileName().toString().startsWith("_")).collect(Collectors.toList());
            collect.remove(path);
            List<Path> files = new ArrayList<>();
            for (Path i : collect) {
                Stream<Path> walk1 = Files.walk(i);
                files.addAll(getAllFile(i));
            }
            List<Path> errorFile = files.stream().filter(temp -> !temp.getFileName().toString().endsWith(".md")).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(errorFile)) {
                log.error("以下是不符合格式的文件：");
                errorFile.forEach(System.out::println);
                throw new RuntimeException("存在不是MarkDown格式的文件，请检查！");
            }
            files.forEach(temp -> changeFile(temp, "https://gitcode.net/weixin_56750535/figure/-/raw/master/cnblogs"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Path> getAllFile(Path path) {
        ArrayList<Path> result = new ArrayList<>();
        if (Files.isRegularFile(path)) {
            result.add(path);
            return result;
        }
        //是目录
        List<Path> collect = null;
        try {
            collect = Files.walk(path).collect(Collectors.toList());
            //去掉本身
            collect.remove(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (CollectionUtils.isEmpty(collect)) {
            return result;
        }
        for (Path temp : collect) {
            if (Files.isDirectory(temp)) {
                List<Path> allFile = getAllFile(temp);
                result.addAll(allFile);
                continue;
            }
            result.add(temp);
        }
        return result;
    }

    private void changeFile(Path path, String url) {
        try {
            List<String> lines = Files.lines(path)
                    .map(line -> line.startsWith("<img") || line.startsWith("![") ?
                            line.replace("../../_resources", url) :
                            line)
                    .collect(Collectors.toList());
            Iterator<String> iterator = lines.iterator();
            while (iterator.hasNext()) {
                String temp = iterator.next().trim();
                if (temp.equalsIgnoreCase("[TOC]")) {
                    iterator.remove(); // 使用迭代器的remove方法安全地删除元素
                }
            }
            Files.write(path, lines, StandardCharsets.UTF_8);
            log.info("文件{}更新完成！", path);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
