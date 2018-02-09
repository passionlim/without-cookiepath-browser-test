

## Running a web server
~~~shell
run_no_path.sh # Path 없이 Cookie 를 생성하는 경우. JSESSIONID 쿠키 유실 발생함
run_root_path.sh # ROOT(/) Path로 Cookie 를 생성하는 경우. 브라우저 쿠키 유실 발생하지 않음.
run_scouter_original.sh # Scouter 1.8.1.1-p1 에 Cookie Path 설정없이 서버를 시작한다.
run_scouter_path.sh # Scouter 1.8.1.1-p1 에 Root(/)로 Cookie Path 설정을 하여 서버를 시작한다.
~~~

## Sample Urls
위 명령으로 서버를 시작하면 아래 주소로 테스트를 해볼 수 있다.
http://localhost:8080/redirect/0/landing?i=500

해당 페이지는 다음 주소의 Path 값을 계속적으로 증가시켜가면 redirect 를 한다. 만약 제출된 JSESISONID 값이 없고 신규 값과 이전 값이 다른 경우 페이지 이동을 멈춘다.

개발자도구 또는 Http Monitoring 프로그램으로 Cookie 요청과 응답값을 통해 유실을 확인할 수 있다.

## 테스트 결과
IE 에서는 Cookie 유실이 좀 더 빨리 일어남을 확인할 수 있다.

IE 는 52~53 번째 요청시 JSESSSIONID 유실이 일어난다.

Edge 는 180번째 요청시 JSSESSIONID 유실이 일어난다.

Chrome 의 경우는 interval 시간이 짧을 경우 (300ms) 주로 발생하는 것을 확인된다.

### Path 없을 경우

#### IE 11
 ![IE](/images/ie_no_path_cookie.png)

#### Edge
 ![Edge](/images/edge_no_path_cookie.png)

#### Chrome
 250번째 쯤 쿠키(JSESSIONID) 유실 발생
 ![Chrome](/images/chrome_no_path_cookie.png)


### Path 없을 경우
Set-Cookie 에 Path 값이 있을 경우 브라우저별 이슈는 발생하지 않는다.

#### IE
![Chrome](/images/chrome_root_path_cookie.png)

#### Edge
 ![Edge](/images/edge_root_path_cookie.png)

#### Chrome
![Chrome](/images/chrome_root_path_cookie.png)
