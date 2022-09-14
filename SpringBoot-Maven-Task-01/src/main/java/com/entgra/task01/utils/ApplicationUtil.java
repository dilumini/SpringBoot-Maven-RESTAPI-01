package com.entgra.task01.utils;

import com.entgra.task01.models.Device;
import com.entgra.task01.models.enums.Status;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import java.sql.*;


public class ApplicationUtil {
    public static ObjectNode createResponse(Object response, boolean ok) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode result = mapper.createObjectNode();
        result.put("status", ok);
        if (response instanceof String) {
            result.put("response", (String) response);
        } else {
            result.set("response", (JsonNode) response);
        }
        return result;
    }

    public static Device selectSQLUtil(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String model = resultSet.getString("model");
        String statusString = resultSet.getString("status");
        Status status = /*Status.valueOf(statusString);*/Status.valueOf(statusString.toUpperCase());
        Date date = resultSet.getDate("enrolledTime");
        return new Device(id, name, model, status, date);
    }

    public static void prepareStatementUtil(PreparedStatement preparedStatement, Device device) throws SQLException {
        preparedStatement.setString(1, device.getName());
        preparedStatement.setString(2, device.getModel());
        preparedStatement.setString(3, device.getStatus().toString());
        preparedStatement.setDate(4, device.getEnrolledTime());
    }
}
