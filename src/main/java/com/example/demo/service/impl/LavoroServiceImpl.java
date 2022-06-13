package com.example.demo.service.impl;

import com.example.demo.dao.LavoroDao;
import com.example.demo.model.Lavoro;
import com.example.demo.service.LavoroService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LavoroServiceImpl implements LavoroService {
    private final LavoroDao lavoroDao;
    public LavoroServiceImpl(LavoroDao lavoroDao) {
        this.lavoroDao = lavoroDao;
    }
    @Override
    public Lavoro save(Lavoro lavoro) {
        return lavoroDao.save(lavoro);
    }
    @Override
    public Optional<Lavoro> findById(Long id) {
        return lavoroDao.findById(id);
    }
    @Override
    public void deleteById(Long id) {
        lavoroDao.deleteById(id);
    }
    @Override
    public Iterable<Lavoro> findAll() {
        return lavoroDao.findAll();
    }
}
