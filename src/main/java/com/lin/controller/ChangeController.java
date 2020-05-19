package com.lin.controller;

import com.lin.service.WordChangeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "文档转换(同时测试 knife4j )")
@RestController
@RequestMapping("/word")
public class ChangeController {
    @Autowired
    private WordChangeService wordChangeService;

    @ApiOperation(value = "changeHtmlToPdf 测试接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "inputFilePath",value = "",required = true),
            @ApiImplicitParam(name = "outFilePath",value = "",required = true)
    })
    @GetMapping("/changeHtmlToPdf")
    public boolean changeHtmlToPdf(String inputFilePath, String outFilePath){
        return wordChangeService.changeHtmlToPdf(inputFilePath,outFilePath);
    }
}
