package com.psj.user.designpattern.mydisign;

/**
 * @author pengshj
 * @version 1.0
 * @date 2025/3/7-9:19
 * @description TODO
 */
public class PayChannelEnum {

    ZFB_PAY(0, "支付宝支付"),
    WX_PAY(1, "微信支付"),
    BANK_PAY(2, "银行卡支付");

    private int code;

    private String desc;

    PayChannelEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 根据code值获取渠道枚举
     */
    public static com.psj.user.designpattern.stragetypattern.PayChannelEnum getByCode(int codeVal) {
        for (com.psj.user.designpattern.stragetypattern.PayChannelEnum payChannelEnum : com.psj.user.designpattern.stragetypattern.PayChannelEnum.values()) {
            if (payChannelEnum.code == codeVal) {
                return payChannelEnum;
            }
        }
        return null;
    }

}
