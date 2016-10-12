package com.tomasky.fqxz.vo;


import java.util.List;

/**
 * Create by jame
 * Date: 2016/4/14
 * Version: 1.0
 * DOTO: 阐述
 */
public class GetRoomTypeData {
    private List<RoomTypeInfo> list;
    private String type;
    private Integer status;
    private String message;

    public GetRoomTypeData() {
        super();
    }

    public List<RoomTypeInfo> getList() {
        return list;
    }

    public void setList(List<RoomTypeInfo> list) {
        this.list = list;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
