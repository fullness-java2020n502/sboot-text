package com.fullnesssboot2.text;

import com.fullnesssboot2.text.service.AccountDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    AccountDetailsService accountDetailsService;
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Autowired
    public void configureAuthenticationManager(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(accountDetailsService).passwordEncoder(passwordEncoder());
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web.ignoring().antMatchers("/public/**");
    }
    @Override
    public void configure(HttpSecurity http) throws Exception{
        // アクセス制限設定
        http.authorizeRequests()
                .antMatchers("/","/login").permitAll() // いつでも許可
                .antMatchers("/menu","/logout").authenticated() // ログイン時に許可
                .antMatchers("/admin","/admin/**").hasRole("ADMIN")// ロール毎の許可
                .antMatchers("/**").denyAll(); // それ以外はアクセス許可しない（認証が必要
        http.formLogin()
                .loginPage("/login") // ログイン画面のURL
                .loginProcessingUrl("/authenticate") // 認証処理URL
                .usernameParameter("username") // ユーザ名のパラメータ名（HTMLのtextboxのname属性と合わせる）
                .passwordParameter("password") // パスワードのパラメータ名（HTMLのtextboxのname属性と合わせる）
                .defaultSuccessUrl("/menu",true) // 認証成功時のURL
                .failureUrl("/login") // 認証失敗時のURL
                .permitAll(); // ログイン認証はいつでも許可
        http.logout()
                .logoutUrl("/logout") // ログアウトURL
                .logoutSuccessUrl("/login") // ログアウト成功時のURL
                .invalidateHttpSession(true) // セッション破棄
                .deleteCookies("JSESSIONID") // 引数のCookie名のものを破棄
                .clearAuthentication(true) // 認証情報をクリア
                .permitAll(); // いつでもログアウトは許可
    }
}
