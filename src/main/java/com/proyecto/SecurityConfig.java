/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("ADMIN")
                    .password("{noop}123")
                    .roles("ADMIN","USER")
                .and()
                .withUser("Juan")
                    .password("{noop}123")
                    .roles("USER")
                .and()
                .withUser("David")
                    .password("{noop}123")
                    .roles("USER");
    }
  
    //Definir config accesos
    @Override
    protected void configure(HttpSecurity http)throws Exception {
        http.authorizeRequests()
                .antMatchers("/auto/nuevo",          "/auto/guardar",
                             "/auto/modificar/**",   "auto/eliminar/**",
                             "/cabana/nuevo",         "/cabana/guardar",
                             "/cabana/modificar/**",  "cabana/eliminar/**",
                             "/casa/nuevo",           "/casa/guardar",
                             "/casa/modificar/**",    "casa/eliminar/**",
                             "/cliente/nuevo",           "/cliente/guardar",
                             "/cliente/modificar/**",    "cliente/eliminar/**")
                       .hasRole("ADMIN")
                .antMatchers("/auto/listado",        "/casa/listado",
                             "/cabana/listado")
                       .hasAnyRole("ADMIN")
                .antMatchers("/")
                       .hasAnyRole("ADMIN", "USER")
                .and()
                    .formLogin()
                    .loginPage("/login")
                .and()
                    .exceptionHandling().accessDeniedPage("/errores/403");
    }
}