package cn.tms.util;

import org.junit.Test;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import java.util.Properties;
import java.util.Random;

/**
 * javamail第一例
 * @author wang
 * 17.6.14
 *
 */

public class EmailTest {

    public static int email(String qq) throws Exception{
        /**
         * 1.得到session
         */
        Properties props=new Properties();
        // props.setProperty("mail.host","smtp.qq.com");    //设置邮件服务器地址    /*不同邮箱：smtp:xxx.com*/
        //props.setProperty("mail.smtp.auth","false");        //设置邮件服务器是否需要认证
        props.put("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.host", "smtp.qq.com");
        //你自己的邮箱
        props.put("mail.user", "1760596310@qq.com");
        props.put("mail.password", "twdceclsffhbeefh");
        props.setProperty("mail.smtp.port", "25");

        props.put("mail.smtp.starttls.enable", "true");

        //创建认证器
        Authenticator auth=new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("1760596310","twdceclsffhbeefh");
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
        msg.setFrom(new InternetAddress("1760596310@qq.com"));        //设置发件人
        msg.addRecipient(RecipientType.TO,new InternetAddress(qq));    //设置收件人
//        msg.addRecipient(RecipientType.CC,new InternetAddress("xxxx"));    //类型为抄送
//        msg.addRecipient(RecipientType.BCC,new InternetAddress("xxxx"));//类型为密送

        msg.setSubject("您正在申请邮箱找回密码请查看详情");    //设置邮件的主题
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
