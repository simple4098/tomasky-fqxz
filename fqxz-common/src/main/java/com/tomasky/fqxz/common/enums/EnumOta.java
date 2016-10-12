package com.tomasky.fqxz.common.enums;

/**
 * 系统ota 枚举
 */
public enum EnumOta {
    xz(101),
    dx(102),
    xyz(106),
    kf(111),
    mt(105),
    yl(3),
    xc(2),
    qunar(1),
    qunar_conn(107),//去哪儿直连
    ctrip_conn(108),//携程直连
    ;
    private int value;

    EnumOta(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
