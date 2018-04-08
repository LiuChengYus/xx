package cn.tmsreception.util;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

/**
 * Created by 17921 on 2017/12/6.
 */
public class EmailUtil {
    public static int getnum(String email) throws AddressException, MessagingException {
        /**
         * 1.得到session
         */
        Properties props=new Properties();
        // props.setProperty("mail.host","smtp.qq.com");    //设置邮件服务器地址    /*不同邮箱：smtp:xxx.com*/
        //props.setProperty("mail.smtp.auth","false");        //设置邮件服务器是否需要认证
        props.put("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.host", "smtp.qq.com");
        //你自己的邮箱
        props.put("mail.user", "1792157715@qq.com");
        //props.put("mail.password", "yvewokihvyfoeeic");
        props.setProperty("mail.smtp.port", "25");

        props.put("mail.smtp.starttls.enable", "true");

        //创建认证器
        Authenticator auth=new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("1792157715","kgmmrvnevluudjgg");
                //指定用户名和密码
        /*用户名不需加后缀   例：xxx@163.com    只需写xxx*/
            }
        };
        //获取session对象
        Session session=Session.getInstance(props,auth);

        /**
         * 2.创建mimemessage
         */
        MimeMessage msg=new MimeMessage(session);
        msg.setFrom(new InternetAddress("1792157715@qq.com"));        //设置发件人
        msg.addRecipient(MimeMessage.RecipientType.TO,new InternetAddress(email));    //设置收件人
//        msg.addRecipient(RecipientType.CC,new InternetAddress("xxxx"));    //类型为抄送
//        msg.addRecipient(RecipientType.BCC,new InternetAddress("xxxx"));//类型为密送

        msg.setSubject("这是一封测试邮件");    //设置邮件的主题
        //指定内容，及内容的mime类型
        Random rand = new Random();
        int yzm = rand.nextInt(1000);
        msg.setContent("验证码为：["+yzm+"]","text/html;charset=utf-8");
        /**
         * 3.发邮件
         */
        Transport.send(msg);
        return yzm;
    }
}
