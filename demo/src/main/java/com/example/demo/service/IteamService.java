package com.example.demo.service;

import com.example.demo.dto.IteamDTO;
import com.example.demo.dto.request.RequestSaveIteamDTO;
import com.example.demo.repo.IteamRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IteamService {



    void addIteam(RequestSaveIteamDTO iteamDTO);

    List<IteamDTO> getIteamByName(String itemName);

    List<IteamDTO> getAllItems();

    List<IteamDTO> getAllItemsActive();
}
