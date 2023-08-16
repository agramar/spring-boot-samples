# Spring Boot JSP Sample

## 내용
- spring boot 3.0 이상 에서 mybatis와 jsp 를 사용한 샘플 프로젝트
- 내장 톰캣을 사용해 실행 가능하나, 일반적인 jar 나 java application 실행하면 jsp 페이지를 찾지 못함
- gradle war 패키징 플러그인을 추가하여 bootWar 로 패키징후 bootRun 으로 실행 시에 jsp 페이지 개발 가능
- 전통적인 방식인 외장 톰캣 설정후 외장 톰캣을 통해 실행도 가능