package com.atguigu.crowd.util;

import com.atguigu.crowd.constant.CrowdConstant;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Lemon
 * @create 2023-02-17-11:48
 */
public class CrowdUtil {
    /**
     * 判断请求是否是AJAX
     * @author: Lemon
     * @create:2023/2/17-11:48
    */
    public static boolean judgeRequestType(HttpServletRequest request){
        String accept = request.getHeader("Accept");
        String XRequested = request.getHeader("X-Requested-With");
        return (accept!=null&&accept.contains("application/json"))||(XRequested!=null&&XRequested.equalsIgnoreCase("XMLHttpRequest"));
    }
    /**
     * 进行字符串MD5加密
     * @author: Lemon
     * @create:2023/2/17-15:09
    */
    public static String md5(String source){
        if(source==null||source.length()==0){
            throw new RuntimeException(CrowdConstant.MESSAGE_STRING_INVALIDATE);
        }
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            byte[] digest = md5.digest(source.getBytes());
            //直接转String结果全是乱码
            //signum可以取-1：负数；0：0；1：正数
            BigInteger bigInteger = new BigInteger(1, digest);
            //按照16进制转换为字符串
            return bigInteger.toString(16).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
