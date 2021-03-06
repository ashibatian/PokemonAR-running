# Pokemen-run
[![CodeFactor](https://www.codefactor.io/repository/github/84461810/pokemen-run/badge)](https://www.codefactor.io/repository/github/84461810/pokemen-run)

---
​		本项目“跑Kemon-Go”，通过增强现实AR技术将趣味性寓于跑步打卡软件

中，通过GPS高精度定位与服务器端的数据处理实现学生跑步情况的统计与管理，

同时实现跑步软件中游戏数据的同步与管理。



​        设想这样一个应用场景：发现一个学生用户开始跑步时，系统自动在地图的

适当地点生成虚拟宠物精灵，当学生在限定的时间内跑步至这些地点，打开手机

摄像头，就可以在虚拟现实的场景中捕捉虚拟宠物精灵。随着跑步总里程数的增

加，宠物精灵可以增加经验并升级。



​        由于本应用面向校园统一跑步的大学生和自由使用者，用户在跑步开始前可

以选择在自由跑模式和校园跑模式中切换。在自由跑模式中，系统随机生成宠物

精灵的位置，用户跑步的里程和速度没有任何的限制。在校园跑模式中，学校可

以设置指定的起点，终点，必经点，范围，系统在学校设置的必经点生成宠物精

灵。学校还可以设置跑步速度和距离的上限和下限。只有符和这些条件的情况下，

学生跑步的里程才会计入，从而完成学校设定的跑步要求。



​        在服务器端，本项目具有统计学生跑步数据，管理学生跑步完成情况的功能。

在手机端，本项目具有切换跑步模式，查看历史跑步记录，查看附近用户，用户

宠物精灵展示与对战，用户论坛交流等功能。

​            

本项目预计实现的所有功能需求如下：

1)  实时获取用户的GPS位置信息，并在APP中的地图中显示（优先级：高）

2)  根据用户定位点的移动，在APP中的地图显示跑步路线（优先级：高）

3)  用户开始跑步时，在APP中的地图显示虚拟宠物的出现位置和时间（优先

级：高）

4)  用户可以在APP内查看虚拟宠物的AR形象（优先级：高）

5)  用户登录与注册（优先级：高）

6)  服务器端用户信息记录与管理：历史跑步记录，虚拟宠物信息等（优先级：

高）

7)  服务器端更改用户跑步限制：规定总里程，合法速度，路线必经点，路线

范围（优先级：高）

8)  用户可以查看附近的用户，并添加好友（优先级：中）

9)  用户可以查看好友的用户信息：历史跑步记录，虚拟宠物信息等（优先级：

中）

10)用户可以与好友进行虚拟宠物对战（优先级：中）

用户可以在用户论坛进行交流（优先级：低）

[![image.jpg](https://i.postimg.cc/wB47z4dz/image.jpg)](https://postimg.cc/wtJ6cVv4)

[Back-end localhost cloud config repo](https://github.com/sjtu-rr-homework/test-config-localhost)

[Back-end docker cloud config repo](https://github.com/MaCoredroid/test-config-docker)

You can use docker-compose file to deploy the whole back-end , [docker hub link](https://hub.docker.com/u/macoredroid)
