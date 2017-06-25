# MovieTime FrondEnd
这是系统分析与设计课程大作业的电影购票系统的前端代码。   

这些代码已经写成thymeleaf模板的形式，可以被thymeleaf直接使用。

代码库中还包含了一些资源文件。

## 启动方式
将template文件夹复制到测试用服务器的 /movietimes/src/main/webapp/WEB-INF 目录下

> 在movieTimes文件夹根目录下执行以下命令：   
> jetty:run   

> 在浏览器中打开 http://localhost:8080/     

## 目录结构
-  /templates：存放各页面.html模板文件
-  /templates/css：放置各页面对应的css文件   
-  /templates/js：放置各页面对应的javascript文件   
-  /templates/images：放置各页面对应的图片资源文件   

## 使用技术   
#### jQuery

为bootstrap提供依赖，简化代码编写。   
[主页：http://jquery.com/](http://jquery.com/)   

#### Bootstrap   

主要用于提供一些风格良好的定制组件、提供栅格布局系统。
[主页：http://v3.bootcss.com/](http://v3.bootcss.com/)   

#### lodash   
简化代码编写。
[主页：https://lodash.com/](https://lodash.com/)   

#### Thymeleaf   
模板引擎。 允许我们在页面中设置由服务端指定的变量。允许通过循环/选择等结构性方法输出页面元素。
[主页：http://www.thymeleaf.org/](http://www.thymeleaf.org/)   

## 注意事项   
#### 代码正确   
请使用Web课学过的[HTML Validator](http://validator.w3.org)和 [CSS Validator](http://jigsaw.w3.org/css-validator/)检验代码正确性，保证commit的代码没有错误，且页面运行时Chrome console没有error。

#### 代码规范   
遵守[HTML和CSS规范](http://codeguide.bootcss.com)、[ES6规范](http://es6.ruanyifeng.com)

#### 兼容性   
请首先保证commit的内容在最新版本的Chrome下显示正常。此外在最后整合时还需要检查Edge、Firefox等主流浏览器的兼容性。



## 页面流程图

![Page Flow diagram](images-for-readme/pageFlowDiagram.png)

## License

See the [LICENSE](./LICENSE) file for license rights and limitations.
