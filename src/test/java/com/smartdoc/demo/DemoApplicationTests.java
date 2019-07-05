package com.smartdoc.demo;

import com.power.doc.builder.ApiDocBuilder;
import com.power.doc.model.ApiConfig;
import com.power.doc.model.ApiReqHeader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
		ApiConfig config = new ApiConfig();
		// 服务地址
		config.setServerUrl("http://localhost:8080");
		// 生成一个文档
		config.setAllInOne(true);
		// 采用严格模式
		config.isStrict();
		// 文档输出路径 (对应当前项目所在的磁盘目录)
		config.setOutPath("/java/workspace/smart-doc-demo");
		// 添加请求的header
		config.setRequestHeaders(ApiReqHeader.header().setName("token").setType("string").setDesc("用户名+密码+jwt"));
		ApiDocBuilder.builderControllersApi(config);
		// 将生成的文档输出到F:\Word目录下,严格模式下api-doc会检测controller的接口注释
	}

}
