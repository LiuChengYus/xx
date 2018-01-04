package cn.test.contoller;

import com.baidu.ueditor.ActionEnter;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by CY on 2017/12/5.
 */
public class ImageContoller {

    /**
     * 百度富文本编辑器：图片上传
     * @param request
     * @param response
     */
    @RequestMapping("/upload")
    public void imgUploadByUeditor(HttpServletRequest request, HttpServletResponse response) throws Exception {
        /*request.setCharacterEncoding( "utf-8" );
        response.setHeader("Content-Type" , "text/html");
        String application = request.getContextPath();
        String rootPath;
        rootPath = application.getRealPath( "/" );
        PrintWriter out = response.getWriter();
        out.write( new ActionEnter( request, rootPath ).exec() );*/
    }
}
