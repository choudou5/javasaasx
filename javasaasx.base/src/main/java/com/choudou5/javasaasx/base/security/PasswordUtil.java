package com.choudou5.javasaasx.base.security;

import cn.hutool.core.util.EscapeUtil;
import com.choudou5.base.util.EncryptUtil;

/**
 * 密码 工具类
 * @author xuhaowende
 * @date 2017年5月12日
 */
public class PasswordUtil {

	/**
	 * 生成安全的密码，组合密码
	 */
	public static String entryptPassword(String plainPassword) {
		String plain = EscapeUtil.unescape(plainPassword);
		String salt = EncryptUtil.md5(plain);
		String hashPassword = EncryptUtil.sha1(plain);;
		return EncryptUtil.sha1(salt)+hashPassword;
	}
	
	/**
	 * 验证密码
	 * @param plainPassword 明文密码
	 * @param password 密文密码
	 * @return 验证成功返回true
	 */
	public static boolean validatePassword(String plainPassword, String password) {
		return password.equals(entryptPassword(plainPassword));
	}
	
	/* ================= test ================= */
	public static void main(String[] args) {
		System.out.println(entryptPassword("111111"));
		System.out.println(validatePassword("111111", "29be0977d967fde83ce1b8657334ec4db7fdc8a53d4f2bf07dc1be38b20cd6e46949a1071f9d0e3d"));
	}
	
	
}
