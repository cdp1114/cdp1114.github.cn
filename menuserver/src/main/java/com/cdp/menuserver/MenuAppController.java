package com.cdp.menuserver;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 菜谱appAPI接口
 *
 * @author cdp
 * @date 2023-8-11 10:22
 */
@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
@Log4j2
public class MenuAppController {

    private static final String APP_KEY = "da39dce4f8aa52155677ed8cd23a6470";

    private static final String APP_URL = "https://way.jd.com/jisuapi/search";


    @GetMapping("getList")
    public Result<JSONObject> getList(Integer num, String keyword) {
        Map<String, Object> mapParam = new HashMap<>(10);
        mapParam.put("appkey", APP_KEY);
        mapParam.put("num", num);
        mapParam.put("keyword", keyword);
        String result = HttpUtil.get(APP_URL, mapParam);
        log.info("result:{}", result);
        return Result.success(JSONUtil.parseObj(result));
    }


}
