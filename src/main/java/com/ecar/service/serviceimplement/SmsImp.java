package com.ecar.service.serviceimplement;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.ecar.dao.SmsDAO;
import com.ecar.dao.UserDAO;
import com.ecar.entity.Smscode;
import com.ecar.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
public class SmsImp implements SmsService{

    @Autowired
    private SmsDAO smsDAO;

    @Autowired
    private UserDAO userDAO;

    private static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    private static final String domain = "dysmsapi.aliyuncs.com";

    // TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    private static final String accessKeyId = "LTAIzNLsbgOkkvgR";
    private static final String accessKeySecret = "2XC6hWuGecKyzlgCG15J98OVhJIQNN";


    @Override
    public boolean sendCode(String phoneNumber) {
        phoneNumber = phoneNumber.replaceAll(" ", "");
        System.out.println("sendCode:"+phoneNumber);
        String source = "0123456789";
        String code = "";
        Random random = new Random();
        for(int i=1;i<=4;i++){
            code += String.valueOf(source.charAt(random.nextInt(9)));
        }

        SendSmsResponse response=null;
        try{
            response = sendSms(phoneNumber, code);
        }catch (Exception e){
            System.out.println("exception:"+e.getMessage());
        }
        if(response!=null&&response.getCode() != null && response.getCode().equals("OK")){
            System.out.println("1");
            Smscode sms = smsDAO.getSmsCodeByPhone(phoneNumber);
            if(sms != null){
                System.out.println("2");
                sms.setCode((code));
                sms.setLasttime(System.currentTimeMillis());
                smsDAO.updateSmscode(sms.getCode(), sms.getLasttime(), phoneNumber);
            }else{
                System.out.println("3");
                sms = new Smscode();
                sms.setPhonenumber(phoneNumber);
                sms.setCode(code);
                sms.setLasttime(System.currentTimeMillis());
                smsDAO.insertSmscode(sms.getPhonenumber(), sms.getCode(), sms.getLasttime());
            }
            return true;
        }else{
            return false;
        }
    }

    private SendSmsResponse sendSms(String phoneNumber,String code) throws ClientException {

        System.out.println("sendM");
        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(phoneNumber);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName("车视界验证码");
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode("SMS_82095098");
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        request.setTemplateParam("{\"code\":\""+code+"\"}");

        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("yourOutId");

        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = null;
        try {
            sendSmsResponse = acsClient.getAcsResponse(request);


        }catch (Exception e){
            e.printStackTrace();
        }
        return sendSmsResponse;
    }


    @Override
    public boolean getSmscodeByPhone(String phone, String code) {
        phone = phone.replaceAll(" ", "");
        Smscode sms = smsDAO.getSmsCodeByPhone(phone);
        System.out.println(sms);
        if(sms!=null){
            if((code).equals(sms.getCode())) {
                if(System.currentTimeMillis()-sms.getLasttime()<10*1000*60) {
                    System.out.println("ok");
                    if (userDAO.getUser(phone, "2323") == null) {
                        return true;
                    } else {
                        System.out.println("插入数据错误");
                        return false;
                    }
                } else {
                    System.out.println("验证码超时");
                    return false;
                }
            }else {
                System.out.println("验证码错误");
                return false;
            }
        }else{
            System.out.println("查无此人");
            return false;
        }
    }

    @Override
    public int updateSmscode(String code, String phone) {
        Long date = new Date().getTime();
        int result = smsDAO.updateSmscode(code,date,phone);

        return result;
    }

    @Override
    public int inserSmscode(String phone, String code) {
        Long date = new Date().getTime();
        int result = smsDAO.insertSmscode(phone, code, date);

        return result;
    }
}
