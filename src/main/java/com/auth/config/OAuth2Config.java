package com.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

// generating tokens specific to a client

@Configuration
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

    public static final String CLIENT_ID = "auth-client";
    public static final String CLIENT_SECRET =  "$2a$04$QTxtNpS5BbpiJRCzdRF8zubVKETqSEEp4HZb5p7i3VwoDIO3y.1i6";// "auth-secret";
    public static final String GRANT_TYPE = "password";
    public static final String AUTH_CODE = "auth_code";
    public static final String REFRESH_TOKEN = "refresh_token";
    public static final String IMPLICIT = "implicit";
    public static final String READ = "read";
    public static final String WRITE = "write";
    public static final String TRUST = "trust";
    public static final int VAL_SEC = 3600;


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenStore tokenStore;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient(CLIENT_ID).secret(CLIENT_SECRET)
                .authorizedGrantTypes(GRANT_TYPE, AUTH_CODE, REFRESH_TOKEN, IMPLICIT)
                .scopes(READ, WRITE, TRUST).accessTokenValiditySeconds(VAL_SEC)
                .refreshTokenValiditySeconds(VAL_SEC);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore).authenticationManager(authenticationManager);
    }

}
