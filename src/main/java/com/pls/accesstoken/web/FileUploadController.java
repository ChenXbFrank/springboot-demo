package com.pls.accesstoken.web;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pls.accesstoken.model.Result;
import com.pls.accesstoken.util.ResultUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileUploadController {

    /**
     * 文件上传的页面
     * @return
     */
    @RequestMapping("/file")
    public String file() {
        return "/file";
    }

    @RequestMapping("/fileUpload")
    @ResponseBody
    public Result fileUpload(@RequestParam("filename") MultipartFile file) {
        if(file.isEmpty()) {
            return ResultUtil.success("false");
        }
        String originalFilename = file.getOriginalFilename();
        System.out.println("****"+originalFilename);
        //存放路径
        String filePath="D://upload/";
        //这个目录是否存在
        File dest=new File(filePath+originalFilename);
        if(!dest.getParentFile().exists()) {
            //创建目录
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            return ResultUtil.success("true");
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ResultUtil.success("false");
    }

    /**
     * 多文件上传
     * @return
     */
    @RequestMapping("/mutiFile")
    public String mutiFile() {
        return "/mutifile";
    }

    /**
     * 处理文件上传
     */
    @RequestMapping(value="/mutiFileUpload",method=RequestMethod.POST)
    @ResponseBody
    public Result mutiFileUpload(HttpServletRequest request) {
        //根据名称获取文件
        List<MultipartFile> files=((MultipartHttpServletRequest)request).getFiles("filename");
        MultipartFile file=null;
        //存放路径
        String filePath="D://upload/";
        for (int i = 0; i < files.size(); i++) {
            file=files.get(i);
            String originalFilename = file.getOriginalFilename();
            if(file.isEmpty()) {
                return ResultUtil.success("false");
            }else {
                //这个目录是否存在
                File dest=new File(filePath+originalFilename);
                if(!dest.getParentFile().exists()) {
                    //创建目录
                    dest.getParentFile().mkdirs();
                }
                try {
                    file.transferTo(dest);
                } catch (Exception e) {
                    return ResultUtil.success("false");
                }
            }
        }
        return ResultUtil.success("true");
    }

    /**
     * 文件下载
     * @return
     */
    @RequestMapping("/downLoad")
    public Result downLoadFile(HttpServletResponse response) {
        String fileName="f1.png";
        String filePath="D://upload/";
        File file=new File(filePath,fileName);
        if(file.exists()) {
            // 设置强制下载不打开
            response.setContentType("application/force-download");
            // 设置文件名
            response.addHeader("Content-Disposition", "attachment;fileName"+fileName);

            byte[] bt=new byte[102400];
            FileInputStream fis=null;
            BufferedInputStream bis=null;
            try {
                fis=new FileInputStream(file);
                bis=new BufferedInputStream(fis);
                OutputStream os=response.getOutputStream();
                int i=bis.read(bt);
                while(i!=-1) {
                    os.write(bt);
                    i=bis.read(bt);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("****下载完毕***");
            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ResultUtil.success("true");
    }

}

