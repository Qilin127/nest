package com.nest.renting.common.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.nest.renting.web.*.mapper")
public class MybatisPlusConfiguration {

}
