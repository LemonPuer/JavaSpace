package DAO;

/**
 * @author Lemon
 * @create 2022-10-30-9:14
 */
public class Tool {
    public static int parseInt(String s,int def){
        if(s!=null){
            return Integer.parseInt(s);
        }
        return def;
    }
}
