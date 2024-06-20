package org.example.controller;

import org.example.pojo.Business;
import org.example.pojo.Result;
import org.example.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/business")
@Validated
public class BusinessController {
    @Autowired
    private BusinessService businessService;

    @GetMapping("/get")
    public Result<List<Business>> list(){
        var list =  businessService.list();
        return Result.success(list);
    }
    @GetMapping("/getByType")
    public Result<List<Business>> listByType(int orderTypeId){
        var list =  businessService.listByType(orderTypeId);
        return Result.success(list);
    }
}
