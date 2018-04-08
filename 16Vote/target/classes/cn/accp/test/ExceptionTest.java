package cn.accp.test;

/**
 * @Auther: Xiao Yu
 * @Date: Created in 17:37 2018/3/24
 */
public class ExceptionTest {
    public static void main(String[] args) {
        try {
           int num=print(1,-4);
        }catch (MyException e){
            e.printStackTrace();
            System.out.println("除数不能为负数"+e.getMessage());
        }catch (ArithmeticException e){
            System.out.println("除数不能为0"+e.getMessage());
        }catch (Exception e){
            System.out.println("程序发生了其他的异常");
        }
    }

    public static int print(int a,int b) throws MyException{
        if (b<0){
            throw new MyException("除数不能为0");
        }
        return a/b;
    }
}
