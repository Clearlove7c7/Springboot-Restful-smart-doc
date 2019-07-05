# Springboot-Restful-smart-doc
Springboot使用smart-doc生成Restful接口文档

# 一、准备工作
#### 1、创建一个springboot项目,引入基本的依赖
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<!--文档生成工具-->
		<!-- https://mvnrepository.com/artifact/com.github.shalousun/smart-doc -->
		<dependency>
			<groupId>com.github.shalousun</groupId>
			<artifactId>smart-doc</artifactId>
			<version>1.6</version>
		</dependency>
#### 2、生成API文档注释规范
    /**
     * 注释内容
     */
必须使用标准的Java注释规范,否则生成文档不会创建注释
# 二、新建基础实体model类、控制器controller类
##### User.class
```
public class User {
    /**
     * 主键id
     */
    @NotNull// 有此注释生成文档require=true
    private int id;
    /**
     * 用户账号
     */
    private String account;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户姓名
     */
    private String name;
    /**
     * 用户年龄
     */
    private int age;
    /**
     * 用户爱好
     */
    private String hobby;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
```
##### UserController.class
```
@RestController
public class UserController {
    /**
     * 新增用户
     * @param user 用户实体类
     */
    @PostMapping("/add")
    public void addUser(User user){
        System.out.println("新增一个用户");

    }

    /**
     * 查询一个用户
     * @param id 用户id
     * @return
     */
    @GetMapping
    public User getUser(int id){
        User user = new User();
        user.setAccount("admin");
        user.setPassword("123456");
        user.setAge(18);
        return user;
    }
}
```
# 三、测试生成接口文档
* 新建一个单元测试类,运行
```
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
```
### 运行单元测试后生成的文档会在指定输出的目录下。
