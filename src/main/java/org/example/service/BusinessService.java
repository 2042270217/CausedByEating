package org.example.service;

import org.example.pojo.Business;

import java.util.List;

public interface BusinessService {
    List<Business> list();

    List<Business> listByType(int orderTypeId);
}
