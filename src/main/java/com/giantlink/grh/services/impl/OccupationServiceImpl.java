package com.giantlink.grh.services.impl;

import com.giantlink.grh.dto.mapper.OccupationMapper;
import com.giantlink.grh.dto.request.OccupationRequest;
import com.giantlink.grh.dto.response.OccupationResponse;
import com.giantlink.grh.entities.Occupation;
import com.giantlink.grh.repositories.OccupationRepository;
import com.giantlink.grh.services.OccupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OccupationServiceImpl implements OccupationService {

    private final OccupationRepository occupationRepository;

    @Autowired
    public OccupationServiceImpl(OccupationRepository occupationRepository) {
        this.occupationRepository = occupationRepository;
    }

    @Override
    public OccupationResponse add(OccupationRequest occupationRequest) {
        Occupation occupation = OccupationMapper.MAPPER.fromRequestToEntity(occupationRequest);
        occupationRepository.save(occupation);
        return OccupationMapper.MAPPER.fromEntityToResponse(occupation);
    }

    @Override
    public OccupationResponse update(Integer id, OccupationRequest occupationRequest) {
        Occupation occupation = OccupationMapper.MAPPER.fromRequestToEntity(occupationRequest);
        occupation.setId(id);
        occupationRepository.save(occupation);
        return OccupationMapper.MAPPER.fromEntityToResponse(occupation);
        }


    @Override
    public OccupationResponse get(Integer id) {
        Optional<Occupation> occupation = occupationRepository.findById(id);
        return OccupationMapper.MAPPER.fromEntityToResponse(occupation.get());
    }

    @Override
    public List<OccupationResponse> get() {
        List<Occupation> occupation = occupationRepository.findAll();
        return OccupationMapper.MAPPER.fromEntityListToResponse(occupation);
    }

    @Override
    public void delete(Integer id) {
        occupationRepository.deleteById(id);
    }

    @Override
    public OccupationResponse getByName(String name) {
        return OccupationMapper.MAPPER.fromEntityToResponse(occupationRepository.findByName(name));
    }

}

