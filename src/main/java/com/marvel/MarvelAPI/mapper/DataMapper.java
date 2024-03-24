package com.marvel.MarvelAPI.mapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.marvel.MarvelAPI.dto.APIResponseDTO;
import com.marvel.MarvelAPI.model.APIResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataMapper {
    public APIResponseDTO buildDataDTO(APIResponse data){
        return new APIResponseDTO(data.getCode(),data.getStatus(),data.getCopyright(),data.getAttributionText(),data.getAttributionHTML(),data.getData());
    }
}
