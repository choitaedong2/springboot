# springboot

### Java SE 17
- https://jdk.java.net/ (Windows 11 x64 Java Development Kit)


### Eclipse용 zip파일
- sts4 검색 > Project Wiki
- Spring Tools 4.20.1(changelog)
![image](https://github.com/user-attachments/assets/1166f70f-ba9b-4475-9c83-8b6a9d7387c7)


### lombok 다운
- lombok 검색 -> 다운로드 ->  Download 1.18.36
- lombok.jar -> sts-4.20.1.RELESE로 이동

### lombok 설치(관리자 권한으로 실행)
![image](https://github.com/user-attachments/assets/2ebd2246-711b-4396-bc88-9deb5e3a17e4)
- sts 경로 설정
![image](https://github.com/user-attachments/assets/ebbb0fd8-5dba-423a-8b73-ce20bee16f84)
- 인스톨

### Spring 환경설정
- Spring UTF-8 환경 설정: window -> preference -> SPELL, ENcoding
- Marketplace: Web검색 -> Eclipse Enterprise java and Web Developer Tools 3.31
 : 체크 항목 모두 선택 -> Trust -> restart

### 오류 모음
- Preference > General > Network Connection > Active Provider(Native -> Direct)
* .xml파일 Web-app 오류 : version="2.4" 추가 시도
- JSP 오류 발생시 : Properties > Project Facets > Dynamic Web Module 6.0 이상으로 변경 / build.gradle org.springframework.boot version '3.1.0'으로 변경
- mapper 태그 오류시 ~> windows/system32/msvcr100.dll 복사하여 java/bin 폴더에 붙여넣기 || preference -> Maven -> User Settings -> Global settings(ojdbc6.jar 선택)
