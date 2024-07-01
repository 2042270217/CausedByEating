package org.example.controller;

import jakarta.validation.constraints.Pattern;
import org.apache.ibatis.annotations.Delete;
import org.example.pojo.DeliveryAddress;
import org.example.pojo.Result;
import org.example.service.DeliveryAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/da")
public class DeliveryAddressController {
    @Autowired
    private DeliveryAddressService deliveryAddressService;

    @PostMapping("/add")
    public Result add(@RequestBody @Validated DeliveryAddress deliveryAddress) {
        deliveryAddressService.add(deliveryAddress);
        return Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody @Validated DeliveryAddress deliveryAddress) {
        deliveryAddressService.update(deliveryAddress);
        return Result.success();
    }

    @GetMapping("/list")
    public Result<List<DeliveryAddress>> list() {
        var daList = deliveryAddressService.list();
        return Result.success(daList);
    }

    @DeleteMapping("/delete")
    public Result delete(@Pattern(regexp = "^\\S{6,16}$") int daId) {
        deliveryAddressService.delete(daId);
        return Result.success();
    }

}
