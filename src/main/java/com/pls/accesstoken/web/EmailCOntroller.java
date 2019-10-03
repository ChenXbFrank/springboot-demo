package com.pls.accesstoken.web;

import com.pls.accesstoken.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 81046 on 2018-07-20
 */
@RestController
@RequestMapping("/email")
public class EmailCOntroller {

    @Autowired
    private EmailService mailService;

    private String to = "1275736266@qq.com";

    /**
     * 发送邮件
     *
     * @return
     */
    @RequestMapping("/send")
    @ResponseBody
    public void handleFileUpload(HttpServletRequest request, HttpServletResponse response) {
        String title = request.getParameter("title");
        mailService.sendSimpleMail(to, "主题：" + title, "测试邮件内容");
    }

    /**
     * 带附件的邮件
     */
    @RequestMapping("/sendAttachmentsMail")
    @ResponseBody
    public void sendAttachmentsMail() {
        mailService.sendAttachmentsMail(to, "主题：带附件的邮件", "亲，生日快乐，有附件，请查收！", "D:\\1.jpg");
    }

    /**
     * 嵌入静态资源的邮件
     */
    @RequestMapping("/sendInlineResourceMail")
    @ResponseBody
    public void sendInlineResourceMail() {
        //? 这个id怎么来的
        String rscId = "rscId001";
        mailService.sendInlineResourceMail(to,
                "主题：嵌入静态资源的邮件",
                "<html><body>这是有嵌入静态资源：<img src=\'cid:" + rscId + "\' ></body></html>",
                "D:\\\\1.jpg",
                rscId);
    }
}
