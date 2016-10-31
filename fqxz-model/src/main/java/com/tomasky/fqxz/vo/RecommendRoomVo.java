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
//    private Double price;//价格
    private Long roomId;//房型编号
    private String bedTypeName;//床型名称
    private String floorNum;//楼层数
    private Double roomArea;//房间面积
    private String img;//封面图片


    public String getBedTypeName() {
        return bedTypeName;
    }

    public void setBedTypeName(String bedTypeName) {
        this.bedTypeName = bedTypeName;
    }

    public String getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(String floorNum) {
        this.floorNum = floorNum;
    }

    public Double getRoomArea() {
        return roomArea;
    }

    public void setRoomArea(Double roomArea) {
        this.roomArea = roomArea;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

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


    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
}
