package com.ar.pay.wechatshare.utils;

/**
 * author：Administrator on 2017/3/1 13:42
 * company: xxxx
 * email：1032324589@qq.com
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * md5工具类
 *
 * @author xiaoke
 *
 */
public class MD5Util {
    /**
     *
     * @param psdMD5要加密的对象
     * @returnMD5加密后市返回一个32位数的字符串，返回“”，代表加密异常
     */
    public static String md5Code(String psd) {
        try {
// 加盐
            psd = psd + "abc";
// 1，获取加密算法对象，单利设计模式
            MessageDigest instance = MessageDigest.getInstance("MD5");
// 2，通过加密算法操作，对psd进行哈希加密操作
            byte[] digest = instance.digest(psd.getBytes());
            StringBuffer sb = new StringBuffer();
// 循环16次
            for (byte b : digest) {
// 获取b的后8位
                int i = b & 0xff;
// 将10进制数，转化为16进制
                String hexString = Integer.toHexString(i);
// 容错处理，长度小于2的，自动补0
                if (hexString.length() < 2) {
                    hexString = "0" + hexString;
                }
// 把生成的32位字符串添加到stringBuffer中
                sb.append(hexString);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
