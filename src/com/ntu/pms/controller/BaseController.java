package com.ntu.pms.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ntu.pms.constant.OtherConstants;
import com.ntu.pms.model.User;

public class BaseController {

    protected Map<String, Object> baseDataMap;

    public User getCurrentLoginUser() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession();
        User currentUser = (User) session.getAttribute(OtherConstants.CURRRENT_USER);
        return currentUser;
    }

    public Object getSessionAttribute(String key) {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession();
        Object value = session.getAttribute(key);
        return value;
    }

    public Object getBaseDataMap(String key) {
        if (this.baseDataMap.containsKey(key)) {
            return this.baseDataMap.get(key);
        }
        return null;
    }

    public void setBaseDataMap(String key, Object object) {
        if (this.baseDataMap == null) {
            baseDataMap = new HashMap<String, Object>();
        }
        if (this.baseDataMap.containsKey(key)) {
            this.baseDataMap.remove(key);
        }
        this.baseDataMap.put(key, object);
    }

    public void removeBaseData(String key) {
        if (this.baseDataMap.containsKey(key)) {
            this.baseDataMap.remove(key);
        }
    }
}
