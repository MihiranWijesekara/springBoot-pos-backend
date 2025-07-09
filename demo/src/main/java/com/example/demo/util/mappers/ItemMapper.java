package com.example.demo.util.mappers;

import com.example.demo.dto.IteamDTO;
import com.example.demo.dto.request.RequestSaveIteamDTO;
import com.example.demo.entity.Iteam;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper{
    Iteam requestDtoToEntity(RequestSaveIteamDTO requestSaveIteamDTO );
    List<IteamDTO>  entityListToDtoList(List<Iteam>items);
    ;

}
