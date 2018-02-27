#分布式框架
##序列化框架性能对比
- 序列化
> type:DefaultJavaSerializer time:25ms.objectSize:195
  type:XStreamSerializer time:26ms.objectSize:142
  type:JsonSerializer time:149ms.objectSize:36
  type:HessianSerializer time:113ms.objectSize:64
  type:ProtostuffSerializer.time:109ms.objectSize:20
- 反序列化
> type:DefaultJavaSerializer time:4ms
  type:XStreamSerializer time:62ms
  type:JsonSerializer time:47ms
  type:HessianSerializer time:9ms
  type:ProtostuffSerializer time:136ms
## RPC框架性能对比
- RMI
> RMI end.time:861ms
