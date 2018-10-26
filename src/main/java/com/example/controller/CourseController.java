package com.example.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.service.CourseService;
import com.example.service.NoteService;
import com.example.utils.HttpUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author xzy
 */
@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private NoteService noteService;

    private static final Logger logger = LoggerFactory.getLogger(CourseController.class);


    @RequestMapping("/getInitiData")
    @ResponseBody
    public Map<String, Object> getInitiData() {
        Map<String, Object> resultMap = new HashMap<>();
        try {
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("result", "操作数据库失败");
        }
        return resultMap;
    }


    @RequestMapping("/deleteModule")
    @ResponseBody
    public Map<String, Object> deleteModule(String data, String id) {
        Map resultMap = new HashMap();
        if (!"21500".equals(data)) {
            resultMap.put("result", "error");
            return resultMap;
        }
        int deleteResult = noteService.deleteNote(id);
        resultMap.put("result", "success");
        return resultMap;
    }

    /**
     * 读取记录列表
     *
     * @param
     * @return
     */
    @RequestMapping("/getAllContents")
    @ResponseBody
    public List<Map<String, Object>> getAllContents() {
        List<Map<String, Object>> contentResultList = noteService.queryContents();
        return contentResultList;
    }

    @RequestMapping("/addContent")
    @ResponseBody
    public Map addContent(String data, String id) {
        Map<String, Object> insertMap = new HashMap();
        Integer idExistCount = noteService.selectContent(id);
        insertMap.put("content", data);

        if (idExistCount > 0) {
            insertMap.put("id", id);
            noteService.updateContent(insertMap);
        } else {
            String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
            insertMap.put("id", uuid);
            Integer insertCount = noteService.insertNote(insertMap);
        }
        Map tempMap = new HashMap();
        tempMap.put("success", "success");
        return tempMap;
    }

    @RequestMapping(value = {"/", "/view"})
    public String index(HttpServletRequest request) {
/**
 * 调用淘宝的ip接口,调用方式post,接口对每秒的请求评率有限制,足够自用.
 */
        String remoteIP = request.getRemoteAddr();
        String ipUrl = "http://ip.taobao.com/service/getIpInfo.php?ip=" + remoteIP;
        JSONObject myJson = null;
        String currentTime = "";
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            currentTime = df.format(new Date());
            String taobaoIPAPIresult = HttpUtils.sendPost(ipUrl, "");
            myJson = JSONObject.fromObject(taobaoIPAPIresult);
            JSONObject tempResultJson=JSONObject.fromObject(myJson.get("data"));
            logger.info(currentTime+" "+tempResultJson.get("city")+" "+remoteIP + " " +tempResultJson.get("region") );
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return "index";
    }

    @RequestMapping("/selectByCourseName")
    public List<Map<String, Object>> selectByCourseName(String courseName) {
        Map<String, Object> map = new HashMap<>();
        map.put("courseName", courseName);
        List<Map<String, Object>> resultList = courseService.selectByCourseName(map);
        return resultList;
    }

    @RequestMapping("/transaction")
    @Transactional
    // 需要事务的时候加上
    public Boolean transaction() {
        return true;
    }

}
