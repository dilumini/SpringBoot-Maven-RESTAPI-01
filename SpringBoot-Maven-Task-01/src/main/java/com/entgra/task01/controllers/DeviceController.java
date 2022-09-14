package com.entgra.task01.controllers;

import com.entgra.task01.models.Device;
import com.entgra.task01.services.DeviceService;
import com.entgra.task01.utils.ApplicationUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @GetMapping
    ObjectNode findAll() {
        Collection<Device> allDevices = deviceService.findAll();
        if (allDevices.size() > 0) {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.convertValue(allDevices, JsonNode.class);
            return ApplicationUtil.createResponse(jsonNode, true);
        }
        return ApplicationUtil.createResponse("No devices found", true);
    }

    @GetMapping("{id}")
    ObjectNode findById(@PathVariable int id) {
        Device foundDevice = deviceService.findById(id);
        if (foundDevice != null) {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.convertValue(foundDevice, JsonNode.class);
            return ApplicationUtil.createResponse(jsonNode, true);
        }
        return ApplicationUtil.createResponse("No device found with id " + id, true);
    }

    @PostMapping
    ObjectNode save(@RequestBody Device device) {
        //(whatever the data that receive as request body convert them into device object)
        System.out.println("l1");
        return ApplicationUtil.createResponse(deviceService.save(device), true);

    }

    @PutMapping
    ObjectNode update(@RequestBody Device device) {
        return ApplicationUtil.createResponse(deviceService.update(device), true);
    }

    @DeleteMapping("{id}")
    ObjectNode deleteById(@PathVariable int id) {
        return ApplicationUtil.createResponse(deviceService.deleteById(id), true);
    }
}
