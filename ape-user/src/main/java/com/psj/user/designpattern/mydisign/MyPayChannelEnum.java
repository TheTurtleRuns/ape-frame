package com.psj.user.designpattern.mydisign;

/**
 * @author pengshj
 * @version 1.0
 * @date 2025/3/7-9:19
 * @description TODO
 */
public enum MyPayChannelEnum {

    ZFB_PAY(0, "支付宝支付"),
    WX_PAY(1, "微信支付"),
    BANK_PAY(2, "银行卡支付");

    private int code;

    private String desc;

    MyPayChannelEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 根据code值获取渠道枚举
     * @return
     */
    public static MyPayChannelEnum getByCode(int codeVal) {
        for (MyPayChannelEnum myPayChannelEnum : MyPayChannelEnum.values()) {
            if (myPayChannelEnum.code == codeVal) {
                return myPayChannelEnum;
            }
        }
        return null;
    }

}
