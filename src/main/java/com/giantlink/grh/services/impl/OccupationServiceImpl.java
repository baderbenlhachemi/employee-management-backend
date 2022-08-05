package com.giantlink.grh.services.impl;

import com.giantlink.grh.dto.mapper.OccupationMapper;
import com.giantlink.grh.dto.request.OccupationRequest;
import com.giantlink.grh.dto.response.OccupationResponse;
import com.giantlink.grh.entities.Occupation;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.NotFoundException;
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
    public OccupationResponse add(OccupationRequest occupationRequest) throws AlreadyExistsException {
        Occupation occupation = OccupationMapper.MAPPER.fromRequestToEntity(occupationRequest);
        if (occupationRepository.findByName(occupation.getName()) != null) {
            throw new AlreadyExistsException("Occupation with name " + occupation.getName() + " already exists");
        }
        occupationRepository.save(occupation);
        return OccupationMapper.MAPPER.fromEntityToResponse(occupation);
    }

    @Override
    public OccupationResponse update(Integer id, OccupationRequest occupationRequest) throws AlreadyExistsException, NotFoundException {
          Occupation occupation = OccupationMapper.MAPPER.fromRequestToEntity(occupationRequest);
            if (occupationRepository.findById(id).isPresent()) {
                occupation.setId(id);
            } else {
                throw new NotFoundException("not found");
            }
            return OccupationMapper.MAPPER.fromEntityToResponse(occupationRepository.save(occupation));
    }


    @Override
    public OccupationResponse get(Integer id) throws NotFoundException {
        Optional<Occupation> occupation = occupationRepository.findById(id);
        if (occupation.isPresent()) {
            return OccupationMapper.MAPPER.fromEntityToResponse(occupation.get());
        } else {
            throw new NotFoundException("Occupation not found");
        }
    }

    @Override
    public List<OccupationResponse> get() throws NotFoundException {
        List<Occupation> occupations = occupationRepository.findAll();
        if (occupations.isEmpty()) {
            throw new NotFoundException("Occupation not found");
        }
        return OccupationMapper.MAPPER.fromEntityListToResponse(occupations);
    }

    @Override
    public void delete(Integer id) throws NotFoundException {
        Optional<Occupation> occupation = occupationRepository.findById(id);
        if (occupation.isPresent()) {
            occupationRepository.delete(occupation.get());
        } else {
            throw new NotFoundException("Occupation not found");
        }
    }

    @Override
    public OccupationResponse getByName(String name) throws NotFoundException {
        if (occupationRepository.findByName(name) == null) {
            throw new NotFoundException("Occupation not found");
        }
        return OccupationMapper.MAPPER.fromEntityToResponse(occupationRepository.findByName(name));
    }
}

