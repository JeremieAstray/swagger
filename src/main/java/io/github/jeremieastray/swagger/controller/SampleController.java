package io.github.jeremieastray.swagger.controller;

import com.alibaba.fastjson.JSONObject;
import io.github.jeremieastray.swagger.bean.SampleBean;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.*;

@RestController
@RequestMapping(value = "/temp")
public class SampleController {

    @RequestMapping("home")
    @ResponseBody
    String home(@PathParam("test") String test) {
        Map<String, Object> result = new HashMap<>();
        result.put("result", "Hello World");
        result.put("test", test);

        return JSONObject.toJSONString(result);
    }

    private final static Map<String, SampleBean> STRING_SAMPLE_BEAN_MAP = Collections.synchronizedMap(new HashMap<>());

    @ApiOperation(value = "获取Sample列表", notes = "")
    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public List<SampleBean> getSampleBeanList() {
        List<SampleBean> r = new ArrayList<>(STRING_SAMPLE_BEAN_MAP.values());
        return r;
    }

    @ApiOperation(value = "创建Sample", notes = "根据SampleBean对象创建Sample")
    @ApiImplicitParam(name = "SampleBean", value = "Sample详细实体SampleBean", required = true, dataType = "SampleBean")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postSampleBean(@RequestBody SampleBean SampleBean) {
        STRING_SAMPLE_BEAN_MAP.put(SampleBean.getPlanId(), SampleBean);
        return "success";
    }

    @ApiOperation(value = "获取Sample详细信息", notes = "根据url的id来获取Sample详细信息")
    @ApiImplicitParam(name = "id", value = "SampleID", required = true, dataType = "String")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public SampleBean getSampleBean(@PathVariable String id) {
        return STRING_SAMPLE_BEAN_MAP.get(id);
    }

    @ApiOperation(value = "更新Sample详细信息", notes = "根据url的id来指定更新对象，并根据传过来的SampleBean信息来更新Sample详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "SampleID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "SampleBean", value = "Sample详细实体SampleBean", required = true, dataType = "SampleBean")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putSampleBean(@PathVariable String id, @RequestBody SampleBean SampleBean) {
        SampleBean u = STRING_SAMPLE_BEAN_MAP.get(id);
        u.setPlanName(SampleBean.getPlanName());
        u.setAmount(SampleBean.getAmount());
        STRING_SAMPLE_BEAN_MAP.put(id, u);
        return "success";
    }

    @ApiOperation(value = "删除Sample", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "SampleID", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteSampleBean(@PathVariable String id) {
        STRING_SAMPLE_BEAN_MAP.remove(id);
        return "success";
    }

}