package cn.loverblue.hr.utils;



import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * @author PHY
 * @date 2020-10-08$-8:17
 */
public class MailSend implements Runnable{


    private String to;
    private String code;

    public void setTo(String to) {
        this.to = to;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public void run() {
        try {
            sendMail(to,code);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void sendMail(String to,String code) throws Exception {
        //创建连接对象，连接服务器
        Properties props=new Properties();
        //一个是主机名，一个是服务器地址
        props.setProperty("loverblue.cn", "175.24.12.12");
        //props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "175.24.12.12");
        //props.put("mail.smtp.host", host);
        /*
         * // 设置用户的认证方式 properties.setProperty( "mail.smtp.auth", "true" );
         * //设置传输协议
         * properties.setProperty( "mail.transport.protocol", "smtp" );
         * //SMTP邮件服务器
         * properties.setProperty( "mail.smtp.host", "smtp.163.com" );
         * //SMTP邮件服务器默认端口
         * properties.setProperty( "mail.smtp.port", "25" );
         * // 获取默认的Session对象。
         * Session mailSession = Session.getDefaultInstance(properties );
         */
        Session  session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("u02@loverblue.cn", "123");
            }
        });
        //创建一个邮件的对象
        Message message=new MimeMessage(session);
        //发件人
        message.setFrom(new InternetAddress("u02@loverblue.cn"));
        //收件人
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
        //邮件的主题
        message.setSubject("来自盒马鲜生的激活邮件");
        //邮件的正文 一个参数是正文内容，一个是文本还是一个html的内容 www.loverblue.cn
        message.setContent("<h1>please click it </h1><h2>'"+code+"'</h2>",
                "text/html;Charset=utf-8");
        //发送邮件了
        Transport.send(message);
        //发送一封激活邮件
    }
}
