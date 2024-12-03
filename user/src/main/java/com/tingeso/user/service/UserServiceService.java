package com.tingeso.user.service;

import com.tingeso.user.entity.UserEntity;
import com.tingeso.user.repository.UserRepository;
import com.tingeso.user.model.LoanModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RestTemplate restTemplateConfig;

    public ArrayList<UserEntity> getUsers(){
        return (ArrayList<UserEntity>) userRepository.findAll();
    }

    public String getState(String rut){
        return userRepository.findByState(rut);
    }

    public UserEntity findByRut(String rut){
        return userRepository.findByRut(rut);
    }

    public void saveUser(UserEntity user){
        userRepository.save(user);
    }

    public void deleteUsers{
        userRepository.deleteAll();
    }

    public List<LoanModel> getLoansByRut(String rut) {
        List<LoanModel> loans = restTemplateConfig.getForObject("http://loan-service/loan/byUsers/" + rut, List.class);
        return loans;
    }



}