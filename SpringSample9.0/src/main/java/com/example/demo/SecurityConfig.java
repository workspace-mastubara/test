package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Bean
	//ビークリプト　=　ハッシュ値
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Autowired
	private DataSource dataSource;

	private static final String USER_SQL = "SELECT user_id, password, true "
			+ "FROM m_user "
			+ "WHERE user_id = ?";

	private static final String ROLE_SQL = "SELECT user_id, role "
			+ "FROM m_user "
			+ "WHERE user_id = ?";

	@Override
	//cssには適用しない
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/webjars/**", "/css/**");
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/webjars/**").permitAll()
		.antMatchers("/css/**").permitAll()
		.antMatchers("/login").permitAll()
		.antMatchers("/signup").permitAll()		//上記までアクセス許可
		.antMatchers("/admin").hasAuthority("ROLE_ADMIN")	//アドミン専用画面はADMIN_ROLEだけ見れる
		.anyRequest().authenticated();			//それ以外は直リンク禁止

		http.formLogin()
		.loginProcessingUrl("/login")			//Login処理をするURL　htmlのformのaction名と一致→コントローラーのgetメソッド
		.loginPage("/login")					//デフォルト設定から変更、コントローラーのGetMapping（）と一致
		.failureUrl("/login")					//login失敗の場合の遷移先
		.usernameParameter("userId")			//ログイン画面での入力内容を記述、htmlのname属性と一致
		.passwordParameter("password")
		.defaultSuccessUrl("/home", true);		//ログイン成功後の遷移先

		http.logout()
		//GETメソッドで送るため
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		//POSTメソッドでログアウトする場合
		.logoutUrl("/logout")
		//成功時の遷移
		.logoutSuccessUrl("/login");

		//CSRF対策　一時的に無効
		http.csrf().disable();
	}

	@Override
	//Spring認証処理用
	//USER_SQL＝ユーザーID、パスワード、使用可否
	//ROLE_SQL＝ユーザーID、権限
	//上のhttp.formLoginにユーザーIDとパスワードを入力することを定義しているから出来ること
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery(USER_SQL)
		.authoritiesByUsernameQuery(ROLE_SQL)
		//DBにハッシュ値ではいっているとき、自動で平文に直す
		.passwordEncoder(passwordEncoder());
	}




}
