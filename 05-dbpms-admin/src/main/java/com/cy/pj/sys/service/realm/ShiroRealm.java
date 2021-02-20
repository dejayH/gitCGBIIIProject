package com.cy.pj.sys.service.realm;

import com.cy.pj.sys.dao.SysUserDao;
import com.cy.pj.sys.pojo.SysUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 创建realm类型，并在此类型的对象中定义认证和授权数据获取逻辑
 */
public class ShiroRealm extends AuthorizingRealm {//AuthorizingRealm继承了AuthenticatingRealm
    @Autowired
    private SysUserDao sysUserDao;

    /**
     * 负责获取并封装授权信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 负责获取并封装认证信息,不进行密码比对
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1.获取用户登录时提交的用户名
        UsernamePasswordToken uToken = (UsernamePasswordToken) authenticationToken;
        String username = uToken.getUsername();
        //2.基于用户名查询用户信息并校验
        SysUser user = sysUserDao.selectUserByUsername(username);
        if(user == null) {
            throw new UnknownAccountException();
        }
        if(user.getValid() == 0) {
            throw new LockedAccountException();
        }
        //3.封装查询到的用户信息并返回(交给调用者)
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt());
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
                user,user.getPassword(),credentialsSalt,this.getName());
        //将封装好的数据交给securitymanager进行认证
        return info;
    }

    /**
     * 获取凭证匹配器(加密策略)，使用什么算法和策略对密码进行加密
     */
    @Override
    public CredentialsMatcher getCredentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        //设置加密算法
        matcher.setHashAlgorithmName("MD5");
        //设置加密次数
        matcher.setHashIterations(1);
        return matcher;
    }
}
