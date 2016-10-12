package com.tomasky.fqxz.vo;

/**
 * Create by jame
 * Date: 2016/10/11 17:18
 * Version: 1.0
 * Description: 阐述
 */
public class RecommendRoomVo {
    private String facilities;//配套设置
    private String name;//房间名称
    private Double price;//价格
    private Long roomId;//房型编号

    public RecommendRoomVo() {
        super();
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
}
