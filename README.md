# SpringBeanUtil
 操作spring bean的工具类，主要用于想通过代码来获取bean，bean必须是spring容器管理的bean
 
需要把该该类注册到spring容器中，例如在applicationContext.xml中这样子注册
```
 <bean id = "springBeanUtil" class = "com.liuxg.util.bean.SpringBeanUtil"/> 
```
或者以java config的方式这样子配置
```
@Configuration
public class AppConfig {
	
	@Bean
	public SpringBeanUtil springBeanUtil(){
		 return new SpringBeanUtil();
	}

}
```
