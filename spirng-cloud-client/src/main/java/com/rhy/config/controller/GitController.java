package com.rhy.config.controller;


import com.rhy.config.common.GitAutoRefreshConfig;
import com.rhy.config.common.GitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class GitController {

    @Autowired
    private GitConfig gitConfig;
    @Autowired
    private GitAutoRefreshConfig gitAutoRefreshConfig;

    @Value("${data.env}")
    private String data;
    @GetMapping(value = "show")
    public Object show(){

        return gitConfig;
    }

    @GetMapping(value = "autoShow")
    public Object autoShow(){

        return gitAutoRefreshConfig;
    }

    @GetMapping(value="getValue")
    public String getValue(){
        return data;
    }
}
