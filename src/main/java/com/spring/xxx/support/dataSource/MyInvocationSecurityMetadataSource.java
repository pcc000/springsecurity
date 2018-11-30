package com.spring.xxx.support.dataSource;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.*;

/**
 * @Auther: chengchengpeng
 * @Date: 2018/11/30 16:58
 * @Description:
 */
public class MyInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

    //tomcat启动时实例化一次
    public MyInvocationSecurityMetadataSource() {
        loadResourceDefine();
    }

    private void loadResourceDefine() {
        resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
        Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
        ConfigAttribute ca = new SecurityConfig("ROLE_USER");
        atts.add(ca);
        resourceMap.put("/index.jsp", atts);
        Collection<ConfigAttribute> attsno =new ArrayList<ConfigAttribute>();
        ConfigAttribute cano = new SecurityConfig("ROLE_NO");
        attsno.add(cano);
        resourceMap.put("/other.jsp", attsno);
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        // 将参数转为url
        String url = ((FilterInvocation)object).getRequestUrl();
        Iterator<String> ite = resourceMap.keySet().iterator();
        while (ite.hasNext()) {
            String resURL = ite.next();
            if (pathMatchesUrl(resURL, url)) {
                return resourceMap.get(resURL);
            }
        }
        return null;
    }


    protected boolean pathMatchesUrl(String path,String url){
        if (("/**".equals(path)) || ("**".equals(path))) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
