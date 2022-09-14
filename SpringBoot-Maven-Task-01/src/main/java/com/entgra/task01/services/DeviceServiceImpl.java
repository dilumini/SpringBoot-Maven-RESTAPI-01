package com.entgra.task01.services;

import com.entgra.task01.dao.DeviceDAO;
import com.entgra.task01.models.Device;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Collection;

@Service
public class DeviceServiceImpl implements DeviceService {
    private static DeviceDAO deviceDAO = new DeviceDAO();

    @Override
    public Collection<Device> findAll() {

        return deviceDAO.getAll();
    }

    @Override
    public Device findById(int id) {
        return deviceDAO.get(id).orElse(null);
    }

    @Override
    public String save(Device device) {
        System.out.println("l2");
        boolean saved = deviceDAO.save(device);
        if (saved) {
            return "Successfully saved device with name " + device.getName();
        }
        return "Device was not saved";
    }

    @Override
    public String update(Device device) {
        boolean updated = deviceDAO.update(device);
        if (updated) {
            return "Successfully updated device with id " + device.getId();
        }
        return "Device was not updated";
    }

    @Override
    public String deleteById(int id) {
        boolean deleted = deviceDAO.delete(id);
        if (deleted) {
            return "Successfully deleted device with id = " + id;
        }
        return "Device was not found";
    }
}
