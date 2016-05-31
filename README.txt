打印收银小票模块

平台及使用工具	1
总体设计	1
四个子模块具体实现	3
运行截图	5


平台及使用工具
MyEclipse 2014
Maven 3.3.9
Spring 4.1.5
Junit 4.11
log4j 1.2.11
json 20151123


总体设计:
	该项目共分为六个子模块，分别是输入模块、处理模块、输出模块、商品及目录管理模块、测试模块和日志模块
	输入模块实现可以选择文件输入和控制台输入两种方式，在配置文件（spring的配置文件，属性和对象通过spring依赖出入，以下提到的配置文件都是指spring的配置文件，在classpath的根目录下，文件名applicationContext.xml）中配置
 
输入成功后会返回所有条形码的jsonArray格式数据，用于处理模块处理。

	处理模块实现了对jsonArray数据的处理和买三减一的处理，并返回处理完的输出链表和价格总计。可以使用更多的优惠方式，只需要继承优惠处理接口，并实现具体的方法，并修改工厂类即可。不需修改其他代码，增加了代码的可拓展性。该项可在配置文件中配置：
 

	输出模块实现了对处理完的输出链表和价格总计进行字符串化，并输出到文件或者控制台，该项在配置文件中配置。
 

	商品及目录管理模块实现了商店的商品和目录的管理，全部信息均在配置文件中配置，默认添加了四个目录：
 
和四种商品：
 
	测试模块，完成了对输入、处理和输出的基础功能测试，由于时间比较紧张，实验室的项目近期要交付了，所以比较忙，没有写出更多的测试用例和压力测试等，对此我以后一定尽力改正。
 
日志模块实现了两个文件日志输出：
 
默认生成在classpath根目录下。
一个控制台输出，控制台只输出error日志。
 


四个子模块具体实现：
1、	输入模块。
 
包括：
一个输入接口类：BarcodesInput.java，定义了一个输入数据的接口方法
一个输入具体实现类的创建工厂：InputFactory.java，用于根据需要创建具体输入实现类
一个输入具体类的父类：BarcodesInputBaseClass.java，给出了通用的条形码格式和合法性检查方法
两个具体实现类：BarcodesInputFromConsole.java 从控制台输入具体实现类  BarcodesInputFromFile.java  从文件输入具体实现类

2、	处理模块。
 
包括：
一个处理接口类：ReceiptCompute.java 定义了json数据处理和优惠方式处理的接口
一个根据具体优惠配置生成具体实现类的工厂ReceiptComputeFactory.java
一个具体实现的基类：ReceiptComputeBaseClass.java
一个买三减一的实现类：ReceiptComputeBuyThreeFreeOne.java
3、	输入模块。
 
包含：
一个输出接口：OutputResult.java
一个接口生产工厂：OutputFactory.java
一个输出基类：outputBaseClass.java
两个输出实现类：OutputResultToConsole.java  OutputResultToFile.java
4、	商品和目录管理类
 
包含：
商品和目录管理接口：GoodsAndCategoryManager.java
商品和目录管理实现类：GoodsAndCategoryManagerImpl.java
5、	测试
 
包含：
输入测试
处理测试
输出测试


运行截图：
文件输入
 
控制台输入
 
输出到控制台
 
输出到文件：
 
 
