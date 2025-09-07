# 1. 베이스 이미지 선택 (Java 21 실행 환경)
# 자바 애플리케이션을 실행만 하면 되므로, JDK가 아닌 JRE 이미지를 사용해 용량을 줄입니다.
FROM eclipse-temurin:21-jre

# 2. 작업 디렉토리 설정
# 컨테이너 내부에서 명령어를 실행할 기본 경로를 지정합니다.
WORKDIR /app

# 3. 빌드된 JAR 파일을 이미지 안으로 복사
# GitHub Actions 워크플로우의 './gradlew build'가 실행된 후 생성된 JAR 파일을 복사합니다.
# 'build/libs/*.jar'는 어떤 이름의 JAR 파일이든 찾아서 'app.jar'라는 이름으로 복사하라는 의미입니다.
COPY build/libs/*.jar app.jar

# 4. 애플리케이션 포트 노출
# 이 컨테이너가 8080 포트를 사용한다는 것을 알려줍니다.
EXPOSE 8080

# 5. 애플리케이션 실행 명령어
# 컨테이너가 시작될 때 이 명령어를 실행하여 스프링 부트 애플리케이션을 구동합니다.
CMD ["java", "-jar", "app.jar"]
