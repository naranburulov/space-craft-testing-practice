package com.cydeo.spacecraft.converter;

import com.cydeo.spacecraft.dto.CreateHitDTO;
import com.cydeo.spacecraft.model.request.CreateHitRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CreateHitRequestToCreateHitDtoConverter implements Converter<CreateHitRequest, CreateHitDTO> {
    @Override
    public CreateHitDTO convert(CreateHitRequest source) {
        final CreateHitDTO createHitDTO = new CreateHitDTO();
        createHitDTO.setAttackType(source.getAttackType());
        createHitDTO.setGameId(source.getGameId());
        return createHitDTO;
    }
}
