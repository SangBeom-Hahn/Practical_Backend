# Etc

## 용어 정리

- Redis(REmote DIctionary Servcer)
  
  메모리 캐시 방식의 인메모리(In-memory) No-SQL 데이터베이스(키-값 구조)입니다. 즉, 데이터를 RAM에 저장하기 때문에, IO의 부담이 줄어 데이터 조회 속도가 빠른 것이 특징입니다.

---

## 약어

- DAG : Directed Acyclic Graphic
- JPQL : Java Persistence Query Language
- JWT : JSON Web Token
- CORS : Cross-Origin Resource Sharing

---

## Spring 용어

- Entity
  
  Entity는 DB의 테이블에 존재하는 Column들을 필드로 가지는 객체를 뜻한다. 
  Entity는 DB의 테이블과 1대1 대응이며, 테이블에 가지지 않는 칼럼을 필드로 가져서는 안 된다. 
  또한 Entity 클래스는 다른 클래스를 상속받거나 인터페이스의 구현체여서는 안되고 순수한 데이터 객체인 것이 좋다. 
  (사실 중복되는 내용이 있을 경우 baseEntity를 만들어 상속할 수 있다)

- DTO(Data Transfer Object)
  
  DTO는 말 그대로 데이터를 Transfer(이동)하기 위한 객체이다. 
  Client가 Controller에 요청을 보낼 때도 RequestDto의 형식으로 데이터가 이동하고, 
  Controller가 Client에게 응답을 보낼 때도 ResponseDto의 형태로 데이터를 보내게 된다.
  
  Controller와 Service, Repository 계층 사이에 데이터가 오갈 때도 데이터는 DTO의 형태로 이동하게 된다. 
  
  DTO는 로직을 갖고 있지 않는 순수한 데이터 객체이며, 일반적으로 getter/setter 메서드만을 가진다. 
  하지만 DTO는 단순히 데이터를 옮기는 용도이기 때문에 굳이 Setter를 이용해 값을 수정할 필요가 없이, 
  생성자만을 사용하여 값을 할당하는 게 좋다. 

- DAO(Data Access Object)
  
  DAO는 말 그대로 실제 DB에 접근하는 객체를 뜻한다. DAO는 Service와 실제 데이터베이스를 연결하는 역할을 하게 된다. 즉, DB에서 데이터를 꺼내오거나 넣는 역할을 DAO가 담당한다. JPA의 경우 Repository가 DAO의 역할을 한다고 볼 수 있다. 하지만 DAO와 Repository가 같은 것은 아니다.

- Repository
  
  JPA를 사용하면 Repository를 통해 DB에 실제로 접근할 수 있다. 
  Service와 DB를 연결해주는 역할을 하며, Service 계층에서 Repository를 이용하여 데이터를 관리할 수 있다. 

- Controller
  
  Controller는 Client의 요청을 DTO의 형태로 받아 Service의 기능을 호출하고, 
  적절한 응답을 DTO의 형태로 반환하는 역할을 한다. 즉, 요청과 응답을 관리하는 계층이라고 생각하면 된다.

- Service
  
  Service 계층은 DTO를 통해 받은 데이터를 이용해 비즈니스 로직을 처리하고, 
  DAO(혹은 Repository)를 통해 DB에 접근하여 데이터를 관리하는 역할을 한다. 

---

## Spring Dependencies

- Spring Boot DevTools <mark>(DEVELOPER TOOLS)</mark>
  
  Provides fast application restarts, LiveReload, and configurations for enhanced development experience.

- Lombok <mark>(DEVELOPER TOOLS)</mark>
  
  Java annotation library which helps to reduce boilerplate code.

- Spring Configuration Processor <mark>(DEVELOPER TOOLS)</mark>
  
  Generate metadata for developers to offer contextual help and "code completion" when working with custom configuration keys (ex.application.properties/.yml files).

- Spring Web <mark>(WEB)</mark>
  
  Build web, including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container.

- Rest Repositories <mark>(WEB)</mark>
  
  Exposing Spring Data repositories over REST via Spring Data REST.

- Spring Data JPA <mark>(SQL)</mark>
  
  Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate.

- MyBatis Framework <mark>(SQL)</mark>
  
  Persistence framework with support for custom SQL, stored procedures and advanced mappings. MyBatis couples objects with stored procedures or SQL statements using a XML descriptor or annotations.

- MySQL Driver <mark>(SQL)</mark>
  
  MySQL JDBC driver.

- JDBC API <mark>(SQL)</mark>
  
  Database Connectivity API that defines how a client may connect and query a database.

- Spring Data JDBC <mark>(SQL)</mark>
  
  Persist data in SQL stores with plain JDBC using Spring Data.

- Spring cache abstraction <mark>(I/O)</mark>
  
  Provides cache-related operations, such as the ability to update the content of the cache, but does not provide the actual data store.

- Thymeleaf <mark>(TEMPLATE ENGINES)</mark>
  
  A modern server-side Java template engine for both web and standalone environments. Allows HTML to be correctly displayed in browsers and as static prototypes.

---

## DataBase 용어

| 명령어 종류                                            | 명령어                                   |
|:-------------------------------------------------:|:-------------------------------------:|
| 데이터조작어<br> (DML : Data Manipulation Language)     | SELECT, INSERT, UPDATE, DELETE        |
| 데이터 정의어<br> (DDL : Data Definition Language)      | CREATE, ALTER, DROP, RENAME, TRUNCATE |
| 데이터 제어어<br> (DCL : Data Control Language)         | GRANT, REVOKE                         |
| 트랜잭션 제어어<br> (TCL : Transaction Control Language) | COMMIT, ROLLABCK, SAVEPOINT           |

---

## 쿠버네티스

- 컨테이너
  
  컨테이너는 애플리케이션의 코드, 라이브러리 및 환경 변수를 포함한느 가벼운 독립 실행형 프로세스로, 컨테이너는 운영 체제의 커널을 공유하므로 실행하는 데 필요한 리소스가 적습니다.

- 노드(Node)
  
  클러스터의 일부이며, 쿠버네티스에 속한 워커 머신으로 컨테이너를 실행 할 수 있습니다.

- 클러스터(Cluster)
  
  쿠버네티스에서 관리되는 컨테이너화 된 애플리케이션을 실행하는 노드 집합으로,  컨테이너를 배포하고 관리하는데 사용됩니다. 일반적인 쿠버네티스 배포에서 클러스터에 속한 노드는 퍼블릭 인터넷의 일부가 아닙니다.

- 디플로이먼트
  
  쿠버네티스 객체로, 디플로이먼트는 노드에 컨테이너를 배포하고 관리하는데 사용됩니다.

- 레플리카셋
  
  쿠버네티스 객체로, 레프리카셋은 노드에 컨테이너의 복사본을 배포하고 관리하는데 사용됩니다.

- 스테이트풀셋
  
  쿠버네티스 객체로, 스테이트풀셋은 노드에 컨테이너의 복사본을 배포하고 관리하며, 각 턴테이너는 고유한 상태를 가질 수 있습니다.

- 데몬셋
  
  쿠버네티스 객체로, 데몬셋은 노드에 컨테이너의 복사본을 배포하고 관리하며, 각 컨테이너는 노드에서 실해되어야 합니다.

- 잡
  
  쿠버네티스 객체로, 잡은 일련의 작업을 실행하는데 사용됩니다.

- 작업
  
  잡의 일부로, 작업은 노드에 컨테이너를 배포하고 관리하는데 사용됩니다.

- 에지 라우터(Edge router)
  
  클러스터에 방화벽 정책을 적용하는 라우터, 이것은 클라우드 공급자 또는 물리적 하드웨어의 일부에서 관리하는 게이트웨이일 수 있다.

- 클러스터 네트워크(Cluster network)
  
  쿠버네티스 네트워킹 모델에 따라 클러스터 내부에서 통신을 용이하게 하는 논리적 또는 물리적 링크 집합.

- 
