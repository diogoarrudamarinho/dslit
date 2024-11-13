package com.projeto.dslist.dto;

import com.projeto.dslist.entities.Game;
import com.projeto.dslist.projections.GameMinProjection;

public class GameMinDTO {
    
    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO(){
    }

    public GameMinDTO(Game entity) {
        this.id = entity.getId();
        this.imgUrl = entity.getImgUrl();
        this.year = entity.getYear();
        this.shortDescription = entity.getShortDescription();
        this.title = entity.getTitle();
    }

    public GameMinDTO(GameMinProjection projection) {
        this.id = projection.getId();
        this.imgUrl = projection.getImgUrl();
        this.year = projection.getYear();
        this.shortDescription = projection.getShortDescription();
        this.title = projection.getTitle();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }


    
}
