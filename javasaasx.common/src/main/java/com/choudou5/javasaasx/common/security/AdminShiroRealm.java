package com.choudou5.javasaasx.common.security;

import cn.hutool.core.lang.Validator;
import com.choudou5.javasaasx.common.constants.SysConsts;
import com.choudou5.javasaasx.service.sys.SysUserService;
import com.choudou5.javasaasx.service.sys.bo.LoginUserBo;
import com.choudou5.javasaasx.service.sys.bo.SysUserBo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Desc: 授权查询领域
 * User: xuhaowende
 * Time: 2017/12/18
 */
public class AdminShiroRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService userService;

    /**
     * 获取授权信息 
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用,负责在应用程序中决定用户的访问控制的方法
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
        LoginUserBo user = (LoginUserBo) SecurityUtils.getSubject().getSession().getAttribute(SysConsts.USER_SESSION);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.addRole(StringUtils.join(user.getRoleIds()));
        return info;
    }

    /**
     * 获取认证信息
     * 认证回调函数，登录信息和用户验证信息验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {
        // 把token转换成User对象
        LoginUserBo userLogin = tokenToUser((UsernamePasswordToken) authcToken);
        // 验证用户是否可以登录
        SysUserBo user = null;
        try {
            if(Validator.isEmail(userLogin.getAccount())){
                user = userService.getByEmail(userLogin.getAccount());
            }else if(Validator.isMobile(userLogin.getAccount())){
                user = userService.getByMobile(userLogin.getAccount());
            }
        } catch (Exception e) {
            throw new AuthenticationException(e.getMessage());
        }
        if(user == null || user.getId() == null)
            throw new AuthenticationException("用户不存在！");
        if(!PasswordUtil.validatePassword(userLogin.getPassword(), user.getPassword())){
            throw new AuthenticationException("账户或者密码错误！");
        }
        // 设置session
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute(SysConsts.USER_SESSION, user.baseLoginInfo());
        //当前 Realm 的 name
        String realmName = this.getName();
        //登陆的主要信息: 可以是一个实体类的对象, 但该实体类的对象一定是根据 token 的 username 查询得到的.
//      Object principal = ui.getUsername();
        Object principal = authcToken.getPrincipal();
        return new SimpleAuthenticationInfo(principal, userLogin.getPassword(), realmName);
    }

    private LoginUserBo tokenToUser(UsernamePasswordToken authcToken) {
        LoginUserBo user = new LoginUserBo();
        user.setAccount(authcToken.getUsername());
        user.setPassword(String.valueOf(authcToken.getPassword()));
        return user;
    }

    //一定要写getset方法
    public SysUserService getUserService() {
        return userService;
    }

    public void setUserService(SysUserService userService) {
        this.userService = userService;
    }
}

