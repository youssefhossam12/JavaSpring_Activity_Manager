package com.example.activities.service;

import com.example.activities.models.Activity;
import com.example.activities.models.Host;
import com.example.activities.repository.HostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostService {

    private HostRepository hostRepository;

    @Autowired
    public HostService(HostRepository hostRepository){
        this.hostRepository = hostRepository;
    }

    public Host getHostById(Long id){
        return hostRepository.findById(id).orElseThrow();
    }

    public List<Host> GetHosts() {
        return hostRepository.findAll();
    }

    public List<Host> GetHostByAct(String name){
        return hostRepository.getByHostName(name);
    }


}
