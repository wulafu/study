package com.study;

import org.springframework.boot.system.ApplicationHome;

import java.io.File;

public class Utils {
    public String getSavePath() {
        // 这里需要注意的是ApplicationHome是属于SpringBoot的类
        // 获取项目下resources/static/img路径
        ApplicationHome applicationHome = new ApplicationHome(this.getClass());

        // 保存目录位置根据项目需求可随意更改
        return applicationHome.getDir().getParentFile()
                .getParentFile().getAbsolutePath() + File.pathSeparator+"src"+File.pathSeparator+"main"+File.pathSeparator+"resources"+File.pathSeparator+"static"+File.pathSeparator+"image";
    }
}
