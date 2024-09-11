package com.psj.user.service.impl;

import com.psj.user.designpattern.stragetypattern.PayHandlerDemo;
import com.psj.user.entity.po.SysUserPo;
import com.psj.user.mapper.SysUserMapper;
import com.psj.user.service.SysUserService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.MessageDigest;

/**
 * @author pengshj
 * @version 1.0
 * @date 2023/10/9-15:57
 * @description TODO
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private com.psj.user.designpattern.stragetypattern.PayHandlerDemo PayHandlerDemo;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return sysUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysUserPo record) {
        return sysUserMapper.insert(record);
    }

    @Override
    public int insertSelective(SysUserPo record) {
        return sysUserMapper.insertSelective(record);
    }

    @Override
    @Cacheable(cacheNames = "sysUser",key ="'byId'+#id")
    public SysUserPo selectByPrimaryKey(Long id) {
        PayHandlerDemo.dealPay(0);
        return sysUserMapper.selectByPrimaryKey(id);
    }



    public static void main(String[] args) {
        String input = "33001200000";
        String output = input.replaceAll("0+(?=[^0]*$)", "");
        System.out.println(output); // 输出: 123
    }


   /* public static void main(String[] args) {





        String pwd="414517712200826";
        //用于加密的字符
        char[] md5String = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            //使用平台的默认字符集将此 String 编码为 byte序列，并将结果存储到一个新的 byte数组中
            byte[] btInput = pwd.getBytes();

            //信息摘要是安全的单向哈希函数，它接收任意大小的数据，并输出固定长度的哈希值。
            MessageDigest mdInst = MessageDigest.getInstance("MD5");

            //MessageDigest对象通过使用 update方法处理数据， 使用指定的byte数组更新摘要
            mdInst.update(btInput);

            // 摘要更新之后，通过调用digest（）执行哈希计算，获得密文
            byte[] md = mdInst.digest();

            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {   //  i = 0
                byte byte0 = md[i];  //95
                str[k++] = md5String[byte0 >>> 4 & 0xf];    //    5
                str[k++] = md5String[byte0 & 0xf];   //   F
            }
            //返回经过加密后的字符串
            System.out.println(str);
        } catch (Exception e) {
             ;
        }
    }


*/

    @Override
    public int updateByPrimaryKeySelective(SysUserPo record) {
        return sysUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysUserPo record) {
        return sysUserMapper.updateByPrimaryKey(record);
    }

}


