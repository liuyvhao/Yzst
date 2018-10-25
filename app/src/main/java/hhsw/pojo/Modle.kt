package hhsw.pojo

//公告
data class Bulletin(var title: String)

//交费记录
data class Record(var year: String, var water: String, var pay: String, var img: String, var name: String, var time: String, var money: String)

//政府法规
data class Law(var img: String, var name: String, var info: String, var time: String)

//服务指南
data class Service(var text: String)