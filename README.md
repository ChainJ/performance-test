# performance-test
It's a test project to compare performances of several Java frameworks.

Struts2-Spring-Hibernate VS SpringMVC-Spring-Hibernate
对比Struts2框架使用OGNL表达式与SpringMVC数据绑定式进行数据序列化/反序列化的性能消耗；

Servlet-Mybatis VS Servlet-Hibernate
对比无数据缓存的Mybatis与ORM将部分数据实例化（在内存与数据库间同步近期查询的数据状态）的Hibernate的性能消耗；