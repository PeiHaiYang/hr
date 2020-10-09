package cn.loverblue.hr.utils;

import com.github.qcloudsms.*;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;


import java.io.IOException;

/**
 * @author PHY
 * @date 2020-10-08$-8:00
 */
public class SmsUtils {

    public static String sendSms(String Tel){
        // 短信应用SDK AppID
        int appid = 1400338082; // 1400开头

        // 短信应用SDK AppKey
        String appkey = "d063f24439ed85ac78308ba1e35b126e";
        // 需要发送短信的随机验证码
        String _Code=RandomNum.Rand();
        //接收手机号
        String[] phoneNumbers = {Tel};

        // 短信模板ID，需要在短信应用中申请
        // NOTE: 这里的模板ID`7839`只是一个示例，
        // 真实的模板ID需要在短信控制台中申请
        int templateId = 561635;

        // 签名
        // NOTE: 这里的签名"腾讯云"只是一个示例，
        // 真实的签名需要在短信控制台中申请，另外
        // 签名参数使用的是`签名内容`，而不是`签名ID`
        String smsSign = "loverblue网";

        // 单发短信
        try {
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.send(0, "86", phoneNumbers[0],
                    "您的动态验证码为：[1]，您正在进行免密登录操作，如非本人操作，请忽略本短信！", "", "");
            System.out.print(result);
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
        }

        // 指定模板ID单发短信
        try {

            String[] params = {_Code};
            SmsMultiSender msender = new SmsMultiSender(appid, appkey);
            SmsMultiSenderResult result =  msender.sendWithParam("86", phoneNumbers,
                    templateId, params, smsSign, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
            System.out.print(result);
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
        }

        // 拉取单个手机短信状态
        try {
            int beginTime = 1511125600;  // 开始时间(unix timestamp)
            int endTime = 1511841600;    // 结束时间(unix timestamp)
            int maxNum = 10;             // 单次拉取最大量
            SmsMobileStatusPuller mspuller = new SmsMobileStatusPuller(appid, appkey);

            // 拉取短信回执
            SmsStatusPullCallbackResult callbackResult = mspuller.pullCallback("86",
                    phoneNumbers[0], beginTime, endTime, maxNum);

            System.out.println(callbackResult);

            // 拉取回复
            SmsStatusPullReplyResult replyResult = mspuller.pullReply("86",
                    phoneNumbers[0], beginTime, endTime, maxNum);
            System.out.println(replyResult);
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
        }

        return  _Code;
    }
}
