package com.ute.environmentalmonitoring.base.common;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 江婷婷 on 2018/5/14.
 */

public class Constant {
    public static final String SERVER_ADDRESS = "http://120.79.196.225:8080/IntelligentDetection/";

    public static final String LOGIN = "user/login.do";
    public static final String REGISTER = "user/register.do";

    public static final String FIRSTDATA = "data/get_now_data.do";
    public static final String SECONDDATA = "data/get_analysis_data.do";

    public static Context context = null;


    public static List<String> locations = new ArrayList<>();

}
