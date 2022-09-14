package com.entgra.task01.services;

import com.entgra.task01.models.Device;

import java.util.Collection;

public interface DeviceService {
    Collection<Device> findAll();

    Device findById(int id);

    String save(Device device);

    String update(Device device);

    String deleteById(int id);
}
