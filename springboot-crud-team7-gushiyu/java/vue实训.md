### 1.	添加MyBatis Generator

MyBatis Generator封装好CRUD  不需要再自己手写，只需要调用即可

xxxMapper.xxx()

1.pom 添加插件

```pom.xml
<plugin>
                <groupId>org.mybatis.generator</groupId>
                <artifactId>mybatis-generator-maven-plugin</artifactId>
                <version>1.3.7</version>
</plugin>
<configuration>
					<configurationFile>${basedir}/src/main/resources/generator/generatorConfig.xml</configurationFile>
					<overwrite>true</overwrite>
					<verbose>true</verbose>
</configuration>            
```

2.resources文件夹添加 generatorConfig.xml  文件

```resources/generatorConfig.xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
        PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">

<generatorConfiguration>
    <classPathEntry location="D:\maven\apache-maven-3.6.1\repository\mysql\mysql-connector-java\5.1.48" />

    <context id="DB2Tables" targetRuntime="MyBatis3">
        <jdbcConnection driverClass="com.mysql.jdbc.Driver"
                        connectionURL="jdbc:mysql://localhost:3306/community?characterEncoding=UTF-8"
                        userId="root"
                        password="root">
        </jdbcConnection>

        <javaTypeResolver >
            <property name="forceBigDecimals" value="false" />
        </javaTypeResolver>

        <javaModelGenerator targetPackage="com.blog.model" targetProject="src/main/java">
            <property name="enableSubPackages" value="true" />
            <property name="trimStrings" value="true" />
        </javaModelGenerator>

        <sqlMapGenerator targetPackage="mapper"  targetProject="src/main/resources">
            <property name="enableSubPackages" value="true" />
        </sqlMapGenerator>

        <javaClientGenerator type="XMLMAPPER" targetPackage="com.blog.mapper"  targetProject="src/main/java">
            <property name="enableSubPackages" value="true" />
        </javaClientGenerator>

        <table  tableName="user" domainObjectName="User" >
         </table>

    </context>
</generatorConfiguration>
```



3.Terminal执行   数据库执行  更新数据库

```
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
```

4.BlogApplication主程序添加注解

```
@MapperScan("com.blog.mapper")
```

5.application.properties

```application.properties
#generatorConfig.xml
mybatis.type-aliases-package=com.vue.mapper
mybatis.mapper-locations=classpath:mapper/*.xml
#数据库
spring.datasource.url=jdbc:mysql://localhost:3306/vue?characterEncoding=UTF-8     
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
```

6.

```SessionInterceptor.java
                            //1.创建userExample
                            UserExample userExample = new UserExample();
                            //2.创建规则(Criteria)   andTokenEqualTo(token) ：与token值相等
                            userExample.createCriteria().andTokenEqualTo(token);
                            //3.select * from user where userExample=userExample;
                            List<User> user=userMapper.selectByExample(userExample);
```



分页功能：

```generatorConfig.xml
<plugin type="org.mybatis.generator.plugins.RowBoundsPlugin"></plugin>
```

```QuestionService.java
questionMapper.selectByExampleWithBLOBsWithRowbounds(new QuestionExample(), new RowBounds(offset, size));
```

------

