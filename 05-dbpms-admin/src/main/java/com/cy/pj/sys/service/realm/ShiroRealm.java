package com.cy.pj.sys.service.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 创建realm类型，并在此类型的对象中定义认证和授权数据获取逻辑
 */
public class ShiroRealm extends AuthorizingRealm {//AuthorizingRealm继承了AuthenticatingRealm
    /**负责获取并封装授权信息*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
    /**负责获取并封装认证信息*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1.获取用户登录时提交的用户名
        //2.基于用户名查询用户信息并校验
        //3.封装查询到的用户信息并返回(交给调用者)
        //将封装好的数据交给securitymanager进行认证
        return null;
    }

    /**获取凭证匹配器(加密策略)，使用什么算法和策略对密码进行加密*/
    @Override
    public CredentialsMatcher getCredentialsMatcher() {
        //...
        return null;
    }
}
