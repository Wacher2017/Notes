jquery-1.12.3.js（这里以该版本的jQuery作为学习基础）

一、简介：
为了简化JavaScript的开发，一些JavaScript库诞生了。
JavaScript库封装了很多预定义的对象和实用函数。能帮助使用者建立有高难度交互的Web2.0特性的客户端页面，并且兼容各大浏览器。
当前流行的JavaScript库有：
-JQuery
-ExtJs
-Prototype
-Dojo
-AngularJs
-AppCan
-AmazeUI
-...

二、jQuery是什么？
jQuery是由美国人John Resig创建，至今已吸引了来自世界各地的众多JavaScript高手加入其team。
jQuery是维护prototype之后的又一个优秀的JavaScript框架，其宗旨是——WRITE LESS，DO MORE，写更少的代码做更多的事情。
它是轻量级的js库（压缩后只有21K）这是其他js所不及的，它兼容CSS3，还兼容各种浏览器（IE6.0+，FF1.5+，safari2.0+，Opera9.0+）。
jQuery是一个快速的，简洁的JavaScript库，使用户能方便的处理HTML、document、事件、实现动画效果，并且方便的为网站提供Ajax交互。
jQuery的文档说明很全，而且各种应用也说的很详细，同时还有很多成熟的插件可供选择。
jQuery能够使用户的html页保持代码和html内容分离，让程序具有良好的可读性。

三、学习jQuery的准备工作
学习jQuery需要掌握的知识
-HTML
-CSS
-JavaScript

开发工具
-Hbuilder
	Hbuilder是DCloud(数字天堂)推出的一款支持HTML5的web开发IDE。
	“快”是Hbuilder的最大优势，通过完整的语法提示和代码输入法、代码块及很多配套，Hbuilder能大幅度提升HTML、js、css的开发效率。

四、开发jQuery页面的步骤
利用jQuery可以将结构（HTML）、美化（CSS）与交互（JavaScript）的部分有效的分离，从而让页面得到良好的可读性。
利用jQuery开发程序的步骤如下：
1.将jquery-1.12.3.js复制到工程的js目录下；
2.在当前页面利用<script>标签引入jquery-1.12.3.js；
	在引入js后，我们的程序就增加了一个内置对象jQuery，这是jQuery的核心对象，同时jQuery的对象还可以使用美元符号$进行替代。
3.在引入后<script>标签内编写jQuery代码。