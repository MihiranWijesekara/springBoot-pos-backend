package com.example.demo.service.Impl;

import com.example.demo.dto.IteamDTO;
import com.example.demo.dto.request.RequestSaveIteamDTO;
import com.example.demo.entity.Iteam;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repo.IteamRepo;
import com.example.demo.service.IteamService;
import com.example.demo.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IteamServiceIMPL implements IteamService {

    @Autowired
    private IteamRepo iteamRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public void addIteam(RequestSaveIteamDTO requestSaveiteamDTO) {
          Iteam item = itemMapper.requestDtoToEntity(requestSaveiteamDTO);
          item.setActiveState(false);
          if(!iteamRepo.existsById(item.getItemId())) {
              iteamRepo.save(item);
          } else {
              System.out.println("Iteam with ID " + item.getItemId() + " already exists.");
          }
    }

    @Override
    public List<IteamDTO> getIteamByName(String itemName) {
        List<Iteam> items = iteamRepo.findAllByItemNameIs(itemName);
        List<IteamDTO>iteamDTOS = itemMapper.entityListToDtoList(items);

        return iteamDTOS;
    }

    @Override
    public List<IteamDTO> getAllItems() {
        List<Iteam> items = iteamRepo.findAllByActiveStateIs( false);
        if (items.size() > 0) {

            List<IteamDTO> iteamDTOS = itemMapper.entityListToDtoList(items);
            return iteamDTOS;
        }
        throw new NotFoundException("No data founds");

    }

}
