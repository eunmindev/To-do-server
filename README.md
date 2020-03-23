# 코드 활용방법
1. resources-coroutine 모듈 안에 /src/main/resources 안에 application.properties 를 만든다.
2. 아래의 코드를 application.properties 안에 넣는다.


    spring.datasource.url=yourDatabase
    spring.datasource.username=youtDatabase username
    spring.datasource.password=yourDatabase password
    spring.datasource.driver-class-name=your database driver
    spring.jpa.database-platform=your database dialect

3. 그리고 실행 후 postman을 통해 테스트를 진행한다.