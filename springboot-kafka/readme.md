<h>项目介绍：</h>
是一个单独的子模块，用于研究消息队列kafka

<br/>
项目启动：
<br>
先启动Zookeeper：
首先下载Zookeeper，解压后是一个文件夹，放到指定的目录即可：

进入Zookeeper安装目录：
	D:\develop\developTools\apache-zookeeper-3.6.0-bin

找到conf文件夹，备份：zoo_sample.cfg后，将zoo_sample.cfg改为zoo.cfg，然后更改一下几个部分的内容：

dataDir=D:/develop/developTools/apache-zookeeper-3.6.0-bin/data
dataLogData=D:/develop/developTools/apache-zookeeper-3.6.0-bin/logs


然后，编辑环境变量：

ZOOKEEPER_HOME,值为：D:\develop\developTools\apache-zookeeper-3.6.0-bin
在path后新增：%ZOOKEEPER_HOME%\bin


cmd打开，输入zkserver即可启动Zookeeper


再启动kafka：
当kafka下载完毕后，解压到指定的目录：注意，kafka文件夹所在的文件夹层级不要过深，放在了d盘：D:\kafka_2.12-2.5.0

	进入到kafka安装的目录，cmd命令下执行：.\bin\windows\kafka-server-start.bat .\config\server.properties

	即可。kafka启动后，默认的端口为：9092 
