package com.kalffman.projetos.planner.api.dto;

import org.springframework.hateoas.RepresentationModel;

public abstract class ResourceModel<T extends RepresentationModel<? extends T>> extends RepresentationModel<T> {
    public abstract <E> E identifier();
}
