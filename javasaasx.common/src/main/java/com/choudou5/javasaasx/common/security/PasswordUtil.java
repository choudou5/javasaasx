package com.choudou5.javasaasx.common.security;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringEscapeUtils;

/**
 * 密码 工具类
 * @author xuhaowende
 * @date 2017年5月12日
 */
public class PasswordUtil {

	public static final String HASH_ALGORITHM = "SHA-1";
	public static final String MD5_ALGORITHM = "MD5";
	public static final int HASH_INTERATIONS = 1024;
	
	/**
	 * 生成安全的密码，生成随机的16位salt并经过1024次 sha-1 hash
	 */
	public static String entryptPassword(String plainPassword) {
		String plain = StringEscapeUtils.unescapeHtml(plainPassword);
		byte[] salt = DigestUtils.md5(plain);
		byte[] hashPassword = DigestUtils.sha1(plain.getBytes());
		return DigestUtils.sha1Hex(salt)+DigestUtils.sha1Hex(hashPassword);
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
		System.out.println(validatePassword("111111", "ac44151dd474f7ed99673cae636d45f34f714df36bb4837eb74329105ee4568dda7dc67ed2ca2ad9"));
	}
	
	
}
