import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2023/09/30 14:20:49
 */
@Slf4j
public class ImageUtils {
    @Test
    public void test1() throws IOException {
        //得到全部的图片文件
        Path path = Paths.get("D:\\Files\\CDN\\file\\_resources");
        if (!Files.exists(path)) {
            throw new RuntimeException("目录或文件不存在！");
        }
        List<Path> collect = new ArrayList<>();
        if (Files.isDirectory(path)) {
            collect = Files.walk(path).filter(temp -> temp.getFileName().toString().endsWith(".png")).collect(Collectors.toList());
        } else {
            boolean b = path.getFileName().toString().endsWith(".png");
            if (b) {
                collect.add(path);
            }
        }
        if (CollectionUtils.isEmpty(collect)) {
            return;
        }
        for (Path temp : collect) {
            changeImg(temp.toFile());
        }
    }

    /**
     * 加水印
     *
     * @param srcImgFile 本地图片地址
     * @throws IOException
     */
    private void changeImg(File srcImgFile) throws IOException {
        //将文件对象转化为图片对象
        Image srcImg = ImageIO.read(srcImgFile);
        //获取图片的宽
        int srcImgWidth = srcImg.getWidth(null);
        //获取图片的高
        int srcImgHeight = srcImg.getHeight(null);
//        System.out.println("图片的宽:" + srcImgWidth);
//        System.out.println("图片的高:" + srcImgHeight);

        BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
        // 加水印
        //创建画笔
        Graphics2D g = bufImg.createGraphics();
        //绘制原始图片
        g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
        //-------------------------文字水印 start----------------------------
        //根据图片的背景设置水印颜色
        g.setColor(new Color(158,160,161));
        //设置字体  画笔字体样式为微软雅黑，加粗，文字大小为60pt
        g.setFont(new Font("微软雅黑", Font.BOLD, 12));
        //水印内容
        String waterMarkContent = "https://www.cnblogs.com/lemonpuer";
        //设置水印的坐标
        int x = (srcImgWidth - getWatermarkLength(waterMarkContent, g)) - 5;
        int y = srcImgHeight - 5;
        //画出水印 第一个参数是水印内容，第二个参数是x轴坐标，第三个参数是y轴坐标
        g.drawString(waterMarkContent, x, y);
        g.dispose();
        //-------------------------文字水印 end----------------------------
        //待存储的地址
//        String tarImgPath = "F:\\0a8de9fc675db86eab79aa36b7575374.png";
        // 输出图片
        FileOutputStream outImgStream = new FileOutputStream(srcImgFile);
        ImageIO.write(bufImg, "png", outImgStream);
        log.info("图片{}成功添加水印",srcImgFile.getName());
        outImgStream.flush();
        outImgStream.close();
    }

    /**
     * 获取水印文字的长度
     *
     * @param waterMarkContent
     * @param g
     * @return
     */
    private int getWatermarkLength(String waterMarkContent, Graphics2D g) {
        return g.getFontMetrics(g.getFont()).charsWidth(waterMarkContent.toCharArray(), 0, waterMarkContent.length());
    }
}
