package com.giantlink.grh.services;

import com.giantlink.grh.entities.Occupation;

import java.util.List;

public interface OccupationService {

    Occupation add(Occupation occupation);

    Occupation update(Integer id, Occupation occupation);

    Occupation get(Integer id);

    Occupation get(String name);

    List<Occupation> get();

    void delete(Integer id);

}
