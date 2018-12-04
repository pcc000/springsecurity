package com.spring.xxx.web;

import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: chengchengpeng
 * @Date: 2018/12/4 11:00
 * @Description:
 */
@Controller
public class WelcomeController {

    @RequestMapping(value={"/welcome","/"},method=RequestMethod.GET)
    public String welcome(){
        return "index";
    }

    @RequestMapping(value="/loginin",method=RequestMethod.POST)
    public String login(HttpRequest request){
        String url = request.getURI().getPath();
        return "index";
    }
}
