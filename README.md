 # 예제 완성 과정입니다. 


### 전자정부 프레임 워크 다운로드
-홈페이지로 들어가 순서대로 다운로드를 진행해주세요
> [전자정부 표준프레임워크](https://www.egovframe.go.kr/home/main.do)  
> 다운로드 > 개발환경 > 3x 다운로드 > 자신의 환경에 맞게 개발자용 개발환경 다운로드

- 다운로드 받은 파일 zip을 풀어 실행!


-  중요 폴더 만들기
> eGov 프로젝트 생성  
![](https://blog.kakaocdn.net/dn/d3YCMj/btre1bOcb69/65cd2GxxInYwWDt2zqT5kk/img.jpg)
![](https://blog.kakaocdn.net/dn/SDxxo/btreYnPmMvo/yAccJI0szgO293ozh4WWC0/img.jpg)

 
> egovframework.example.sample.service 폴더에 BoardService(interface) , BoardVO 만들기  *자바파일로 만들어주세요
![](https://blog.kakaocdn.net/dn/Zq35s/btre5vLE1bo/CQ32ITKC2rsSgvFd7uPbZk/img.jpg)

> egovframework.example.sample.service.impl 폴더에 BoardServiceImpl(BoardService의 인터페이스를 상속받기) 자세한 설명은 다시함 , BoardDAO 만들기 
![](https://blog.kakaocdn.net/dn/bsejww/btreY4vg3Z0/hPY6LukkKQdJg4AJT35PrK/img.jpg)

> egovframework.example.sample.web 에 BoardController 만들기
![](https://blog.kakaocdn.net/dn/P8Eqt/btreYpGpMMp/wbvh1zMSKFs6xx5E7oFMSk/img.jpg)

> mapper.xml 만들기 (new > sqlMap 생성)
[](https://blog.kakaocdn.net/dn/JvEi8/btreX2EueRi/hx6DYkskPZsjKuhiUaY0yK/img.jpg)


> jsp 폴더에서 기본적인 crud 가 가능한 jsp 파일 만들어주기  (예제에 있으니 사용하세요 )
[](https://blog.kakaocdn.net/dn/b0L6uH/btre4OLGi0X/jsrj8sJwzPmOnaxihclLU1/img.jpg)

# controller , VO , DAO , Service  작성법
- controller
![](https://blog.kakaocdn.net/dn/eEdPWa/btre6lvgdgH/VsS7Afin65FAqZnhX7jqv0/img.jpg)
```
1. controller 라고 컴퓨터에게 선언해줍니다. @Controller로 사용 
2. 스프링에서는 @AutoWrite 를 사용했지만 전자정부프레임워크에서는 @Resource 로 사용 
3 메인페이지를 화면에 송출하기위해 작성된 메소드
```

- VO 
![](https://blog.kakaocdn.net/dn/by3pqs/btreY3wl8Wi/SNEtTKijdVJ3oUgKvcP15k/img.jpg)
```
1 @Component 로 DTO 또는 VO라는것을 컴퓨터에 인지시켜줌
2 and 3 . 자신이 사용할 변수들을 캡슐화 getter 와 setter를 만들어줌
```
 

- Service
> 인터페이스로 만들어야함
![](https://blog.kakaocdn.net/dn/m0Ky5/btre5a14U6L/44BILL4Q4eDTc1eaG6cm2k/img.jpg)

- ServiceImpl
![](https://blog.kakaocdn.net/dn/ohPDC/btre4NsuOlb/SAYnLM2kB0OISuVFw51wuK/img.jpg)
```
1 . service라는 것을 컴퓨터에 인지시켜줌
2 . 인터페이스로 만든 BoardService를 implements 해줌  
3 .  resource 로 DAO랑 연결
4 . EgovSampleServiceImpl 에 있는 extends EgovAbstractServiceImpl 를 복사해 붙혀넣기
```
> EgovAbstractServiceImpl 
![EgovAbstractServiceImpl](https://blog.kakaocdn.net/dn/qSu1u/btreX2EvmfT/dephyksMRHjRee9qGicwt0/img.jpg)
 



- DAO
![](https://blog.kakaocdn.net/dn/cgaG97/btreY07d8FN/KKNIO7VZ2hm5Ph6bLmiUNK/img.jpg)
```
1 . DAO 라는 것을 컴퓨터에 인지시켜줌 
2 .SampleDAO에 있는 extends EgovAbstractDAO를 복사해 붙혀넣기
```
 
# Board_SQL  와 sql-map-config 설정 
- Board_SQL 설정
![](https://blog.kakaocdn.net/dn/bvk12V/btre6m11YVV/VX5mK6JZVMpUWtVOaXaHGk/img.jpg)  
```
1 작은 빨간 표시해둔 SQL.xml파일에서 큰 빨간 표시해둔 곳까지 복사해  Board_SQL 에 붙혀넣기 하기
2 분홍네모칸은 수정한 부분   
```
 
- sql-map-config 설정
![](https://blog.kakaocdn.net/dn/bI01fr/btre0a9CPsF/cPKhY5cbQpSU0iBiByk7oK/img.jpg)  
> sql-map-config파일에 큰 네모된 곳을 작은 네모칸으로 표시된 Board_SQL 의 경로를 적어준다.
 
- pom.xml 설정  
> pom.xml 중간 쯤에 이런 코드가 있다 주석처리 되어있음  
![](https://blog.kakaocdn.net/dn/cc01lZ/btre6En296b/q5sMuNmf0jgTtqK78CsSpk/img.jpg) 
```
5-2 주석을 풀면  아래 사진처럼 빨간줄이 뜸  빨간 네모 표시를 지워주세요.
5-3  지운 자리에 아래 코드를 붙혀넣어주세요
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.46</version>
        </dependency>

 		<dependency>
			<groupId>org.apache.commons</groupId>
			<artifactId>commons-dbcp2</artifactId>
			<version>2.0</version>
		</dependency>
```

- index.jsp 변경 
> 변경전  
![](https://blog.kakaocdn.net/dn/cSjreb/btreY4aWiHp/yDrTVuALqzzHSCcHUWMBS1/img.jpg)  
> 변경후  
![](https://blog.kakaocdn.net/dn/bH8eJS/btre34VyycM/azETgdChF9XT9PktWkUAQK/img.jpg)


- context-datasource.xml 설정
![](https://blog.kakaocdn.net/dn/qPzLY/btre7IjruZ9/jnEDEiOoWvHbY1a3LZBsV0/img.jpg)  
> context-datasource.xml 를 보면  2번과 3번이 있습니다.
> 2번의 주석을 풀어 mysql정보를 입력해주세요  
> 3번은 지워주세요 
