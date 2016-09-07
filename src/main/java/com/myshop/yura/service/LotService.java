package com.myshop.yura.service;

import com.myshop.yura.DAO.LotDAO;
import com.myshop.yura.entity.Lot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LotService {

    @Autowired
    private LotDAO lotDAO;

    @Transactional
    public List<Lot> getAll() {
        return lotDAO.getAll();
    }

    @Transactional
    public void removeLot(long id) {
        lotDAO.removeLot(id);
    }

    @Transactional
    public Lot getLot(long id) {
        return lotDAO.getLot(id);
    }

    @Transactional
    public void addLot(Lot lot) {
        lotDAO.addLot(lot);
    }

    @Transactional
    public void editLot(Lot lot) {
        lotDAO.addLot(lot);
    }

    @Transactional
    public List<Lot> getByName(String name) {
        return lotDAO.getByName(name);
    }

    @Transactional
    public List<Lot> getByType(String type) {
        return lotDAO.getByType(type);
    }
}
