package com.cwkim723.springbootstudy.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) // 어노테이션이 생성될 수 있는 위치 지정, 메소드 파라미터
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {

}
