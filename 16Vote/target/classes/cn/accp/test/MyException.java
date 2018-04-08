package cn.accp.test;

/**
 * @Auther: Xiao Yu
 * @Date: Created in 17:35 2018/3/24
 */
public class MyException extends Exception {


    /**
     * 异常信息描述
     */
    public  MyException(String message){
        super(message);
    }

    public  MyException(String message,Throwable cause){
        super(message,cause);
    }
}
